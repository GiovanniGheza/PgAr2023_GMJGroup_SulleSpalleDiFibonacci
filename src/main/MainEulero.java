package main;

public class MainEulero {

	public static void main(String[] args) {
		while(true) {
			int n = InputDati.leggiInteroPositivo("Inserire il valore di cui calcorale il phi: ");
			long tempo = System.currentTimeMillis();
			int phi = CalcolatoreDellaPhi.calcolaPhi(n);
			tempo = System.currentTimeMillis() - tempo;
			System.out.println("La phi di " + n + " e' " + phi 
					+ "(calcolata in " + ((tempo < 1)? "meno di un": tempo) + " ms)");
			
			if(!InputDati.yesOrNo("----------\nLeggere un'altro numero?"))
				break;
		}
	}
}