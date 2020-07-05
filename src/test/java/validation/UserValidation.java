package validation;

import org.testng.Assert;
import pojoobjects.Ad;
import pojoobjects.User;
import pojoobjects.Data;


public class UserValidation {

    public static void validateUser(User user) {

        validateData(user.getData());
        validateAd (user.getAd());

    }

    public static void validateAd(Ad ad) {
        Assert.assertEquals(ad.getCompany(),"StatusCode Weekly");
        Assert.assertEquals(ad.getUrl(),"http://statuscode.org/");
        Assert.assertEquals(ad.getText(),"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.");
    }

    public static void validateData (Data data) {

        Assert.assertEquals(data.getId(),"2");
        Assert.assertEquals(data.getEmail(),"janet.weaver@reqres.in");
        Assert.assertEquals(data.getFirst_name(),"Janet");
        Assert.assertEquals(data.getLast_name(),"Weaver");
        Assert.assertEquals(data.getAvatar(),"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg");

    }
}
