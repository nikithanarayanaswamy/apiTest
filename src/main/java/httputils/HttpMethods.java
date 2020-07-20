package httputils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpMethods {

    private static HttpClient client = HttpClientBuilder.create().build();

    public static String HttpGet(String uriString) throws URISyntaxException, IOException {
        URIBuilder ub = new URIBuilder();
        URI uri = ub.setPath(uriString).build();

        HttpGet get  = new HttpGet(uri);
        HttpResponse resp = client.execute(get);
        Assert.assertEquals(resp.getStatusLine().getStatusCode(),200);
        return EntityUtils.toString(resp.getEntity());
    }

    public static String HttpPost (String uriString, String body) throws Exception {
        URIBuilder ub = new URIBuilder();
        URI uri = ub.setPath(uriString).build();

        HttpPost post = new HttpPost(uri);
        StringEntity entity = new StringEntity(body);
        post.setEntity(entity);
        HttpResponse resp = client.execute(post);
        Assert.assertEquals(resp.getStatusLine().getStatusCode(),201);
        return EntityUtils.toString(resp.getEntity());
    }
}
