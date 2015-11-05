/**
 * Defines an Address type.
 */

package dw317.lib;

import java.io.Serializable;
import java.util.Optional;
/**

 * 
 * This class creates a class object holding five different fields:
 *  city 		the name of the city
 *  province	the province where is located the city
 *  code		Zip code, postal code
 *  streetName name of the street
 *  civicNumber civic number of the dwelling
 *   
 *  It holds all the information to locate the dwelling of a Person
 * 	@author Andrew Azevedo, Tiffany Le-Nguyen, Hugo Pham & Sévan Topalian
 *	@since JDK 1.8
 */
public class Address implements Serializable {
	private static final long  serialVersionUID = 42031768871L;
	private String city = "";
	private String civicNumber = "";
	private String province = "";
	private String code = "";
	private String streetName = "";

	/**
	 * No parameter constructor
	 */
	public Address() {
	}

	/**
	 * Initializes a new instance of the Address class 3 parameters constructor
	 * 
	 * @param String
	 *            civicNumber
	 * @param String
	 *            streetName
	 * @param String
	 *            city
	 */

	public Address(String civicNumber, String streetName, String city) {
		this.civicNumber = validateExistence("civic number", civicNumber);
		this.streetName = validateExistence("street name", streetName);
		this.city = validateExistence("city", city);
	}

	public Address(String civicNumber, String streetName, String city,
			String province, String code) {
		this.civicNumber = validateExistence("civic number", civicNumber);
		this.streetName = validateExistence("street name", streetName);
		this.city = validateExistence("city", city);
		this.province = validateExistence("province", province);
		this.code = validateExistence("code", code);
	}
	
	public Address(String civicNumber, String streetName, String city, 
			Optional<String> province, Optional<String> code) {		
		this.civicNumber = validateExistence("civic number", civicNumber);
		this.streetName = validateExistence("street name", streetName);
		this.city = validateExistence("city", city);
		this.province = validateExistence("province", province.get());
		this.code = validateExistence("code", code.get());
		
	}


	/**
	 * Returns address detail
	 * 
	 * @return String address
	 */
	public String getAddress() {
		String address = civicNumber + " " + streetName + "\n" + city;
		address += (province.equals("") ? "" : (", " + province))
				+ (code.equals("") ? "" : ("\n" + code));
		return address;
	}

	/**
	 * Returns the city name
	 * 
	 * @return String city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Returns civic number
	 * 
	 * @return String civicNumber
	 */
	public String getCivicNumber() {
		return civicNumber;
	}

	/**
	 * Returns the province name
	 * 
	 * @return String province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Returns the area code
	 * 
	 * @return String code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Returns the street name
	 * 
	 * @return String streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the city instance field
	 * 
	 * @param String
	 *            city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Sets the civicNumber instance field
	 * 
	 * @param String
	 *            civicNumber
	 */
	public void setCivicNumber(String civicNumber) {
		this.civicNumber = civicNumber;
	}

	/**
	 * Sets the province instance field
	 * 
	 * @param String
	 *            province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Sets the area code instance variable
	 * 
	 * @param String
	 *            code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Sets the streetName instance variable
	 * 
	 * @param String
	 *            streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Validates that the field value given exists
	 * 
	 * @param String
	 *            fieldName
	 * @param String
	 *            fieldValue
	 * @return String trimmedString
	 */
	private String validateExistence(String fieldName, String province) {
		/*
		if (province == null)
			throw new IllegalArgumentException("Address Error - " + fieldName
					+ " must exist. Invalid value = " + province);
		*/

		/*if (trimmedString.isEmpty())
			throw new IllegalArgumentException("Address Error - " + fieldName
					+ " must exist. Invalid value = " + province);
		*/
		return province.trim();
	}

	/**
	 * This returns a string representation of the object
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return (civicNumber + "*" + streetName + "*" + city + "*" + province
				+ "*" + code);
	}
}
