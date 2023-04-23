package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class TestLabirinto {
	
	Labirinto l = new Labirinto();
	
	@Before
	public void setUp() {
		l.creaStanze();
	}
	
	@Test
	public void testIngresso() {
		assertEquals("Atrio",l.getIngresso().getNome());
	}
	
	@Test
	public void testUscita() {
		assertEquals("Biblioteca",l.getUscita().getNome());
	}

}
