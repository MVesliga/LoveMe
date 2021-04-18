package hr.tvz.loveme.selenium;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class UpdateProfileTests extends SeleniumTestBase {

    private final Random random = new Random();

    @Test
    @SneakyThrows
    void updateUserData_success() {
        prijava();

        WebElement mojProfil = webDriver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", mojProfil);
        Thread.sleep(1000);
        Assertions.assertThat(webDriver.getCurrentUrl()).contains("love-me/profil");

        WebElement urediProfil = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/a"));
        urediProfil.click();
        Thread.sleep(1000);
        Assertions.assertThat(webDriver.getCurrentUrl()).contains("love-me/profil/update");

        String generatedName = "Luka" + random.nextInt(1000);

        WebElement ime = webDriver.findElement(By.id("ime"));
        ime.clear();
        ime.sendKeys(generatedName);

        WebElement spremiPromjene = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        spremiPromjene.click();
        Thread.sleep(1000);

        WebElement porukaUspjeha = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/p"));
        Assertions.assertThat(porukaUspjeha.getText()).contains("Upješno ste promijenili korisničke podatke!");

        WebElement novoIme = webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/p[3]/span[2]"));
        Assertions.assertThat(novoIme.getText()).contains(generatedName);
    }
}
