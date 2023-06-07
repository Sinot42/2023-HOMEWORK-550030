package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;


public class LabirintoBuilderTest {
	Labirinto.LabirintoBuilder lb;

	@Before
	public void setUp() throws Exception {
		lb = new LabirintoBuilder("labirinto.txt");
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class, lb.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		lb.addStanzaIniziale("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		assertEquals(expected, lb.getNome2stanza().get("stanzetta"));
	}

	

	@Test
    public void testAddAttrezzoConStanza() {
        lb.addStanzaIniziale("stanzetta");
        lb.addAttrezzo("cacciavite", 3);
        assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}