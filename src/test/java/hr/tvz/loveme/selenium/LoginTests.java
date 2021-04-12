package hr.tvz.loveme.selenium;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class LoginTests {

    @BeforeEach
    public void setup() throws URISyntaxException {
        setProperties();
    }

    @Test
    @SneakyThrows
    void loginTest_success() {
        setProperties();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080");

        Thread.sleep(10000);
        webDriver.quit();
    }


    private void setProperties() throws URISyntaxException {
        URL chromeURL = getClass().getClassLoader().getResource("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", Paths.get(chromeURL.toURI()).toFile().getAbsolutePath());

    }
}
