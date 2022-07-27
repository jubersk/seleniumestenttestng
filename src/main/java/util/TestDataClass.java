package util;

import java.util.*;

public class TestDataClass {
	private List<String> ownerDetails; 
	private List<String> petDetails; 

	public void setListOwner(List<String> list) { 
		this.ownerDetails = new ArrayList<String>(list); 
	} 

	public List<String> getListOwner() { 
		return new ArrayList<String>(this.ownerDetails); 
	} 

	public void setListPet(List<String> list) { 
		this.petDetails = new ArrayList<String>(list); 
	} 

	public List<String> getListPet() { 
		return new ArrayList<String>(this.petDetails); 
	} 

}
