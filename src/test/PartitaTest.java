package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	Labirinto l = new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addStanzaVincente("Biblioteca")
			.getLabirinto();
	Partita p = new Partita(l);
	Stanza s = new Stanza("cucina");
	
	@Test
	public void testPartitaNonVinta() {
		assertFalse(p.vinta());
	}
	
	@Test
	public void testPartitaVinta() {
		p.setStanzaCorrente(s);;
		p.getLabirinto().setUscita(s);
		assertTrue(p.vinta());
	}
	
	@Test
	public void testStanzaCorrente() {
		p.setStanzaCorrente(s);
		assertEquals(p.getStanzaCorrente(),s);
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getUscita().getNome());
	}
	
	@Test
	public void testParitaInCorso() {
		assertFalse(p.isFinita());
	}
	
	
}
