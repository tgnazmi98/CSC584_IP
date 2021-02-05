package bean;

public class StudentBean implements java.io.Serializable{
    int id;
    String name;

    public StudentBean() {
    }

    public StudentBean(String name) {
        this.name = name;
    }

    public StudentBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
