package exercicis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MiniProjecte8Lanzador {

	public static void Lanzador(String neoName, String positionNeo, String velocityNeo) {

		try {
			String clase = "exercicis.MiniProjecte8";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(neoName);
			command.add(positionNeo);
			command.add(velocityNeo);

			ProcessBuilder builder = new ProcessBuilder(command);

			Process process = builder.inheritIO().start();
			// builder.redirectOutput(fichResultado)
			// process.waitFor();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// long tiempoInicial = System.nanoTime();
		// int cores = Runtime.getRuntime().availableProcessors();

		// long tiempoFin = System.nanoTime();
		// long duracion = (tiempoFin - tiempoInicial)/1000000;
		// Tiempo medio de cores: duracion/cores

		// --Para parar ejecucion hasta que no se haya acabado todo
		// boolean comprobarFin = false;
		// while (!comprobarFin) {
		// try {
		// arrayProbabilidades = getBloqueAnalisis();
		// --Nuevo array con las probabilidades y intenta guardar ahí los resultados que
		// se encuentran en los distintos ficheros nombreNeo.txt

		// --getBloqueAnalisis() llama a su vez a getResultadoFichero() que intenta leer
		// todos los ficheros para almacenar el resulado, en el caso de no haber acabado
		// la ejecucion

		// --no estarán todos los ficheros por lo cual dará error al no encotrarlos y no
		// saldrá del while.

		// comprobarFin = true; --En el caso de que no de error, ya estarán todos los
		// datos y se sale del while
		// } catch (Exception e) {
		// Nada
		// }
		// }

		File datosNeos = new File("datos_neo.txt");
		try {
			BufferedReader bf = new BufferedReader(new FileReader(datosNeos));
			String linea = "";
			while ((linea = bf.readLine()) != null) {
				String[] parts = linea.split(",");
				if (parts.length != 3) {
					System.err.println("Error: Datos incorrectos en la línea: " + linea);
					continue;
				}
				Lanzador(parts[0], parts[1], parts[2]);
			}
			bf.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
