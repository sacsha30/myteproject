package accentureutils.myte;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Timesheet {

	private static final String STRFROMDATE = "10/16/2017";// m/dd/yyyy
	private static final String STRTODATE = "10/31/2017";

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://myte.accenture.com");

		WebElement username = driver.findElement(By.name("UserName"));
		WebElement password = driver.findElement(By.name("Password"));

		username.sendKeys("s.r.sharma");
		password.sendKeys("");

		WebElement signInBtn = driver.findElement(By.id("submitButton"));
		signInBtn.click();

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// WebElement element = wait.until(ExpectedConditions.);
		// element.click();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement securityCodeLink = driver.findElement(By.id("vipOoblink"));
		securityCodeLink.click();

		WebElement selectSMSText = driver.findElement(By.name("oob"));
		selectSMSText.click();

		WebElement sendSMSSendBtn = driver.findElement(By.id("vipSend"));
		sendSMSSendBtn.click();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement enterTAndELink = driver
				.findElement(By.id("ctl00_MainContentPlaceHolder_AnnouncementControl_lnk_Enter2"));
		enterTAndELink.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement expenseTab = driver.findElement(By.id("ctl00_ctl00_MainContentPlaceHolder_Expense-IN"));
		expenseTab.click();

		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = (Date) formatter.parse(STRFROMDATE);
			endDate = (Date) formatter.parse(STRTODATE);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		while (startDate != null && endDate != null && startDate.compareTo(endDate) == -1) {
			System.out.println("Startdate:: " + startDate);
			Calendar c = Calendar.getInstance();
			c.setTime(startDate);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (dayOfWeek != 1 && dayOfWeek != 7) {
				WebElement expenseTypeDiv = driver.findElement(By.xpath(
						"//*[@id=\"ctl00_ctl00_MainContentPlaceHolder_ContentPlaceHolder_TimeReport_AddExpenseList_new_toggleDiv\"]"));
				//expenseTypeDiv.click();
				Actions actions = new Actions(driver);
				actions.moveToElement(expenseTypeDiv).click().perform();

				WebElement expenseOption = driver.findElement(By.xpath(
						"//*[@id=\"ctl00_ctl00_MainContentPlaceHolder_ContentPlaceHolder_TimeReport_tabContent\"]/div[2]/table/tbody/tr/td[11]/div/ul/li[11]"));
				expenseOption.click();

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				WebElement assignmentInput = driver.findElement(By.name(
						"ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$expense_DetailsControl$expenseProjectDropDown"));
				assignmentInput.sendKeys("Out Forcecom - India - India (Z004QB85)");

				WebElement amountInput = driver.findElement(By.name(
						"ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$expense_DetailsControl$9040"));
				amountInput.sendKeys("300");

				WebElement fromDate = driver.findElement(By.name(
						"ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$expense_DetailsControl$expenseDate"));
				fromDate.sendKeys(formatter.format(startDate));

				WebElement toDate = driver.findElement(By.name(
						"ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$expense_DetailsControl$9049"));
				toDate.sendKeys(formatter.format(startDate));

				WebElement reasonInput = driver.findElement(By.name(
						"ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$expense_DetailsControl$9051"));
				reasonInput.sendKeys("Home <-> Home Office");

				WebElement typeInput = driver.findElement(By.name(
						"ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$expense_DetailsControl$9054"));
				typeInput.sendKeys("Taxi");
				
				try {
					Thread.sleep(2000);
				}catch(Exception e) {
					
				}

				WebElement roundTripSelect = driver.findElement(By.id(
						"ctl00_ctl00_MainContentPlaceHolder_ContentPlaceHolder_TimeReport_expense_DetailsControl_11031_1"));
				roundTripSelect.click();

				WebElement saveBtn = driver.findElement(By
						.name("ctl00$ctl00$MainContentPlaceHolder$ContentPlaceHolder_TimeReport$btn_DetailOK_bottom"));
				saveBtn.click();
			}
			c.add(Calendar.DATE, 1);
			startDate = c.getTime();
		}
	}
	// driver.close();
	// }

}
