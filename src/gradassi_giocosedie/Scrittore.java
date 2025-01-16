/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gradassi Tommaso
 */
package gradassi_giocosedie;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Scrittore implements Runnable{

    String nomeFile;
    
    public Scrittore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    
    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     * @param id 
     * @param posti
     */
    public void scrivi(int id ,int posti){
        BufferedWriter br=null;
        
        try {
            //1) apro il file
            br = new BufferedWriter(
                    new FileWriter(nomeFile));
            //2) scrivo nel buffer
            br.write("il thread"+id+"occupa il posto"+posti);
            br.write("\n\r");
            //3) svuoto il buffer e salvo nel file i dati
            br.flush();         
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    //4)chiudo lo stream in uscita
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}