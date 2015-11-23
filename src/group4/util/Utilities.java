package group4.util;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Utilities {

	private Utilities() {

	}

	public static void serializeObject(Object object, String fileSpecification)
			throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(
					new FileOutputStream(fileSpecification));
			out.writeObject(object);
		} catch (IOException e) {
			// normally the exception would be logged to file then thrown
			throw new IOException("Error serializing object to \n"
					+ fileSpecification + " " + e);
		} finally {
			if (out != null)
				out.close();
		}

	}

	public static Object deserializeObject(String fileSpecification)
			throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try {
			Object obj = null;
			in = new ObjectInputStream(new FileInputStream(fileSpecification));
			if (in != null)
				obj = in.readObject();
			return obj;
		} catch (ClassNotFoundException | IOException e) {
			// normally the exception would be logged to file then thrown
			throw new IOException("Error deserializing object from "
					+ fileSpecification + "\n" + e);
		} finally {
			if (in != null)
				in.close();
		}
	}
	/*
	 * Serializes objects to memory in order to create deep copies
	 * of the objects
	 */
	public static Object copyOf(Object anObject){
		return null;		
	}
}
