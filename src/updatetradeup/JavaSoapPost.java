/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author marcos
 */
public class JavaSoapPost {

    public String soapPost() throws MalformedURLException, IOException {
        String reqXML;

        URL oURL = new URL("https://oi.centrodeseguranca.com.br/nswebservice/LibMdvV2/ns_registration_mdv01.asp");
        HttpURLConnection con = (HttpURLConnection) oURL.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-type", "text/xml; charset=utf-8");
        con.setRequestProperty("SOAPAction", "https://oi.centrodeseguranca.com.br/nswebservice/LibMdvV2/ns_registration_mdv01.asp");

//        reqXML = "<SOAP:Envelope xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'><SOAP:Header/><SOAP:Body><m:NSorder xmlns:m='urn:soapserver/soap:AuthorizationModule'><HEADER><RPARTNERID>NETBR55</RPARTNERID></HEADER><DATA><CUSTOMER><RCUSTOMERID>ois5323317704148</RCUSTOMERID><RREQUESTTYPE>TRADEUP</RREQUESTTYPE><REMAIL>ois5323317704148@oi.com.br</REMAIL><RFIRSTNAME>usuario de teste</RFIRSTNAME><RLASTNAME>usuario de teste</RLASTNAME><RPASSWORD>yW2oB6sT1y</RPASSWORD><RLANGUAGE>pt-br</RLANGUAGE></CUSTOMER><ORDER><RNETSAFEREF>NETBR55_150508151351_OIS5323317704148</RNETSAFEREF><RPARTNERREF>NCS1533003328</RPARTNERREF><ITEM><RSKU SKU='907-66226-srvc_1umma' QTY='3'/><OSKU SKU='907-42750-mvss'/></ITEM></ORDER></DATA></m:NSorder></SOAP:Body></SOAP:Envelope>";
        reqXML = "<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\"><SOAP:Header /><SOAP:Body><m:NSorder xmlns:m=\"urn:soapserver/soap:AuthorizationModule\">            <HEADER>                <RPARTNERID>NETBR55</RPARTNERID>            </HEADER>            <DATA>                <CUSTOMER>                    <RCUSTOMERID>ois5323317704167</RCUSTOMERID>		    <RREQUESTTYPE>NEW</RREQUESTTYPE>                    <REMAIL>alexandre.gomes.da.silva@titansgroup.com.br</REMAIL>                    <RFIRSTNAME>alexandre</RFIRSTNAME>                    <RLASTNAME>alexandre.gomes</RLASTNAME>                    <RPASSWORD>yW2oB6sT1y</RPASSWORD>                    <RLANGUAGE>pt-br</RLANGUAGE>                </CUSTOMER>                <ORDER>                    <RNETSAFEREF/>                    <RPARTNERREF>ois5323317704167</RPARTNERREF>                    <ITEM>		      <RSKU SKU=\"907-42750-mvss\" QTY=\"1\" />                    </ITEM>                </ORDER>            </DATA>        </m:NSorder>    </SOAP:Body></SOAP:Envelope>";

        OutputStream reqStream = con.getOutputStream();
        reqStream.write(reqXML.getBytes());

        InputStream resStream = con.getInputStream();
        byte[] byteBuf = new byte[10240];
        int len = resStream.read(byteBuf);
        resStream.toString();

        return resStream.toString();
    }

    public  void main(String[] args) throws MalformedURLException, IOException {
        JavaSoapPost soap = new JavaSoapPost();
        System.out.println(soap.soapPost());
    }
}
