package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita p = new Partita();
	Stanza s1 = new Stanza("s1");
	Stanza s2 = new Stanza("s2");
	
	@Test
	public void testPartitaNonVinta() {
		assertFalse(p.vinta());
	}
	
	@Test
	public void testPartitaVinta() {
		p.setStanzaCorrente(s2);
		p.getLabirinto().setUscita(s2);
		assertTrue(p.vinta());
	}
	
	@Test
	public void testStanzaCorrente() {
		p.setStanzaCorrente(s2);
		assertEquals(p.getStanzaCorrente(),s2);
	}
	
	
	@Test
	public void testParitaInCorso() {
		assertFalse(p.isFinita());
	}
	
	
}
