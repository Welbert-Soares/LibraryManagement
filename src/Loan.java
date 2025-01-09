import java.util.Date;

public class Loan {
    private int id;
    private static int countId = 1;
    private Book book;
    private String userName;
    private Date loanDate;
    private Date returnDate;
    private boolean isActived;


    public Loan(Book book, String userName) {
        this.id = countId++;
        this.book = book;
        this.userName = userName;
        this.loanDate = new Date();
        this.isActived = true;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getUserName() {
        return userName;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public boolean isActived() {
        return isActived;
    }

    public void returnBook() {
        this.returnDate = new Date();
        this.isActived = false;
        this.book.setIsAvailable(true);
    }

    @Override
    public String toString(){
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", userName='" + userName + '\'' +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", isActived=" + isActived +
                '}';
    }
}
