package test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private Partita p;
	private Attrezzo a;
	private Comando prendi;
	private IO io;
	Labirinto l;
	
	@Before
	public void setUp() throws Exception{
		l=Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("martello", 3)
//				.addStanzaVincente("Biblioteca")
//				.addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
//				.getLabirinto();
		p=new Partita(l);
		a=new Attrezzo("spada",2);
		prendi=new ComandoPrendi();
		io = new IOConsole(new Scanner(System.in));
		prendi.setIo(io);
		
	}
	
	@Test
	public void testPrendiAttrezzo() {
		prendi.setParametro("spada");
		p.getStanzaCorrente().addAttrezzo(a);
		prendi.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("spada"));
	}
	
	@Test
	public void testPrendiAttrezzoSbagliato() {
		Attrezzo a2 = new Attrezzo("scudo",5);
		p.getStanzaCorrente().addAttrezzo(a2);
		prendi.setParametro("spada");
		prendi.esegui(p);
		assertEquals(a2,p.getStanzaCorrente().getAttrezzo("scudo"));
	}
	
	@Test
	public void testPrendiNull() {
		Attrezzo a2 = new Attrezzo("scudo",5);
		p.getStanzaCorrente().addAttrezzo(a2);
		prendi.setParametro("spada");
		prendi.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("spada"));
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("scudo"));
	}

}
