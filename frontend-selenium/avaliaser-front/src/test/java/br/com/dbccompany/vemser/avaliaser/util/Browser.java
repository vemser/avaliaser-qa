package br.com.dbccompany.vemser.avaliaser.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void browserUp(String url) {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

//
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security","--ignore-certificate-errors", "--allow-running-insecure-content");

//

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, 10);

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);




    }

    public void browserDown() {
        driver.quit();
    }
}
