package VTigerTestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.CrossBrowsing;
import com.crm.pom.OrganizationRepo;

import Utility.VtigerTestCases;

public class Organization extends CrossBrowsing{

	public static VtigerTestCases org_info;
	@Test
	public void main() throws EncryptedDocumentException, IOException, InterruptedException {
		
		org_info=new VtigerTestCases();
		String sheet_data = org_info.ReadData("Sheet1", 9, 2);
		String actual_url = driver.getCurrentUrl();
		
		OrganizationRepo or = new OrganizationRepo(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		assertEquals(expected_url, actual_url, "First Verification Success");
		
		or.organizationLink().click();
		or.addSymbol().click();
		String orgName = sheet_data + Math.random()+1000;
		or.accountName().sendKeys(orgName);
		or.saveButton().click();
		Thread.sleep(2000);
		String name_header = or.organizationHeaderVerification().getText();
		assertTrue(name_header.contains(orgName),"Last Verification Success");
		
	}
}
