import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class PhoneBook{

    Long id;
    Fio fio;
    Date birthDate;
    String address;
    String phone;
    Integer photo;
    //???, ???? ????????, ?????, ????? ????????, ??????????.

    public Long getId() {
        return id;
    }

    public PhoneBook(Long id, String name,String fname,String oname,
                     Date birthDate, String address, String phone, Integer photo) {

        this.id = id;
        this.fio = new Fio(name,fname,oname);
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
    }

    public PhoneBook(Long id, Fio fio, Date birthDate, String address, String phone, Integer photo) {

        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.photo = photo;
    }

    public void setId(Long id) {
        this.id = id;
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


}
