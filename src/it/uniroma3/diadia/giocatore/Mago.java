package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentaz,Attrezzo att) {
		super(nome, presentaz);
		this.attrezzo = att;
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		StringBuilder risposta = new StringBuilder("Grazie per avermi regalato ");
		risposta.append(attrezzo.getNome()+".");
		risposta.append(" Lo modificher� e lo lascer�!");
		Attrezzo attrezzoModificato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoModificato);
		return risposta.toString();
	}

}
