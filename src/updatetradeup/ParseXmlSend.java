/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package updatetradeup;

/**
 *
 * @author marcos
 */
public class ParseXmlSend {

    public String parseXml() {
        String xmlMySql, xmlSendUpdate,RCUSTOMERID,REMAIL,RFIRSTNAME,RLASTNAME,
        RPASSWORD,RNETSAFEREF,RPARTNERREF,SKU;
        xmlMySql = "<SOAP:Envelope xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'><SOAP:Header/><SOAP:Body><m:NSorder xmlns:m='urn:soapserver/soap:AuthorizationModule'><HEADER><RPARTNERID>NETBR55</RPARTNERID></HEADER><DATA><CUSTOMER><RCUSTOMERID>ois5323317704148</RCUSTOMERID><RREQUESTTYPE>TRADEUP</RREQUESTTYPE><REMAIL>ois5323317704148@oi.com.br</REMAIL><RFIRSTNAME>usuario de teste</RFIRSTNAME><RLASTNAME>usuario de teste</RLASTNAME><RPASSWORD>yW2oB6sT1y</RPASSWORD><RLANGUAGE>pt-br</RLANGUAGE></CUSTOMER><ORDER><RNETSAFEREF>NETBR55_150508151351_OIS5323317704148</RNETSAFEREF><RPARTNERREF>NCS1533003328</RPARTNERREF><ITEM><RSKU SKU='907-66226-srvc_1umma' QTY='3'/><OSKU SKU='907-42750-mvss'/></ITEM></ORDER></DATA></m:NSorder></SOAP:Body></SOAP:Envelope>";
        
        RCUSTOMERID = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RCUSTOMERID>") + 13,xmlMySql.lastIndexOf("</RCUSTOMERID>"));
        REMAIL      = (String) xmlMySql.subSequence(xmlMySql.indexOf("<REMAIL>") + 8,xmlMySql.lastIndexOf("</REMAIL>"));
        RFIRSTNAME  = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RFIRSTNAME>") + 12,xmlMySql.lastIndexOf("</RFIRSTNAME>"));
        RLASTNAME   = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RLASTNAME>") + 11,xmlMySql.lastIndexOf("</RLASTNAME>"));
        RPASSWORD   = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RPASSWORD>") + 11,xmlMySql.lastIndexOf("</RPASSWORD>"));
        RNETSAFEREF = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RNETSAFEREF>") + 13,xmlMySql.lastIndexOf("</RNETSAFEREF>"));
        RPARTNERREF = (String) xmlMySql.subSequence(xmlMySql.indexOf("<RPARTNERREF>") + 13,xmlMySql.lastIndexOf("</RPARTNERREF>"));
        SKU         = (String) xmlMySql.subSequence(xmlMySql.indexOf("SKU='") + 5,xmlMySql.lastIndexOf("' QTY='3'"));
        
        xmlSendUpdate = "<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
                + "    <SOAP:Header/>\n"
                + "    <SOAP:Body>\n"
                + "        <m:NSorder xmlns:m=\"urn:soapserver/soap:AuthorizationModule\">\n"
                + "            <HEADER>\n"
                + "                <RPARTNERID>NETBR55</RPARTNERID>\n"
                + "            </HEADER>\n"
                + "            <DATA>\n"
                + "                <CUSTOMER>\n"
                + "                    <RCUSTOMERID>"+RCUSTOMERID+"</RCUSTOMERID>\n"
                + "                    <RREQUESTTYPE>UPDATE</RREQUESTTYPE>\n"
                + "                    <REMAIL>"+REMAIL+"</REMAIL>\n"
                + "                    <RFIRSTNAME>"+RFIRSTNAME+"</RFIRSTNAME>\n"
                + "                    <RLASTNAME>"+RLASTNAME+"</RLASTNAME>\n"
                + "                    <RPASSWORD>"+RPASSWORD+"</RPASSWORD>\n"
                + "                    <RLANGUAGE>pt-br</RLANGUAGE>\n"
                + "                </CUSTOMER>\n"
                + "                <ORDER>\n"
                + "                    <RNETSAFEREF>"+RNETSAFEREF+"</RNETSAFEREF>\n"
                + "                    <RPARTNERREF>"+RPARTNERREF+"</RPARTNERREF>\n"
                + "                    <ITEM>\n"
                + "                        <RSKU SKU='"+SKU+"' QTY='3' />\n"
                + "                    </ITEM>\n"
                + "                </ORDER>\n"
                + "            </DATA>\n"
                + "        </m:NSorder>\n"
                + "    </SOAP:Body>\n"
                + "</SOAP:Envelope> ";
        return xmlSendUpdate;
    }

    public  void main(String[] args) {
        ParseXmlSend xml = new ParseXmlSend();
        System.out.println(xml.parseXml());
        
    }
}
