import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AuthorDA {
    public HashMap<String, Author> create() {
        HashMap<String, Author> authors = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Author.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String name = data[0].trim();
                    String bio = data[1].trim();
                    Author author = new Author(name, bio);
                    authors.put(name, author);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authors;
    }

    public Author create(String name) {
        HashMap<String, Author> authors = create();
        return authors.get(name);
    }
}
