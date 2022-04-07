class Bai2 {
	public int fraction(int n) {
		if (n == 0)
			return 1;
		return n*fraction(n-1);
	}
	public double exponential(int x, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 1.0/x * exponential(x, n+1);
		else 
			return x * exponential(x, n-1);
	}
	public int countDigits(int n) {
		if (n == 0)
			return 0;
		return 1 + countDigits(n/10);
	}
	public boolean checkPrime(int n, int i) {
		if (n <= 2)
			return n == 2 ? true : false;
		if (n % i == 0)
			return false;
		if (i*i > n)
			return true;
		return checkPrime(n, i+1);

	}
	public int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b%a, a);
	}
}