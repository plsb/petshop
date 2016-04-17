package br.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory sessionFactory
            = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg
                    = new Configuration();
//            JOptionPane.showMessageDialog(null, LoadPropriedade.loadProperty("servidor"));
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://" + LoadPropriedade.loadProperty("servidor") + "/" + LoadPropriedade.loadProperty("banco"));
            cfg.setProperty("hibernate.connection.username", LoadPropriedade.loadProperty("user"));
            cfg.setProperty("hibernate.connection.password", LoadPropriedade.loadProperty("senha"));

            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        } catch (Throwable e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Criação inicial do objeto"
                    + " SessionFactory falhou. Erro: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

}
