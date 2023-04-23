package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{

	private Attrezzo attrezzoIlluminante;

	public StanzaBuia(String nome,Attrezzo a) {
		super(nome);
		this.attrezzoIlluminante=a;
	} 

	@Override
	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		if(super.hasAttrezzo(this.attrezzoIlluminante.getNome())==true) {
			s.append(super.getDescrizione());
			return s.toString();
		}
		else {
			s.append("qui c'è un buio pesto\n");
			return s.toString();
		}
	}

}
