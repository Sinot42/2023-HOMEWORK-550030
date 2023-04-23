package test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoNonValido;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private IO io;
	private FabbricaDiComandiFisarmonica f = new FabbricaDiComandiFisarmonica(io);
	public Partita p =new Partita();
	public Comando c ;
	
	@Test
	public void testComandoNonValido() {
		c = new ComandoNonValido();
		assertEquals(c.getNome(),f.costruisciComando("frena").getNome());
	}
	
	@Test
	public void testComandoValido() {
		c = new ComandoVai();
		assertEquals(c.getNome(),f.costruisciComando("vai nord").getNome());
	}


}
