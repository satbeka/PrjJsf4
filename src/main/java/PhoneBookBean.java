import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;

@ManagedBean(name = "PhoneBookBean")
@SessionScoped
public class PhoneBookBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String action;
    private String fio;
    private Date birthDate;
    private String address;
    private String phone;

    public PhoneBook getPhoneBookExample() {
        return phoneBookExample;
    }

    public void setPhoneBookExample(PhoneBook phoneBookExample) {
        this.phoneBookExample = phoneBookExample;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public PhoneBook phoneBookExample;

    public String getFio() {
        return fio;
    }

    public void setfio(String fio) {
        this.fio = fio;
    }

    Integer photo;

    private static final ArrayList<PhoneBook> phoneBooks
            = new ArrayList<PhoneBook>(Arrays.asList(
            new PhoneBook((long) 1, "John",java.sql.Date.valueOf("1910-01-01"),
                    //new Date.valueOf("01-01-1910"),
                    "Almaty1", "7017017070", 5),
            new PhoneBook((long) 2, "Andry", java.sql.Date.valueOf("1920-01-01"),
                    "Almaty2", "7017017010", 6),
            new PhoneBook((long) 3, "Will Plok", java.sql.Date.valueOf("1930-01-01"),
                    "Almaty3", "7017017020", 7),
            new PhoneBook((long) 4, "Peter Li", java.sql.Date.valueOf("1940-01-01"),
                    "Almaty4 tylebaeva 55", "7017017030", 99)));

    public ArrayList<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public String addPhoneBook() {
        PhoneBook phoneBook = new PhoneBook((long) 5555, fio,
                new java.sql.Date(birthDate.getTime())
                , address,
                phone, photo);
        phoneBooks.add(phoneBook);
        return null;
    }
    public String saveAction() {

        //get all existing value but set "editable" to false
        for (PhoneBook phoneBook : phoneBooks){
            //phoneBook.setEditable(false);
        }
        System.out.println("Save phone");
        //return to current page
        return null;

    }
    public String editAction(PhoneBook phoneBook){
        this.phoneBookExample=phoneBook;
        System.out.println("editAction ="+phoneBookExample);
        return "edit?faces-redirect=true";
    }

    public String deleteAction(PhoneBook phoneBook) {

        phoneBooks.remove(phoneBook);
        return null;
    }

    public String deleteEmployee(PhoneBook phoneBook) {
        phoneBooks.remove(phoneBook);
        return null;
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
