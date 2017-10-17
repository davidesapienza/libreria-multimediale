/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import org.omg.CORBA.SystemException;
enum tipo {video, musica, ebook};
/**
 *
 * @author Davide
 */
public class Esame {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       try{
        MyFrame fin = new MyFrame("Libreria Multimediale");
        fin.setVisible(true);
       }catch(Exception e){
           System.out.println("errore");
           System.exit(1);
       }
        
    }
    
}
