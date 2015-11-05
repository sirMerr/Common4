package group4.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import group4.util.ListUtilities;


public class ListUtilitiesTest {

	public static void main(String[] args) {


		String [] appointmentList1 = {"SMIM85122501","Mike","Smith","5143634564","DIN","02239497","Absorbine Jr","Athlete’s foot"};
		String [] appointmentList2 = {"SMIM85122501","Martha","Smits","5145554444","DIN","02229419","LIPBALM","Dry lips"};
		@SuppressWarnings("rawtypes")
		Comparable[] appointmentMergedList = null;
		

		//Test Merge
		try {
			appointmentMergedList = ListUtilities.merge(appointmentList1, appointmentList2, 
					"testFileResult/duplicates.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n\nMERGED LIST 1 AND LIST 2\n");
		for(int i = 0; i < appointmentMergedList.length; i++)
			System.out.println(appointmentMergedList[i].toString());


		//test binarySearch method
		System.out.println("Test 1: Binary Search: \n");
		String[] test1 = { "a",
				"b",
				"c",
				"d",
				"f",
				"h",
				"t",
				"x",
				"z"
		};
		String searchKey = "t";
		int goodAnswer = 6;
		testBinarySearch(test1, searchKey, goodAnswer);

		String searchKey2 = "w";
		int goodAnswer2 = -8;
		testBinarySearch(test1, searchKey2, goodAnswer2);

		String searchKey3 = "e";
		int goodAnswer3 = -5;
		testBinarySearch(test1, searchKey3, goodAnswer3);	

		//test merging with no duplicates	
		String case2 = "Test 2: Two sorted lists with no duplicate  \n";
		String[] list1 = {
				"2014*11*07*10*00*",
				"2014*11*07*11*00*",
		"2014*11*15*11*00*"};
		String[] list2 ={
				"2014*11*01*08*00*",
				"2014*11*08*09*30*",
				"2014*12*09*14*30*",
		"2014*12*12*16*30*"};
		String duplicatefilePath = "testFileResult/appointment1.txt";
		Boolean append = true;
		testMerge(case2, list1, list2, duplicatefilePath, append);//no duplicates so empty txt file

		//test merging with duplicates
		String case3 = "Test 3: Two sorted lists with some duplicates  \n";
		String[] list3 = {
				"2014*11*07*10*00*",
				"2014*11*07*11*00*",
		"2014*11*15*11*00*"};
		String[] list4 ={
				"2014*11*01*08*00*",
				"2014*11*07*11*00*",
				"2014*11*08*09*30*",
				"2014*11*15*11*00*",
				"2014*12*09*14*30*",
		"2014*12*12*16*30*"};
		duplicatefilePath = "testFileResult/appointment2.txt";//duplicates, will be written to this txt file
		append = true;
		testMerge(case3, list3, list4, duplicatefilePath, append);//merge and writes to txt file

		//test sort method
		String case4 = "Test 1: Sort two lists  \n";
		String[] sort1 = { "z",
				"y",
				"w",
				"t",
				"c",
				"p",
				"q",
				"q",
				"a"		
		};

		String[] expectedSort1 = { "a",
				"c",
				"p",
				"q",
				"q",
				"t",
				"w",
				"y",
				"z"	
		};
		testSort(case4,sort1,expectedSort1);

		//saveListToTextFile test
		try {
			ListUtilities.saveListToTextFile(sort1, "testFileResult/sortedLists");
			ListUtilities.saveListToTextFile(expectedSort1, "testFileResult/sortedLists", true);
			ListUtilities.saveListToTextFile(list1, "testFileResult/sortedLists2", true);
			ListUtilities.saveListToTextFile(list2, "testFileResult/sortedLists2", false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private static void testBinarySearch(String[] test1, String searchKey,
			int goodAnswer) {

		int result = ListUtilities.binarySearch(test1,searchKey);
		int len = test1.length;

		if(result != goodAnswer)
		{
			System.out.println("BinarySearch didn't work. List searched: ");
			for(int ctr = 0; ctr < len; ctr++)
				System.out.println(test1[ctr]);
			System.out.println("\nSearch key: "
					+ searchKey
					+ ". Good answer: " 
					+ goodAnswer 
					+ ". Result: " 
					+ result + "\n");
		}else
			System.out.println("BinarySearch worked. List searched: ");
		
		for(int ctr = 0; ctr < len; ctr++)
			System.out.println(test1[ctr]);
		System.out.println("\nSearch key: "
				+ searchKey
				+ ". Good answer: " 
				+ goodAnswer 
				+ ". Result: " 
				+ result + "\n");
	}

	@SuppressWarnings({ "rawtypes" })
	public static void testMerge(String testCase, Comparable[] list1, Comparable[] list2, String filePath, Boolean valid)
	{
		try{
			Comparable[] result;
			System.out.println(testCase);
			result = ListUtilities.merge(list1,list2,filePath);
			int len = result.length;
			for(int ctr = 0; ctr < len; ctr++)
				System.out.println(result[ctr]);

			if(valid)
				System.out.println("*********Expected result above********\n");
			else
				System.out.println("NOT EXPECTED RESULT: NO EXCEPTION THROWN\n");
		}

		catch(IOException ioe)
		{
			if(valid)
			{
				System.out.println("EXCEPTION THROWN: NOT EXPECTED RESULT\n");
				ioe.printStackTrace();
			}
			else
				System.out.println("*********Expected result above*********\n");
		}
	}

	private static void testSort(String testCase, String[] sortList, String[] expectedSortList) {
		System.out.println(testCase);

		ListUtilities.sort(sortList);
		int len = sortList.length;

		for(int cntr = 0; cntr < len ; cntr++) {
			System.out.println("sortedList: " + sortList[cntr]);
			System.out.println("expectedSortList: " + expectedSortList[cntr] + "\n");
			if(sortList[cntr] != expectedSortList[cntr])
				System.out.println("Sorting didn't work. \n");
		}

		System.out.println("Sorting worked. \n");

	}


}
