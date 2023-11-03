package exercicis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ej7LanzadorConRedireccionAarchivo {

	public static void lanzarSumador(Integer n1, Integer n2, String archivoSalida) {
		try {
			String clase = "exercicis.SumadorConArchivo";
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
			command.add(archivoSalida); // Nombre del archivo de salida como tercer argumento

			ProcessBuilder builder = new ProcessBuilder(command);

			// Redirige la salida estándar del proceso al archivo especificado
			File outputRedirectFile = new File(archivoSalida);
			builder.redirectOutput(outputRedirectFile);

			Process process = builder.start();
			process.waitFor();

			System.out.println("Proceso SumadorConArchivo finalizado.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ej7LanzadorConRedireccionAarchivo l = new Ej7LanzadorConRedireccionAarchivo();
		lanzarSumador(1, 50, "resultado1.txt");
		lanzarSumador(51, 100, "resultado2.txt");
		System.out.println("Ok");
	}
}
