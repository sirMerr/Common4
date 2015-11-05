package group4.util;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/***
 * Class ListUtilities will merely contain static utility methods, and has a
 * do-nothing private constructor to prevent the class from being instantiated.
 * 
 * @author Sevan Topalian, Tiffany Le-Nguyen, Hugo Pham, Andrew Azevedo
 * @since JDK 1.7
 *
 */
public class ListUtilities implements Serializable {

	private static final long serialVersionUID = 42031768871L;

	// This constant will be used as our default character encoding scheme.
	private static final Charset CHARACTER_ENCODING = StandardCharsets.UTF_8;

	/**
	 * No parameter constructor
	 * */

	private ListUtilities() {
	}

	/**
	 * This method is used to search for the position of the element you are
	 * looking for in the provided Comparable array
	 * 
	 * Precondition: The array has to be full to capacity & can't be null.
	 * searchKey and list should be of the same type.
	 * 
	 * @param list
	 *            A list in which you are looking for the searchKey. Full to
	 *            capacity and is not null. List has to be sorted.
	 * 
	 * @param searchKey
	 *            The element you are searching for in the list
	 * 
	 * @return int The position where the value is found. If value is negative,
	 *         value is not found and it shows the position it should be in
	 *         minus one.
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int binarySearch(Comparable[] list, Comparable searchKey) {
		int low = 0;
		int high = list.length - 1;
		int mid;
		int value;

		mid = (low + high) / 2;

		while (low <= high) {
			value = list[mid].compareTo(searchKey);

			if (value == 0)
				return mid;

			if (value > 0)
				high = mid - 1;
			else
				low = mid + 1;

			mid = (low + high) / 2;
		}

		// If not found
		return -(low + 1);
	}

	/**
	 * 
	 * @param list
	 * @param searchKey
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int binarySearch(List<Comparable> list, Comparable searchKey) {
		int low = 0;
		int high = list.size() - 1;
		int mid;
		int value;

		mid = (low + high) / 2;

		while (low <= high) {
			value = list.get(mid).compareTo(searchKey);

			if (value == 0)
				return mid;

			if (value > 0)
				high = mid - 1;
			else
				low = mid + 1;

			mid = (low + high) / 2;
		}

		// If not found
		return -(low + 1);
	}

	/**
	 * Merge a list of objects in ascending natural order. It must return a
	 * reference to a list object whose capacity is equal to its size. Its
	 * responsibility is to merge two sorted list objects (in sorted order)
	 * referenced by list1 and list2 into a third list object (created in the
	 * merge method). RAMQ must be unique in the merged list of Patients; the
	 * RAMQ/registration time must be unique in the merged list of Visits.
	 * 
	 * Precondition: Assumes that the list is not null and that the list's
	 * capacity is equal to the list's size and already sorted.
	 * 
	 * 
	 * @param list1
	 *            A list of objects. Assumes that the list's capacity is equal
	 *            to the list's size and already sorted.
	 * 
	 * @param list2
	 *            A list of objects. Assumes that the list's capacity is equal
	 *            to the list's size and already sorted.
	 * 
	 * @param duplicateFileName
	 *            of the duplicate filename. All the elements that are
	 *            duplicate. Assume that the name is not null or empty.
	 * 
	 * @throws IOException
	 *             if duplicate filename doesn't exist.
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Comparable[] merge(Comparable[] list1, Comparable[] list2,
			String duplicateFileName) throws IOException {

		File duplicateFile = new File(duplicateFileName);

		if (!(duplicateFile.exists())) {
			int hyphen = duplicateFileName.lastIndexOf('\\');
			String directory = duplicateFileName.substring(0, hyphen);
			new File(directory).mkdirs();
			duplicateFile.createNewFile();
		}

		int lenList1 = list1.length;
		int lenList2 = list2.length;
		String[] duplicateList = new String[lenList1 + lenList2];
		int duplicateListCntr = 0;

		Comparable[] mergedList = (Comparable[]) Array.newInstance(list1
				.getClass().getComponentType(), lenList1 + lenList2);

		int mergeCntr = 0;
		int cntrList1 = 0;
		int cntrList2 = 0;
		int compareResults;

		while ((cntrList1 < lenList1) && (cntrList2 < lenList2)) {
			compareResults = list1[cntrList1].compareTo(list2[cntrList2]);

			if (compareResults < 0) {
				mergedList[mergeCntr] = list1[cntrList1];
				cntrList1++;
			} else if (compareResults > 0) {
				mergedList[mergeCntr] = list2[cntrList2];
				cntrList2++;
			} else {

				mergedList[mergeCntr] = list1[cntrList1];

				duplicateList[duplicateListCntr] = list1[cntrList1].toString()
						+ "(merged)";
				duplicateListCntr++;
				duplicateList[duplicateListCntr] = list2[cntrList2].toString();
				duplicateListCntr++;

				cntrList1++;
				cntrList2++;
			}

			mergeCntr++;
		}

		while (cntrList1 < lenList1) {
			mergedList[mergeCntr] = list1[cntrList1];
			cntrList1++;
			mergeCntr++;
		}

		while (cntrList2 < lenList2) {
			mergedList[mergeCntr] = list2[cntrList2];
			cntrList2++;
			mergeCntr++;
		}

		if (mergedList.length > mergeCntr)
			mergedList = Arrays.copyOf(mergedList, mergeCntr);

		if (duplicateListCntr != 0) {
			duplicateList = Arrays.copyOf(duplicateList, duplicateListCntr);
			saveListToTextFile(duplicateList, duplicateFileName, true);
		}

		return mergedList;
	}

	/**
	 * Saves a list into a .txt file
	 * 
	 * Precondition: Assumes that the object and fileName are not null.
	 * 
	 * 
	 * @param objects
	 *            - the object that will be save in a text file. Assume that the
	 *            object is not null
	 * @param filename
	 *            - the path to the file. Assume that the file exist.
	 * @param append
	 *            - if the data will in the file will be override or append
	 * @param characterEncoding
	 *            - type of encoding
	 * @throws FileNotFoundException
	 *             if file does not exist
	 * 
	 * @throws UnsupportedEncodingException
	 *             if the encoding is not supported
	 */
	public static void saveListToTextFile(Object[] objects, String filename,
			boolean append, Charset characterEncoding)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter outputFile = null;

