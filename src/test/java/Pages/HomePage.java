package Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.TestDataClass;


public class HomePage extends BasePageClass {
	TestDataClass testData = new TestDataClass();
	List<String> items1 = new ArrayList<>();
	List<String> items2 = new ArrayList<>();
	String generatedString = RandomStringUtils.randomAlphabetic(10);
	String generateNumber = RandomStringUtils.randomNumeric(10);
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement imageHome;

	@FindBy(xpath = "//span[normalize-space()='Veterinarians']")
	WebElement VetMenu;

	@FindBy(xpath = "//*[@id=\"vets\"]")
	WebElement VetTable;

	@FindBy(xpath = "//a[@title='find owners']")
	WebElement OwnerMenu;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement findOwnerButton;

	@FindBy(xpath = "//*[@id=\"owners\"]")
	WebElement OwnerTable;

	@FindBy(xpath = "//table[@id='owners']//tr//th")
	List<WebElement> OwnerTableHeader;
	
	@FindBy(xpath = "//table[@id='vets']//tr//th")
	List<WebElement> VetsTableHeader;

	@FindBy(xpath = "//table[@id='owners']//tbody//tr")
	List<WebElement> OwnerTableRow;

	@FindBy(xpath = "//table[@id='vets']//tbody//tr")
	List<WebElement> VetsTableRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']//tbody//td")
	List<WebElement> OwnerTableDetails;
	
	@FindBy(xpath = "//table[@class='table table-striped']//tbody//dd")
	List<WebElement> PetTableDetails;
	

	@FindBy(xpath = "//*[@title=\"Next\"]")
	WebElement buttonNext;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement buttonAdd;
	
	@FindBy(xpath = "//a[contains(text(),'Add')]")
	WebElement buttonAddNewPet;
	
	@FindBy(xpath = "//a[contains(text(),'Add Owner')]")
	WebElement buttonAddOwner;
	
	@FindBy(xpath = "//a[contains(text(),'Find Owner')]")
	WebElement buttonFindOwner;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonSubmit;
		
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement inputFirstName;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement inputLastName;
	
	@FindBy(xpath = "//input[@id='address']")
	WebElement inputAddress;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement inputCity;
	
	@FindBy(xpath = "//input[@id='telephone']")
	WebElement inputTelephone;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement inputPetName;
	
	@FindBy(xpath = "//input[@id='birthDate']")
	WebElement inputPetBD;
	
	@FindBy(xpath = "//select[@id='type']")
	List<WebElement> inputPetType;
	
	@FindBy(xpath = "//dt[normalize-space()='Name']")
	WebElement petDetailsContainer;
	
	
	public void fillOwnerDetails() {
		String firstName = generatedString + "FN";
	   	webActionHelperMethods.ClearTextArea(inputFirstName);
		webActionHelperMethods.writeOnEditText(firstName,inputFirstName);
		items1.add(firstName);
		
		String lastName = generatedString + "LN";
		webActionHelperMethods.ClearTextArea(inputLastName);
		webActionHelperMethods.writeOnEditText(lastName,inputLastName);
		items1.add(lastName);
		
		String ownerAddress = generatedString + "Add";
		webActionHelperMethods.ClearTextArea(inputAddress);
		webActionHelperMethods.writeOnEditText(ownerAddress,inputAddress);
		items1.add(ownerAddress);
		
		String ownerCity = generatedString + "City";
		webActionHelperMethods.ClearTextArea(inputCity);
		webActionHelperMethods.writeOnEditText(ownerCity,inputCity);
		items1.add(ownerCity);
		
		String ownerTel = generateNumber;
		webActionHelperMethods.ClearTextArea(inputTelephone);
		webActionHelperMethods.writeOnEditText(ownerTel,inputTelephone);
		items1.add(ownerTel);
		
		testData.setListOwner(items1);
		
		webActionHelperMethods.clickbutton(buttonSubmit);
		
		webActionHelperMethods.VerifyObjectExists(buttonAddNewPet);
		
	}
	
	public void fillPetDetails() {
		webActionHelperMethods.clickbutton(buttonAddNewPet);
		
		String petName = generatedString + "P";
		webActionHelperMethods.ClearTextArea(inputPetName);
		webActionHelperMethods.writeOnEditText("Test",inputPetName);
		items2.add(petName);
		
		String birthDate = "12-11-2021";
		webActionHelperMethods.ClearTextArea(inputPetBD);
		webActionHelperMethods.writeOnEditText(birthDate,inputPetBD);
		items2.add(birthDate);
		
		webActionHelperMethods.selectdropdown(inputPetType,"cat");
		items2.add("cat");
		
		testData.setListPet(items2);
		
		webActionHelperMethods.clickbutton(buttonSubmit);
		
		webActionHelperMethods.VerifyObjectExists(petDetailsContainer);
		
		
		
	}
	
	public void searchByLastName() {
		webActionHelperMethods.writeOnEditText(testData.getListOwner().get(1), inputLastName);
		webActionHelperMethods.clickbutton(buttonSubmit);
		
	}
	
	
	public void checkDetailsAdded() {
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(0), OwnerTableDetails.get(0));
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(1), OwnerTableDetails.get(1));
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(2), OwnerTableDetails.get(2));
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(3), OwnerTableDetails.get(3));
		
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(0), PetTableDetails.get(0));
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(1), PetTableDetails.get(1));
		webActionHelperMethods.verifyObjectText(testData.getListOwner().get(2), PetTableDetails.get(2));
		
	}
	

	public boolean checkHomePageImage() {
		return webActionHelperMethods.VerifyObjectExists(imageHome);

	}

	public void clickVetsMenu() {
		webActionHelperMethods.clickbutton(VetMenu);
	}
	public void searchOwnersMenu() {
		webActionHelperMethods.clickbutton(OwnerMenu);
		

	}
	public void clickSubmit() {
		webActionHelperMethods.clickbutton(buttonSubmit);
	}
	public void clickAddOwner() {
		webActionHelperMethods.clickbutton(OwnerMenu);
		webActionHelperMethods.clickbutton(buttonAddOwner);
	}
	public void getAllOwners() {
		webActionHelperMethods.getTableData(OwnerTable,OwnerTableHeader,OwnerTableRow,buttonNext, "Owner List::");
	}
	public void getAllVeterns() {
		webActionHelperMethods.getTableData(VetTable,VetsTableHeader,VetsTableRow,buttonNext, "Vets List::");
	}

}
