package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BaseTest {
	@Test(priority = 0)
	public void HomePage_Image() throws Exception {
		Assert.assertTrue(homePage.checkHomePageImage(), "Verify Image on HomePage");

	}

	@Test(priority = 1) 
	public void FindAllVeterns() throws Exception {
		homePage.clickVetsMenu(); 
		homePage.getAllVeterns();

	}

	@Test(priority = 2)
	public void FindAllOwners() throws Exception {
		homePage.searchOwnersMenu();
		homePage.clickSubmit();
		homePage.getAllOwners();

	}

	@Test(priority=3)
	public void AddNewOwnerPet() throws Exception {
		homePage.clickAddOwner();
		homePage.fillOwnerDetails();
		homePage.fillPetDetails();

	}
	
	@Test(priority=4)
	public void VerifyNewOwnerPetDetails() throws Exception {
		homePage.searchOwnersMenu();
		homePage.searchByLastName();
		homePage.checkDetailsAdded();

	}

	
	
}
