package gb.ru.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LogInLenovo {
    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--blink-settings=imagesEnabled=false");


        WebDriver webDriver = WebDriverManager.chromedriver().create();


        webDriver.manage().window().setSize(new Dimension(1500, 1100));
        webDriver.get("https://shop.lenovo.ru/lk/");

        //TODO:Вставить валидное имя после починки класса MailGeneration
        /**
         *Вводим имя
         */
        webDriver.findElement(By.name("USER_LOGIN")).sendKeys("LOGIN@login.ru");

        //TODO:Вставить валидную фамилию после починки класса MailGeneration
        /**
         *Вводим фамилию
         */
        webDriver.findElement(By.name("USER_PASSWORD")).sendKeys("PASSWORD");

        //TODO:открыть после починки класса MailGeneration
        /**
         *Нажимает войти
         */
        //webDriver.findElement(By.xpath("//button[@class='lk-auth__btn js-lk-profile-save valid']")).click();



    }
}
