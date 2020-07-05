package apitests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.net.URI;

// Simple API test, similar to Opentext project

public class SampleTest {

    @Test
    public void fun () throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        String url = "https://apistg.np.covapp.io/organization/v3/organizations/OS-3A-TEST11498801";
        //URI uri = URIBuilder.setPath("url").setParameter("", "").build();

        URIBuilder ub = new URIBuilder();
        URI uri = ub.setPath(url).build();

        HttpGet get  = new HttpGet(uri);
        get. addHeader("Accept" , "application/vnd.com.covisint.platform.organization.v1+json");
        get. addHeader("Content-Type" , "application/vnd.com.covisint.platform.person.v1+json");
        get. addHeader("Authorization" , "Bearer 2|M9abZoThY0jparRlc4Og0AYrzhAA");
        HttpResponse resp = client.execute(get);

        HttpEntity entityBody = resp.getEntity();
        String strBody = EntityUtils.toString(entityBody);
        int statuscode = resp.getStatusLine().getStatusCode();

        JSONObject object = new JSONObject(strBody);
        String id = object.get("id").toString();	// id is the key, value of id will be returned

    }

}
