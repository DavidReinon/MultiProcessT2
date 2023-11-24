package exercicis;

public class Ej1Sumador {

	public int sumar(int n1, int n2) {
		System.out.println("Sumando de " + n1 + " hasta " + n2);
		int resultat = 0;

		for (int i = n1; i <= n2; i++) {
			resultat = resultat + i;
		}

		return resultat;
	}

	public static void main(String[] args) {
		Ej1Sumador s = new Ej1Sumador();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int resultat = s.sumar(n1, n2);
		System.out.println("resultat de este sumador: " + resultat);
	}
}