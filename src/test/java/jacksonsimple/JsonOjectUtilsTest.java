package jacksonsimple;

import com.fasterxml.jackson.core.JsonProcessingException;
import jackson.JsonObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoobjects.Author;
import pojoobjects.Book;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JsonOjectUtilsTest {

    @Test
    public void objectToStringTest() throws JsonProcessingException, ParseException {
        Author author = new Author();
        Book book1 = new Book();

        book1.setBookName("book1");
        book1.setaBoolean(true);
        book1.setReleaseDate("");

        Book book2 = new Book();
        book2.setBookName("book2");
        book2.setaBoolean(false);
        book2.setReleaseDate("");

        List<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        author.setAuthorName("nik");
        author.setBooks(books);
        String jsonString = JsonObjectUtils.objectToString(author);
        System.out.println(jsonString);
    }

    @Test
    public void stringToObjectTest() throws IOException {

        File file = new File("./Author.json");
        Author author = JsonObjectUtils.stringToObjectFromFile(file, Author.class);
        Assert.assertEquals(author.getAuthorName(),"nik");

    }
}
