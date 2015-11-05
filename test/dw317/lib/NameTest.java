/**
 * 
 */
package dw317.lib;
import dw317.lib.Name;
import static java.lang.System.out;

/**
 * @author 1337762
 *
 */
public class NameTest {

	/**
	 * @param Frank Birikundavyi, Hugo Pham & Brandon Balala
	 * 
	 * @since JDK 8.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			out.println("Test case1 : \n\tNo parameters constructors");
		Name name1 = new Name();
		out.println(name1);
		}
		catch(IllegalArgumentException iae)
		{
			out.println("---RESULT NOT EXPECTED--- Problem: Error detected IN CASE 1");
		}
		
		try{
			out.println("Test case2 : \n\tTwo parameters constructors \n\t First name: null"
					+ "\n\tLast Name: null");
		Name name2 = new Name(null, null);
		out.println(name2);
		}catch(IllegalArgumentException iae)
		{
			out.println("ERROR DETECTED ---NULL IS NOT ACCEPTED AS INPUT---");
		}
		
		try{
			out.println("Test case3 : \n\tTwo parameters constructors \n\t First name: \"Frank\""
					+ "\n\tLast Name: \"Birikundavyi\"");
		Name name3 = new Name("Frank", "Birikundavyi");
		out.println(name3);
		}catch(IllegalArgumentException iae){
			out.println("---RESULT NOT EXPECTED--- Problem: Error detected IN CASE 3");
		}
		
		try{
			out.println("Test case4 : \n\tTwo parameters constructors \n\t First name: \"  Brandon  \""
					+ "\n\tLast Name: \"     Balala  \"");
		Name name4 = new Name("  Brandon  ", "     Balala  ");
		out.println(name4);
		}catch(IllegalArgumentException iae){
			out.println("---RESULT NOT EXPECTED--- Problem: Error detected IN CASE 4");
		}
		
		try{
			out.println("Test case5 : \n\tTwo parameters constructors \n\t First name: \"Hugo-Xavier\""
				+ "\n\tLast Name: \"Pham-hubert\"");
		Name name5 = new Name("Hugo-Xavier","Pham-hubert");
		out.println(name5);
		}catch(IllegalArgumentException iae){
			out.println("---RESULT NOT EXPECTED--- Problem: Error detected IN CASE 5");
		}
		
		try{
			out.println("Test case6 : \n\tTwo parameters constructors \n\t First name: \"Cato\""
				+ "\n\tLast Name: \"4tin\"");
		Name name6 = new Name("Cato", "4tin");
		out.println(name6);
		}catch(IllegalArgumentException iae){
			out.println("ERROR DETECTED ---DIGITS ARE NOT ACCEPTED AS INPUT---");
		}
		try{
			out.println("Test case7 : \n\tTwo parameters constructors \n\t First name: \"Frank-Brandon-Hugo\""
				+ "\n\tLast Name: \"teamSeven\"");
		Name name7 = new Name("Frank-Brandon-Hugo", "teamSeven");
		out.println(name7);
		}catch(IllegalArgumentException iae){
			out.println("ERROR DETECTED ---LIMIT OF ONE DASH BY NAME---");
		}
		try{
			out.println("Test case8 : \n\tTwo parameters constructors \n\t First name: \"-hubert\""
				+ "\n\tLast Name: \"-Dawson\"");
		Name name8 = new Name("-hubert", "-Dawson");
		out.println(name8);
		}catch(IllegalArgumentException iae){
			out.println("ERROR DETECTED ---CANNOT START WITH A DASH---");
		}
		try{
			out.println("Test case9 : \n\tTwo parameters constructors \n\t First name: \"hubert-\""
				+ "\n\tLast Name: \"Dawson-\"");
		Name name9 = new Name("hubert-", "Dawson-");
		out.println(name9);
		}catch(IllegalArgumentException iae){
			out.println("ERROR DETECTED ---CANNOT FINISH WITH A DASH---");
		}
		
	}

}
