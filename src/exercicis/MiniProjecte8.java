package exercicis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MiniProjecte8 {

	public static void main(String[] args) {
		String inputFile = "datos_neo.txt";
		String outputDirectory = "resultados_neo//";

//		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
//			String line = " ";
//			while ((line = reader.readLine()) != null) {
//				String[] parts = line.split(",");
//				if (parts.length != 3) {
//					System.err.println("Error: Datos incorrectos en la línea: " + line);
//					continue;
//				}

		String neoName = args[0];
		double positionNEO = Double.parseDouble(args[1]);
		double velocityNEO = Double.parseDouble(args[2]);

		// Realiza cálculos para determinar la probabilidad de colisión
		double collisionProbability = calcularProbabilidadColision(positionNEO, velocityNEO);

		// Guarda la probabilidad en un archivo independiente
		String outputFileName = outputDirectory + neoName + ".txt";
		guardarProbabilidadEnArchivo(outputFileName, collisionProbability);

		// Muestra las probabilidades de colisión
		System.out.println(
				"Probabilidad de colision para " + neoName + ": " + String.format("%.2f", collisionProbability));

		// Genera alertas si es necesario
		if (collisionProbability > 0.10) {
			System.err.println("¡Alerta mundial! Probabilidad de colision alta para " + neoName);
		} else {
			System.out.println("Todo tranquilo para " + neoName);
		}
	}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	private static double calcularProbabilidadColision(double positionNEO, double velocityNEO) {
		double posicioTerra = 1;
		double velocitatTerra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
			positionNEO = positionNEO + velocityNEO * i;
			posicioTerra = posicioTerra + velocitatTerra * i;
		}
		double resultat = 100 * Math.random()
				* Math.pow(((positionNEO - posicioTerra) / (positionNEO + posicioTerra)), 2);
		return resultat;
	}

	private static void guardarProbabilidadEnArchivo(String fileName, double probability) {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write("Probabilidad de colisión: " + String.format("%.2f", probability));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
