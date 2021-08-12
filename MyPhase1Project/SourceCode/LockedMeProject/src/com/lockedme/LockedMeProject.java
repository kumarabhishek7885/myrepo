package com.lockedme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeProject 
{
	//private static Scanner scan = new Scanner(System.in);
	static final String folderpath="F:\\MyPhase1Project\\LockedMeFiles";
	
	public static void main(String[] args) 
	{
		int goahead=1;
		
		do {
				//Variable declaration
				Scanner obj = new Scanner(System.in);
				int ch;
				
				//Menu
				displayMenu();
				System.out.println("Enter your Choice:");
				ch = Integer.parseInt(obj.nextLine());
			
		//switch case
		switch(ch)
		{
				case 1:	getAllFiles();
						break;
						
				case 2: createFiles();
						break;
						
				case 3:	deleteFile();
						break;
						
				case 4:	searchFile();
						break;
						
				case 5: System.exit(0);
				
				default:System.out.println("Invalid Option");
						break;
		}
		
		}while(goahead>0);
	}
		
	public static void displayMenu()
	{
		System.out.println("___________________________________________________");				
		System.out.println("\t\tLockedMe.com");
		System.out.println("___________________________________________________");
		System.out.println("1. Display All Files");
		System.out.println("2. Add New Files");
		System.out.println("3. Delete a File");
		System.out.println("4. Search a File");
		System.out.println("5. Exit");
		System.out.println("___________________________________________________");
	}
	
	/**
	 * This method will retrieve files
	 */
	public static void getAllFiles()
	{
	//getting the file names
	List<String> fileNames = FileManager.getAllFiles(folderpath);
	
	if(fileNames.size()==0)
		System.out.println("No Files in the Directory");
	else
	{
		System.out.println("FILES LIST IS BELOW:");
		for(String f:fileNames)
			System.out.println(f);
	}
	}
	
	/**
	 * this method will Create files
	 */
	public static void createFiles()
	{			
				//Variables declaration
				Scanner obj = new Scanner(System.in);
				String fileName;
				int linesCount;
				List<String> content = new ArrayList<String>();
						
				//reading file name from user
				System.out.println("Enter file Name:");
				fileName=obj.nextLine();
				
				//Reading number of lines from user
				System.out.println("Enter How Many lines in the file:");
				linesCount = Integer.parseInt(obj.nextLine());
				
				//Reading lines from user
				for(int i=1;i<=linesCount;i++)
				{
					System.out.println("Enter line "+i+":");
					content.add(obj.nextLine());
				}
				
				//Saving the content into the file
				boolean isSaved= FileManager.createFiles(folderpath, fileName, content);
				if(isSaved)
					System.out.println("File and Data Saved Successfully");
				else
					System.out.println("Some error occured. please contact Kumar.abhishek7885@gmail.com ");
	}
	
	/**
	 * This method will Delete files
	 */
	public static void deleteFile()
	{
			//code for deleting a file
			String fileName;
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter File Name to be Deleted:");
			fileName=obj.nextLine();
			
			//Deleting file
			boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
			
			if(isDeleted)
				System.out.println("File Deleted successfully");
			else
				System.out.println("Either file not there or some access issues");
	}
	
	/**
	 * This method will search files
	 */
	public static void searchFile()
	{
		//code for Searching a file
		String fileName;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter File Name to be searched:");
		fileName=obj.nextLine();
		
		//Searching file
		boolean isFound = FileManager.searchFile(folderpath, fileName);
		
		if(isFound)
			System.out.println("File is present in the folder");
		else
			System.out.println("File is not present in the folder");
	}
	
}
