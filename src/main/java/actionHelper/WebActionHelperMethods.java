package actionHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import reportManager.ExtentTestManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebActionHelperMethods {

	private WebDriver driver;

	public WebActionHelperMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void writeOnEditText(String data, WebElement xpath) {
		xpath.sendKeys(data);
	}

	public boolean clickbutton(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		return true;
	}

	public boolean clickbutton(WebElement xpath) {
		xpath.click();
		return true;
	}

	public void clickLink(String data) {
		driver.findElement(By.linkText(data));
	}

	public void clickImage(String data, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public String getObjectText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public boolean compareString(String First, String Second) {
		if (First.equalsIgnoreCase(Second)) {
			return true;
		} else
			return false;

	}

	public boolean containsString(String First, String Second) {
		if (First.contains(Second)) {
			return true;
		} else
			return false;

	}

	/**
	 * This Keyword verifies the Text of an specified object on the web page. It
	 * takes an object as object input argument and before & after as data input
	 * arguments.
	 *
	 * @param Text
	 * @param xpath
	 * @return
	 */
	public boolean verifyObjectText(String Text, WebElement xpath) {

		return compareString(Text, xpath.getText());
	}

	/**
	 * This keyword verifies whether the specified object exist over the given
	 * web page or not. This keyword takes object as object input argument.
	 *
	 * @param xpath
	 * @return
	 */
	public boolean VerifyObjectExists(WebElement xpath) {
		if (xpath.isDisplayed()) {
			return true;


		} else {
			return false;
		}
	}

	/**
	 * This keyword verifies that the provided Object is enabled on page or not.
	 * This keyword is mostly used in situations where you have to provide an
	 * Object and want to verify that the particular object is enabled on the
	 * page or not.
	 *
	 * @param xpath
	 * @return
	 */
	public boolean VerifyObjectEnabled(String xpath) {
		if (driver.findElement(By.xpath(xpath)).isEnabled()) {
			return true;

		} else {
			return false;
		}
	}

	/**
	 * This keyword verifies that the specified object is disabled on the page.
	 *
	 * @param xpath
	 * @return
	 */
	public boolean VerifyObjectDisabled(String xpath) {
		if (driver.findElement(By.xpath(xpath)).isEnabled()) {
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Method is used to get Internal text
	 *
	 * @param xpath
	 * @return
	 * @author 
	 */
	public String getobjectValue(String xpath) {
		return driver.findElement(By.xpath(xpath)).getAttribute("value");
	}

	/**
	 * This keyword clears the value of specified Edit box.
	 *
	 * @param xpath
	 */
	public void ClearEditField(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	/**
	 * This keyword clears the text from specified TextArea
	 *
	 * @param xpath
	 */
	public void ClearTextArea(WebElement xpath) {
		xpath.clear();
	}

	/**
	 * This keyword clicks on given button and waits for the specified Time. It
	 * takes Button object and time in seconds as input argument.
	 *
	 * @param xpath
	 * @param time
	 * @throws Exception
	 */
	public void ClickButtonAndWait(String xpath, long time) throws Exception {
		driver.findElement(By.xpath(xpath)).click();
		TimeUnit.SECONDS.sleep(time);
	}

	/**
	 * This keyword closes all the open browser sessions started by Selenium. It
	 * does not take any input argument.
	 *
	 * @return
	 */
	public boolean CloseAllBrowsers() {
		try {
			driver.quit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This keyword closes the currently opened browser session.
	 *
	 * @return
	 */
	public boolean CloseBrowser() {
		try {
			driver.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}




	/**
	 * This keyword maximizes the current browser.
	 *
	 * @return
	 */
	public boolean MaximizeBrowser() {
		try {
			driver.manage().window().maximize();
			return true;
		} catch (Exception e) {
			return false;
		}

	}


	public void SelectByValue() {

		Select select = new Select(driver.findElement(By.xpath("")));
		select.selectByIndex(1);
	}


	public boolean selectdropdown(List<WebElement> xpath, String value) {

		try {
			List<WebElement> elements = xpath;

			for (WebElement element : elements) {
				System.out.println(element.getText());
				if (element.getText().contains(value)) {
					//  System.out.println(element.getText());
					element.click();
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void getTableData(WebElement tableLoc,List<WebElement> headerLoc,List<WebElement> rowLoc, WebElement buttonNext, String addedList) {
		List<WebElement> allHeadersEle = headerLoc;
		List<String> allHeaderNames = new ArrayList<String>();
		for (WebElement header : allHeadersEle) {
			String headerName = header.getText();
			allHeaderNames.add(headerName);
		}

		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
		boolean flag = true;

		while (flag) {
			// Get total rows count
			List<WebElement> allRowsEle = rowLoc;
			for (int i = 1; i < allRowsEle.size(); i++) {
				// Getting specific row with each iteration
				WebElement specificRowLoc = rowLoc.get(i);
				// Locating only cells of specific row.
				List<WebElement> allColumnsEle = specificRowLoc
						.findElements(By.tagName("td"));
				// Creating a map to store key-value pair data. It will be created for each
				// iteration of row
				LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
				// Iterating each cell
				for (int j = 0; j < allColumnsEle.size(); j++) {
					// Getting cell value
					String cellValue = allColumnsEle.get(j).getText();
					// We will put in to map with header name and value with iteration
					// Get jth index value from allHeaderNames and jth cell value of row
					eachRowData.put(allHeaderNames.get(j), cellValue);
				}
				// After iterating row completely, add in to list.
				allTableData.add(eachRowData);

			}
			if ((buttonNext.getTagName().contains("span"))) {
				flag = false;
				break;
			} else {
				buttonNext.click();

			}
		}
		ExtentTestManager.getTest().log(Status.INFO,  addedList + "are added in the application"+"\n" + allTableData.toString());

	}
}