package SeleniumDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumDesign.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    // Step 1: Declare global WebDriver and LandingPage
    public WebDriver driver;
    public LoginPage landingPage;

    // Step 2: Method to initialize WebDriver
    public WebDriver intializedriver() throws IOException {
        Properties prop = new Properties();

        // Load GlobalData.properties from correct path
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "/src/main/java/SeleniumDesign/Resources/GlobalData.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");

       
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } 

        // Waits and setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        return driver;
    }

    // Step 3: Method to take a screenshot
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dst = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");

        // Create reports directory if it doesn't exist
       
        FileUtils.copyFile(src, dst);
        return  System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
    }

    // Step 4: Launch application before each test
    @BeforeMethod(alwaysRun = true)
    public LoginPage launchApplication() throws IOException {
        driver = intializedriver();
        landingPage = new LoginPage(driver);
        landingPage.gotoDemoBlazeURL();  // Replace with actual method to open your test site
        return landingPage;
    }

    // Step 5: Close browser after each test
    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();  // Use quit instead of close to end session cleanly
        }
    }
}
