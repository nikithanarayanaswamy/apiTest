package jacksonsimple;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import jackson.JsonNodeUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoobjects.Person;

import java.io.IOException;

public class JsonNodeUtilsTest {

    @Test
    public void teststringToJsonNode() throws IOException {

        String json = "{\"id\":\"identifier1\", \"name\":\"nikitha\"}";
        JsonNode jsonNode = JsonNodeUtils.stringToJsonNode(json);
        Assert.assertEquals(jsonNode.get("name").asText(),"nikitha");
        //as text removes "" from "nikitha"
    }
    @Test
    public void testjsonNodeToClass() throws IOException {

        String json = "{\"id\":\"identifier1\", \"name\":\"nikitha\"}";
        JsonNode jsonNode = JsonNodeUtils.stringToJsonNode(json);
        Person person = JsonNodeUtils.jsonNodeToClass(jsonNode, Person.class);
        Assert.assertEquals(person.getName(),"nikitha");
        Assert.assertEquals(person.getId(),"identifier1");
    }

    @Test
    public void testobjectToJsonNode() {

        Person person = new Person();
        person.setName("niki");
        JsonNode jsonNode = JsonNodeUtils.objectToJsonNode(person);
        Assert.assertEquals(jsonNode.get("name").asText(), "niki");

    }

    @Test
    public void testJsonNodeToString() throws JsonProcessingException {
        Person person = new Person();
        person.setName("niki");
        JsonNode jsonNode = JsonNodeUtils.objectToJsonNode(person);
        System.out.println(JsonNodeUtils.jsonNodeToString(jsonNode));
    }
}
