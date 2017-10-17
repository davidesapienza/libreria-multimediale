/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esame;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Davide
 */
class TableModel extends AbstractTableModel{
    /* Stringa della riga titoli */
    private final String[] titolo={"Titolo", "Autore", "Anno", "Percorso", "Durata", "F Campionamento", "N Pagine"};
    private Libreria tabella;
    
    public TableModel() {
          //System.out.println("entrato in Costrutore");
          tabella = new Libreria();
         
          
    }
    public TableModel(Libreria l) {
          //System.out.println("entrato in Costrutore");
          tabella = l;
          
    }
    
    @Override
    public int getRowCount() {
        //System.out.println("entrato in getRowCount");
        return tabella.getLunghezza();
    }

    @Override
    public int getColumnCount() {
        return titolo.length;
    }
    
    /* Ritorna il contenuto di una cella */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //System.out.println("entrato in getvalueat");
        switch(columnIndex){
            case 0: //System.out.println(tabella.get(rowIndex).getTitolo());
                    return tabella.ottieniElemento(rowIndex).getTitolo();
                    
            case 1: //System.out.println(tabella.get(rowIndex).getAutore());
                    return tabella.ottieniElemento(rowIndex).getAutore();
            case 2: //System.out.println(tabella.get(rowIndex).getAnno());
                    return tabella.ottieniElemento(rowIndex).getAnno();
            case 3: //System.out.println(tabella.get(rowIndex).getPercorso());
                    return tabella.ottieniElemento(rowIndex).getPercorso();
            case 4: 
                    if(tabella.ottieniElemento(rowIndex).getCod()==1){
                        Video temp=(Video)tabella.ottieniElemento(rowIndex);
                        return temp.getDurata();
                    }
                    else if(tabella.ottieniElemento(rowIndex).getCod()==2){
                        BraniMusicali temp=(BraniMusicali)tabella.ottieniElemento(rowIndex);
                        return temp.getDurata();
                    }
                    else
                        return "";
            case 5:
                    if(tabella.ottieniElemento(rowIndex).getCod()==2){
                        BraniMusicali temp=(BraniMusicali)tabella.ottieniElemento(rowIndex);
                        return temp.getFCampionamento();
                    }
                    else
                        return "";
            case 6:
                    if(tabella.ottieniElemento(rowIndex).getCod()==3){
                        Ebook temp=(Ebook)tabella.ottieniElemento(rowIndex);
                        return temp.getPagine();
                    }
                    else
                        return "";
            default: return"Errore";
            }
        
        
    }
    @Override
        public String getColumnName(int i){
        return (titolo[i]);
    }

}