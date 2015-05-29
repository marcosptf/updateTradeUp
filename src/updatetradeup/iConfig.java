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
        this.endpoint = "https://oi.centrodeseguranca.com.br/nswebservice/LibMdvV2/ns_registration_mdv01.asp";
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