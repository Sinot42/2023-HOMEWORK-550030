package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Direzione;

public class StanzaBloccataTest {

	private StanzaBloccata s;
	private Attrezzo a;
	
	@Before
	public void setUp(){
		this.a=new Attrezzo("chiave",1);
		this.s=new StanzaBloccata("sala",Direzione.nord,this.a.getNome());
	}
	
	@Test
	public void testStanzaSbloccata() {
		s.addAttrezzo(this.a);
		Stanza s1=new Stanza("cucina");
		s.impostaStanzaAdiacente(Direzione.nord, s1);
		assertEquals(s1.getDescrizione(),s.getStanzaAdiacente(Direzione.nord).getDescrizione());
	}

	@Test
	public void testStanzaBloccata() {
		Stanza s1=new Stanza("cucina");
		s.impostaStanzaAdiacente(Direzione.nord, s1);
		assertEquals(s.getDescrizione(),s.getStanzaAdiacente(Direzione.nord).getDescrizione());
	}
}
