package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	
	private IO io;
	private final static String NOME = "comando non valido";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando non valido");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
	}

	
}
