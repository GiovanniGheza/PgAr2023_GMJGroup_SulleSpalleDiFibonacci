package main;

import java.util.*;

public abstract class CalcolatoreDellaPhi {
	
	private static ArrayList<Integer> numeriPrimiTrovati = new ArrayList<Integer>();
	private static Map<Integer,Integer> phiTrovati = new HashMap<>();
	
	public static int calcolaPhi(int n) {
		
		//calcolo primi 100 000 numeri
		//con TreeMap e questo if: 20345 ms
		//con HashMap e questo if: 20321 ms
		//senza questo if: 39621 ms
		if(phiTrovati.containsKey(n)) {
			return phiTrovati.get(n);
		}
		
		//se e' uno il phi e' uno
		if(n == 1) {
			phiTrovati.put(n,1);
			return 1;
		}
		
		//se il numero e' primo il phi e' n - 1 (fonte: wikipedia)
		if(isPrimo(n)) {
			phiTrovati.put(n, n - 1);
			return n - 1;
		}
		
		//primo caso, il numero e' una potenza di un numero primo
		int[] potenzaDiPrimo = PotenzaDiPrimo(n);
		if(!(potenzaDiPrimo[0] == 0 && potenzaDiPrimo[1] == 0)) {
			int phi = (int) ((potenzaDiPrimo[0] - 1)*Math.pow(potenzaDiPrimo[0], potenzaDiPrimo[1] - 1));
			phiTrovati.put(n,phi);
			return phi;
		}
		
		//secondo caso: n = a*b, con MCD(a,b) = 1
		int[] secondoCaso = SecondoCaso(n);
		if(!(secondoCaso[0] == 0 && secondoCaso[1] == 0)) {
			int phi = calcolaPhi(secondoCaso[0])*calcolaPhi(secondoCaso[1]);
			phiTrovati.put(n,phi);
			return phi;
		}
		
		//caso qualcosa e' andato storto, ritorno -1 (un valore impossibile) come avvertimento
		return -1;
	}
	
	/**
	 * con secondo caso si intende: n = a*b, con MCD(a,b) = 1
	 * @param n numero di cui si vuole sapere se il secondo caso avviene
	 * @return vero se siamo nel secondo caso
	 */
	private static int[] SecondoCaso(int n) {
		
		//le coppie sono quei numeri a e b che moltiplicati tra loro danno n
		ArrayList<int[]> coppie = scomponi(n);
		
		//controllo se tra le coppie c'e' ne' almeno una con mcd = 1
		for(int[] coppia: coppie) {
			//controllo il mcd se e' uguale a uno,
			//inoltre controllo che non stia controllando la coppia 1,n
			if(mcd(coppia[0], coppia[1]) == 1 && coppia[1] != 1 && coppia[0] != 1)
				return new int[] {coppia[0], coppia[1]};
		}
		
		//se non siamo nel secondo caso ritorno come coppia 0,0
		return new int[] {0, 0};
	}
	
	/**
	 * controlla se un numero e' una potenza di primo
	 * @param n - il numero da controllare
	 * @return il numero primo e il suo esponente se n e' una potenza di primo, [0,0] altrimenti
	 */
	public static int[] PotenzaDiPrimo(int n) {
		if(numeriPrimiTrovati.isEmpty()) {
			numeriPrimiTrovati.add(2);
		}
		
		int pow = 0;
		
		for(int primo: numeriPrimiTrovati) {
			for(int i = 0; pow < n; i++) {
				pow = (int) Math.pow(primo, i);
				if(pow == n)
					return new int[]{primo, i};
			}
			pow = 0;
		}
		
		return new int[]{0, 0};
	}
	
	/**
	 * calcola il massimo comune divisore tra due numeri
	 * @param m - il primo numero
	 * @param n - il secondo numero
	 * @return il mcd dei due numeri
	 */
	public static int mcd(int m, int n) {
		int temp = 0;
		while (n != 0) {
			temp = n;
			n = m % n;
			m = temp;
			}
		return m;
	}
	
	/**
	 * scompone un numero in coppie di valori che moltiplicati tra loro danno il numero inserito
	 * @param n - numero da scomporre
	 * @return la lista delle coppie di valori che moltiplicati tra loro danno il numero inserito
	 */
	public static ArrayList<int[]> scomponi(int n) { 
		//tutte le coppiedi valori
		ArrayList<int[]> coppieDiValori = new ArrayList<int[]>();

		//perche' faccio questo controllo?
		if(n > numeriPrimiTrovati.get(numeriPrimiTrovati.size() - 1))
			calcolaPrimiFinoA(n);
		
		//scorro tutti i numeri tra 1 e la radice di n
		for(int i = 1; i <= Math.sqrt(n); i++) {
			//se n e' divisibile per i allora ho trovato una coppia di numeri, n/i e i
			if(n % i == 0) {
				coppieDiValori.add(new int[]{n / i, i});
			}
		}
		
		//ho finitro di trovare le coppie quindi le ritorno
		return coppieDiValori;
	}
	 
	/**
	 * controlla se un numero e' primo
	 * @param n - il numero che si vuol sapere se e' primo
	 * @return vero se il numero e' primo, falso altrimenti
	 */
	public static boolean isPrimo(int n) {
		//uno e' un numero primo
		if(n == 1)
			return true;
		
		//se la lista di numeri primi e' vuota aggiungo il 2
		if(numeriPrimiTrovati.isEmpty()) {
			numeriPrimiTrovati.add(2);
		}
		//se n e' piu' alto del piu' grande numero primo che possiedo
		//devo calcolare nuovi numeri primi
		if(n > numeriPrimiTrovati.get(numeriPrimiTrovati.size() - 1))
			calcolaPrimiFinoA(n);
		
		//controllo se n e' tra i miei numeri primi calcolati
		return numeriPrimiTrovati.contains(n);
	}
	
	/**
	 * calcola tutti i numeri primi fino a un numero dato
	 * e, se ne trova di nuovi, li aggiunge alla lista di numeri primi della classe
	 * @param n - il numero fino a dove si vuol cercare
	 */
	private static void calcolaPrimiFinoA(int n) {
		//se la lista di numeri primi e' vuota aggiungo il 2
		if(numeriPrimiTrovati.isEmpty())
			numeriPrimiTrovati.add(2);
		
		//se n e' minore o uguale al piu' grande numero primo gia' calcolato
		//non ho bisogno di trovarne di nuovi
		if(n <= numeriPrimiTrovati.get(numeriPrimiTrovati.size() - 1))
			return;
		
		
		boolean isPrimo;
		
		//controllo tutti i numeri tra il primo numero dopo il piu' grande numero primo gia' calcolato
		//ed n incluso
		for(int i = numeriPrimiTrovati.get(numeriPrimiTrovati.size() - 1) + 1; i <= n; i++) {
			//suppongo che il numero che sto controllando sia primo
			isPrimo = true;
			//scorro tutti i miei numeri primi,
			//mi basta usare solo i numeri primi e non tutti i numeri tra 2 ed i
			//visto che tutti i numeri non primi sono scomponibili in numeri primi
			for(int primo: numeriPrimiTrovati) {
				//se scopro che i e' divisibile per un numero significa che non e' primo
				if(i % primo == 0) {
					//dico che non e' primo
					isPrimo = false;
					//mi fermo nel cercare altri divisori
					break;
				}
			}
			
			//se non ho trovato divisori i e' un numero primo
			if(isPrimo)
				numeriPrimiTrovati.add(i);
		}
	}
}