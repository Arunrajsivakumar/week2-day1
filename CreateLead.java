package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String Comapany = "testleaf";
		String Fname = "Automation";
		String Lname = "Test";
		String LocalName = "Engineer";
		String Dept = "QA";
		String Desc = "Automatation is key";

		driver.get("http://leaftaps.com/opentaps/");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();// createLeadForm_companyName
		driver.findElement(By.className("selected")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Comapany);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lname);
		WebElement et = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(et);
		dd.selectByValue("LEAD_CONFERENCE");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(LocalName);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(Dept);
		driver.findElement(By.id("createLeadForm_description")).sendKeys(Desc);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select now = new Select(state);
		now.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();

		if (driver.getTitle().equals("View Lead | opentaps CRM")) {
			System.out.println("Lead Created successfully");
		} else {
			System.out.println("Lead has not been created");
		}

	}

}
