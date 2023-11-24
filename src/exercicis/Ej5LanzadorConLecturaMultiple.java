package exercicis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ej5LanzadorConLecturaMultiple {

	public static void lanzarSumador(Integer n1, Integer n2, String archivoSalida) {
		try {
			String clase = "exercicis.Ej3SumadorConArchivo";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(n1.toString());
			command.add(n2.toString());
			command.add(archivoSalida);

			ProcessBuilder builder = new ProcessBuilder(command);
			builder.redirectErrorStream(true); // Redirige la salida de error al flujo de entrada para capturarla

			Process process = builder.start();
			process.waitFor();

			// Verifica que el proceso haya terminado correctamente
			if (process.exitValue() == 0) {
				// Lee el resultado del archivo
				File archivoResultado = new File(archivoSalida);
				if (archivoResultado.exists()) {
					try (BufferedReader reader = new BufferedReader(new FileReader(archivoResultado))) {
						String linea;
						while ((linea = reader.readLine()) != null) {
							System.out.println(linea);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("El archivo de resultado no existe.");
				}
			} else {
				System.out.println("Error al ejecutar el proceso SumadorConArchivo.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ej5LanzadorConLecturaMultiple l = new Ej5LanzadorConLecturaMultiple();
		// Lanzar el programa con dos pares de números diferentes y archivos de
		// resultado diferentes
		lanzarSumador(1, 1000, "resultat1.txt");
		lanzarSumador(1000, 1001, "resultat2.txt");

		System.out.println("Ok");
	}
}
