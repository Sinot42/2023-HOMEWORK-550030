package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

public class TestLabirinto {
	
	private Partita p;
	
	@Before
	public void setUp() {
		Labirinto l = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		p = new Partita(l);
	}
	
	@Test
	public void testIngresso() {
		assertEquals("Atrio",p.getLabirinto().getIngresso().getNome());
	}
	
	@Test
	public void testUscita() {
		assertEquals("Biblioteca",p.getLabirinto().getUscita().getNome());
	}

}
