package javaprograms;

public class CountingOfCharactersWithoutLengthMethod {

	public static void main(String[] args) 
	{
		String s="India is my Country";
		//System.out.println(s.length());
		int count=0;
		char[] ch=s.toCharArray();
		for(char a:ch)
		{
			System.out.println(a);
			count++;
		}
		System.out.println("Length of the String = "+count);
	}

}
