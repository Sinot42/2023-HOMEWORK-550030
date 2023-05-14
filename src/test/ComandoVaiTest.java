package test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	
	private Labirinto l;
	private Comando vai;
	private IO io;
	private Partita p;
	private Stanza s1;
	private Stanza s2;
	
	
	@Before
	public void setUp() throws Exception{
	l=new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("martello", 3)
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", "nord")
			.getLabirinto();
	vai = new ComandoVai();
	p = new Partita(l);
	s1 = new Stanza("cucina");
	s2 = new Stanza("salone");
	io= new IOConsole();
	vai.setIo(io);
	}
	
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
