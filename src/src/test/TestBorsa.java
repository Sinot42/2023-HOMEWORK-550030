package test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {

	Borsa b = new Borsa();
	Attrezzo a1 = new Attrezzo("a1",1);
	Attrezzo a2 = new Attrezzo("a2",30);
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(a1));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		assertFalse(b.addAttrezzo(a2));
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		assertFalse(b.addAttrezzo(null));
	}
	
	@Test
	public void hasAttrezzo() {
		b.addAttrezzo(a1);
		assertTrue(b.hasAttrezzo("a1"));
	}
	
	@Test
	public void removeAttrezzo() {
		b.addAttrezzo(a1);
		b.removeAttrezzo("a1");
		assertFalse(b.hasAttrezzo("a1"));
	}
	
	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(a1);
		assertEquals(a1,b.getAttrezzo("a1"));
	}
	
	

}
