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
public class Ebook extends InfoBase{
	private int pagine;
	
	public Ebook(){
		super();
		this.pagine=0;
	}
	
	public Ebook(int pagine, String titolo,
			String autore, int anno, File percorso){
		super(titolo, autore, anno, percorso,3);
		this.pagine=pagine;
	}

        public int getPagine() {
                return this.pagine;
        }
            
}
