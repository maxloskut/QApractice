package practice4.Hibernate;

import org.hibernate.Session;
import practice4.Model.adrress;
import practice4.Model.student;
import java.util.Date;


public class HibernateClient {
    Integer user_id = 7;
    private static Session session = HibernateUtil.getSessionFactory().openSession();
    public static void main(String[] args) {
//        crudUser();

//        adrress address = new adrress();
//        address.setId_address(4);
//        address.setCountry("USA");
//        address.setCity("New-York");
//        save(address);

        session.beginTransaction();
//        session.createQuery("SELECT a FROM student a", student.class).getFirstResultList();
        session.getTransaction().commit();

        session.close();
    }

    private static void save(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    private static void crudUser() {
        Integer id = 7;
        student student = new student();
        student.setId_student(4);
        student.setCourse(1);
        student.setName("Maksim Loskutov" + id);
        student.setBd(new Date());

        System.out.println(student);

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();


        //Read
        session.beginTransaction();
        student readStudent = (practice4.Model.student) session.get(student.class, student.getId_student());
        session.getTransaction().commit();

        System.out.println(readStudent);

        //Update
        student.setName(student.getName() + " updated");
        session.beginTransaction();
        session.update(student);
        System.out.println(session.get(student.class, id));
        session.getTransaction().commit();

        //Delete
        session.beginTransaction();
        session.delete(student);
        System.out.println(session.get(student.class, id));
        session.getTransaction().commit();

        session.close();
    }
}
