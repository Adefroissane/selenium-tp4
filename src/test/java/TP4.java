import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TP4 {
    WebDriver driver;

    @Before
    public void init()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr/"); //point1
    }

    @Test
    public void test() {
        /**
         * Ouvrir le lien Nintendo Switch
         */
        WebElement categorie = driver.findElement(By.cssSelector("#nav-link-shopall"));
        Actions actions = new Actions(driver);
        actions.moveToElement(categorie);
        actions.build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[11]/span")));
        WebElement menuCat = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[11]/span"));
        actions.moveToElement(menuCat);
        actions.build().perform();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[11]/div/a[7]/span")));
        WebElement nintendoSwitch = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[11]/div/a[7]/span"));
        actions.moveToElement(nintendoSwitch);
        actions.build().perform();
        nintendoSwitch.click(); //point2

        /**
         * Ouvrir la catégorie jeux
         */
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[2]/div/a/div[1]/div/img")));
        WebElement jeux = driver.findElement(By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[2]/div/a/div[1]/div/img"));
        jeux.click(); //point3

        /**
         * Ouvrir le n°1 des ventes
         */
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"result_0\"]/div")));
        WebElement bestSeller = driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[2]/div/div[1]/div/div/a/img"));
        bestSeller.click(); //point4

        /**
         * Ajouter le jeu au panier
         */
        WebDriverWait wait5 = new WebDriverWait(driver, 10);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button\"]")));
        WebElement addPanier = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
        addPanier.click(); //point5

        /**
         * Ouvrir le panier
         */
        WebDriverWait wait6 = new WebDriverWait(driver, 10);
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-cart\"]/span[1]")));
        WebElement panier = driver.findElement(By.xpath("//*[@id=\"nav-cart\"]/span[1]"));
        panier.click(); //point6

        /**
         * Changer la quantité à 2
         */
        WebDriverWait wait7 = new WebDriverWait(driver, 10);
        wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-0-announce\"]")));
        WebElement nbr = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
        nbr.click();
        WebDriverWait wait8 = new WebDriverWait(driver, 10);
        wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdown1_1\"]")));
        WebElement nbr2 = driver.findElement(By.xpath("//*[@id=\"dropdown1_1\"]"));
        nbr2.click(); //point7

        /**
         * Verrifier le prix
         */
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        WebElement prix = driver.findElement(By.xpath("//*[@id=\"gutterCartViewForm\"]/div[3]/div[2]/div/div[1]/p/span/span[2]"));
        Assert.assertEquals("EUR 99,98", prix.getText()); //point8
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}
