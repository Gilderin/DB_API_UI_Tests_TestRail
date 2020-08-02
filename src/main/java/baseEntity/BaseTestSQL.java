package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import services.JDBCService;
import utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTestSQL {
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public JDBCService jdbcService;
    public BrowsersService browsersService;
    public ReadProperties properties;

    @BeforeClass
    public void setup() {
        jdbcService = new JDBCService();
        jdbcService.connectionDB();
        jdbcService.createTableProject();
        jdbcService.insertTestData();
        browsersService = new BrowsersService();
        properties = new ReadProperties();
        browsersService.getDriver().get(properties.getURL());
    }

    @AfterClass
    public void tearDown() {
        jdbcService.deleteTableProject();
        jdbcService.closeConnection();
        browsersService.getDriver().quit();
        browsersService = null;
    }
}
