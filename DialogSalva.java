/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.awt.Button;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Davide
 */
public class DialogSalva extends javax.swing.JDialog {

    private Libreria lib;
    private Frame parent;
    private boolean sovra;
    private int risposta;
    //private FileNameExtensionFilter filtro;
    /**
     * Creates new form DialogSalva
     */
    public DialogSalva(java.awt.Frame parent, boolean modal, Libreria lib) {
        super(parent, modal);
        initComponents();
        //setDialogTitle(String dialogTitle)
        this.parent=parent;
        this.lib=lib;
        //jFileChooser1.setVisible(true);
        risposta=jFileChooser1.showSaveDialog(parent);
        
        String nome;
        if(risposta==JFileChooser.APPROVE_OPTION){  
            System.out.println("sono entrato qua");  
            System.out.println(""+jFileChooser1.getSelectedFile());
            nome=jFileChooser1.getSelectedFile().getPath();
            if(!nome.contains(".mylib"))
                nome=nome+".mylib";
        
            File f=new File(nome);
            //controllo che il nome non sia già esistente
            sovra=true;
            if(f.exists()){
                Sovrascrivere err=new Sovrascrivere(parent, true, this);
            
                err.setVisible(true);
                System.out.println(sovra);
            
            }
            if(sovra){
            
                //System.out.println(jFileChooser1.getName().toString());
                FileOutputStream fout=null;
                try{
                    fout=new FileOutputStream(nome);
                }
                catch(FileNotFoundException e){
                    DialogErrore der= new DialogErrore(parent, true, "Errore nella creazione di FileOutputStream!");
                    der.setVisible(true);
                }
                ObjectOutputStream o=null;
                try{
                    o=new ObjectOutputStream(fout);
                    o.writeObject(lib);
                    o.flush();
                    o.close();
                }   
                catch(IOException e){
                    DialogErrore der= new DialogErrore(parent, true, "Errore in ObjectOutputStream!");
                    der.setVisible(true);
                }
            }
            
        }
        
        /*filtro=new FileNameExtensionFilter("Libreria multimediale", "mylib");
        jFileChooser1.setFi
        jFileChooser1.setFileFilter(filtro);
        jFileChooser1.setAcceptAllFileFilterUsed(false);*/
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jFileChooser1ActionPerformed
    public void setSovrascrivi(boolean b){
        sovra=b;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    // End of variables declaration//GEN-END:variables
}
