/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
@author Gradassi Tommmaso
 */
package gradassi_giocosedie;

import static java.lang.Thread.sleep;

/**
 * Classe che rappresenta il display del gioco, mostrando lo stato delle sedie. 
 * Ogni volta che il display viene aggiornato, viene stampata una rappresentazione
 * delle sedie, con un '0' per i posti liberi e '*' per i posti occupati.
 * La classe estende {@link Thread}, quindi il display viene aggiornato in un thread separato.
 */
class Display extends Thread {
    private Posto sedie[];
    private boolean endgame;

    /**
     * Costruttore che inizializza il display con un array di sedie.
     * 
     * @param sedie array di oggetti {@link Posto} che rappresentano i posti nel gioco
     */
    public Display(Posto sedie[]) {
        this.sedie = new Posto[sedie.length];

        // Copia i posti ricevuti
        for (int s = 0; s < sedie.length; s++)
            this.sedie[s] = sedie[s];
    }

    /**
     * Metodo che viene eseguito quando il thread del display parte. Mostra continuamente lo stato
     * del gioco, aggiornando la visualizzazione ogni volta che cambia.
     */
    public void run() {
        try {
            while (!endgame) {
                int count = 0; // Conta i posti occupati

                // Aspetta un tempo casuale prima di aggiornare lo stato
                sleep((int) (Math.random() * 250));

                // Visualizza lo stato delle sedie
                for (int i = 0; i < sedie.length; i++) {
                    if (sedie[i].libero())
                        System.out.print("0"); // Posto libero
                    else {
                        count++;
                        System.out.print("*"); // Posto occupato
                    }
                }
                System.out.println();

                // Se tutti i posti sono occupati, termina il gioco
                endgame = (count == sedie.length);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

