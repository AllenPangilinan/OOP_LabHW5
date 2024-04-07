import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BookDA {
    public HashMap<String, Book> create() {
        HashMap<String, Book> books = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Book.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    Book book = new Book(isbn, title);
                    books.put(isbn, book);
                    AuthorDA authorDA = new AuthorDA();
                    Author author = authorDA.create(authorName);
                    book.setAuthor(author);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
