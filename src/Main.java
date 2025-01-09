import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        Author jkRowling = new Author(1, "J.K. Rowling", new Date());
        Author jrrTolkien = new Author(2, "J.R.R. Tolkien", new Date());

        library.addAuthor(jkRowling);
        library.addAuthor(jrrTolkien);

        Book philosopherStone = new Book(1, "Harry Potter and the Philosopher's Stone", jkRowling);
        Book chamberOfSecrets = new Book(2, "Harry Potter and the Chamber of Secrets", jkRowling);
        Book prisonerOfAzkaban = new Book(3, "Harry Potter and the Prisoner of Azkaban", jkRowling);
        Book gobletOfFire = new Book(4, "Harry Potter and the Goblet of Fire", jkRowling);
        Book orderOfThePhoenix = new Book(5, "Harry Potter and the Order of the Phoenix", jkRowling);
        Book halfBloodPrince = new Book(6, "Harry Potter and the Half-Blood Prince", jkRowling);
        Book deathlyHallows = new Book(7, "Harry Potter and the Deathly Hallows", jkRowling);
        Book hobbit = new Book(8, "The Hobbit", jrrTolkien);

        library.addBook(philosopherStone);
        library.addBook(chamberOfSecrets);
        library.addBook(prisonerOfAzkaban);
        library.addBook(gobletOfFire);
        library.addBook(orderOfThePhoenix);
        library.addBook(halfBloodPrince);
        library.addBook(deathlyHallows);
        library.addBook(hobbit);

        System.out.println("Bem vindo a biblioteca!");
        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (s/n)");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("s")){
                List<Book> availableBooks = library.getAvailableBooks();

                if (availableBooks.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (Book book : availableBooks) {
                        System.out.println(book.getId() + " -> " + book.getTitle());
                    }

                    System.out.println("Digite o número do livro que deseja pegar emprestado:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    Book selectedBook = library.getBookById(bookId);

                    if (selectedBook != null && selectedBook.isAvailable()){
                        System.out.println("Digite seu nome:");
                        String userName = scanner.nextLine();

                        library.loanBook(selectedBook, userName);
                        System.out.println("Livro " + selectedBook.getTitle() + "foi emprestado com sucesso para " + userName);
                    } else {
                        System.out.println("Livro não encontrado ou não disponível.");
                    }
                }
            } else if (response.equals("n")) {
                System.out.println("Até mais!");
                break;
            } else {
                System.out.println("Opção inválida. Por favor, digite 's' ou 'n'.");
            }
        }
        scanner.close();
    }
}