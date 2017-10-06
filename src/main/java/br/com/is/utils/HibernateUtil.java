/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.is.utils;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            factory = null;
        }
    }

    public static Session getSession() {
        return factory.openSession();
    }

}
