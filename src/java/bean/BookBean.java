package bean;

public class BookBean implements java.io.Serializable {
    int id;
    String title;
    String author;

    public BookBean(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public BookBean(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    public BookBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
