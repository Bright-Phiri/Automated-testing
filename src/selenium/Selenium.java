/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//@author Bright

public class Selenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bright\\Desktop\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/Patient-Health-Record-IMS");
        WebElement username = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("bphiri.aki@gmail.com");
        password.sendKeys("Bright??1");
        driver.findElement(By.id("loginBtn")).click();
        String actaualUrl = "http://localhost/Patient-Health-Record-IMS/view/index.php";
        String expectedUrl = driver.getCurrentUrl();
        if (actaualUrl.equals(expectedUrl)) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Selenium.class.getName()).log(Level.SEVERE, null, ex);
            }
            driver.navigate().to("http://localhost/Patient-Health-Record-IMS/view/view_users.php");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Selenium.class.getName()).log(Level.SEVERE, null, ex);
            }
            driver.navigate().to("http://localhost/Patient-Health-Record-IMS/view/view_patients.php");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Selenium.class.getName()).log(Level.SEVERE, null, ex);
            }
            driver.navigate().to("http://localhost/Patient-Health-Record-IMS/view/add_patient.php");
            driver.findElement(By.id("firstname")).sendKeys("Bright");
            driver.findElement(By.id("lastname")).sendKeys("Phiri");
            driver.findElement(By.id("gender")).sendKeys("Male");
            driver.findElement(By.id("district")).sendKeys("Lilongwe");
            driver.findElement(By.id("village")).sendKeys("Kayivi");
            driver.findElement(By.id("occupation")).sendKeys("Student");
            driver.findElement(By.id("add-user-btn")).click();
        } else {
        }
    }

}
