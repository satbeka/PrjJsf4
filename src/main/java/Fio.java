
public class Fio {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    String name;
    String fname;
    String oname;
    public Fio(String name,String fname,String oname) {
        this.fname=fname;
        this.name=name;
        this.oname=oname;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getOname() {
        return oname;
    }

    @Override
    public String toString() {
        return "Fio{" +
                "name='" + name + '\'' +
                ", fname='" + fname + '\'' +
                ", oname='" + oname + '\'' +
                '}';
    }

    public void setOname(String oname) {
        this.oname = oname;
    }
}
