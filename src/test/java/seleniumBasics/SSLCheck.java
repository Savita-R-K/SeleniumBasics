package seleniumBasics;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SSLCheck {
    @Test
    public void ssl() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addExtensions("dowloadedextension");

        //proxy
        Proxy proxy = new Proxy();

        WebDriver driver = new ChromeDriver(options);

    }

    @Test
    public void sslCertHandlingAndProxy() {
        ChromeOptions options = new ChromeOptions();

        Proxy proxy = new Proxy();

        proxy.setHttpProxy("ipaddress:4444");

        options.setCapability("proxy", proxy);

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        // FirefoxOptions options1 = new FirefoxOptions();
        // options1.setAcceptInsecureCerts(true);
        // EdgeOptions options2 = new EdgeOptions();

        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }

}
