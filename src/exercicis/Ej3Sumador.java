package exercicis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Ej3Sumador {

	public int sumar(int n1, int n2) {
		System.out.println("Sumando de " + n1 + " hasta " + n2);
		int resultado = 0;

		for (int i = n1; i <= n2; i++) {
			resultado = resultado + i;
		}

		return resultado;
	}

	public static void main(String[] args) {
		Ej3Sumador s = new Ej3Sumador();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int resultado = s.sumar(n1, n2);

		String rutaDirectoriActual = System.getProperty("user.dir");
		File fitxerResultat = new File(rutaDirectoriActual, "fitxerResultat.txt");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fitxerResultat));
			bw.write("Resultado sumador de" + n1 + " a " + n2 + ":" + String.valueOf(resultado));
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}