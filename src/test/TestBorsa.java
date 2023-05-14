package test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {

	Borsa b = new Borsa();
	Attrezzo a1 = new Attrezzo("a1",1);
	Attrezzo a2 = new Attrezzo("a2",4);
	Attrezzo a4 = new Attrezzo("a4",1);
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(a1));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo troppoPesante = new Attrezzo("vibranio",500);
		assertFalse(b.addAttrezzo(troppoPesante));
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
	
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoDiverso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		List<Attrezzo> l = new ArrayList<>();
		l.add(a1);
		l.add(a2);
		assertArrayEquals(b.getSortedSetOrdinatoPerPeso().toArray(),l.toArray());	
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoUguale() {
		b.addAttrezzo(a1);
		Attrezzo a3 = new Attrezzo("a3", 1);
		b.addAttrezzo(a3);
		List<Attrezzo> l = new ArrayList<>();
		l.add(a1);
		l.add(a3);
		assertArrayEquals(b.getSortedSetOrdinatoPerPeso().toArray(),l.toArray());	
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a4);
		List<Attrezzo> l = new ArrayList<>();
		l.add(a1);
		l.add(a4);
		l.add(a2);
		assertArrayEquals(b.getContenutoOrdinatoPerPeso().toArray(),l.toArray());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo spada = new Attrezzo("spada",3);
		Attrezzo lancia = new Attrezzo("lancia",2);
		b.addAttrezzo(spada);
		b.addAttrezzo(lancia);
		List<Attrezzo> l = new ArrayList<>();
		l.add(lancia);
		l.add(spada);
		assertArrayEquals(l.toArray(),b.getContenutoOrdinatoPerNome().toArray());
	}
	
}
