/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;


import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Davide
 */
public class Libreria implements Serializable{
    private ArrayList<InfoBase> lib;
        
    public Libreria(){
        lib=new ArrayList<InfoBase>();
    }
    
    public Libreria(ArrayList<InfoBase> l){
        lib=l;
    }
    public void aggiungiVideo(Video x){
        lib.add(x);
    }
    
    public void aggiungiBranoMusicale(BraniMusicali x){
        lib.add(x);
    }
    
    
    public void aggiungiEbook(Ebook x){
        lib.add(x);
    }
    
    /**Metodo che mi restituisce l'elemento i-esimo della libreria
     * 
     * @param i
     * @return 
     */
    public InfoBase ottieniElemento(int i){
        return lib.get(i);
    }
    
    /**Metodo che cancella l'elemento i-esimo dalla libreria
     * 
     * @param i 
     */
    public void cancellaElemento(int i){
        lib.remove(i);
    }
    
    /**Metodo che mi ritorna la lunghezza della libreria
     * 
     * @return 
     */
    public int getLunghezza(){
        return lib.size();
    }
    
}
