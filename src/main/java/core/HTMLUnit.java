package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HTMLUnit {
	public static void main(String[] v) {
		if(v.length == 0) {
			System.err.println("No argumnets!");
			System.exit(1);
		}
		WebDriver driver = new FirefoxDriver();
		for (int i = 0; i < v.length; i++) {
			String test_case_id = "TC-001.0" + (i + 1);
			String param[] = v[i].split("\\|");
			String url = param[0];
			String title_expected = param[1];
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			System.out.println("");
			if(title_expected.equals(title_actual)) {
				System.out.println("Test Case ID:\t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			}else {
				System.out.println("Test Case ID:\t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAIL");
				
			}
		}
		driver.quit();
	} 


}

