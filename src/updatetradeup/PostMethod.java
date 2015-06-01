/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author marcos
 */
public class PostMethod  extends iConfig{

    public String resp = "js=>0";
    
    public String post() throws UnsupportedEncodingException, IOException {
        
        iConfig iconfig  = new iConfig();
        iconfig.setDados();
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(iconfig.getEndpoint());

// Request parameters and other properties.
        List<NameValuePair> params;
        params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("param-1", "12345"));
        params.add(new BasicNameValuePair("param-2", "Hello!"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

//Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                // do something useful
//                this.resp = instream.toString()+response.getStatusLine().toString();
                this.resp = entity.getContent().toString();
            } finally {
                instream.close();
            }
        }
        return this.resp;
    }

    public  void main(String[] args) throws UnsupportedEncodingException, IOException {
        
        PostMethod post = new PostMethod();
        post.post();
        System.out.println("resp do post==>");
        System.out.println(post.resp);
        
    }
}
