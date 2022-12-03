package br.com.dbccompany.vemser.avaliaser.pages;

import br.com.dbccompany.vemser.avaliaser.util.Elements;
import org.openqa.selenium.By;

import static br.com.dbccompany.vemser.avaliaser.util.Elements.waitElement;
import static br.com.dbccompany.vemser.avaliaser.util.Elements.waitVisibility;

public class BasePage extends Elements {
    public static void click(By by){
        waitElement(by);
        waitVisibility(by).click();
    }

    public static void clear(By by){
        waitElement(by);
        waitVisibility(by).clear();
    }

    public static void sendKeys(By by, String texto){
        waitElement(by);
        waitVisibility(by).sendKeys(texto);
    }

    public static String getText(By by){
        waitElement(by);
        return waitVisibility(by).getText();
    }

    public static String getAttributeInnerText(By by){
        waitElement(by);
        return waitVisibility(by).getAttribute("innerText");
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}