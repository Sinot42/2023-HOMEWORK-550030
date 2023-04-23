package test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class TestGiocatore {

	Giocatore g = new Giocatore();
	
	@Test
	public void testCfuIniziali() {
		assertEquals(20,g.getCfu());
	}
	
	@Test
	public void testGetBorsaVuota() {
		assertEquals("Borsa vuota",g.getBorsa().toString());
	}


}
