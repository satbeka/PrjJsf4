import model.PhoneBook;

import javax.faces.model.SelectItem;
import java.util.ArrayList;

public class FilterBean {
    private String filterPhone = "7";
    private String filterValue="";
    private ArrayList<SelectItem> filterPhones = new ArrayList<SelectItem>();

    public boolean filterFio(Object current) {
        PhoneBook phoneBook = (PhoneBook)current;
        if (filterValue.length()==0) {
            return true;
        }
        if (phoneBook.getFio().toLowerCase().startsWith(filterValue.toLowerCase())) {
            return true;
        }else {
            return false;
        }
    }

    public FilterBean() {
        for (int i = 5; i < 11; i++) {
            SelectItem select = new SelectItem();
            select.setLabel("-" + i);
            select.setValue(i);
            filterPhones.add(select);
        }
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public String getFilterPhone() {
        return filterPhone;
    }

    public void setFilterPhone(String filterPhone) {
        this.filterPhone = filterPhone;
    }

    public ArrayList<SelectItem> getFilterPhones() {
        return filterPhones;
    }
}
