package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

	@DataProvider(name = "Signin")
	public Object[][] dataSetSignin() {
		return new Object[][] { { "qa", "123" } };
	}

}
