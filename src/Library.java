import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void updateBookTitle(int id, String newTitle) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(newTitle);
                break;
            }
        }
    }

    public void removeBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Author getAuthorById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public void updateAuthorName(int id, String newName) {
        for (Author author : authors) {
            if (author.getId() == id) {
                author.setName(newName);
                break;
            }
        }
    }

    public void removeAuthor(int id) {
        authors.removeIf(author -> author.getId() == id);
    }


    public void loanBook(Book book, String userName) {
        if (book.isAvailable()){
            Loan loan = new Loan(book, userName);
            loans.add(loan);
            book.setIsAvailable(false);
        } else {
            System.out.println("O Livro $book.getTitle() não está disponível para empréstimo.");
        }
    }

    public void returnBook(int loanId){
        for (Loan loan : loans) {
            if (loan.getId() == loanId && loan.isActived()) {
                loan.returnBook();
                break;
            }
        }
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
