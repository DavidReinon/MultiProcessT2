package exercicis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ej6LanzadorConRedireccion {

	public static void lanzarSumador(Integer n1, Integer n2) {
		try {
			String clase = "exercicis.Ej1Sumador";
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

			ProcessBuilder builder = new ProcessBuilder(command);

			// Redirige la salida estándar del proceso al flujo de ejecución del programa
			// actual
			//builder.inheritIO();

			Process process = builder.inheritIO().start();
			process.waitFor();

			System.out.println("Proceso Sumador finalizado. (LANZADOR)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Ej6LanzadorConRedireccion l = new Ej6LanzadorConRedireccion();
		lanzarSumador(1, 50);
		lanzarSumador(51, 100);
		System.out.println("Ok (LANZADOR)");
	}
}
