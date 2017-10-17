/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Davide
 */
public class RiproduciBrano {
    private AudioInputStream din;
    private SourceDataLine line;    
    private volatile boolean paused;
    private Object lock;
    
    public RiproduciBrano(MyFrame parent, Libreria lib, int riga){
    din = null;
        lock = new Object();
        paused = false;
        /*char [] s;
        char [] sottos=null;
        */

        try {
            System.out.println(lib.ottieniElemento(riga).getPercorso().toString());
            /*s=lib.ottieniElemento(riga).getPercorso().toString().toCharArray();
            int i=0;
            while(s[i]!='\0'){
                i++;    
            }
            int k, j;
            for(k=i-1;s[k]!='/';k--){
                
            }
            k++;
            for(j=0;k<=i;k++,j++){
                sottos[j]=s[k];
            }*/
            //AudioInputStream in = AudioSystem.getAudioInputStream(sottos.);
            AudioInputStream in = AudioSystem.getAudioInputStream(lib.ottieniElemento(riga).getPercorso());
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                                    baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
                                    baseFormat.getChannels() * 2, baseFormat.getSampleRate(),false);
            
            din = AudioSystem.getAudioInputStream(decodedFormat, in);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);
            
            if(line != null) {
                line.open(decodedFormat);
                byte[] data = new byte[4096];
                // Start
                line.start();

                int nBytesRead;
                synchronized (lock) {
                    while ((nBytesRead = din.read(data, 0, data.length)) != -1) {
                        while (paused) {
                            if(line.isRunning()) {
                                line.stop();
                                }
                            try {
                                lock.wait();
                            }
                            catch(InterruptedException e) {
                            }
                        }

                        if(!line.isRunning()) {
                            line.start();
                        }
                    line.write(data, 0, nBytesRead);
                    }
                }

                // Stop
                line.drain();
                line.stop();
                line.close();
                din.close();
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(din != null) {
                try { din.close(); } catch(IOException e) { }
            }
        }

    }
}