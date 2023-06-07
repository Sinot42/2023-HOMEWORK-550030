package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private Attrezzo a;
	private Partita p;
	private Comando posa;
	private IO io;
	private Labirinto l;
	private Stanza s;
	
	@Before
	public void setUp() throws Exception{
		s = new Stanza("salone");
		l=Labirinto.newBuilder("labirinto3.txt").getLabirinto();
		a = new Attrezzo("spada",2);
		p = new Partita(l);
		posa = new ComandoPosa();
		io = new IOConsole(new Scanner(System.in));
		posa.setIo(io);
		p.setStanzaCorrente(s);
		
	}


	@Test
	public void testPosaNull() {
		posa.setParametro("spada");
		posa.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	@Test
	public void testPosaAttrezzo() {
		p.getGiocatore().getBorsa().addAttrezzo(a);
		posa.setParametro("spada");
		posa.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
}
