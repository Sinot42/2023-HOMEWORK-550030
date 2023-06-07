package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Direzione;
import it.uniroma3.diadia.giocatore.AbstractPersonaggio;
import it.uniroma3.diadia.giocatore.Cane;
import it.uniroma3.diadia.giocatore.Mago;
import it.uniroma3.diadia.giocatore.Strega;

public class CaricatoreLabirinto {
	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";             

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";
	
	/* prefisso della riga contenente le specifiche del Mago  da collocare nel formato <nomeMago> <presentazione> <attrezzo>*/
	private static final String MAGO_MARKER = "Mago:";
	
	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeStrega> <presentazione> */
	private static final String STREGA_MARKER = "Strega:";
	
	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeCane> <presentazione> */
	private static final String CANE_MARKER = "Cane:";
	
	/* prefisso della riga contenente le specifiche di una stanza buia */
	private static final String STANZA_BUIA_MARKER = "Buia:";
	
	/* prefisso della riga contenente le specifiche di una stanza magica */
	private static final String STANZA_MAGICA_MARKER = "Magica:";
	
	/* prefisso della riga contenente le specifiche di una stanza bloccata */
	private static final String STANZA_BLOCCATA_MARKER = "Bloccata:";

	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;


	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiInizialeEvincente();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
			this.leggiECreaMago();
			this.leggiECreaStrega();
			this.leggiECreaCane();
			this.leggiECreaStanzaBuia();
			this.leggiECreaStanzaMagica();
			this.leggiECreaStanzaBloccata();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	private void leggiECreaStanzaBloccata() throws FormatoFileNonValidoException{
		// TODO Auto-generated method stub
		String specificaStanze = this.leggiRigaCheCominciaPer(STANZA_BLOCCATA_MARKER);
		for(String specifica : separaStringheAlleVirgole(specificaStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)){
				while(scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la  stanza "+ specifica+" non esiste\n"));
					String nomeStanza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la  direzione della stanza"+ specifica+" non esiste\n"));
					Direzione direzione = Direzione.valueOf(scannerDiLinea.next());
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("vi è stato qualche problema nella creazione dell'attrezzo per sbloccare la stanza "+specifica+"\n"));
					String attrezzoSbloccante = scannerDiLinea.next();

					Stanza stanza = new StanzaBloccata(nomeStanza, direzione, attrezzoSbloccante);
					this.nome2stanza.put(nomeStanza, stanza);
				}
			}
		}
	}

	private void leggiECreaStanzaMagica() throws FormatoFileNonValidoException{
		// TODO Auto-generated method stub
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZA_MAGICA_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new StanzaMagica(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}
		

	private void leggiECreaStanzaBuia() throws FormatoFileNonValidoException{
		// TODO Auto-generated method stub
		String specificaStanze = this.leggiRigaCheCominciaPer(STANZA_BUIA_MARKER);
		for(String specifica : separaStringheAlleVirgole(specificaStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)){
				while(scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la  stanza "+ specifica+" non esiste\n"));
					String nomeStanza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("vi è stato qualche problema nella creazione dell'attrezzo per vedere la stanza "+specifica+"\n"));
					String attrezzoPerVedere = scannerDiLinea.next();

					Stanza stanza = new StanzaBuia(nomeStanza, attrezzoPerVedere);
					this.nome2stanza.put(nomeStanza, stanza);
				}
			}
		}
	}

	private void leggiECreaMago() throws FormatoFileNonValidoException {
		// TODO Auto-generated method stub
		String specificaStanze = this.leggiRigaCheCominciaPer(MAGO_MARKER);
		for(String specifica : separaStringheAlleVirgole(specificaStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)){
				while(scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la  stanza "+ specifica+"per aggiungere il mago non esiste\n"));
					String nomeStanza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("problemi nella creazione del mago ...\n"));
					String mago = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("specifica la presentazione del mago\n"));
					String presentazione = scannerDiLinea.next();					
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("vi è stato qualche problema nella creazione dell'attrezzo per il mago della stanza "+specifica+"\n"));
					String attrezzo = scannerDiLinea.next();

					AbstractPersonaggio personaggio = new Mago(mago, presentazione, new Attrezzo(attrezzo, 4));
					this.nome2stanza.get(nomeStanza).setPersonaggio(personaggio);
				}
			}
		}
	}

	private void leggiECreaStrega() throws FormatoFileNonValidoException {
		// TODO Auto-generated method stub
		String specificaStanze = this.leggiRigaCheCominciaPer(STREGA_MARKER);
		for(String specifica : separaStringheAlleVirgole(specificaStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)){
				while(scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la  stanza "+ specifica+"per aggiungere la strega non esiste\n"));
					String nomeStanza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("problemi nella creazione della strega ...\n"));
					String strega = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("specifica la presentazione della strega\n"));
					String presentazione = scannerDiLinea.next();					
			
					AbstractPersonaggio personaggio = new Strega(strega,presentazione);
					this.nome2stanza.get(nomeStanza).setPersonaggio(personaggio);
				}
			}
		}
	}

	private void leggiECreaCane() throws FormatoFileNonValidoException {
		// TODO Auto-generated method stub
		String specificaStanze = this.leggiRigaCheCominciaPer(CANE_MARKER);
		for(String specifica : separaStringheAlleVirgole(specificaStanze)) {
			try (Scanner scannerDiLinea = new Scanner(specifica)){
				while(scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la  stanza "+ specifica+"per aggiungere il cane non esiste\n"));
					String nomeStanza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("problemi nella creazione del cane ...\n"));
					String cane = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("specifica la presentazione del cane\n"));
					String presentazione = scannerDiLinea.next();					

					AbstractPersonaggio personaggio = new Cane(cane,presentazione);
					this.nome2stanza.get(nomeStanza).setPersonaggio(personaggio);
				}
			}
		}
		
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			while(scannerDiParole.hasNext()) {
				result.add(scannerDiParole.next());
			}
		}
		return result;
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
		nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
				nomeStanza = scannerLinea.next();
			}				
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		for(String specifiche : separaStringheAlleVirgole(specificheUscite)) {
			try (Scanner scannerDiLinea = new Scanner(specifiche)) 	{	
				while (scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
					String stanzaPartenza = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
					String dir = scannerDiLinea.next();
					check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
					String stanzaDestinazione = scannerDiLinea.next();

					impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
				}
			}
		} 
	}

	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa,String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(Direzione.valueOf(dir), arrivoA);
	}



	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
}
