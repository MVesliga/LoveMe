package hr.tvz.loveme.selenium;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LanguageChangeTests extends SeleniumTestBase {

    @Test
    @SneakyThrows
    void languageChange_success() {
        prijava();

        // Defaultni jezik je hrvatski
        WebElement pocetnaPorukaHrv = webDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/h1"));

        Assertions.assertThat(pocetnaPorukaHrv.getText()).contains("Dobrodošli na LoveMe!");

        WebElement radioButtonEng = webDriver.findElement(By.xpath("//*[@id=\"enRadio\"]"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", radioButtonEng);
        Thread.sleep(1000);

        WebElement pocetnaPorukaEng = webDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/h1"));
        Assertions.assertThat(pocetnaPorukaEng.getText()).contains("Welcome to LoveMe!");
    }




}
