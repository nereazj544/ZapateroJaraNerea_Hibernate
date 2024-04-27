package Versiones_Alternativas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

import RecuP1.Fabricantes;
import RecuP1.HibernateUtil;
import RecuP1.Programas;

/**
 * Ej4_1_alreves
 */
public class Ej4_1_alreves {

    public static void main(String[] args) {
        // Sesion con Hibernate
        SessionFactory sFactory = HibernateUtil.getSessionFactory();
        Session s = sFactory.openSession();
        Transaction t = s.beginTransaction();

        if (args.length != 1) {
            System.out.println("No has introduccido un codigo");
        }

        String cod = args[0].toUpperCase(); // codigo

        try {
            Programas p = s.get(Programas.class, cod);

            if (p == null) {
                System.out.println("NO SE HA ENCONTRADO NADA");
            }else{
                System.out.println("DATOS DEL PROGRAMA CON EL CODIGO: " + cod);
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Version: " + p.getVer());

                Set<Fabricantes> f = p.getFabricanteses();

                if (f.isEmpty()) {
                    System.out.println("El prgrama no tiene fabricante asociados");
                }else{
                    System.out.println("FABRICANTES ASOCIADOS AL PROGRAMA CON EL CODIGO: " + cod);

                    for (Fabricantes fabricantes : f) {
                        System.out.println("Codigo: " + fabricantes.getCodFab());
                        System.out.println("Nombre: " + fabricantes.getNombre());
                        System.out.println("Pais: " + fabricantes.getPais());
                    }
                }

            }

            t.commit();

        } catch (Exception e) {
            // TODO: handle exception
        }
        s.close();

        // END MAIN
    }

    // END CLASS
}