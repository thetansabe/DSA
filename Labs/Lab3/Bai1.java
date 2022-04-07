class Bai1 {
    public static void main(String[] args) 
	{
		int x = 168;
		int y = 420;
		int n = 10;

		System.out.println("Cau a: " + n + "! = " + factorial(n)); 
		System.out.println("Cau b: " + pow(4,2)); 
		System.out.println("Cau c: " + DigitOfPositive(401));
		System.out.println("Cau d: " + PositiveIsPrime(2));
		System.out.println("Cau e: Uoc chung lon nhat cua " + x + " va " + y + " la "+  GCD(x,y));
		
	
	}
	
	//Exercise 1
	public static int factorial(int n)
	{
		int result = 1;
		if( n == 0 || n == 1)
			return 1;
		for(int i = 2; i <= n;i++)
		{
			result*=i;
		}
		return result;
	}
	
	public static int pow(int x,int n)
	{
		int result = 1;
		if(n == 0)
			return 1;
		for(int i = 1; i <= n;i++)
		{
			result *=x;
		}
		return result;
	}
	
	public static int DigitOfPositive(int n)
	{
		int result = 0;
		while( n > 0)
		{
			result++;
			n /= 10;
		}
		return result;
	}
	
	public static boolean PositiveIsPrime(int n)
	{
		boolean isPrime = true;
		if (n < 0 || n == 1 || n == 0)
			return false;
		for(int i = 2; i < n;i++)
		{
			if(n % i == 0)
			{
				isPrime = false;
			}
		}
		return isPrime;
	}
	
	public static int GCD(int x,int y)
	{
		while(y != 0)
		{
			
			int t = y;
			y = x % t;
			x = t;
		}
		return x;
	}
}
