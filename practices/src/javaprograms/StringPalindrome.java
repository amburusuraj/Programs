package javaprograms;

public class StringPalindrome {

	public static void main(String[] args) 
	{
		String s="radar";
		String str_rev="";
		char[] ch=s.toCharArray();

		for(int i=s.length()-1;i>=0;i--)
		{
			str_rev=str_rev+ch[i];
		}
		System.out.println(str_rev);
		if(s.equals(str_rev))
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("String is not palindrome");
		}
		

	}
	

}
