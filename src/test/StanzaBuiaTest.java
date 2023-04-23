package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia s;
	private Attrezzo a;
	
	@Before
	public void setUp() {
		this.a=new Attrezzo("lanterna",2);
		this.s=new StanzaBuia("stanza",a);
	}
	
	@Test
	public void testStanzaBuia() {
		assertEquals("qui c'è un buio pesto\n",s.getDescrizione());
	}
	
	@Test
	public void testStanzaIlluminata() {
		s.addAttrezzo(a);
		assertEquals(s.toString(), s.getDescrizione());
	}

}
