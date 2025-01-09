/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
@author Gradassi Tommmaso
 */
package gradassi_giocosedie;

/**
 * Rappresenta un posto che può essere occupato o lasciato libero.
 * I metodi di questa classe sono sincronizzati per garantire che l'accesso al posto
 * avvenga in modo sicuro tra più thread.
 */
class Posto {
    private boolean occupato;

    /**
     * Costruttore che inizializza il posto come libero.
     */
    public Posto() {
        occupato = false;
    }

    /**
     * Restituisce true se il posto è libero, false se è occupato.
     * Questo metodo è sincronizzato per evitare accessi concorrenti da parte di più thread.
     * 
     * @return true se il posto è libero, false se occupato
     */
    public synchronized boolean libero() {
        return (!occupato);
    }

    /**
     * Cerca di occupare il posto. Restituisce true se l'occupazione è riuscita,
     * false se il posto è già occupato.
     * Questo metodo è sincronizzato per garantire che solo un thread possa
     * occupare un posto alla volta.
     * 
     * @return true se il posto è stato occupato con successo, false se già occupato
     */
    public synchronized boolean occupa() {
        if (occupato)
            return false; // Il posto è già occupato
        else
            return occupato = true; // Il posto viene occupato
    }
}
