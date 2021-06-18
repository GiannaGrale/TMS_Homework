import javafx.scene.shape.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class SmokeTest {

    @Test
    public void smokeTest1() throws InterruptedException{
 /*     1)Открыть сайт https://calc.by/weight-and-calories/body-mass-index-calculator.html
        2)Ввести Рост = 183 см
        3)Ввести Вес = 58 кг
        4)Нажать на кнопку ‘Рассчитать’
        5)Проверить, что значение в поле ‘ИМТ’ равно 17.32
        6)Проверить, что статус равен ’ Недостаточной массе тела’
        7)Закрыть окно браузера*/

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

/*        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Lenovo\\Downloads\\UnitTest\\untitled\\src\\test\\resources\\drivers\\chromedriver.exe");*/

        System.setProperty("webdriver.chrome.driver", absolutePath);
       //1.
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/weight-and-calories/body-mass-index-calculator.html");

       //2.
        WebElement heightInput = driver.findElement(By.id("bmiVar1"));
        //Assert.assertTrue(heightInput!=null);
        heightInput.sendKeys("183");

        //3.
        WebElement weightInput = driver.findElement(By.name("bmiVar2"));
        //Assert.assertTrue(weightInput!=null);
        weightInput.sendKeys("58");

        //4.
        WebElement calculateButton = driver.findElement(By.className("btn-calculate"));
        //Assert.assertTrue(calculateButton!=null);
        calculateButton.click();

        //5.
        String expectedIMTResult = "17.32";
        WebElement actualImtResultLabel = driver.findElement(By.id("AnswerBMI"));
        String actualImtResult = actualImtResultLabel.getText();
        Assert.assertEquals(actualImtResult,expectedIMTResult);


        //6.
        String expectedIMTMessage = "Недостаточной массе тела";
        WebElement actualImtResultMessageElement = driver.findElement(By.id("AnswerBMI1"));
        String actualImtMessage= actualImtResultMessageElement.getText();
        Assert.assertEquals(actualImtMessage,expectedIMTMessage);

   /*   WebElement customsCalculators = driver.findElement(By.linkText("Таможенные калькуляторы"));
        Assert.assertTrue(customsCalculators!=null);

        List<WebElement> webElementList = driver.findElements(By.tagName("section"));
        Assert.assertEquals(webElementList.size(),2);

        WebElement otherCalc = driver.findElement(By.partialLinkText("Прочие"));
        Assert.assertTrue(otherCalc!=null);*/


       //driver.close(); //закрывает тукущую вкладку но не процесс

        //7.
        driver.quit();  //выходит из драйвера и убивает процесс полностью


    }

    public void SmokeTest2 (){

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

/*        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Lenovo\\Downloads\\UnitTest\\untitled\\src\\test\\resources\\drivers\\chromedriver.exe");*/

        System.setProperty("webdriver.chrome.driver", absolutePath);
        //1.
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement layingMethodLaminateElement = driver.findElement(By.tagName("select"));

        Select layingMethodLaminate = new Select(layingMethodLaminateElement);
        layingMethodLaminate.selectByIndex(0);
        layingMethodLaminate.selectByValue("1");
        layingMethodLaminate.deselectByVisibleText("с использованием отрезанного элемента");
        driver.quit();
    }
}