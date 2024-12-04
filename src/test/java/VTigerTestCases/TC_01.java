package VTigerTestCases;

import org.testng.annotations.Test;

import com.crm.BaseClass.CrossBrowsing;
import com.crm.pom.CalendarRepo;
import com.crm.pom.HomePageElemenets;

public class TC_01 extends CrossBrowsing{

//	public static CalendarRepo cr;
	@Test
	public void main() {
//		cr = new CalendarRepo(driver);
//		cr.calendarTab().click();
		
		HomePageElemenets hp = new HomePageElemenets(driver);
		hp.calendarLink();
	}
}
