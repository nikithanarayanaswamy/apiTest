package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojoobjects.Author;

import java.io.File;
import java.io.IOException;

public class JsonObjectUtils {

    public static ObjectMapper objectMapper = new ObjectMapper();

    // cnovert object to string
    public static String objectToString (Object object) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    //convert string to object from file
    public static <T> T stringToObjectFromFile(File jsonString, Class<T> tClass) throws IOException {
        return objectMapper.readValue(jsonString, tClass);
    }

    //convert string to object from file
    public static <T> T stringToObject(String jsonString, Class<T> tClass) throws IOException {
        return objectMapper.readValue(jsonString, tClass);
    }
}
