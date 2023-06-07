package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoIlluminante;

	public StanzaBuia(String nome,String attrezzoPerVedere) {
		super(nome);
		this.attrezzoIlluminante=attrezzoPerVedere;
	} 

	@Override
	public String getDescrizione() {
		StringBuilder s = new StringBuilder();
		if(super.hasAttrezzo(this.attrezzoIlluminante)==true) {
			s.append(super.getDescrizione());
			return s.toString();
		}
		else {
			s.append("qui c'è un buio pesto\n");
			return s.toString();
		}
	}

}
