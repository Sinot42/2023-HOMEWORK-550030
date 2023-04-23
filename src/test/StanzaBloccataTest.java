package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata s;
	private String direzioneB;
	private Attrezzo a;
	
	@Before
	public void setUp(){
		this.direzioneB="nord";
		this.a=new Attrezzo("chiave",1);
		this.s=new StanzaBloccata("sala",this.direzioneB,this.a);
	}
	
	@Test
	public void testStanzaSbloccata() {
		s.addAttrezzo(this.a);
		Stanza s1=new Stanza("cucina");
		s.impostaStanzaAdiacente(direzioneB, s1);
		assertEquals(s1.getDescrizione(),s.getStanzaAdiacente(direzioneB).getDescrizione());
	}

	@Test
	public void testStanzaBloccata() {
		Stanza s1=new Stanza("cucina");
		s.impostaStanzaAdiacente(direzioneB, s1);
		assertEquals(s.getDescrizione(),s.getStanzaAdiacente(direzioneB).getDescrizione());
	}
}
