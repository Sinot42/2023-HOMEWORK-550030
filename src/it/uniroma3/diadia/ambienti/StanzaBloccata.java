package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.comandi.Direzione;

public class StanzaBloccata extends Stanza{

	private Direzione direzioneBloccata;
	private String aSpeciale;
	
	public StanzaBloccata(String nome,Direzione d,String att) {
		super(nome);
		this.direzioneBloccata=d;
		this.aSpeciale=att;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzione.equals(this.direzioneBloccata) && (super.hasAttrezzo(this.aSpeciale)==false)) {
			return this;
		}
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		if (super.hasAttrezzo(this.aSpeciale)==false) {
			s.append(super.getDescrizione()+"\nla stanza ha la direzione "+this.direzioneBloccata+" bloccata\n");
			s.append("per sbloccarla bisogna portare l'attrezzo "+this.aSpeciale+" in questa stanza\n");
		}else {
			s.append(super.getDescrizione());
		}
		return s.toString();
	}
	
}
