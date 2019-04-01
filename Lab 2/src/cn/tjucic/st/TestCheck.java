package cn.tjucic.st;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestCheck {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	String driverPath = System.getProperty("user.dir") + "/src/geckodriver.exe";
	System.setProperty("webdriver.gecko.driver", driverPath);
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	InputStream is = new FileInputStream("src/»Ìº˛≤‚ ‘√˚µ•.xlsx");
    XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
	int rows = xssfSheet.getLastRowNum();
	System.out.println(rows);
    driver.get("http://121.193.130.195:8800/login");
    for (int i=2; i<=rows; i++)
    {
    	XSSFRow xssfRow = xssfSheet.getRow(i);
    	XSSFCell cell = xssfRow.getCell(1);
    	DecimalFormat df = new DecimalFormat("##########");
    	String ID = df.format(cell.getNumericCellValue());
    	if (ID.equals("3016218164"))
    		continue;
    	driver.findElement(By.name("id")).click();
        driver.findElement(By.name("id")).clear();
        driver.findElement(By.name("id")).sendKeys(ID);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(ID.substring(4));
        driver.findElement(By.id("login_form")).click();
        driver.findElement(By.id("btn_login")).click();
        assertEquals(xssfRow.getCell(3).getStringCellValue(), driver.findElement(By.id("student-git")).getText());
        driver.findElement(By.linkText("LOG OUT")).click();
        driver.findElement(By.linkText("Return to Login Page")).click();
    }
  }

  @After
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
