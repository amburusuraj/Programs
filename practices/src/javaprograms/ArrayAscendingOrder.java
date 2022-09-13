package javaprograms;

public class ArrayAscendingOrder {

	public static void main(String[] args) 
	{
		int[] x= {20,40,10,50,60,80,30,70};
		for(int i=0;i<x.length-1;i++)
		{
			for(int j=i+1;j<x.length;j++)
			{
				if(x[i] > x[j])
				{
					int temp=x[i];
					x[i]=x[j];
					x[j]=temp;
				}
			}
		}
		for(int z:x)
		{
			System.out.print(z+" ");
		}
		System.out.println( );
		System.out.println("Smallest Number in array= "+x[0]);
		System.out.println("Largest Number in array= "+x[x.length-1]);
	}

}
