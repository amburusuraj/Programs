package javaprograms;

public class ReverseAnArray {

	public static void main(String[] args) 
	{
		int[] x= {10,12,4,5,19,8,1};
		int count=0;
		int[] rev=new int[x.length];
		for(int i=x.length-1;i>=0;i--)
		{
			rev[count++]=x[i];
		}
		for(int i:rev)
		{
			System.out.print(i+" ");
		}
	}

}
