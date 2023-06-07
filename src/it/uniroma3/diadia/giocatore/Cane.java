package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	private static final String MESSAGGIO="Ti ho morso e ti ho tolto un CFU" ;
	private static final Object CIBO_PREFERITO = "osso";
	
	public Cane(String nome,String present) {
		super(nome,present);
	}
	
	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		StringBuilder risposta = new StringBuilder("Bau grazie per avermi regalato ");

		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("il mio cibo preferito.");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 2));
		} else {
		risposta.append(attrezzo.getNome()+",ma non e' il mio cibo preferit, bau!");
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		
		return risposta.toString();
	}
	
}
