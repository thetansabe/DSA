//valid parenthensis
class Bai5{
    public static boolean check(String s){
        MyStack<Character> stack = new MyStack<Character>();
        Character c;
        for(int i = 0 ; i<s.length();i++){
            c = s.charAt(i);
            if(c == '(' || c == '{' || c=='[')
                stack.push(c);
            else{
                switch (stack.pop()) {
                    case '(':
                        if(c != ')') return false;
                        break;

                    case '{':
                        if(c != '}') return false;
                        break;

                    case '[':
                        if(c != ']') return false;
                        break;

                    default:
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(check("[({)]"));
        System.out.println(check("[({})]"));
        System.out.println(check("(){}[]"));
    }
}