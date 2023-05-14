package it.uniroma3.diadia.ambienti;

public class Labirinto {
	private Stanza ingresso;
	private Stanza uscita;

	public Stanza getIngresso() {
		return ingresso;
	}

	public void setIngresso(Stanza ingresso) {
		this.ingresso = ingresso;
	}

	public Stanza getUscita() {
		return uscita;
	}

	public void setUscita(Stanza uscita) {
		this.uscita = uscita;
	}
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
    
	
}
