/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Davide
 */
public class DialogCarica extends javax.swing.JDialog {

    private Libreria lib;
    private MyFrame parent; 
    private int risposta; 
    private FileNameExtensionFilter filtro;

    /**
     * Creates new form DialogCarica
     */
    public DialogCarica(MyFrame parent, boolean modal, Libreria lib) {
        super(parent, modal);
        initComponents();
        this.parent=parent;
        this.lib=lib;
        jFileChooser2.setVisible(true);
        risposta=0;//jFileChooser2.showOpenDialog(parent);
        filtro=new FileNameExtensionFilter("File Libreria Multimediale", "mylib");
        jFileChooser2.setFileFilter(filtro);
        jFileChooser2.setAcceptAllFileFilterUsed(false);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser2 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /* Metodo associato al FileChooser che permette di aprire una libreria precedentemente
    *  memorizzata.    
    */
    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed
        // TODO add your handling code here:
       // if(jFileChooser2.get)
        FileInputStream fout=null;
        try {
            fout=new FileInputStream(jFileChooser2.getSelectedFile().getPath());
        } 
        catch (FileNotFoundException ex) {
            DialogErrore der= new DialogErrore(parent, true, "Errore in apertira del FileInputStream!\n"+ex.toString());
            der.setVisible(true);
        }
        
        ObjectInputStream o=null;
        try{
            o=new ObjectInputStream(fout);
            parent.setLibreria((Libreria) o.readObject());
            
            o.close();
            }
        catch (IOException ex) {   
            DialogErrore der= new DialogErrore(parent, true, "Errore in apertura di ObjectInputStram!\n"+ex.toString());
            der.setVisible(true);
        } 
        catch (ClassNotFoundException ex) {
            DialogErrore der= new DialogErrore(parent, true, "Errore in lettura!");
            der.setVisible(true);
        }
        
        this.dispose();
    }//GEN-LAST:event_jFileChooser2ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser2;
    // End of variables declaration//GEN-END:variables
}
