package RecuP2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;



import RecuP1.Fabricantes;
import RecuP1.HibernateUtil;

public class Ejercicio2 {
 public static void main(String[] args) {
	//Abrimos la sesion
	 SessionFactory sFactory = HibernateUtil.getSessionFactory();
	 Session s = sFactory.openSession();
	 Transaction t = s.beginTransaction();
	 
	 //Introduciremos los datos por teclado
	 Scanner sc = new Scanner(System.in);
	 Fabricantes f = new Fabricantes();
	 
	 System.out.println("=========================");
	 System.out.println("NOMBRE DEL FABRICANTE HA AÑADIR: ");
	 f.setNombre(sc.nextLine());
	 if (f.getNombre().isBlank()) {
		System.out.println("AÑADIDO CORRECTAMENTE");
		System.exit(0);
	}
	 System.out.println("NOMBRE EL PAIS DEL FABRICANTE HA AÑADIR: ");
	 f.setPais(sc.nextLine());
	 System.out.println("NOMBRE EL CODIGO DEL FABRICANTE HA AÑADIR: ");
	 f.setCodFab(sc.nextLine());
	 System.out.println("=========================");
	 
	 
	 try {
		s.save(f);
		t.commit();
		System.out.println("SESION FINALIZADA");
	} catch (DataException e) {
		System.err.println("Error en el formato de los datos que se ha introducido \n");
//		e.printStackTrace();
	} catch (ConstraintViolationException e) {
		System.err.println("FABRICANTE YA REGISTRADO\n");
//		e.printStackTrace();
	}
	 
	 //Cerramos la sesion
	 s.close();
	 sc.close();
	 
	 
	 
}
}
