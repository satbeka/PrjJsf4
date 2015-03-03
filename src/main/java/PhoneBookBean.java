import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.Date;

@ManagedBean(name="PhoneBookBean", eager = true)
@SessionScoped
public class PhoneBookBean implements Serializable{
    private static final long serialVersionUID = 1L;
    Long id;
    String action;
    Fio fio;
    Date birthDate;
    String address;
    String phone;
    Integer photo;
    //???, ???? ????????, ?????, ????? ????????, ??????????.
    public PhoneBookBean() {
        System.out.println("PhoneBookBean started!");
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String doAddAction(){
        this.action="add?faces-redirect=true";
        System.out.println(this.action);
        return action;
    }
}
