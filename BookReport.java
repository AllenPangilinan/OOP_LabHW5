import java.util.HashMap;

public class BookReport {
    public static void main(String[] args) {
        BookDA bookDA = new BookDA();
        HashMap<String, Book> books = bookDA.create();

        for (Book book : books.values()) {
            Author author = book.getAuthor();
            System.out.println(book.getIsbn() + " " + book.getTitle());
            System.out.println("\t" + author.getName() + " - " + author.getBio() + "\n");
        }
    }
}
