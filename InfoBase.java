/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Davide
 */
public class InfoBase implements Serializable{
    private String titolo;
	private String autore;
	private int anno;
	private File percorso;
        private int cod;
	
	public InfoBase(){
		this.titolo=null;
		this.autore=null;
		this.anno=-1;
		this.percorso=null;
                this.cod=0;
	}
	
	public InfoBase(String titolo, String autore, int anno, File percorso, int cod){
		this.titolo=titolo;
		this.autore=autore;
		this.anno=anno;
		this.percorso=percorso;
                this.cod=cod;
	}
	
	/** Ritorna il titolo del file
     * @return  */
	public String getTitolo(){
		return this.titolo;
	}
	
	/** Setta il titolo del file
     * @param titolo */
	public void setTitolo(String titolo){
		this.titolo=titolo;
	}
	
	/** Ritorna l'autore del file
     * @return  */
	public String getAutore(){
		return this.autore;
	}
	
	/** Setta l'autore del file
     * @param autore */
	public void setAutore(String autore){
		this.autore=autore;
	}
	
	/** Ritorna l'anno del file
     * @return  */
	public int getAnno(){
		return this.anno;
	}
	
	/** Setta l'anno del file
     * @param anno */
	public void setAnno(int anno){
		this.anno=anno;
	}
	
	/** Ritorna il percorso del file
     * @return  */
	public File getPercorso(){
		return this.percorso;
	}
	
	/** Setta il percorso del file
     * @param percorso */
	public void setPercorso(File percorso){
		this.percorso=percorso;
	}

        public int getCod() {
                return this.cod;
        }
        
}
