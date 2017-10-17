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
public class BraniMusicali extends InfoBase{
    private float durata;
    private int FCampionamento;

	
    public BraniMusicali(){
        super();
        durata=0;
        FCampionamento=0;
    }
            
   
    public BraniMusicali(float durata, int FCampionamento, String titolo,
					String autore, int anno, File percorso){
	super(titolo, autore, anno, percorso,2);
	this.durata=durata;
	this.FCampionamento=FCampionamento;		
    }

    public float getDurata() {
        return this.durata;
    }

    public int getFCampionamento() {
        return this.FCampionamento;
    }
	
    
}
