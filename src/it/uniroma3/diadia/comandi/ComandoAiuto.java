package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda","interagisci","saluta","regala"};
	private final static String NOME = "aiuto";
	

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<elencoComandi.length; i++) 
			getIo().mostraMessaggio(elencoComandi[i]+"");
		System.out.println(" ");
	}
	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}



}
