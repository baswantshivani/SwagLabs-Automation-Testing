package SwagLabsTestCases;

import org.testng.annotations.DataProvider;

public class TestData {

	 @DataProvider(name="loginData")
	    public Object[][] getData()
	    {
	        return new Object[][] {
	            {"standard_user", "secret_sauce"},
	            {"problem_user", "secret_sauce"}
	        };
	    }
}
//can use dataProvider also instead of loop