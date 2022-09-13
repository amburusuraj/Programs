package javaprograms;

public class ReverseEachWordOfString {

	public static void main(String[] args) 
	{
		String s="Good Morning and Good night";
		s=s.toLowerCase();
		String[] str=s.split(" ");
		String rev_str="";
		for(String w:str)
		{
			String rev_word="";
			for(int i=w.length()-1;i>=0;i--)
			{
				rev_word=rev_word+w.charAt(i);
			}
			rev_str=rev_str+rev_word;
		}
		System.out.println(rev_str);
		

	}

}
