package es.florida.examen;

import java.beans.ParameterDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cambrer {

	private static int nombreClientsLocal = 0, nombreClientsEmportar = 0;
	private static int pot = 0;
	private static int propina = 0;

	public static int getPropina() {
		return propina;
	}

	public static void setPot(int pot) {
		Cambrer.pot = pot;
	}

	public static void setPropina(int propina) {
		Cambrer.propina = propina;
	}

	public static int getPot() {
		return pot;
	}

	public static void main(String[] args) {
		if (args.length == 3) {
			nombreClientsLocal = Integer.parseInt(args[0]);
			nombreClientsEmportar = Integer.parseInt(args[1]);
			pot = Integer.parseInt(args[2]);
		} else {
			nombreClientsLocal = (int) (Math.random() * 10 + 11);
			nombreClientsEmportar = (int) (Math.random() * 10 + 11);
		}

		ArrayList<String> clients = new ArrayList<String>();
		for (int i = 0; i < nombreClientsLocal; i++) {
			clients.add("local");
		}
		for (int i = 0; i < nombreClientsEmportar; i++) {
			clients.add("emportar");
		}

		Thread t;
		Atendre atendre;
		for (int i = 0; i < clients.size(); i++) {
			atendre = new Atendre(clients.get(i));

			t = new Thread(atendre);
			t.setName(clients.get(i) + "-" + (i + 1));
			t.start();
		}

		try {
			Thread.sleep(1000 * nombreClientsLocal + 500 * nombreClientsEmportar);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("=> Nombre total de clients atesos: " + Atendre.getLlistaClientsAtenguts().size());
		System.out.println("=> El pot total ha sigut de:  " + getPot());
		System.out.println("=> La propina total ha sigut de:  " + getPropina());
	}

}
