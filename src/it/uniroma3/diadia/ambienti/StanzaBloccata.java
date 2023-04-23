package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	private String direzioneBloccata;
	private Attrezzo aSpeciale;
	
	public StanzaBloccata(String nome,String d,Attrezzo att) {
		super(nome);
		this.direzioneBloccata=d;
		this.aSpeciale=att;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata) && (super.hasAttrezzo(this.aSpeciale.getNome())==false)) {
			return this;
		}
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		if (super.hasAttrezzo(this.aSpeciale.getNome())==false) {
			s.append(super.getDescrizione()+"\nla stanza ha la direzione "+this.direzioneBloccata+" bloccata\n");
			s.append("per sbloccarla bisogna portare l'attrezzo "+this.aSpeciale.getNome()+" in questa stanza\n");
		}else {
			s.append(super.getDescrizione());
		}
		return s.toString();
	}
	
}
