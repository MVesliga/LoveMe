package hr.tvz.loveme.selenium;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class LoginTests extends SeleniumTestBase {

    @Test
    @SneakyThrows
    void loginTest_success() {

        webDriver.get("http://localhost:8080");

        WebElement linkNaPrijavu = webDriver.findElement(By.xpath("/html/body/div/div/div/div/a"));
        linkNaPrijavu.click();
        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/prijava");

        Thread.sleep(1000);
        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys("luka");

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("lukapas");

        WebElement predaj = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        predaj.click();
        Thread.sleep(1000);

        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/love-me/");
    }

    @Test
    @SneakyThrows
    void loginTest_fail() {

        webDriver.get("http://localhost:8080");

        WebElement linkNaPrijavu = webDriver.findElement(By.xpath("/html/body/div/div/div/div/a"));
        linkNaPrijavu.click();
        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/prijava");

        Thread.sleep(1000);
        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys("luka");

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys("badPassword");

        WebElement predaj = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        predaj.click();
        Thread.sleep(1000);

        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/prijava");
    }
}
