package test;

public class Ce {
	public static void main(String args[])
	{
		int[] array1={4,5,8,1,87,45,3,2};
		int[] array2={12,56,89,3,2,7,1,4,25};
		for(int i=0;i<array1.length;i++)
		{
			for(int j=0;j<array2.length;j++)
			{
				if(array1[i]==array2[j])
				{System.out.println("commom element is:"+array1[i]);
			}
		}
	}

	}
}
