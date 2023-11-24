package es.florida.examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Restaurant {

	public static void Lanzador() {
		int nombreClientsLocal = 0, nombreClientsEmportar = 0, pot = 0;
		Scanner teclat = new Scanner(System.in);

		System.out.println("Introdueix el numero de clients locals: ");
		try {
			nombreClientsLocal = Integer.parseInt(teclat.next());
		} catch (Exception e) {
			System.out.println("ERROR. Introdueix un numero ENTER: ");
		}
		System.out.println("Introdueix el numero de clients per emportar: ");
		try {
			nombreClientsLocal = Integer.parseInt(teclat.next());
		} catch (Exception e) {
			System.out.println("ERROR. Introdueix un numero ENTER: ");
		}
		System.out.println("Introdueix el numero total de pot disponible: ");
		try {
			nombreClientsLocal = Integer.parseInt(teclat.next());
		} catch (Exception e) {
			System.out.println("ERROR. Introdueix un numero ENTER: ");
		}

		try {
			String clase = "es.Florida.examen.Cambrer";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(String.valueOf(nombreClientsLocal));
			command.add(String.valueOf(nombreClientsEmportar));
			command.add(String.valueOf(pot));

			ProcessBuilder builder = new ProcessBuilder(command);

			System.out.println("Elegeix una opcio: ");
			System.out.println("1: Mostrar per consola l'eixida de sols la app Restaurant");
			System.out.println("2: Mostrar per consola l'eixida de toto el proces d'execució ");
			System.out.println("3: Guradra en un fitxer de text.");

			if (teclat.nextLine().equals("1")) {
				Process process = builder.start();
			} else if (teclat.nextLine().equals("2")) {
				Process process = builder.inheritIO().start();
			} else {
				System.out.println("No realitzada");
				// builder.redirectOutput(fichResultado)
			}

			teclat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		boolean continuar = true;
		while (continuar) {
			Lanzador();

			System.out.println("");
			System.out.println("");
			Scanner teclat = new Scanner(System.in);
			String resp = "";
			System.out.println("Vols cridar un nou cambrer ? (S/N)");
			resp = teclat.nextLine();
			if (!resp.toLowerCase().equals("s")) {
				continuar = false;
			}

		}
	}

}
