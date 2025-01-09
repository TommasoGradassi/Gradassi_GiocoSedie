/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradassi_giocosedie;

/**
 *
 * @author Gradassi Tommmaso
 */
import java.util.logging.Logger;

/**
 * Classe principale che esegue il gioco delle sedie. Viene creata una lista di posti, 
 * un display che mostra lo stato del gioco e una serie di partecipanti che tentano di 
 * sedersi. Ogni partecipante è gestito come un thread separato.
 */
public class TestGiocoSedie {
    private final static int NUMSEDIE = 15;
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");

    /**
     * Metodo principale che avvia il gioco delle sedie.
     * Crea una serie di posti, un display per mostrare lo stato del gioco, e un array di partecipanti.
     * 
     * @param args gli argomenti passati dalla riga di comando (non usati in questo caso)
     */
    public static void main(String[] args) {
        Posto sedie[] = new Posto[NUMSEDIE];

        // Crea i posti
        for (int k = 0; k < sedie.length; k++)
            sedie[k] = new Posto();

        // Crea e avvia il display
        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
        display.start();

        // Crea e avvia i partecipanti (ognuno come un thread)
        Partecipante array[] = new Partecipante[NUMSEDIE + 1];
        for (int i = 0; i < NUMSEDIE + 1; i++) {
            array[i] = new Partecipante(sedie);
            logger.info("Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }
    }
}

 
