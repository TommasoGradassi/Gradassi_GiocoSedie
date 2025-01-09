/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradassi_giocosedie;

class Posto

{
	private boolean occupato;

	public Posto()

	{
		occupato = false;
	}

	public synchronized boolean libero() {
		return (!occupato);
	}

	public synchronized boolean occupa() {
		if (occupato)
			return false;
		else
			return occupato = true;
	}
}