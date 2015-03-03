import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name="PhoneBookBean", eager = true)
@SessionScoped
public class PhoneBookBean implements Serializable{
    private static final long serialVersionUID = 1L;
    String action;
    public PhoneBookBean() {
        System.out.println("PhoneBookBean started!");
    }
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String doAddAction(){
        this.action="add";
        System.out.println(this.action);
        return action;
    }
}
