import java.util.*;

public class Bai7
{
    public static boolean isPalin(String s){
        MyStack<Character> stack = new MyStack<>();
        MyQueue<Character> queue = new MyQueue<>();
        
        for(int i = 0;i<s.length();i++){
            Character c = s.charAt(i);
            if(c>=97 && c<=122){
                stack.push(c);
                queue.add(c);
            }
        }

        stack.show();
        queue.show();

        for(int i = 0;i<stack.size();i++){
            if(stack.pop() != queue.poll()) return false;
        }

        return true;
    }
    public static void main(String[] args)
    {
        String s = "A man, a plan, a canal: Panama";
        s= s.toLowerCase();

        if(isPalin(s)){
            System.out.println("This is a palindrome");
        } else System.out.println("This is not a palindrome");
    }
}