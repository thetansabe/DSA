class Bai6 {
    public static void main(String[] args) 
	{
		
		int[] n = {-3,-2,-6,9,2,-11};
		System.out.println("Cau a: " + minimum(n,6));
		System.out.println("Cau b: " + SumofElement(n,3));
		System.out.println("Cau c: " + CountEvenNumber(n,6));
	}

    //Exercise 6
	public static int minimum(int[] n,int size)
	{
		int min = n[0];
		for(int i = 0;i < size; i++)
		{
			if(n[i] <  min)
				min = n[i];
		}
		return min;
	}
	
	public static int SumofElement(int[] n,int size)
	{
		int sum = 0;
		for(int i = 0;i < size; i++)
		{
			sum+=n[i];
		}
		return sum;
	}
	
	public static int CountEvenNumber(int[] n,int size)
	{
		int count = 0;
		for(int i = 0;i < size; i++)
		{
			if(n[i] % 2 == 0)
				count++;
		}
		return count;
	}
    
}
