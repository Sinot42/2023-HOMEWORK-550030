package test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	
	private Stanza s1 = new Stanza("cucina");
	private Stanza s2 = new Stanza("salone");
	private Comando vai = new ComandoVai();
	private Partita p = new Partita();
	
	@Test
	public void testVaiNull() {
		p.setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1,p.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneEsistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertEquals(s2,p.getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneSbagliata() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertNotEquals(s2,p.getStanzaCorrente());
	}
	
}
