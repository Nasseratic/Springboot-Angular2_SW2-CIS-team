package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCreateGame {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://127.0.0.1:7777/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateGame() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.xpath("//md-tab-body[@id='md-tab-content-0-0']/div/game-cards/md-card/div/div[7]/md-card/md-card-actions/button")).click();
    driver.findElement(By.xpath("//md-tab-body[@id='md-tab-content-0-0']/div/game-cards/md-card/div/div[7]/md-card/md-card-actions/button")).click();
    driver.findElement(By.cssSelector("#md-radio-2 > label.mat-radio-label > div.mat-radio-label-content")).click();
    driver.findElement(By.id("md-radio-2-input")).click();
    driver.findElement(By.id("md-radio-2-input")).click();
    driver.findElement(By.xpath("//button[2]")).click();
    driver.findElement(By.xpath("//button[2]")).click();
    driver.findElement(By.xpath("//div[@id='cdk-overlay-0']/md-dialog-container/cdk-focus-trap/div[2]/dialog-result-example-dialog/button[2]")).click();
    driver.findElement(By.xpath("//div[@id='cdk-overlay-0']/md-dialog-container/cdk-focus-trap/div[2]/dialog-result-example-dialog/button[2]")).click();
    driver.findElement(By.cssSelector("#md-radio-3 > label.mat-radio-label > div.mat-radio-label-content")).click();
    driver.findElement(By.id("md-radio-3-input")).click();
    driver.findElement(By.id("md-radio-3-input")).click();
    driver.findElement(By.xpath("//button[2]")).click();
    driver.findElement(By.xpath("//button[2]")).click();
    driver.findElement(By.cssSelector("button.mat-button.mat-button-focus")).click();
    driver.findElement(By.cssSelector("button.mat-button.mat-button-focus")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
