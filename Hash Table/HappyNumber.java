import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        // Input: n = 19
        // Output: true
        // Explanation:
        // 1^2 + 9^2 = 82
        // 8^2 + 2^2 = 68
        // 6^2 + 8^2 = 100
        // 1^2 + 0^2 + 0^2 = 1

        //Cac happy number dau tien
        //1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, ...

        //con` 1 cach dung 2 con tro cua Floyd
    }
}