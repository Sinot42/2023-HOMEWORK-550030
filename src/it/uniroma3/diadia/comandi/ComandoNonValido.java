package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{
	
	private final static String NOME = "comando non valido";

	@Override
	public void esegui(Partita partita) {
		getIo().mostraMessaggio("Comando non valido");
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
