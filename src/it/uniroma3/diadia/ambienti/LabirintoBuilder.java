package it.uniroma3.diadia.ambienti;


import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto l;
	private Stanza ultimaStanzaAggiunta;
	private Map<String,Stanza> nome2stanza;
	
	public LabirintoBuilder() {
		this.l=new Labirinto();
		this.nome2stanza=new HashMap<>();
	}
	
	public Map<String,Stanza> getNome2Stanza(){
		return this.nome2stanza;
	}
	
	public void setUltimaStanzaAggiunta(Stanza s) {
		this.ultimaStanzaAggiunta=s;
		this.nome2stanza.put(s.getNome(), s);
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.l.setIngresso(s);
		this.setUltimaStanzaAggiunta(s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String s,int i) {
		Attrezzo att = new Attrezzo(s,i);
		this.ultimaStanzaAggiunta.addAttrezzo(att);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String s) {
		Stanza stanza = new Stanza(s);
		l.setUscita(stanza);
		this.setUltimaStanzaAggiunta(stanza);
		return this;
	}
	
	
	public LabirintoBuilder addAdiacenza(String s1,String s2,String direzione) {
		Stanza c = this.nome2stanza.get(s1);
		Stanza u = this.nome2stanza.get(s2);
		c.impostaStanzaAdiacente(direzione, u);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nome, Attrezzo attrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
		this.setUltimaStanzaAggiunta(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nome,int s) {
		Stanza stanza = new StanzaMagica(nome,s);
		this.setUltimaStanzaAggiunta(stanza);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome,String direzione,Attrezzo att) {
		Stanza stanza = new StanzaBloccata(nome,direzione,att);
		this.setUltimaStanzaAggiunta(stanza);
		return this;
	}

	public Labirinto getLabirinto() {
		return this.l;
	}
	


}
