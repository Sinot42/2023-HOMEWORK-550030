package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoAiuto;

public class AbstractComandoTest {

	private IO io;
	private AbstractComando astratto;
	
	@Before
	public void setUp() throws Exception{
		io = new IOConsole(new Scanner(System.in));
		astratto = new ComandoAiuto();
	}
	
	@Test
	public void testSetParametro() {
		String stringa = new String("casa");
		astratto.setParametro(stringa );
		assertEquals(stringa,astratto.getParametro());
	}
	
	@Test
	public void testSetIo() {
		astratto.setIo(io);
		assertEquals(io,astratto.getIo());
	}

}
