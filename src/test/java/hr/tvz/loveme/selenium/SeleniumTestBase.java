package hr.tvz.loveme.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class SeleniumTestBase {

    WebDriver webDriver;

    @BeforeEach
    public void setup() throws URISyntaxException {
        setProperties();
        webDriver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

    private void setProperties() throws URISyntaxException {
        URL chromeURL = getClass().getClassLoader().getResource("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", Paths.get(chromeURL.toURI()).toFile().getAbsolutePath());
    }

    protected void prijava() throws InterruptedException {
        webDriver.get("http://localhost:8080");

        WebElement linkNaPrijavu = webDriver.findElement(By.xpath("/html/body/div/div/div/div/a"));
        linkNaPrijavu.click();

        Thread.sleep(1000);
        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys("luka");

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("lukapas");

        WebElement predaj = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        predaj.click();
        Thread.sleep(2000);
    }

}
