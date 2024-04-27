package RecuP3;

import java.util.List;
import java.util.Set;

import org.hibernate.*;

import RecuP1.Fabricantes;
import RecuP1.HibernateUtil;
import RecuP1.Programas;

public class Ejercicio3 {

	// TODO: Faltaria poner otro bucle para que liste los fabricantes

	public static void main(String[] args) {
		// Sesion con Hibernate
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();

		// Comprobacion de los argumentos
		if (args.length != 3) {
			System.out.println("PROPOCIONA TRES ARGUMENTOS: \n" + "Nombre de la version\n" + "OPERADOR\n" + "Version");
		}

		// Almacenamos los argumentos

		String n = args[0]; // Nombre
		String o = args[1]; // Operador
		String v = args[2]; // Version

		// Si no has introducido bien los operadores
		if (!o.equalsIgnoreCase("AND") && !o.equalsIgnoreCase("OR")) {
			System.out.println("No has introducido un AND o un OR");
		}

		String q = "From Programas where nombre like '" + n + "' " + o + " ver like '" + v + "'";

//				Query<Programas> p = s.createQuery(sql, Programas.class);
		// Query esta en desuso

		List<Programas> p = s.createQuery(q).list();

		// De esta manera no muestra
		// ! FABRICANTES
//		Fabricantes f = new Fabricantes();

//		List<Fabricantes> fList = s.createQuery(q).list();

		// Mostramos los resultados
		System.out.println("RESULTADOS: ");
		for (Programas programas : p) {
			System.out.println("Codigo: " + programas.getCodPro() + "\nNombre: " + programas.getNombre() + "\nVersion: "
					+ programas.getVer());

			Set<Fabricantes> f = programas.getFabricanteses();
			System.out.println("\nFabricantes: ");
			for (Fabricantes fabricante : f) {
				System.out.println("Nombre: " + fabricante.getNombre());
			}
		}
		s.close(); // Cerramos sesion
		System.out.println("SESION FINALIZADA");
	}

}