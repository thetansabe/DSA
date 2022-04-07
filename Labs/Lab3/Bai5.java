//convert Dec to Bin
class Bai5{
    public static int decToBin(int n){
        int remain = n%2;
        if(n==0) return remain;
        return decToBin(n/2)*10+remain;
    }

    public static void main(String[] args) {
        System.out.println("0000"+" "+decToBin(1));
        System.out.println("0000"+" "+decToBin(2));
        System.out.println("0000"+" "+decToBin(8));
        System.out.println("0000"+" "+decToBin(12));
    }
}