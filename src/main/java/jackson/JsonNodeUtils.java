package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonNodeUtils {

    private static ObjectMapper objectMapper = getObjectMapper();

    private  static ObjectMapper getObjectMapper () {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    // take a json string, returns json node
    public static JsonNode stringToJsonNode(String jsonString) throws IOException {
        return objectMapper.readTree(jsonString);
    }

    // takes jsonnode, maps it to a class
    public static <T> T jsonNodeToClass (JsonNode jsonNode, Class<T> tClass) throws JsonProcessingException {
        return objectMapper.treeToValue(jsonNode, tClass);
    }

    //converts pojo to jsonnode
    public static JsonNode objectToJsonNode(Object object) {
        return objectMapper.valueToTree(object);
    }

    //converts jsonnode to string
    public static String jsonNodeToString(JsonNode jsonNode) throws JsonProcessingException {
     return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
     //not pretty --> objectMapper.writer().writeValueAsString("");
    }
}
