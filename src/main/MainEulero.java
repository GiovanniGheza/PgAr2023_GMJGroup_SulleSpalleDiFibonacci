package main;

import java.util.ArrayList;

public class MainEulero {

	public static void main(String[] args) {
		
		//for(int i = 0; i < 100; i++)
		
		/*int n = 32;
		long tempoIniziale = System.currentTimeMillis();
		
		System.out.println("e' primo " + n + "?" + " " + CalcolatoreDellaPhi.isPrimo(n));
		System.out.println("scomposizione " + n + " " + ArrayListOfArrayToString(CalcolatoreDellaPhi.scomponi(n)));
		System.out.println("e' potenza di un numero primo " + n + "?" + " " + !CalcolatoreDellaPhi.PotenzaDiPrimo(n).equals(new int[] {0,0}));
		System.out.println("phi di Eulero di " + n + ": " + CalcolatoreDellaPhi.calcolaPhi(n));
		System.out.println("Tempo:" + (System.currentTimeMillis() - tempoIniziale));*/
		
		long tempoIniziale = System.currentTimeMillis();
		int n = 100000;
		
		for(int i = 1; i < n; i++) {
			//tempoIniziale = System.currentTimeMillis();
			CalcolatoreDellaPhi.calcolaPhi(i);
			//if(i % (1000000 / 100) == 0) System.out.println(i * 100/1000000 + "% numero: " + i);
			/*if(System.currentTimeMillis() - tempoIniziale < 10 && i > 100000)
				System.out.println("phi di Eulero di " + i + " calcolato in meno di un decimo di secondo");*/
			//System.out.println("phi di Eulero di " + i + " -> " + CalcolatoreDellaPhi.calcolaPhi(i));
		}
		
		System.out.println("Fatto in " + (System.currentTimeMillis() - tempoIniziale) + "ms");
		
		int k = 100000 + 1230;
		
		tempoIniziale = System.currentTimeMillis();
		System.out.println("phi di Eulero di " + k + " -> " + CalcolatoreDellaPhi.calcolaPhi(k));
		System.out.println("Fatto in " + (System.currentTimeMillis() - tempoIniziale) + "ms");
		
		/*tempoIniziale = System.currentTimeMillis();
		System.out.println("phi di Eulero di " + 100000 + " -> " + CalcolatoreDellaPhi.calcolaPhi(100000));
		System.out.println("Fatto in " + (System.currentTimeMillis() - tempoIniziale) + "ms");
		
		tempoIniziale = System.currentTimeMillis();
		System.out.println("phi di Eulero di " + 186145 + " -> " + CalcolatoreDellaPhi.calcolaPhi(186145));
		System.out.println("Fatto in " + (System.currentTimeMillis() - tempoIniziale) + "ms");
		
		tempoIniziale = System.currentTimeMillis();
		System.out.println("phi di Eulero di " + 990991 + " -> " + CalcolatoreDellaPhi.calcolaPhi(990991));
		System.out.println("Fatto in " + (System.currentTimeMillis() - tempoIniziale) + "ms");
		
		tempoIniziale = System.currentTimeMillis();
		System.out.println("phi di Eulero di " + 186145 + " -> " + CalcolatoreDellaPhi.calcolaPhi(186145));
		System.out.println("Fatto in " + (System.currentTimeMillis() - tempoIniziale) + "ms");*/
		
		/*for(int i = 1; i < 100; i++) {
			if(controlloInterno[i] != controlloEsterno[i * 2 - 1])
				System.out.println("!");
		}*/
	}
	
	public static String ArrayListOfArrayToString(ArrayList<int[]> a) {
		StringBuffer str = new StringBuffer("[");
		
		for(int[] c: a) {
			str.append("(" + c[0] + "," + c[1] + ")");
		}
		
		str.append("]");
		
		return str.toString();
	}
}