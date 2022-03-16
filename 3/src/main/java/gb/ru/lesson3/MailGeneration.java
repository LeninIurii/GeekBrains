package gb.ru.lesson3;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MailGeneration {
    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu","--blink-settings=imagesEnabled=false");


        WebDriver webDriver = WebDriverManager.chromedriver().create();



        webDriver.manage().window().setSize(new Dimension(1500,1100));
        webDriver.get("https://account.mail.ru/signup");

        /**
         *вводит имя
         */
        webDriver.findElement(By.xpath(" //input[@name='fname']")).sendKeys("Name");
        /**
         *вводит фамилию
         */
        webDriver.findElement(By.xpath(" //input[@name='lname']")).sendKeys("lastname");
        /**
         *выбирает пол
         */
        webDriver.findElement(By.xpath("//label[@data-test-id='gender-male']//span[@class='base-0-2-61 control-0-2-69 auto-0-2-86']")).click();

        webDriver.wait(5000);
        WebElement birthdate = webDriver.findElement(By.xpath("//div[@data-test-id='birth-date-form-field']"));

         /**
         *выбирает день
         */
        birthdate.findElement(By.xpath(" //div[@class='select-0-2-120 daySelect-0-2-121']")).click();
        webDriver.wait(500);
        birthdate.findElement(By.xpath(" //div[@data-test-id='birth-date__day']//div[@data-test-id='select-value:6']")).click();

        /**
         *выбирает месяц
         */
        birthdate.findElement(By.xpath(" //div[@data-test-id='birth-date__month']")).click();
        webDriver.wait(500);
        birthdate.findElement(By.xpath(" //div[@data-test-id='birth-date__month']//div[@data-test-id='select-value:5']")).click();

        /**
         *выбирает год
         */
        birthdate.findElement(By.xpath(" //div[@data-test-id='birth-date__year']")).click();
        webDriver.wait(500);
        birthdate.findElement(By.xpath("  //div[@data-test-id='birth-date__year']//div[@data-test-id='select-value:2015']")).click();

        /**
        *выбирает первую почту с доменом @bk.ru
        */
        webDriver.findElement(By.xpath("//div[@data-test-id='account-form-field']")).click();
        webDriver.findElement(By.xpath("(//div[@data-test-id='account-form-field']//a[contains(text(), '@bk.ru')])[1]")).click();

        /**
         *нажимает сгенерировать пароль
         */
        webDriver.findElement(By.xpath("(//a[@data-test-id='generate-password']")).click();

        /**
         *нажимает Указать резервную почту
         */
        webDriver.findElement(By.xpath("//a[@data-test-id='phone-number-switch-link']")).click();

        /**
         *нажимает Создать
         */
        // TODO: Открыть кнопку когда метод заработает
        // webDriver.findElement(By.xpath("//a[@data-test-id='phone-number-switch-link']")).click();



       webDriver.quit();


    }
}
