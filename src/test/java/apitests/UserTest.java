package apitests;

import httputils.HttpMethods;
import jackson.JsonObjectUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojoobjects.CreateUserRequest;
import pojoobjects.CreateUserResponse;
import pojoobjects.User;
import validation.UserValidation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserTest {

    Properties properties;
    InputStream input;

    @BeforeClass
    public void loadProperties () throws IOException {
        properties = new Properties();
        input = new FileInputStream("src/test/UserProperties.properties");
        properties.load(input);

    }
    @Test
    public void getUser() throws Exception {

        String strBody = HttpMethods.HttpGet( properties.getProperty("getPerson"));

        UserValidation.validateGetUser(JsonObjectUtils.stringToObject(strBody, User.class));

    }

    @Test
    public void createUser() throws Exception {

        String strBody = HttpMethods.HttpPost( properties.getProperty("createPerson"), JsonObjectUtils.objectToString(CreateUserRequest.class));
        UserValidation.validateCreateUser(JsonObjectUtils.stringToObject(strBody,CreateUserResponse.class));

    }
}
