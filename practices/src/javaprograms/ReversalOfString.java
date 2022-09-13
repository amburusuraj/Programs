package javaprograms;

public class ReversalOfString {

	public static void main(String[] args) 
	{
		String s="Good morning and good Night";
		s=s.toLowerCase();
		String str=s.replace(" ", "");
		String str_rev="";
		for(int i=str.length()-1;i>=0;i--)
		{
			str_rev=str_rev+str.charAt(i);
		}
		System.out.println(str_rev);
		

	}

}
