package Versiones_Alternativas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import RecuP1.Fabricantes;
import RecuP1.HibernateUtil;

//TODO: NO CARRURA :)
public class Ej2_2_File {
	public static void main(String[] args) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();
		Transaction t = s.beginTransaction();

		System.out.println("Introducce una ruta al archivo a leer");
		Scanner sc = new Scanner(System.in);

		// ! Alternativa del Scanner
		// String r = "[METE LA RUTA AQUI]";

		String ruta = sc.nextLine();
		File file = new File(ruta);
		
		Fabricantes f = new Fabricantes();
		
		f.setNombre(ruta);
		f.setPais(ruta);
		f.setCodFab(ruta);
		
		s.save(f);
		t.commit();
	}
}
