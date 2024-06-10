/*Automate below scenario
1.launch browser
2.goto google.com
3.type "india" on search textfield
4.click on search button
*/

package selenium_assignment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A123_SearchOnGoogle {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("India");

		Thread.sleep(2000);
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.click();

	}

}
