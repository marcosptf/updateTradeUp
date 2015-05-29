/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

//import java.net.;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author marcos
 */
public class JavaNet {
    
    String resp;
    
    public String javaNetRequest() throws MalformedURLException, IOException{
        this.resp = "js=>0";
        
        URL url  = new URL("https://oi.centrodeseguranca.com.br/nswebservice/LibMdvV2/ns_registration_mdv01.asp");
        this.resp = "js=>1";
        URLConnection urlconn = url.openConnection();
        
        this.resp = "js=>2";
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
        this.resp = "js=>3";
        for(String line;(line = reader.readLine()) != null;){
        this.resp = "js=>4";
            this.resp = line;
        }
        return this.resp;
    }
    
    public static void main(String[] args) throws MalformedURLException, IOException{
        JavaNet jn = new JavaNet();
        System.out.println("resp post using java.net.URL==>"+jn.javaNetRequest());
        System.out.println(jn.resp);
    }
    
}
