package br.com.dbccompany.vemser.avaliaser.pages;

import br.com.dbccompany.vemser.avaliaser.util.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BasePage extends Elements {

    public static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    public static Boolean isSelected(By by) {
        waitElement(by);
        return element(by).isSelected();
    }

    public static void sendKeys(By by, String texto) {
        waitElement(by);
        element(by).sendKeys(texto);
    }

    public static String getText(By by) {
        waitElement(by);
        return element(by).getAttribute();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
