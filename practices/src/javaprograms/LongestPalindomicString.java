package javaprograms;

import java.util.Scanner;

public class LongestPalindomicString 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your String : ");
		String inputstring=sc.nextLine();
		
		//System.out.println("Reverse String is : "+PalindromeString.reverseString(inputstring));
		System.out.println("Longest Palindrome is "+LongestPalindomicString.getLongestPalindrome(inputstring));
		sc.close();
	}
	/*public static String reverseString(String inputstring)
	{
		String org_str=inputstring;
		String rev="";
		String s=org_str.replaceAll(" ", "");
		for(int i=s.length()-1;i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		return rev;
	}*/
	
		public static String getLongestPalindrome(String inputString)
		{ 
			String[] str=inputString.split(" ");
			String reverseString="";
			for(String w:str)
			{
				String reverseWord="";
				for(int i=w.length()-1;i>=0;i--)
				{
					reverseWord=reverseWord+w.charAt(i);
				}
				reverseString=reverseString+reverseWord;
			}
			System.out.println("Reverse String is : "+reverseString);
			//validation
			if(inputString.isEmpty())
			{
				return "Enter proper String";
			}
			if(inputString.length()==1)
			{
				return inputString;
			}
			
			String longest=reverseString.substring(0, 1);
			
			for(int i=0;i<reverseString.length();i++)
			{
				//odd checking
				String temp=checkEquality(reverseString,i,i);
				 
				if(longest.length() < temp.length())
				{
					longest=temp;
				}
				
				// even checking
				temp=checkEquality(reverseString,i,i+1);
				
				if(longest.length() < temp.length())
				{
					longest=temp;
				}
				
			}
			return longest;
		}
		
		public static String checkEquality(String inputstring,int begin,int end)
		{
			
			while(begin>=0 && end<=inputstring.length()-1 && inputstring.charAt(begin)==inputstring.charAt(end))
			{
				begin--;
				end++;
			}
			
			return inputstring.substring(begin+1, end);
		}

}
