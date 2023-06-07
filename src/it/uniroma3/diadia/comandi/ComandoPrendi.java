package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{

	private final static String NOME = "prendi";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(this.getParametro());
		if(a!=null) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			getIo().mostraMessaggio("attrezzo preso");
		}else {
			getIo().mostraMessaggio("non hai preso niente");
		}
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}

}
