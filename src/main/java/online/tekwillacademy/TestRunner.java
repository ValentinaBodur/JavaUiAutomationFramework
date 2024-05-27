package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();
        Thread.sleep(5000);

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://maven.apache.org/download.cgi");
        Thread.sleep(5000);
        driver.close();

        driver.switchTo().window(currentWindowName);
        manager.getDriver().get("https://tekwillacademy-opencart.online/");
        Thread.sleep(5000);
        driver.quit();

        System.out.println("The driver is closed");


    }


}