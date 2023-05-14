package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	Stanza salone = new Stanza("Salone");
	Stanza cucina = new Stanza("Cucina");
	Attrezzo martello = new Attrezzo("Martello",3);
	Attrezzo spada = new Attrezzo("Spada",4);
	

	@Test
	public void testImpostaStanzaAdiacente() {
		salone.impostaStanzaAdiacente("nord", cucina);
		assertEquals(cucina,salone.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteNull() {
		assertNull(salone.getStanzaAdiacente("nord"));
	}
	
	
	@Test
	public void testAddAttrezzo() {
		salone.addAttrezzo(martello);
		assertTrue(salone.addAttrezzo(martello));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		salone.addAttrezzo(martello);
		assertTrue(salone.removeAttrezzo(martello));
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		salone.addAttrezzo(martello);
		assertFalse(salone.removeAttrezzo(spada));
	}
	
}
