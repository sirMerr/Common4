/**
 * Defines a Person type.
 */
package dw317.lib;

import java.io.Serializable;

/**
 * Defines a Person type.
 * This class creates a Person object holding two fields
 *	name		Name object holding a first and last Name
 *	address  	address holding 5 fields(civic number, street name, 
 *								code, province & city)
 *
 *	Those two fields are considered to define a Person information:
 *		Name and where he/she/it lives
 *
 * @author Andrew Azevedo, Tiffany Le-Nguyen, Hugo Pham & Sévan Topalian
 * @since JDK 1.8
 *
 */
public class Person implements Serializable{
	private static final long  serialVersionUID = 42031768871L;
	private Name name;
	private Address address;

	/**
	 * Initializes a new instance of the Person class 2 parameters constructor
	 * 
	 * @param String	firstName
	 * @param String	lastName
	 */
	public Person(String firstName, String lastName) {
		name = new Name(firstName, lastName);
	}

	/**
	 * Initializes a new instance of the Person class 3 parameters constructor
	 * 
	 * @param String	firstName
	 * @param String	lastName
	 * @param Address	address
	 */
	public Person(String firstName, String lastName, Address address) {
		name = new Name(firstName, lastName);
		this.address = address;
	}

	/**
	 * Gets the address of a Person
	 * 
	 * @return Address
	 */
	public Address getAddress() {

		return new Address(address.getCivicNumber(), address.getStreetName(),
				address.getCity(), address.getProvince(), address.getCode());
	}

	/**
	 * Gets the name of a Person
	 * 
	 * @return Name
	 */
	public Name getName() {
		return new Name(name.getFirstName(), name.getLastName());
	}

	/**
	 * Sets the address of a Person
	 * 
	 * Assume that the address is not null 
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address.setCivicNumber(address.getCivicNumber());
		this.address.setStreetName(address.getStreetName());
		this.address.setCity(address.getCity());
	}
	
	/**
	 * Sets the firstName and the lastName instance fields in the Person class
	 * Assume that the firstName & lastname are not null
	 * 
	 * @param String	firstName
	 * @param String	lastName
	 */
	public void setName(String firstName, String lastName) {
		name.setFirstName(firstName);
		name.setLastName(lastName);
	}

	/**
	 * Returns a String representation of the Person class
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return name.toString() + "*"
				+ (address == null ? "" : address.toString());
	}

}