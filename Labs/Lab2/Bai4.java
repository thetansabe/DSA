//reverse string by stack
class Bai4{
    public static void printReverse(String s){
        MyStack<Character> c = new MyStack<Character>();
        for(int i = 0;i<s.length();i++){
            c.push(s.charAt(i));
        }
        while(!c.isEmpty()){
            System.out.print(c.pop()+" ");
        }
    }

    public static void main(String[] args) {
        printReverse("Hello");
    }
}