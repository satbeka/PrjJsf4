import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name = "PhoneBookBean", eager = true)
@SessionScoped
public class PhoneBookBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public String action;
    Fio fio;
    Date birthDate;
    String address;
    String phone;
    Integer photo;
    private static final ArrayList<PhoneBook> phoneBooks
            = new ArrayList<PhoneBook>(Arrays.asList(
            new PhoneBook(null, "John", "", "", Date.valueOf("01-01-1910"),
                    "Almaty1", "7017017070", 5),
            new PhoneBook(null, "Andry", "", "", Date.valueOf("01-01-1920"),
                    "Almaty2", "7017017010", 6),
            new PhoneBook(null, "Will", "", "", Date.valueOf("01-01-1930"),
                    "Almaty3", "7017017020", 7),
            new PhoneBook(null, "Peter", "", "", Date.valueOf("01-01-1940"),
                    "Almaty4 tylebaeva 55", "7017017030", 99)));

    public ArrayList<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public String addPhoneBook() {
        PhoneBook phoneBook = new PhoneBook(null, fio, birthDate, address,
                phone, photo);
        phoneBooks.add(phoneBook);
        return null;
    }

    public String deleteEmployee(PhoneBook phoneBook) {
        phoneBooks.remove(phoneBook);
        return null;
    }

    public Fio getFio() {
        return fio;
    }

    public void setFio(Fio fio) {
        this.fio = fio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public PhoneBookBean() {
        System.out.println("PhoneBookBean started!");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String doAddAction() {
        this.action = "add?faces-redirect=true";
        System.out.println(this.action);
        return action;
    }
}
