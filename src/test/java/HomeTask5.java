import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class HomeTask5 {

    @Test
    public void smokeTest2() throws InterruptedException {

 /*     1.Открыть сайт https://calc.by/building-calculators/laminate.html
        2.Выбрать ‘Способ укладки ламината’ из выпадающего списка
        3.Ввести ‘Длина комнаты’ = 500
        4.Ввести ‘Ширина комнаты’ = 400
        5.Ввести ‘Длина панели ламината’ = 2000
        6.Ввести ‘Ширина панели ламината’ = 200
        7.Выбрать ’Направление укладки’ = по ширине комнаты
        8.Нажать на кнопку ‘Рассчитать’
        9.Проверить результаты: ‘Требуемое количество досок ламината: '53'
        10.Проверить результаты: ‘Количество упаковок ламината: '7'
        11.Закрыть окно браузера*/

        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absPath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absPath);

        //1
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://calc.by/building-calculators/laminate.html");

        //2
        WebElement laminateLayingChoiceElement = chromeDriver.findElement(By.id("laying_method_laminate"));
        Select laminateLayingChoice = new Select(laminateLayingChoiceElement);
        laminateLayingChoice.selectByValue("2");

        //3
        WebElement roomLengthInput = chromeDriver.findElement(By.id("ln_room_id"));
        roomLengthInput.clear();
        roomLengthInput.sendKeys("500");

        //4
        WebElement roomWidthInput = chromeDriver.findElement(By.id("wd_room_id"));
        roomWidthInput.clear();
        roomWidthInput.sendKeys("400");

        //5
        WebElement lengthLaminateInput = chromeDriver.findElement(By.id("ln_lam_id"));
        lengthLaminateInput.clear();
        lengthLaminateInput.sendKeys("2000");

        //6
        WebElement widthLaminateInput = chromeDriver.findElement(By.id("wd_lam_id"));
        widthLaminateInput.clear();
        widthLaminateInput.sendKeys("200");

        //7
        WebElement layingDirection = chromeDriver.findElement(By.id("direction-laminate-id1"));
        layingDirection.click();
        Thread.sleep(1000);

        //8
        WebElement calculateButton = chromeDriver.findElement(By.linkText("Рассчитать"));
        calculateButton.click();
        Thread.sleep(2000);

        //9
        String expectedLaminateNeededMessage = "53";
        WebElement actualLaminateNeededElement = chromeDriver.findElement(By.xpath("//div[@class='calc-result']/div[1]/span"));
        String actualLaminateNeededElementMessage = actualLaminateNeededElement.getText();
        Assert.assertEquals(actualLaminateNeededElementMessage, expectedLaminateNeededMessage);
        Thread.sleep(2000);

        //10
        String expectedLaminateWrappersMessage = "7";
        WebElement actualLaminateWrappersElement = chromeDriver.findElement(By.xpath("//div[@class='calc-result']/div[2]/span"));
        String actualLaminateWrappersMessage = actualLaminateWrappersElement.getText();
        Assert.assertEquals(actualLaminateWrappersMessage, expectedLaminateWrappersMessage);

        //11
        chromeDriver.quit();
    }
}

