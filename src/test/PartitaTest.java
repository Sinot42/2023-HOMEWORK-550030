package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Labirinto labirinto;
	Partita p;
	Stanza s;

	@Before
	public void setUp()  throws FileNotFoundException, FormatoFileNonValidoException{
		Labirinto l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		//			.addStanzaIniziale("Atrio")
		//			.addStanzaVincente("Biblioteca")
		//			.getLabirinto();
		p = new Partita(l);
		s = new Stanza("cucina");
	}

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
