package hr.tvz.loveme.selenium;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegistrationTests extends SeleniumTestBase {

    private final Random random = new Random();

    @Test
    @SneakyThrows
    void registrationTest_success() {

        webDriver.get("http://localhost:8080");

        WebElement linkNaRegistraciju = webDriver.findElement(By.xpath("/html/body/div/div/div/div/p[2]/a"));
        linkNaRegistraciju.click();
        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/registracija");

        Thread.sleep(1000);
        WebElement ime = webDriver.findElement(By.id("ime"));
        ime.sendKeys("Luka");

        WebElement prezime = webDriver.findElement(By.id("prezime"));
        prezime.sendKeys("Doncic");

        WebElement korisnickoIme = webDriver.findElement(By.id("korisnickoIme"));
        korisnickoIme.sendKeys("ldoncic" + random.nextInt());

        WebElement email = webDriver.findElement(By.id("email"));
        email.sendKeys("ldoncic@test.com");

        WebElement lozinka = webDriver.findElement(By.id("lozinka"));
        lozinka.sendKeys("password");

        WebElement lozinkaPonovi = webDriver.findElement(By.id("potvrdiLozinku"));
        lozinkaPonovi.sendKeys("password");

        WebElement datumRodjenja = webDriver.findElement(By.id("datumRodjenja"));
        datumRodjenja.sendKeys("07/14/1993");

        WebElement predaj = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        predaj.click();
        Thread.sleep(1000);

        WebElement tekstUspjesnaRegistracija = webDriver.findElement(By.xpath("/html/body/div/div/div/div/p"));

        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/prijava");
        Assertions.assertThat(tekstUspjesnaRegistracija.getText()).contains("Uspješna registracija!");
    }

    @Test
    @SneakyThrows
    void registrationTest_ponovljenaLozinkaNijeIsta() {

        webDriver.get("http://localhost:8080");

        WebElement linkNaRegistraciju = webDriver.findElement(By.xpath("/html/body/div/div/div/div/p[2]/a"));
        linkNaRegistraciju.click();
        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/registracija");

        Thread.sleep(2000);
        WebElement ime = webDriver.findElement(By.id("ime"));
        ime.sendKeys("Luka");

        WebElement prezime = webDriver.findElement(By.id("prezime"));
        prezime.sendKeys("Doncic");

        WebElement korisnickoIme = webDriver.findElement(By.id("korisnickoIme"));
        korisnickoIme.sendKeys("ldoncic");

        WebElement email = webDriver.findElement(By.id("email"));
        email.sendKeys("ldoncic@test.com");

        WebElement lozinka = webDriver.findElement(By.id("lozinka"));
        lozinka.sendKeys("password");

        WebElement lozinkaPonovi = webDriver.findElement(By.id("potvrdiLozinku"));
        lozinkaPonovi.sendKeys("passwordNijeIsti");

        WebElement datumRodjenja = webDriver.findElement(By.id("datumRodjenja"));
        datumRodjenja.sendKeys("07/14/1993");

        WebElement predaj = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        predaj.click();
        Thread.sleep(1000);

        WebElement upozorenje = webDriver.findElement(By.xpath("/html/body/div/div/div/form/div[5]/div"));

        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/registracija");
        Assertions.assertThat(upozorenje.getText()).contains("Lozinke se ne podudaraju");
    }
}
