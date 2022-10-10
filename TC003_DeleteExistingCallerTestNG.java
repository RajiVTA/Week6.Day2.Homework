package week6.day2.serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC003_DeleteExistingCallerTestNG  extends TC004_BaseClass{
	
	
	@Test
	public void deleteExistingCaller() throws InterruptedException
	{
		// 3.1 -------Enter Callers in filter navigator and press enter -------------------

				Thread.sleep(30000);
				WebElement proposal = shadow.findElementByXPath("//input[@id='filter']");
				proposal.sendKeys("Callers");
				Thread.sleep(25000);
				proposal.sendKeys(Keys.ENTER);
				Thread.sleep(20000);
				
				// 4. Search by LastName and Enter the lastName for the record to be deleted

				// 4.1 Switch to frame
				
				WebElement frame3 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(frame3);
				
				// 4.2 -------------- Select 'Last Name' as search field---------------------------------------------------
				WebElement forText = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
				Select sel=new Select(forText);
				sel.selectByValue("last_name");
				
				// 4.3 ----------------Enter LastName of the Caller to be upsated------------------------------------------
				Thread.sleep(5000);
				String lName="Velmurugan";
				WebElement searchEle = driver.findElement(By.xpath("//input[@class='form-control']"));
				searchEle.sendKeys(lName);
				Thread.sleep(4000);
				searchEle.sendKeys(Keys.ENTER);
				
				// 4.4 --------------Fetch the LastName from the table displayed and click that caller -------
				
				WebElement resultData = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]"));
				String result = resultData.getText();
				resultData.click();
				
				Thread.sleep(9000);
				
				driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]/a")).click();
				Thread.sleep(18000);
				
				//driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[1]")).click();
				//Thread.sleep(9000);
						
				driver.switchTo().defaultContent();
				
				// 5.1 --------------Switch to Frame-------------------------------------------------------------------------
				WebElement frame4 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(frame4);
				
				driver.findElement(By.xpath("//button[@id='sysverb_delete_bottom']")).click();
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//button[@id='ok_button']")).click();
				Thread.sleep(15000);
				
				driver.switchTo().defaultContent();
				
				// 6. Check whether Deleted caller is available or not
				
				Thread.sleep(17000);
				WebElement frame5 = shadow.findElementByXPath("//iframe[@title='Main Content']");
				driver.switchTo().frame(frame5);
				
				
				WebElement result1 = driver.findElement(By.xpath("//table[@id='sys_user_table']/tbody/tr[1]/td[3]"));
				String res = result1.getText();
				Thread.sleep(10000);
				
			
				if(lName!=res)
				{
					System.out.println("Caller deleted");
				}
				else
				{
					System.out.println("Caller is not deleted");
				}

				driver.switchTo().defaultContent();
				Thread.sleep(6000);
				
		
		
		
		
	}

}
