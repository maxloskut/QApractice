package practice4.Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import practice4.Model.adrress;
import practice4.Model.student;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) initSessionFactory();
        return sessionFactory;
    }

    private static void initSessionFactory() {
        Configuration config = new Configuration();
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src/main/resources/config.properties"));
            config.setProperties(props);
        } catch (IOException e) {
            e.printStackTrace();
        }


        config.addAnnotatedClass(adrress.class);
        config.addAnnotatedClass(student.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        System.out.println("Hibernate Java Config serviceRegistry created");

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }
}

