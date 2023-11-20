package exercicis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SumadorConArchivo {

	public void sumar(int n1, int n2, String archivoSalida) {
		int resultado = 0;

		for (int i = n1; i <= n2; i++) {
			resultado += i;
		}

		// Guarda el resultado en el archivo especificado
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
			writer.write("Sumando de " + n1 + " hasta " + n2);
			writer.newLine();
			writer.write("Resultado de este sumador: " + resultado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SumadorConArchivo s = new SumadorConArchivo();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		String archivoSalida = args[2]; // Nombre del archivo de salida proporcionado como tercer argumento

		s.sumar(n1, n2, archivoSalida);
		System.out.println("Resultado guardado en " + archivoSalida);
		// Si se ejecuta directamente no funcion ya que los parametros se pasan desde el lanzador
	}
}