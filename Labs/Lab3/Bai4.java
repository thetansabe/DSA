class Bai4{
    //cau a
    public static double TinhA(int n) {
		if(n == 1) {
			return 3;
		}
		else {
			return 2*n + 1 + TinhA(n-1);
		}
		
    }
    
    //cau b
    public static double FactorialR(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return n * FactorialR(n-1); 
	}
	
	public static double TinhB(int d) {
		if(d == 1) {
			return 1;
		}
		return FactorialR(d) + TinhB(d-1);
    }
    
    //cau c
    public static double TinhC(int d) {
		if (d == 1) {
			return 1;
		}
		return FactorialR(d) * TinhC(d-1);
    }
    
    //cau d
    public static int calC(int n,int r){
        if(r<=0 || r>n ) return 1;
        return (n-r+1)*calC(n,r-1);
    }

    //cau e
    public static double calP(int n){
        if(n == 1) return 3;
        return Math.pow(2,n)+n*n+calP(n-1);
    }

    public static void main(String[] args) {
        System.out.println(calC(5,3));
        System.out.println(calP(5));
    }
}