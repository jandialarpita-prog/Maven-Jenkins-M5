package module_Contacts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_Contacts {
	public static void main(String[] args) throws InterruptedException {
		
		// OPEN THE BROWSER
		WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        
        //LOGIN
        driver.get("http://localhost:8888");
        
        WebElement username = driver.findElement(By.name("user_name"));
        username.sendKeys("admin");
        
        WebElement password = driver.findElement(By.name("user_password"));
        password.sendKeys("manager");
        
        driver.findElement(By.id("submitButton")).click();
        
        Thread.sleep(1000);
        
        //CREATE CONTACTS
        driver.findElement(By.linkText("Contacts")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
        Thread.sleep(1000);
        
        //FILLING THE DATA
        WebElement dropDown= driver.findElement(By.name("salutationtype"));
		Select salutationtype = new Select(dropDown);
		salutationtype.selectByValue("Ms.");
		
        WebElement name = driver.findElement(By.name("firstname"));
		name.sendKeys("Arpita");
		Thread.sleep(1000);
		
		String lastName = "Gupta";
		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys(lastName);
		
		WebElement dropDown1 = driver.findElement(By.name("leadsource"));
		Select leadsource = new Select(dropDown1);
		leadsource.selectByValue("Employee");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("arpitagupta@gmail.com");
		Thread.sleep(2000);
		
		WebElement phoneNumber = driver.findElement(By.id("mobile"));
		phoneNumber.sendKeys("9834751880");
        Thread.sleep(1000);

		
		// USING WINDOW HANDLE FIRST TIME

		// STEP 1:GET THE HOME ADDRESS/PARENT ID
		String PID = driver.getWindowHandle();

		// STEP 2 :PERFORM THE TASK WHICH WILL OPEN NEW WINDOW
		driver.findElement(By.xpath("//tr[2]//img[@alt='Select']")).click();
		Thread.sleep(2000);

		// STEP 3 :GET ALL THE WINDOWS ID/CJILDERN IDS
		Set<String> IDS = driver.getWindowHandles();

		// STEP 4 :SWITCH TO PARTICULAR WINDOW
		for (String i : IDS) {
			driver.switchTo().window(i);

			// STEP 5 :PERFORM THE TASK
			if (driver.getCurrentUrl().contains("Popup&popuptype")) {
				WebElement choose = driver.findElement(By.linkText("automationwitharpita"));
				Actions act = new Actions(driver);
				act.moveToElement(choose).click().build().perform();
				Thread.sleep(1000);
				driver.close();
				break;
			}
		}

		// STEP 6 :COME BACK TO HOME/PARENT PAGE
		driver.switchTo().window(PID);
		Thread.sleep(1000);
		

 //		Save 
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		Thread.sleep(1000);

//		Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println("Created contact " + lastName + " successfully!!!");
		} else {
			System.out.println("Failed....");
		}
		Thread.sleep(1000);

		
//		Logout
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Thread.sleep(1000);

        driver.quit();
	}

}
