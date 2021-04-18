package hr.tvz.loveme.selenium;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddPetTests extends SeleniumTestBase {

    @Test
    @SneakyThrows
    void addNewPet_success() {
        prijava();

        WebElement createPetButton = webDriver.findElement(By.xpath("/html/body/div/div[1]/div[2]/a"));
        createPetButton.click();
        Thread.sleep(1000);

        Assertions.assertThat(webDriver.getCurrentUrl()).contains("/love-me/novi-ljubimac");

        WebElement ime = webDriver.findElement(By.id("ime_ljubimci"));
        ime.sendKeys("djuro");

        WebElement vrsta = webDriver.findElement(By.id("vrsta_ljubimci"));
        vrsta.sendKeys("pekinezer");

        WebElement dob = webDriver.findElement(By.id("dob_ljubimci"));
        dob.sendKeys("4");


        WebElement veterinar = webDriver.findElement(By.xpath("//*[@id=\"veterinar\"]/input"));
        veterinar.sendKeys("1/2/1999");

        WebElement obuka = webDriver.findElement(By.id("obuka"));
        obuka.sendKeys("Nema");

        WebElement hrana = webDriver.findElement(By.id("hrana"));
        hrana.sendKeys("Whiskas");

        WebElement igracka = webDriver.findElement(By.id("igracka"));
        igracka.sendKeys("igracka");

        WebElement addNewPet = webDriver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        addNewPet.click();
        Thread.sleep(1000);
    }
}
