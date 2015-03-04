package persistence;

import model.PhoneBook;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

public class SqlUtil {

    public static ArrayList<PhoneBook> getPhoneBookAll(){
        System.out.println("getPhoneBookAll()");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

        Query query = session.getNamedQuery("callPhoneBookAllProcedure");
        List result = query.list();

        for(int i=0; i<result.size(); i++){
            PhoneBook phoneBook = (PhoneBook)result.get(i);
            System.out.println(phoneBook.getFio());
            phoneBooks.add(phoneBook);
        }

        session.close();
        HibernateUtil.shutdown();
        return phoneBooks;
    }

    public static ArrayList<PhoneBook> getPhoneBook(String phoneSeek){
        System.out.println("getPhoneBook()="+phoneSeek);
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

        Query query = session.getNamedQuery("callPhoneBookByPhoneProcedure")
                .setParameter("phoneSeek",phoneSeek);
        List result = query.list();

        for(int i=0; i<result.size(); i++){
            PhoneBook phoneBook = (PhoneBook)result.get(i);
            System.out.println(phoneBook.getFio());
            phoneBooks.add(phoneBook);
        }

        session.close();
        HibernateUtil.shutdown();
        return phoneBooks;
    }
    public static ArrayList<PhoneBook> getPhoneBookAll(){
        System.out.println("getPhoneBookAll()");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

        Query query = session.getNamedQuery("callPhoneBookAllProcedure");
        List result = query.list();

        for(int i=0; i<result.size(); i++){
            PhoneBook phoneBook = (PhoneBook)result.get(i);
            System.out.println(phoneBook.getFio());
            phoneBooks.add(phoneBook);
        }

        session.close();
        HibernateUtil.shutdown();
        return phoneBooks;
    }

}
