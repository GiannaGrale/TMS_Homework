import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class HomeTask5Additional {

    @Test
    public void SmokeTest3_1() throws InterruptedException {
/*
        1.Открыть сайт
        2.https://masterskayapola.ru/kalkulyator/laminata.html
        3.Ввести параметры для расчета
        4.Нажать на кнопку ‘Рассчитать’
        5.Проверить полученные значения
        6.Закрыть окно браузера*/

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absPath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absPath);

        //1.1
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        //1.2 (9,100) длина помещения
        WebElement lengthRoomInput = driver.findElement(By.name("calc_roomwidth"));
        lengthRoomInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        lengthRoomInput.sendKeys("9,100");

        //1.3 (8) ширина помещения
        WebElement widthRoomInput = driver.findElement(By.name("calc_roomheight"));
        widthRoomInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        widthRoomInput.sendKeys("8");

        //1.4 в упаковке
        WebElement packageInput = driver.findElement(By.name("calc_inpack"));
        packageInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        packageInput.sendKeys("10");

        //1.5 направление укладки
        WebElement layingDirection = driver.findElement(By.name("calc_direct"));
        Select layingDirectionChoice = new Select(layingDirection);
        layingDirectionChoice.selectByValue("toh");

        //1.6 рассчитать
        WebElement calculateButtonElement = driver.findElement(By.className("btn-secondary"));
        calculateButtonElement.click();
        Thread.sleep(1000);

        //1.7 проверка площади укладки
        String expectedLengthRoomInputMessage = "72.46 м2.";
        WebElement lengthRoomInputElement = driver.findElement(By.id("s_lam"));
        String actualLengthRoomInputMessage = lengthRoomInputElement.getText();
        Assert.assertEquals(actualLengthRoomInputMessage, expectedLengthRoomInputMessage);

        //1.8  проверка кол-во панелей
        String expectedNumberBarsMessage = "300 шт.";
        WebElement numberBarsElement = driver.findElement(By.id("l_count"));
        String actualNumberBarsMessage = numberBarsElement.getText();
        Assert.assertEquals(actualNumberBarsMessage, expectedNumberBarsMessage);

        //1.9 проверка кол-во упаковок
        String expectedNumberPackagesMessage = "30 шт.";
        WebElement numberPackagesElement = driver.findElement(By.id("l_packs"));
        String actualNumberPackagesMessage = numberPackagesElement.getText();
        Assert.assertEquals(actualNumberPackagesMessage, expectedNumberPackagesMessage);

        //1.10 проверка цены
        String expectedPriceMessage = "37440 руб.";
        WebElement priceElement = driver.findElement(By.id("l_price"));
        String actualPriceMessage = priceElement.getText();
        Assert.assertEquals(expectedPriceMessage, actualPriceMessage);

        //1.11 проверка остатка
        String expectedRestMessage = "0 шт.";
        WebElement restElement = driver.findElement(By.id("l_over"));
        String actualRestMessage = restElement.getText();
        Assert.assertEquals(expectedRestMessage, actualRestMessage);

        //1.12 проверка отрезков
        String expectedCutoffMessage = "12 шт.";
        WebElement cutOffElement = driver.findElement(By.id("l_trash"));
        String actualCutoffMessage = cutOffElement.getText();
        Assert.assertEquals(expectedCutoffMessage, actualCutoffMessage);
        driver.quit();
    }

    @Test
    public void SmokeTest3_2() throws InterruptedException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absPath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absPath);

        //2.1 старт
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        //2.2 (1800) длина ламината
        WebElement lengthLaminateInput = driver.findElement(By.name("calc_lamwidth"));
        lengthLaminateInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        lengthLaminateInput.sendKeys("1800");

        //2.3 (300) ширина ламината
        WebElement widthLaminateInput = driver.findElement(By.name("calc_lamheight"));
        widthLaminateInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        widthLaminateInput.sendKeys("300");

        //2.4 (700) цена
        WebElement costInput = driver.findElement(By.name("calc_price"));
        costInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        costInput.sendKeys("700");

        //2.5 (400) смещение рядов
        WebElement biasInput = driver.findElement(By.name("calc_bias"));
        biasInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        biasInput.sendKeys("400");

        //2.6 направление укладки
        WebElement layingDirection = driver.findElement(By.name("calc_direct"));
        Select layingDirectionChoice = new Select(layingDirection);
        layingDirectionChoice.selectByValue("tow");

        //2.7 рассчитать
        WebElement calculateButtonElement = driver.findElement(By.className("btn-secondary"));
        calculateButtonElement.click();
        Thread.sleep(1000);

        //2.8 площадь укладки
        String expectedLengthRoomInputMessage = "17.82 м2.";
        WebElement lengthRoomInputElement = driver.findElement(By.id("s_lam"));
        String actualLengthRoomInputMessage = lengthRoomInputElement.getText();
        Assert.assertEquals(actualLengthRoomInputMessage, expectedLengthRoomInputMessage);

        //2.9 кол-во панелей
        String expectedNumberBarsMessage = "34 шт.";
        WebElement numberBarsElement = driver.findElement(By.id("l_count"));
        String actualNumberBarsMessage = numberBarsElement.getText();
        Assert.assertEquals(actualNumberBarsMessage, expectedNumberBarsMessage);

        //2.10 кол-во упаковок
        String expectedNumberPackagesMessage = "3 шт.";
        WebElement numberPackagesElement = driver.findElement(By.id("l_packs"));
        String actualNumberPackagesMessage = numberPackagesElement.getText();
        Assert.assertEquals(actualNumberPackagesMessage, expectedNumberPackagesMessage);

        //2.11 стоимость
        String expectedPriceMessage = "13608 руб.";
        WebElement priceElement = driver.findElement(By.id("l_price"));
        String actualPriceMessage = priceElement.getText();
        Assert.assertEquals(expectedPriceMessage, actualPriceMessage);

        //2.12 проверка остатка
        String expectedRestMessage = "2 шт.";
        WebElement restElement = driver.findElement(By.id("l_over"));
        String actualRestMessage = restElement.getText();
        Assert.assertEquals(expectedRestMessage, actualRestMessage);

        //2.13 проверка отрезков
        String expectedCutoffMessage = "2 шт.";
        WebElement cutOffElement = driver.findElement(By.id("l_trash"));
        String actualCutoffMessage = cutOffElement.getText();
        Assert.assertEquals(expectedCutoffMessage, actualCutoffMessage);
        driver.quit();
    }

    @Test
    void SmokeTest3_3() throws InterruptedException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absPath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absPath);

        //2.1 старт
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        //2.2 (2200) длина помещения
        WebElement lengthRoomInput = driver.findElement(By.name("calc_roomwidth"));
        lengthRoomInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        lengthRoomInput.sendKeys("2,220");

        //2.3 (9,900) ширина помещения
        WebElement widthRoomInput = driver.findElement(By.name("calc_roomheight"));
        widthRoomInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        widthRoomInput.sendKeys("9,900");

        //2.2 (777) ширина ламината
        WebElement widthLaminateInput = driver.findElement(By.name("calc_lamheight"));
        widthLaminateInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        widthLaminateInput.sendKeys("777");

        //2.3 (654) цена
        WebElement costInput = driver.findElement(By.name("calc_price"));
        costInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        costInput.sendKeys("654");

        //2.4 (15) отуступ от стены
        WebElement wallDistanceInput = driver.findElement(By.name("calc_walldist"));
        wallDistanceInput.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        wallDistanceInput.sendKeys("15");

        //2.5 направление укладки
        WebElement layingDirection = driver.findElement(By.name("calc_direct"));
        Select layingDirectionChoice = new Select(layingDirection);
        layingDirectionChoice.selectByValue("tow");

        //2.6 рассчитать
        WebElement calculateButtonElement = driver.findElement(By.className("btn-secondary"));
        calculateButtonElement.click();
        Thread.sleep(1000);

        //2.7 площадь укладки
        String expectedLengthRoomInputMessage = "21.62 м2.";
        WebElement lengthRoomInputElement = driver.findElement(By.id("s_lam"));
        String actualLengthRoomInputMessage = lengthRoomInputElement.getText();
        Assert.assertEquals(actualLengthRoomInputMessage, expectedLengthRoomInputMessage);

        //2.8 кол-во панелей
        String expectedNumberBarsMessage = "23 шт.";
        WebElement numberBarsElement = driver.findElement(By.id("l_count"));
        String actualNumberBarsMessage = numberBarsElement.getText();
        Assert.assertEquals(actualNumberBarsMessage, expectedNumberBarsMessage);

        //2.9 кол-во упаковок
        String expectedNumberPackagesMessage = "2 шт.";
        WebElement numberPackagesElement = driver.findElement(By.id("l_packs"));
        String actualNumberPackagesMessage = numberPackagesElement.getText();
        Assert.assertEquals(actualNumberPackagesMessage, expectedNumberPackagesMessage);

        //2.10 стоимость
        String expectedPriceMessage = "15854 руб.";
        WebElement priceElement = driver.findElement(By.id("l_price"));
        String actualPriceMessage = priceElement.getText();
        Assert.assertEquals(expectedPriceMessage, actualPriceMessage);

        //2.12 проверка остатка
        String expectedRestMessage = "1 шт.";
        WebElement restElement = driver.findElement(By.id("l_over"));
        String actualRestMessage = restElement.getText();
        Assert.assertEquals(expectedRestMessage, actualRestMessage);

        //1.10 проверка отрезков
        String expectedCutoffMessage = "4 шт.";
        WebElement cutOffElement = driver.findElement(By.id("l_trash"));
        String actualCutoffMessage = cutOffElement.getText();
        Assert.assertEquals(expectedCutoffMessage, actualCutoffMessage);
        driver.quit();
    }
}

