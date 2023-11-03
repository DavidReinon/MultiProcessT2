package exercicis;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MiniProjecte8 {

	public static void main(String[] args) {
        String inputFile = "datos_neo.txt";
        String outputDirectory = "resultados_neo/";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)) {
            String line = " ";
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("Error: Datos incorrectos en la línea: " + line);
                    continue;
                }

                String neoName = parts[0];
                double positionNEO = Double.parseDouble(parts[1]);
                double velocityNEO = Double.parseDouble(parts[2]);

                // Realiza cálculos para determinar la probabilidad de colisión
                double collisionProbability = calcularProbabilidadColision(positionNEO, velocityNEO);

                // Guarda la probabilidad en un archivo independiente
                String outputFileName = outputDirectory + neoName + ".txt";
                guardarProbabilidadEnArchivo(outputFileName, collisionProbability);

                // Muestra las probabilidades de colisión
                System.out.println("Probabilidad de colisión para " + neoName + ": " + String.format("%.2f", collisionProbability));

                // Genera alertas si es necesario
                if (collisionProbability > 0.10) {
                    System.err.println("¡Alerta mundial! Probabilidad de colisión alta para " + neoName);
                } else {
                    System.out.println("Todo tranquilo para " + neoName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private static double calcularProbabilidadColision(double positionNEO, double velocityNEO) {
		// Realiza cálculos para determinar la probabilidad de colisión basada en la
		// física y matemáticas
		// Debes investigar y definir la fórmula adecuada para tus cálculos.
		// Este es un marcador de posición.
		return 0.0;
	}

	private static void guardarProbabilidadEnArchivo(String fileName, double probability) {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write("Probabilidad de colisión: " + String.format("%.2f", probability));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
