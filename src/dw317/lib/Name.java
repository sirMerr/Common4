/**
 * Defines a Name type.
 */
package dw317.lib;

import java.io.Serializable;

/**
 * This class creates a Name object holding two fields value:
 * 	firstName	The first name 
 * 	lastName	The last name
 * 
 * It holds the information to define a name
 * The class implement the serializable interface to persist the data even after runtime
 * 	
 * @author Andrew Azevedo, Tiffany Le-Nguyen, Hugo Pham & Sévan Topalian
 * @since JDK 1.8
 *
 */
public class Name implements Comparable<Name>, Serializable {
	private static final long serialVersionUID = 42031768871L;

	private String firstName = "";
	private String lastName = "";

	/**
	 * No parameter constructor
	 */
	public Name() {
	}

	/**
	 * Initializes a new instance of the Name class 2 parameters constructor
	 * 
	 * @param String first
	 * @param String last
	 */
	public Name(String first, String last) {
		firstName = first;
		lastName = last;
	}
	
	/**
	 * Compares two Name objects.
	 * The last names are compared first; if they are the same
	 * the first names are then compared. Uses compareToIgnoreCase.
	 * 
	 * @param Name name
	 * @return int
	 */
	public int compareTo(Name name) {
		//compare last name
		int returnValue = lastName.compareToIgnoreCase(name.getLastName());
		if(returnValue != 0)
			return returnValue;
		
		//compare firstName
		returnValue = firstName.compareToIgnoreCase(name.getFirstName());
		if(returnValue != 0)
			return returnValue;
		
		//the two name objects are equal
		return 0;
	}

	/**
	 * The equals() method compares two objects for equality and returns true if
	 * they are equal. Two names are considered equal if their first
	 * name and last name are equal. 
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		
		Name name = (Name) obj;
		if (firstName.equalsIgnoreCase(name.getFirstName()) && lastName.equalsIgnoreCase(name.getLastName()))
				return true;
		return false;
	}

	/**
	 * Get the first name of a person
	 * 
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get the full name of a person
	 * 
	 * @return String
	 */
	public String getFullName() {
		return (firstName + " " + lastName);
	}
	
	/**
	 * Get the last name of a person
	 * 
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Return the hashcode for the firstName and lastName instance fields
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		
		return firstName.toUpperCase().hashCode()
				+ lastName.toUpperCase().hashCode();
	}

	/**
	 * Sets the firstName instance field
	 * 
	 * @param String
	 *            firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Sets the lastName instance field
	 * 
	 * @param String
	 *            lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns a String representation of the Name Object
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return (firstName + "*" + lastName);
	}
	
	/**
	 * UNUSED
	 * This method validates the first names or last name variables
	 * 
	 * @throws IllegalArgumentException
	 * @param fieldValue
	 * @param fieldName
	 * @return String trimmedString
	 */
	
	/*
	private String validateName(String fieldValue, String fieldName) {
		if (fieldValue == null)
			throw new IllegalArgumentException("Name Error - " + fieldName
					+ " must exist. Invalid value = " + fieldValue);

		fieldValue = fieldValue.toLowerCase();
		String trimmedString = fieldValue.trim();

		if (trimmedString.trim().isEmpty())
			throw new IllegalArgumentException("Name Error - " + fieldName
					+ " must exist. Invalid value = " + fieldValue);

		// Check if first letter is a letter and changes it to upper case, if it
		// isn't, it throws an exception
		if (Character.isLetter(trimmedString.charAt(0))) {
			char firstLetter = Character.toUpperCase(trimmedString.charAt(0));
			trimmedString = firstLetter + trimmedString.substring(1);
		} else
			throw new IllegalArgumentException("Name Error - " + fieldName
					+ " must exist. Invalid value = " + fieldValue);

		int dashOccurences = 0;
		char letter;
		int length =trimmedString.length();

		for (int counter = 0; counter < length; counter++) {
			letter = trimmedString.charAt(counter);
			if (letter == 45)
				dashOccurences++;
			else {
				if (!Character.isLetter(letter))
					throw new IllegalArgumentException("Name Error - "
							+ fieldName + " must exist. Invalid value = "
							+ fieldValue);
			}

		}
		
		//Assumed that only 1 dash in a name and that name should not end with a dash either
		if (dashOccurences > 1 || trimmedString.charAt(length - 1) == 45)
			throw new IllegalArgumentException("Name Error - "
					+ fieldName + " must exist. Invalid value = "
					+ fieldValue);
			

		return trimmedString;
	}
	*/

}