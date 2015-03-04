package persistence;

import model.PhoneBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SqlUtil {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    public static ArrayList<PhoneBook> rsToArray(ResultSet rs) {
        ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();
        try {
            while (rs.next()) {
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.setId(rs.getInt("id"));
                phoneBook.setAddress(rs.getString("address"));
                phoneBook.setFio(rs.getString("fio"));
                phoneBook.setBirthDate(rs.getDate("birth_date"));
                phoneBook.setPhone(rs.getString("phone"));
                phoneBooks.add(phoneBook);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return phoneBooks;
    }


    public static ArrayList<PhoneBook> getPhoneBookAll() {
        System.out.println("getPhoneBookAll()");
        ArrayList<PhoneBook> phoneBooks=null;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String StoreProc = "{call sakila.get_phonebook_all()}";

        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(StoreProc);
            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                try {
                    phoneBooks = rsToArray(callableStatement.getResultSet());
                    callableStatement.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (dbConnection != null) {
                try {
                    //dbConnection.commit();
                    dbConnection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return phoneBooks;
    }

    public static ArrayList<PhoneBook> getPhoneBook(String phoneSeek) {
        System.out.println("getPhoneBook()=" + phoneSeek);
        ArrayList<PhoneBook> phoneBooks=null;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String StoreProc = "{call sakila.get_phonebook_phone(?)}";

        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(StoreProc);
            callableStatement.setString(1, phoneSeek);
            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                try {
                    phoneBooks = rsToArray(callableStatement.getResultSet());
                    callableStatement.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (dbConnection != null) {
                try {
                    //dbConnection.commit();
                    dbConnection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return phoneBooks;
    }

    public static ArrayList<PhoneBook> insPhoneBook
            (String fio, Date birthDate, String address, String phone) {
        System.out.println("insPhoneBook()=" + phone);
        ArrayList<PhoneBook> phoneBooks=null;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String StoreProc = "{CALL sakila.ins_phonebook(?,?,?,?)}";

        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(StoreProc);
            //fio varchar (50), in birthDate date ,in address varchar (50),in phone
            callableStatement.setString(1, fio);
            java.sql.Date datePar = new java.sql.Date(birthDate.getTime());
            callableStatement.setDate(2, datePar);
                    //new java.sql.Date(birthDate.getTime())));
                    callableStatement.setString(3, address);
            callableStatement.setString(4, phone);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                try {
                     phoneBooks= rsToArray(callableStatement.getResultSet());
                    callableStatement.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.commit();
                    dbConnection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return phoneBooks;

    }

    public static ArrayList<PhoneBook> updPhoneBook
            (Integer id, String fio, Date birthDate, String address, String phone) {
        System.out.println("updPhoneBook()=" + id);
        ArrayList<PhoneBook> phoneBooks=null;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String StoreProc = "{CALL sakila.upd_phoneBook(?,?,?,?,?)}";

        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(StoreProc);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, fio);
            callableStatement.setDate(3, new java.sql.Date(birthDate.getTime()));
            callableStatement.setString(4, address);
            callableStatement.setString(5, phone);

            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                try {
                    phoneBooks = rsToArray(callableStatement.getResultSet());
                    callableStatement.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.commit();
                    dbConnection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return phoneBooks;
    }

    public static ArrayList<PhoneBook> delPhoneBook
            (Integer id) {
        System.out.println("delPhoneBook()=" + id);
        ArrayList<PhoneBook> phoneBooks=null;
        Connection dbConnection = null;
        CallableStatement callableStatement = null;

        String StoreProc = "{CALL sakila.del_phonebook(?)}";

        try {
            dbConnection = getDBConnection();
            callableStatement = dbConnection.prepareCall(StoreProc);
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (callableStatement != null) {
                try {
                    phoneBooks = rsToArray(callableStatement.getResultSet());
                    callableStatement.close();


                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (dbConnection != null) {
                try {
                    dbConnection.commit();
                    dbConnection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        return phoneBooks;
    }


    /**--Hiber only 1 parameters for call proced
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
     public static ArrayList<PhoneBook> insPhoneBook
     (String fio,Date birthDate,String address,String phone){
     System.out.println("insPhoneBook()="+phone);
     Session session = HibernateUtil.getSessionFactory().openSession();

     session.beginTransaction();
     ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

     Query query2 = session.createSQLQuery(
     "CALL sakila.insphonebook(:fio,:birthDate,:address,:phone)")
     .addEntity(PhoneBook.class);
     query2.setDate("birthDate",birthDate);
     query2.setParameter("fio", fio);
     query2.setParameter("address", address);
     query2.setParameter("phone", phone);



     List result = query2.list();

     for(int i=0; i<result.size(); i++){
     PhoneBook phoneBook = (PhoneBook)result.get(i);
     System.out.println(phoneBook.getFio());
     phoneBooks.add(phoneBook);
     }

     session.close();
     HibernateUtil.shutdown();
     return phoneBooks;
     }

     public static ArrayList<PhoneBook> updPhoneBook
     (Integer id,String fio,Date birthDate,String address,String phone){
     System.out.println("updPhoneBook()="+id);
     Session session = HibernateUtil.getSessionFactory().openSession();

     session.beginTransaction();
     ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

     Query query = session.getNamedQuery("callUpdPhoneBookProcedure");
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

     public static ArrayList<PhoneBook> delPhoneBook
     (Integer id){
     System.out.println("delPhoneBook()="+id);
     Session session = HibernateUtil.getSessionFactory().openSession();

     session.beginTransaction();
     ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

     Query query = session.getNamedQuery("callDelPhoneBookProcedure");
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

     */


}
