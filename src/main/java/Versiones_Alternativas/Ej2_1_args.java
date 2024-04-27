package Versiones_Alternativas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.DataException;

import RecuP1.*;

public class Ej2_1_args {

	public static void main(String[] args) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();
		Transaction t = s.beginTransaction();
		if (args.length != 3) {
			System.out.println("PROPOCIONA TRES ARGUMENTOS: \n"
					+ "Nombre para el Fabricante\n"
					+ "Pais\n"
					+ "Codigo (FAB+nº)");
		}
		
		String n = args[0];
		String p = args[1];
		String c = args[2];
		
		Fabricantes f = new Fabricantes();
		
		System.out.println("Nombre: " + n);
		f.setNombre(n);
		System.out.println("Pais: " + p);
		f.setPais(p);
		System.out.println("Codigo: " + c);
		f.setCodFab(c);
		
		try {
			s.save(f);
			t.commit();
			System.out.println("AÑADIDO CORRECTAMENTE Y SESION FINALIZADA");
			
			
		} catch (DataException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
