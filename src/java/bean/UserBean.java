package bean;

public class UserBean implements java.io.Serializable{
    
    int id;
    String password;
    String name;

    public UserBean() {
    }

    public UserBean(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public UserBean(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}