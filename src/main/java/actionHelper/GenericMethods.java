package actionHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class GenericMethods {

	private WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void writeOnEditText(String data, WebElement xpath) {
		xpath.sendKeys(data);
	}

	
	public boolean clickbutton(WebElement xpath) {
		xpath.click();
		return true;
	}

	

	public boolean compareString(String First, String Second) {
		if (First.equalsIgnoreCase(Second)) {
			return true;
		} else
			return false;

	}

	
	public boolean verifyObjectText(String Text, WebElement xpath) {

		return compareString(Text, xpath.getText());
	}


	public boolean VerifyObjectExists(WebElement xpath) {
		if (xpath.isDisplayed()) {
			return true;


		} else {
			return false;
		}
	}


	public void ClearEditField(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	
	public void ClearTextArea(WebElement xpath) {
		xpath.clear();
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

	public String getTableData(WebElement tableLoc,List<WebElement> headerLoc,List<WebElement> rowLoc, WebElement buttonNext, String addedList) {
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
		return allTableData.toString();
	}
	
	public String getCurrentTimeStamp() {
	       SimpleDateFormat formDate = new SimpleDateFormat("dd-MM-yyyy");
	       String strDate = formDate.format(new Date());
	       return strDate;
	  }
}