		File fileName = new File(filename);

		if (!(fileName.exists())) {
			int hyphen = filename.lastIndexOf('/');
			String directory = filename.substring(0, hyphen);
			new File(directory).mkdirs();

			try {
				fileName.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			FileOutputStream f = new FileOutputStream(filename, append);
			OutputStreamWriter out = new OutputStreamWriter(f,
					characterEncoding);
			// decorators
			outputFile = new PrintWriter(new BufferedWriter(out));

			// transfer data to file
			for (Object obj : objects)
				if (obj != null)
					outputFile.println(obj);
		} catch (FileNotFoundException e) {
			// e.g. the directory doesn't exist
			// catch to give a better exception message
			throw new FileNotFoundException(
					"Error saving list! Unable to access the device "
							+ filename);
			// won't catch the two other exceptions since their default
			// exception message is fine
		} finally {
			if (outputFile != null) // successfully opened
				outputFile.close(); // flushes buffer and releases resources
		}

	}

	/**
	 * One of the overloaded methods provided as a convenience to client classes
	 * that want to send in two, three or four arguments when invoking a
	 * saveToTextFile method in order to save their object arrays to a
	 * sequential text file. Also note, that since the first parameter is
	 * Object[ ], and that arrays are covariant, you can send in arrays that are
	 * referencing any type of objects since the only functionality that is
	 * expected of the objects in the saveListToTextFile methods is that they
	 * provide a toString method.
	 * 
	 * @param objects
	 * @param filename
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void saveListToTextFile(Object[] objects, String filename)
			throws FileNotFoundException, UnsupportedEncodingException {
		saveListToTextFile(objects, filename, false, CHARACTER_ENCODING);
	}

	/**
	 * @param objects
	 * @param filename
	 * @param append
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void saveListToTextFile(Object[] objects, String filename,
			boolean append) throws FileNotFoundException,
			UnsupportedEncodingException {
		saveListToTextFile(objects, filename, append, CHARACTER_ENCODING);
	}

	/**
	 * Saves a list into a text file. Takes in a List type object.
	 * 
	 * Precondition: Assumes that the object and fileName are not null.
	 * 
	 * @param objects
	 *            the object that will be save in a text file. Assume that the
	 *            object is not null
	 * @param filename
	 *            the path to the file. Assumes that the file exist.
	 * @param append
	 *            if the data will in the file will be override or append
	 * @param characterEncoding
	 *            type of encoding
	 * @throws FileNotFoundException
	 *             if file does not exist
	 * 
	 * @throws UnsupportedEncodingException
	 *             if the encoding is not supported
	 */
	public static <T> void saveListToTextFile(List<T> objects, String filename,
			boolean append, Charset characterEncoding)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter outputFile = null;

