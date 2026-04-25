package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class DriverFactory {

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeMethod
    @Parameters({ "browser" })
    public void setUp(@Optional("chrome") String browser) throws IOException {

        logger = LogManager.getLogger(this.getClass());

        String path = System.getProperty("user.dir")  + "/src/test/resources/config.properties";

        FileInputStream file = new FileInputStream(path);
        p = new Properties();
        p.load(file);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(p.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String targetPath = System.getProperty("user.dir")
                + "/screenshots/" + tname + "_" + timeStamp + ".png";

        File target = new File(targetPath);
        target.getParentFile().mkdirs();

        org.openqa.selenium.io.FileHandler.copy(source, target);

        return targetPath;
    }
}