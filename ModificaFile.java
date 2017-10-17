/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Davide
 */
public class ModificaFile extends AggiungiFile{
    private int riga;
    private int t;
    
    public ModificaFile(Frame parent, boolean modal, int t, Libreria l, int r) {
        super(parent, false, t, l);
        this.riga=r;
        this.t=t;
        //super.getjOk().addAncestorListener(null);
        getjOk().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkActionPerformed1(evt);
            }

            
        });
        InfoBase aus=super.getLib().ottieniElemento(riga);
        super.setText1(aus.getTitolo());
        super.setText2(aus.getAutore());
        super.setText3(""+aus.getAnno());
        super.setText4(aus.getPercorso().getPath());
        switch(t){
            case 0: super.setText5(""+((Video) aus).getDurata());
                    break;
            case 1: super.setText5(""+((BraniMusicali) aus).getDurata());
                    super.setText6(""+((BraniMusicali) aus).getFCampionamento());
                    break;
            case 2: super.setText7(""+((Ebook) aus).getPagine());
                    break;
            default:
                    break;
        }
        super.setModal(modal);
        //this.setModal(modal);
        this.setVisible(true);
        
    }
    
    /**Metodo che gestisce il borrone OK.
     * In base al file che si sta inserendo, crea un oggetto corrispondente e lo aggiunge 
     * alla libreria.
     * 
     * @param evt 
     */
    private void jOkActionPerformed1(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        super.getLib().cancellaElemento(riga);
        //super.creaFile(t);
        this.dispose();
    } 
}