		File fileName = new File(filename);

		if (!(fileName.exists())) {
			int hyphen = filename.lastIndexOf('/');
			String directory = filename.substring(0, hyphen);
			new File(directory).mkdirs();

			try {
				fileName.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			FileOutputStream f = new FileOutputStream(filename, append);
			OutputStreamWriter out = new OutputStreamWriter(f,
					characterEncoding);
			outputFile = new PrintWriter(new BufferedWriter(out));

			for (Object obj : objects)
				if (obj != null)
					outputFile.println(obj);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(
					"Error saving list! Unable to access the device "
							+ filename);
		} finally {
			if (outputFile != null)
				outputFile.close();
		}

	}

	/**
	 * Using list. Doesn't append the list to the text file (overwrite) by
	 * default.
	 * 
	 * @param objects
	 *            The list to be saved
	 * @param filename
	 *            The name of the text file
	 * @throws FileNotFoundException
	 *             if file does not exist
	 * @throws UnsupportedEncodingException
	 *             if encoding is not supported
	 */
	public static <T> void saveListToTextFile(List<T> objects, String filename)
			throws FileNotFoundException, UnsupportedEncodingException {
		saveListToTextFile(objects, filename, false, CHARACTER_ENCODING);
	}

	/**
	 * 
	 * @param objects
	 * @param filename
	 * @param append
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static <T> void saveListToTextFile(List<T> objects, String filename,
			boolean append) throws FileNotFoundException,
			UnsupportedEncodingException {
		saveListToTextFile(objects, filename, append, CHARACTER_ENCODING);
	}

	/**
	 * Sorts a list of objects in ascending natural order.
	 * 
	 * Precondition: Assumes that the list is not null and that the list's
	 * capacity is equal to the list's size.
	 * 
	 * 
	 * @param list
	 *            A list of objects. Assumes that the list's capacity is equal
	 *            to the list's size.
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameter is * equal to null.
	 * 
	 * @throws NullPointerException
	 *             if the list is not full to * capacity.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] list) {
		if (list == null || list.length == 0)
			return;
		int len = list.length;
		int lenMinusOne = len - 1;
		int cntr1, cntr2;
		int tempSmallest;
		Comparable temp;

		for (cntr1 = 0; cntr1 < lenMinusOne; cntr1++) {
			tempSmallest = cntr1;

			for (cntr2 = cntr1 + 1; cntr2 < len; cntr2++) {
				if (list[tempSmallest].compareTo(list[cntr2]) > 0)
					tempSmallest = cntr2;
			}

			temp = list[cntr1];
			list[cntr1] = list[tempSmallest];
			list[tempSmallest] = temp;
		}
	}

	/**
	 * Sorts a list of objects in the given order.
	 * 
	 * Precondition: Assumes that the list is not null and that the list's
	 * capacity is equal to the list's size.
	 * 
	 *
	 * @param list
	 *            A list of objects. Assumes that the list's capacity is equal
	 *            to the list's size.
	 * @param sortOrder
	 *            A Comparator object that defines the sort order
	 *
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameter is not full to capacity.
	 *
	 * @throws NullPointerException
	 *             if the list or sortOrder are null.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] list, Comparator sortOrder)
			throws IllegalArgumentException, NullPointerException {
		if (list == null || sortOrder == null)
			throw new IllegalArgumentException("List or sortOrder are null.");
		int cntr = 0;
		while (cntr < list.length) {
			if (list[cntr] == null)
				throw new NullPointerException("Element " + cntr
						+ " of the list is null. List is not full to capacity.");

			cntr++;
		}
		java.util.Arrays.sort(list, sortOrder);
	}

}
