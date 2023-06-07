package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	private final static String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {
		getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		getIo().mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		if(partita.isFinita()==true) {
			getIo().mostraMessaggio("la partita è finita");
		}else {
			getIo().mostraMessaggio("la partita non è finita");
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}


}
