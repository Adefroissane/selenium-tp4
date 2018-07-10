import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

    @Test
    public void t1(){
        WebDriver driver = new ChromeDriver();
        driver.get ("https://www.google.com");
        driver.close();
    }
}
