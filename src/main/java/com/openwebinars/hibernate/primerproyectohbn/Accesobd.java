package com.openwebinars.hibernate.primerproyectohbn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Accesobd {
	private static SessionFactory sf;
	private static Session sesion;
	private static Transaction transaction;

	protected static void setUp() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // por defecto:
																									// hibernate.cfg.xml
				.build();
		try {
			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	public static Session abrir() throws Exception {
		setUp();
		sesion = sf.openSession();
		transaction = sesion.beginTransaction();

		return sesion;
	}

	public static void cerrar() {
		try {
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		sf.close();
	}

	// Guardar Persona
	private static SessionFactory sessionFactory = null;

	public static void guardar(EntidadPersona persona) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int id = (int) session.save(persona);
		transaction.commit();
		System.out.println(id);
		sessionFactory.close();
	}

	// Leer Persona
	public static void leer(int id) throws Exception {
		sesion = abrir();
		Transaction transaction = sesion.beginTransaction();
		EntidadPersona persona = sesion.load(EntidadPersona.class, id);// PersonasEntity persona =
																		// session.get(PersonasEntity.class, id); //
																		// Esta línea también funcionaría como la
																		// anterior
		System.out.println(persona.getNombre());
		transaction.commit();
		cerrar();
	}

	// Actualizar Persona
	public static void actualizar(int id, String nombre, String apellidos, int Edad, String laboral) throws Exception {
		sesion = abrir();
		Transaction transaction = sesion.beginTransaction();
		EntidadPersona persona = sesion.get(EntidadPersona.class, id);
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setEdad(Edad);
		persona.setLaboral(laboral);
		// session.saveOrUpdate(persona); // session.merge(persona);
		sesion.update(persona);
		transaction.commit();
		cerrar();
	}

	// Borrar persona
	public static void borrar(int id) {

		EntidadPersona persona;

		persona = sesion.get(EntidadPersona.class, id);
		sesion.delete(persona);
	}

}
