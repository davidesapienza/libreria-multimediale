/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

/**
 *
 * @author Davide
 */
public class MyThread extends Thread {
    private Libreria lib;
    private int riga;
    private MyFrame parent;
    
    public MyThread(MyFrame parent,Libreria lib, int riga) {
        this.lib=lib;
        this.riga=riga;
        this.parent=parent;
        //RiproduciBrano rb=new RiproduciBrano(parent, lib, riga);
    }
    
    public void run(){
        DialogRiproduci rb=new DialogRiproduci(parent, false, lib, riga);
        
    }
    
}
