//Login to Amazon application using DDT concept

package selenium_assignment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A177_DDT_AmazonLogin {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		String credSheet = "credentials";
		FileInputStream file = new FileInputStream("C:\\Users\\91809\\eclipse-workspace\\GrotechMinds\\Selenium\\TestData\\Amazon login.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		
		WebElement signInHover = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(signInHover).perform();
		
		WebElement signInButton = driver.findElement(By.xpath("(//span[@class = 'nav-action-inner'])[1]"));
		signInButton.click();

		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		String emailCell = workbook.getSheet(credSheet).getRow(0).getCell(0).getStringCellValue();
		email.sendKeys(emailCell);
		email.sendKeys(Keys.ENTER);
		
		WebElement password = driver.findElement(By.name("password"));
		String passwordCell = workbook.getSheet(credSheet).getRow(9).getCell(1).getStringCellValue();
		password.sendKeys(passwordCell);
		password.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.close();
	}

}
