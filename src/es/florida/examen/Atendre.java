package es.florida.examen;

import java.util.ArrayList;
import java.util.List;

public class Atendre implements Runnable {
	private static ArrayList<String> llistaClientsAtenguts = new ArrayList<String>();
	private String tipus;

	public Atendre(String tipus) {
		this.tipus = tipus;
	}

	public static List<String> getLlistaClientsAtenguts() {
		return llistaClientsAtenguts;
	}

	public void AtendreClient(String nombre, int tempsFabricacio) {
		synchronized (this) {
			if (tempsFabricacio == 1000) {
				int propinaNova = (int) (Math.random() * 3 + 1);
				int propinaAcumulada = Cambrer.getPropina();
				if (propinaAcumulada + propinaNova <= 50) {
					Cambrer.setPropina(propinaAcumulada + propinaNova);
				} else {
					System.out.println("No es pot rebre mes propina en aques torn :(");
					int potAcumulat = Cambrer.getPot();
					Cambrer.setPot(propinaNova + potAcumulat);
				}
			}
		}

		try {
			long tIni = System.currentTimeMillis();
			long tFin = tIni + tempsFabricacio;
			int iteraciones = 0;
			while (System.currentTimeMillis() < tFin) {
				iteraciones++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		synchronized (llistaClientsAtenguts) {
			llistaClientsAtenguts.add(nombre);
			System.out.println(nombre + " ha sigut ates.");
		}
		
	}

	@Override
	public void run() {
		int tFabricacion = 0;
		if (tipus.equals("local")) {
			tFabricacion = 1000;
		} else {
			tFabricacion = 500;
		}
		String nom = Thread.currentThread().getName();
		AtendreClient(nom, tFabricacion);
	}
}
