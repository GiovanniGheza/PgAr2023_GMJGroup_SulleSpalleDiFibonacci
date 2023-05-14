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
		
		int[] controlloEsterno = {1 , 1,2 , 1,3 , 2,4 , 2,5 , 4,6 , 2,7 , 6,8 , 4,9 , 6,10 , 4,11 , 10,12 , 4,13 , 12,14 , 6,15 , 8,16 , 8,17 , 16,18 , 6,19 , 18,20 , 8,21 , 12,22 , 10,23 , 22,24 , 8,25 , 20,26 , 12,27 , 18,28 , 12,29 , 28,30 , 8,31 , 30,32 , 16,33 , 20,34 , 16,35 , 24,36 , 12,37 , 36,38 , 18,39 , 24,40 , 16,41 , 40,42 , 12,43 , 42,44 , 20,45 , 24,46 , 22,47 , 46,48 , 16,49 , 42,50 , 20,51 , 32,52 , 24,53 , 52,54 , 18,55 , 40,56 , 24,57 , 36,58 , 28,59 , 58,60 , 16,61 , 60,62 , 30,63 , 36,64 , 32,65 , 48,66 , 20,67 , 66,68 , 32,69 , 44,70 , 24,71 , 70,72 , 24,73 , 72,74 , 36,75 , 40,76 , 36,77 , 60,78 , 24,79 , 78,80 , 32,81 , 54,82 , 40,83 , 82,84 , 24,85 , 64,86 , 42,87 , 56,88 , 40,89 , 88,90 , 24,91 , 72,92 , 44,93 , 60,94 , 46,95 , 72,96 , 32,97 , 96,98 , 42,99 , 60};
		int controlloInterno[] = new int[controlloEsterno.length];
		
		for(int i = 1; i < 100; i++) {
			System.out.println("phi di Eulero di " + i + " -> " + CalcolatoreDellaPhi.calcolaPhi(i));
			controlloInterno[i] = CalcolatoreDellaPhi.calcolaPhi(i);
		}
		
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