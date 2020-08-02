package baseEntity;



import core.BrowsersService;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Users;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import services.JDBCService;
import utils.Listener;

import static io.restassured.RestAssured.*;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    public ReadProperties properties;
    public Users master;
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public JDBCService jdbcService;
    public BrowsersService browsersService;

    @BeforeTest
    public void setup() {
        properties = new ReadProperties();
        String url=properties.getApiUrl();
        baseURI=properties.getApiUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(properties.getApiUsername(), properties.getApiPassword());
    }

    @BeforeClass
    public void setupClass() {
        jdbcService = new JDBCService();
        jdbcService.connectionDB();
        jdbcService.createTableProject();
        jdbcService.insertTestData();
    }

    @AfterClass
    public void tearDown() {
        jdbcService.deleteTableProject();
        jdbcService.closeConnection();
    }
}
