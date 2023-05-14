package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo!=null) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			if (this.numeroAttrezzi==10)
				return false;
			this.attrezzi.add(attrezzo);
			this.numeroAttrezzi++;
			return true;
		}
		else return false;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		int trovato=0;
		Attrezzo a = null;
		while(it.hasNext()==true && trovato==0) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				trovato=1;
			}
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			peso += it.next().getPeso();
		}
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		int trovato=0;
		while(it.hasNext() && trovato==0) {
			a = it.next();
			if(nomeAttrezzo.equals(a.getNome())) {
				this.attrezzi.remove(a);
				this.numeroAttrezzi--;
				trovato=1;
			}
		}
		return a;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		Attrezzo a = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			while(it.hasNext()) {
				a = it.next();
				if(a!=null)
					s.append(a.toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> list = new ArrayList<>();
		list.addAll(this.attrezzi);
		ComparatoreAttrezziPerPeso c = new ComparatoreAttrezziPerPeso();
		Collections.sort(list, c);
		return list;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		ComparatoreAttrezziPerNome c = new ComparatoreAttrezziPerNome();
		SortedSet<Attrezzo> s = new TreeSet<Attrezzo>(c);
		s.addAll(this.attrezzi);
		return s;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		Map<Integer,Set<Attrezzo>> m = new TreeMap<>();
		Attrezzo a = null;
		while(it.hasNext()) {
			a = it.next();
			if(m.containsKey(a.getPeso())) {
				m.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo>  s =new HashSet<Attrezzo>();
				s.add(a);
				m.put(a.getPeso(), s);
			}
		}
		return m;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> s = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		s.addAll(this.attrezzi);
		return s;
	}
	

	

	
	
	
}

