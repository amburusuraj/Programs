package javaprograms;

import java.util.Scanner;

public class LongestPalindrome {
	
	public static String longestPalindrome(String inputString)
	{
		String[] str=inputString.split(" ");
		String rev_String="";
		for(String w:str)
		{
			String rev_Word="";
			for(int i=w.length()-1;i>=0;i--)
			{
				rev_Word=rev_Word+w.charAt(i);
			}
			rev_String=rev_String+rev_Word;
		}
		System.out.println("Reverse String = "+rev_String);
		
		//validation
		
		if(inputString.isEmpty())
		{
			return "Enter Proper String";
		}
		if(inputString.length()==1)
		{
			return inputString;
		}
		
		String longest=rev_String.substring(0, 1);
		
		for(int i=0;i<rev_String.length();i++)
		{
			String temp=checkEquality(rev_String, i, i);
			//odd check
			if(longest.length() < temp.length())
			{
				longest=temp;
			}
			
			temp=checkEquality(inputString, i, i+1);
			//even check
			if(longest.length() < temp.length())
			{
				longest=temp;
			}
		}
		return longest;
	}
	
	public static String checkEquality(String inputString,int begin,int end)
	{
		while(begin >=0 && end<=inputString.length()-1 && inputString.charAt(begin)==inputString.charAt(end))
		{
			begin--;
			end++;
		}
		return inputString.substring(begin+1, end);
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String");
		String inputString=sc.nextLine();
		System.out.println("Longest Palindrome String = "+longestPalindrome(inputString));
		sc.close();
		
	}
	
}
