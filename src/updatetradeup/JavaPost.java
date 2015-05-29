/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author marcos
 */
public class JavaPost {
    
    public String post() throws IOException{
        URL url = new URL("http://search.yahoo.com/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","text/plain");
        connection.setRequestProperty("charset","uft-8");
        connection.connect();
        return connection.getContent().toString();
//        return "";
    }
    
    public static void main(String[] args) throws IOException{
        JavaPost jp = new JavaPost();
        System.out.println("resp===>");
        System.out.println(jp.post());
    }
}
