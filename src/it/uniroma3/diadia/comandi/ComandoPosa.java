package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		if(a!=null) {
			partita.getGiocatore().getBorsa().removeAttrezzo(a.getNome());
			partita.getStanzaCorrente().addAttrezzo(a);
			getIo().mostraMessaggio("attrezzo posato");
		}else {
			getIo().mostraMessaggio("non hai posato niente");
		}
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}


}
