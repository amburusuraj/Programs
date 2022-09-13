package javaprograms;

public class OccuranceOfEachCharacterOfString {

	public static void main(String[] args) 
	{
		String s="Mahabharat";
		s=s.toLowerCase();
		for(int i=0;i<s.length()-1;i++)
		{
			int count=0;
			char ch1=s.charAt(i);
			for(int j=0;j<s.length()-1;j++)
			{
				char ch2=s.charAt(j);
				if(ch1==ch2 && i>j)
				{
					break;
				}
				if(ch1==ch2)
				{
					count++;
				}
			}
			if(count >0)
			{
				System.out.println(ch1+" Present"+count+" times");
			}
		}
		
		

	}

}
