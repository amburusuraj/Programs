package javaprograms;

import java.util.Scanner;

public class RemovingDuplicatesFromString {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String input=sc.nextLine();
		System.out.println("After removing duplicates String is: "+removeDuplicates(input));
		sc.close();

	}
	public static String removeDuplicates(String input)
	{
		String remove_str="";
		char[] ch=input.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(remove_str.indexOf(ch[i])==-1)
			{
				remove_str=remove_str+ch[i];
			}
		}
		return remove_str;
	}

}
