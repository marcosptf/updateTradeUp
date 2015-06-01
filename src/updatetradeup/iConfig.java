/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

/**
 *
 * @author marcos
 */
public class iConfig {

    private String dbServer;
    private String dbUser;
    private String dbPsw;
    private String dbPort;
    private String dbDatabase;
    private String tplTitle;
    private String driver;
    private String jdbc;
    private String endpoint;
    private String method;
    private String requestContent;
    private String requestCharset;
    private String soap;
    private String requestXmlToPost;
    private String responseXmlSent;

    private void iConfig() {
        this.setDados();
    }

    protected void setDados() {
        this.dbDatabase = "test";
        this.dbUser = "root";
        this.dbServer = "localhost";
        this.dbPort = "3306";
        this.dbPsw = "123456";
        this.tplTitle = "";
        this.driver = "com.mysql.jdbc.Driver";
        this.jdbc = "jdbc:mysql://localhost/test";
        this.endpoint = "https://search.yahoo.com/";
        this.method = "POST";
        this.requestContent = "Content-type";
        this.requestCharset = "text/xml; charset=utf-8";
        this.soap = "SOAPAction";
        this.requestXmlToPost = "select id,replace(xmlsend,'\"\"',\"'\") as xmlsend from test.xmlsend where xmlsent='0' order by id asc;";
        this.responseXmlSent = "update test.xmlsend set xmlsent='1' where id='";

    }

    public String xmlSendUpdate(String RCUSTOMERID, String REMAIL, String RFIRSTNAME, String RLASTNAME, String RPASSWORD, String RNETSAFEREF, String RPARTNERREF, String SKU) {

        String xmlSendUpdate = "<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "    <SOAP:Header/>\n"
                + "    <SOAP:Body>\n"
                + "        <m:NSorder xmlns:m=\"urn:soapserver/soap:AuthorizationModule\">\n"
                + "            <HEADER>\n"
                + "                <RPARTNERID>NETBR55</RPARTNERID>\n"
                + "            </HEADER>\n"
                + "            <DATA>\n"
                + "                <CUSTOMER>\n"
                + "                    <RCUSTOMERID>" + RCUSTOMERID + "</RCUSTOMERID>\n"
                + "                    <RREQUESTTYPE>UPDATE</RREQUESTTYPE>\n"
                + "                    <REMAIL>" + REMAIL + "</REMAIL>\n"
                + "                    <RFIRSTNAME>" + RFIRSTNAME + "</RFIRSTNAME>\n"
                + "                    <RLASTNAME>" + RLASTNAME + "</RLASTNAME>\n"
                + "                    <RPASSWORD>" + RPASSWORD + "</RPASSWORD>\n"
                + "                    <RLANGUAGE>pt-br</RLANGUAGE>\n"
                + "                </CUSTOMER>\n"
                + "                <ORDER>\n"
                + "                    <RNETSAFEREF>" + RNETSAFEREF + "</RNETSAFEREF>\n"
                + "                    <RPARTNERREF>" + RPARTNERREF + "</RPARTNERREF>\n"
                + "                    <ITEM>\n"
                + "                        <RSKU SKU='" + SKU + "' QTY='3' />\n"
                + "                    </ITEM>\n"
                + "                </ORDER>\n"
                + "            </DATA>\n"
                + "        </m:NSorder>\n"
                + "    </SOAP:Body>\n"
                + "</SOAP:Envelope> ";
        return xmlSendUpdate;
    }

    public String getResponseXmlSent() {
        return this.responseXmlSent;
    }

    public String getRequestXmlToPost() {
        return this.requestXmlToPost;
    }

    public String getRequestSoap() {
        return this.soap;
    }

    public String getRequestCharset() {
        return this.requestCharset;
    }

    public String getRequestContent() {
        return this.requestContent;
    }

    public String getMethod() {
        return this.method;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getDatabase() {
        return this.dbDatabase;
    }

    public String getUser() {
        return this.dbUser;
    }

    public String getPSW() {
        return this.dbPsw;
    }

    public String getDriver() {
        return this.driver;
    }

    public String getJdbc() {
        return this.jdbc;
    }
}
