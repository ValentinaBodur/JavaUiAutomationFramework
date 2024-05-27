package online.tekwillacademy.managers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager driverManagerSingleObject;
    private WebDriver driver;

    private DriverManager (){
        switch (webDriverType.toUpperCase()){
            case "CHROME":
                driver = new ChromeDriver();

                System.out.println("The Chrome Driver was initiated!");
                break;
            case "FIREFOX":
                driver = new SafariDriver();
                System.out.println("The Safari Driver was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println("The Edge Driver was initiated!");
                break;
            default:
                System.out.println("The webDriverType" + webDriverType + "is not de...");

        }
        driver.manage().window().maximize();
    }
    public static DriverManager getInstance(){
        if (driverManagerSingleObject == null){
            driverManagerSingleObject = new DriverManager();
        }
        return driverManagerSingleObject;
    }

    public WebDriver getDriver(){
        if (driver == null){
            DriverManager.getInstance();
        }
        return driver;
    }


}