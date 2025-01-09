import java.util.Date;

public class Book {
    private int id;
    private String title;
    private Author author;
    private boolean isAvailable;
    private Date registrationDate;
    private Date updateDate;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.registrationDate = new Date();
        this.updateDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updateDate = new Date();
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString(){
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", isAvailable=" + isAvailable +
                ", registrationDate=" + registrationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
