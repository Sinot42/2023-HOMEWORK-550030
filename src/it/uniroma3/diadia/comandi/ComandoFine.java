package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	private final static String NOME = "fine";
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		getIo().mostraMessaggio("Grazie di aver giocato!");
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}

}
