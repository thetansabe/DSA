import java.lang.Math;

class Bai3{
    public static double recursiveP(int n){
        if(n<2) return 3;
        return Math.pow(2,n) + n*n + recursiveP(n-1);
    }

    public static double stackForP(int n){
        MyStack<Double> stack = new MyStack<Double>();
        stack.push(3.0);
        for(int i = 2 ; i<= n;i++){
            Double p = stack.pop();
            Double tmp = Math.pow(2,i) + i*i + p;
            stack.push(tmp);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // System.out.println(recursiveP(4));
        System.out.println(stackForP(4));
    }

}