package dw317.lib;

import static java.lang.System.out;

public class AddressTest {

	public static void main(String[] args) {
		testTheThreeParameterConstructor();
		testGetCity();
		testSetCity();
		testGetCivicNumber();
		testSetCivicNumber();
		/*testGetProvince();
		testSetProvince();
		testGetCode();
		testSetCode();
		testGetStreetName();
		testSetStreetName();
		*/
	}

	public static void testTheThreeParameterConstructor() {
		out.println("\nTesting the three parameter constructor.");
		testTheThreeParameterConstructor(
				"Case 8 - Invalid data – null civicNumber (null Sherbrooke Westmount)",
						null,"Sherbrooke","Westmount",false);
	}
	
	public static void testGetCity()
	{
		out.println("\nTesting the getCity method.");
		testGetCity("Case 1: same city name",
				"Westmount","Westmount");
		testGetCity("Case 2: not same city name",
				"Montreal","Westmount");
	}
	
	public static void testGetCity( String testCase, 
			String city, String expectedCity)
	{
		out.println("   " + testCase);
		Address theAddress = 
				new Address ("3040", "Sherbrooke",city);
		out.print("\tThe Address instance was created: " + theAddress);

		if (!theAddress.getCity().equals(expectedCity))
			out.print("  Error! Expected Invalid. ==== FAILED TEST ====");

		out.println("\n");
	}
	public static void testSetCity()
	{
		
	}
	
	public static void testSetCity(String testCase, 
			String civicNumber, String expectedCivicNumber,boolean expectValid)
	{
		
	}
	
	public static void testGetCivicNumber()
	{
		out.println("\nTesting the getCivicNumber method.");
		testGetCivicNumber("Case 1: 3040 without leading/trailing spaces",
				"3040","3040");
		testGetCivicNumber("Case 2: 3040 with leading/trailing spaces",
				"    3040    ","3040");
	}
	
	private static void testGetCivicNumber(String testCase, 
			String civicNumber, String expectedCivicNumber)
	{
		out.println("   " + testCase);
		Address theAddress = 
				new Address (civicNumber, "Sherbrooke","Westmount");
		out.print("\tThe Address instance was created: " + theAddress);

		if (!theAddress.getCivicNumber().equals(expectedCivicNumber))
			out.print("  Error! Expected Invalid. ==== FAILED TEST ====");

		out.println("\n");
	}
	
	public static void testSetCivicNumber() {
		out.println("\nTesting the setCivicNumber method.");
		testSetCivicNumber("Case 1: Valid - 2086 without leading/trailing spaces",
				"2086","2086",true);
		testSetCivicNumber("Case 2: Invalid null civic number",
				"2065","2065",true);
	}
	
	private static void testSetCivicNumber(String testCase, 
			String civicNumber, String expectedCivicNumber,boolean expectValid){
		out.println("   " + testCase);
		Address theAddress = 
				new Address ("3040", "Sherbrooke","Westmount");
		try {
			theAddress.setCivicNumber(civicNumber);
			out.print("\tThe Address instance was created: " + theAddress);
			
			if (!theAddress.getCivicNumber().equals(expectedCivicNumber))
				out.print("  Error! Expected Invalid. ==== FAILED TEST ====");
		}
		catch (IllegalArgumentException iae) {
			out.print("\t"+ iae.getMessage());
			if (expectValid)
				out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		}
		catch (Exception e) {
			out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " " +
					e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				out.print(" Expected Valid.");
		}

		out.println("\n");
	}


	private static void testTheThreeParameterConstructor(String testCase,
			String civicNumber, String streetName, String city,
			boolean expectValid) {

		out.println("   " + testCase);

		try {
			Address theAddress = new Address(civicNumber, streetName, city);
			out.print("\tThe Address instance was created: " + theAddress);

			if (!expectValid)
				out.print("  Error! Expected Invalid. ==== FAILED TEST ====");
		} catch (IllegalArgumentException iae) {
			out.print("\t" + iae.getMessage());
			if (expectValid)
				out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		} catch (Exception e) {
			out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " "
					+ e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				out.print(" Expected Valid.");
		}

		out.println("\n");
	}
	
	
}
