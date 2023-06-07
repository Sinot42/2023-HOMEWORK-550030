package test;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestLabirinto{
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				Labirinto.newBuilder()
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("martello", 3)
//				.addStanzaVincente("Biblioteca")
//				.addAdiacenza("Atrio", "Biblioteca", "nord")
//				.getLabirinto();
		 biblioteca = new Stanza("Biblioteca");
		 DS1 = new Stanza("DS1");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getUscita().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		assertEquals("Atrio", l.getIngresso().getNome());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getIngresso().getNome());
	}

}
