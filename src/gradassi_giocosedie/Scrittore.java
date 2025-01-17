package gradassi_giocosedie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scrittore {

    private String nomeFile;

    public Scrittore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    /**
     * Scrive nel file di testo usando la classe BufferedWriter
     * @param id l'ID del partecipante
     * @param posto il numero del posto occupato
     */
    public synchronized void scrivi(long id, int posto) {
        BufferedWriter br = null;

        try {
            // Apro il file in modalità append
            br = new BufferedWriter(new FileWriter(nomeFile, true));
            // Scrivo nel buffer
            br.write("Il thread " + id + " occupa il posto " + posto);
            br.newLine();  // Aggiunge una nuova linea
            // Svuoto il buffer e salvo nel file
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null) {
                try {
                    // Chiudo lo stream
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
