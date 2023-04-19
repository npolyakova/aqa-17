import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleSeleniumTest {

    static ChromeDriver driver;

    @BeforeAll
    public static void setBeforeAll() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @BeforeEach
    public void openBeforeEach() {
        driver = new ChromeDriver();
        driver.get("https://www.tkani-feya.ru/");
    }

    @AfterEach
    public void closeAfterEach() {
        driver.close();
    }

    @Test
    public void shouldSearchTextile() {
        driver.findElement(By.name("find")).sendKeys("шелк" + Keys.ENTER); //name="find"

        assertEquals(driver.getCurrentUrl(), "https://www.tkani-feya.ru/fabrics/?find=%D1%88%D0%B5%D0%BB%D0%BA");
        assertTrue(driver.findElement(By.tagName("h1")).isDisplayed());

        for ( WebElement el : driver.findElements(By.cssSelector(".text-block .name"))) {
            assertTrue(el.getText().contains("Шелк"));
        }

    }
}
