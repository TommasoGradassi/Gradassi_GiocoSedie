/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
@author Gradassi Tommmaso
 */
package gradassi_giocosedie;

import static java.lang.Thread.sleep;

/**
 * Classe che rappresenta un partecipante al gioco delle sedie. Ogni partecipante
 * cerca di sedersi su uno dei posti disponibili. I partecipanti sono gestiti come thread,
 * e ogni partecipante tenta di occupare un posto dopo un tempo casuale.
 */
class Partecipante extends Thread {
    Posto sedie[];

    /**
     * Costruttore che inizializza il partecipante con un array di posti.
     * 
     * @param sedie array di oggetti {@link Posto} che rappresentano i posti disponibili
     */
    public Partecipante(Posto sedie[]) {
        this.sedie = sedie;
    }

    /**
     * Metodo che viene eseguito quando il thread del partecipante parte. Ogni partecipante
     * attende per un tempo casuale e poi cerca di occupare uno dei posti. Se non riesce a
     * sedersi, il partecipante "perde".
     */
    public void run() {
        try {
            // Attende un tempo casuale tra 0 e 1000 ms
            Scrittore s=new Scrittore("Risultato.txt");
            sleep((int) (Math.random() * 1000));

            // Cerca un posto libero
            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    System.out.println("Sono il Thread " + this.getName()
                            + ". Sono riuscito a sedermi sul posto " + i);
                    s.scrivi(getId(), i);
                    return; // Se trova un posto, si siede e termina
                }
            }
            // Se non riesce a trovare un posto
            System.out.println("Sono il Thread " + this.getName() + ". Ho perso :((((");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

