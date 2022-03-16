package gb.ru.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddtoCart {

    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--blink-settings=imagesEnabled=false");


        WebDriver webDriver = WebDriverManager.chromedriver().create();


        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.get("https://shop.lenovo.ru/noutbuki/");


        /**
         *Нажимает купить по выбранной моделе
         */
        webDriver.findElement(By.xpath("//span[@data-name='Ноутбук Lenovo Legion 5 Gen 5 (82B300C8RK)']")).click();

        /**
         *Проверка добавлен ли элемент
         */
        webDriver.findElement(By.xpath("//h2[contains(text(),'Товар добавлен в корзину')]")).isDisplayed();





        webDriver.quit();

    }

}
