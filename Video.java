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
public class Video extends InfoBase{
	private float durata;
	
	public Video(){
		super();
		this.durata=0;
	}
	
	public Video(float durata, String titolo,
			String autore, int anno, File percorso){
		super(titolo, autore, anno, percorso,1);
		this.durata=durata;
	}

        public float getDurata() {
                return this.durata;
        }
    
}
