/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

/**
 *
 * @author marcos
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import updatetradeup.iConfig;
import java.sql.*;
import java.sql.Connection.*;
import java.sql.DriverManager.*;
import java.sql.Statement.*;
import java.sql.ResultSet.*;
import java.sql.SQLException.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateTradeUp extends iConfig {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    String resp;
    iConfig config;

    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void MySqlConn() throws ClassNotFoundException, SQLException {
        try {
            this.config = new iConfig();
            this.config.setDados();
            Class.forName(this.config.getDriver());
            conn = DriverManager.getConnection(this.config.getJdbc(), this.config.getUser(), this.config.getPSW());
            this.stmt = conn.createStatement();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public String parseXmlSend(String xmlMySql) {
        String RCUSTOMERID, REMAIL, RFIRSTNAME, RLASTNAME,
                RPASSWORD, RNETSAFEREF, RPARTNERREF, SKU;

        RCUSTOMERID = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RCUSTOMERID>") + 13, xmlMySql.lastIndexOf("</RCUSTOMERID>"));
        REMAIL = (String) xmlMySql.subSequence(xmlMySql.indexOf("<REMAIL>") + 8, xmlMySql.lastIndexOf("</REMAIL>"));
        RFIRSTNAME = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RFIRSTNAME>") + 12, xmlMySql.lastIndexOf("</RFIRSTNAME>"));
        RLASTNAME = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RLASTNAME>") + 11, xmlMySql.lastIndexOf("</RLASTNAME>"));
        RPASSWORD = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RPASSWORD>") + 11, xmlMySql.lastIndexOf("</RPASSWORD>"));
        RNETSAFEREF = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RNETSAFEREF>") + 13, xmlMySql.lastIndexOf("</RNETSAFEREF>"));
        RPARTNERREF = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RPARTNERREF>") + 13, xmlMySql.lastIndexOf("</RPARTNERREF>"));
        SKU = (String) xmlMySql.subSequence(xmlMySql.indexOf("SKU='") + 5, xmlMySql.lastIndexOf("' QTY"));
        RPARTNERREF = (String) RPARTNERREF.subSequence(0,(RPARTNERREF.length()-2));
        this.resp = REMAIL;
        return this.config.xmlSendUpdate(RCUSTOMERID,REMAIL,RFIRSTNAME,RLASTNAME,RPASSWORD,RNETSAFEREF,RPARTNERREF,SKU);

    }

    public String post(String param) throws UnsupportedEncodingException, IOException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(this.config.getEndpoint());
        List<NameValuePair> params;
        params = new ArrayList<>(2);
        params.add(new BasicNameValuePair("xml", param));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                this.resp = entity.getContent().toString();
            } finally {
                instream.close();
            }
        }
        return this.resp;
    }

    public String soapPost(String reqXML) throws MalformedURLException, IOException {
        URL oURL = new URL(config.getEndpoint());
        HttpURLConnection con = (HttpURLConnection) oURL.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod(config.getMethod());
        con.setRequestProperty(config.getRequestContent(), config.getRequestCharset());
        con.setRequestProperty(config.getRequestSoap(), config.getEndpoint());
        con.connect();
        OutputStream reqStream = con.getOutputStream();
        reqStream.write(reqXML.getBytes());
        InputStream resStream = con.getInputStream();
        byte[] byteBuf = new byte[10240];
        int len = resStream.read(byteBuf);
        return resStream.toString();
    }

    public String getXmlSend() throws UnsupportedEncodingException, IOException { 
        try {
            this.MySqlConn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateTradeUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTradeUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        return " 0=>"+config.getMethod()+" 1=>"+config.getRequestContent()+" 2=>"+config.getRequestCharset()+" 3=>"+config.getRequestSoap()+" 4=>"+config.getEndpoint();
        
        try {
            this.rs = this.stmt.executeQuery(config.getRequestXmlToPost());
            while (this.rs.next()) {
                this.resp = this.soapPost(this.parseXmlSend(this.rs.getString("xmlsend")));
                this.stmt.executeUpdate(config.getResponseXmlSent() + this.rs.getString("id") + "';");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return this.resp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
        UpdateTradeUp update;
        update = new UpdateTradeUp();
        System.out.println("javascripter");
        System.out.println("getting xml from mysql throught java jdbc==>");
        System.out.println(update.getXmlSend());
    }
}
