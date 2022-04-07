import java.util.*;

class Isomorphic{
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> assignedValues = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (!map.containsKey(s.charAt(i)) && assignedValues.contains(t.charAt(i))) {
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
            assignedValues.add(t.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        //Ki tu cua str1 co the dc thay the boi ki tu str2
        //"aaaaa" "aaaaa" => true
        //"abc" "abc" => true
        //"egg" "add" => true
        //"paper" "title" => true
        //"bar" "foo" =>false
        //"bbbaaaba" "aaabbbba"=>false

        String s1 = "bbbaaaba";
        String s2 = "aaabbbba";

        System.out.println(isIsomorphic(s1,s2));
    }
}