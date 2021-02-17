package hw05;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Random;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        EntityDAO studentDao = new EntityDAO(Student.class, Integer.class);
        for (int i = 1; i < 1001; i++) {
            studentDao.create(
                    new Student(
                            "Student_" + i,
                            new Random().nextInt(5))
            );
        }
        System.out.println(studentDao.findById(4));

        studentDao.updateEntity(new Student(3, "Vasia", 3));

        System.out.println(studentDao.findAll());

        System.out.println(studentDao.deleteEntityById(1));
        System.out.println(studentDao.deleteEntityById(2));
        System.out.println(studentDao.deleteEntityById(3));
        System.out.println(studentDao.deleteEntityById(2000));
        System.out.println(studentDao.findAll());

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
            sessionFactory = meta.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }


}
