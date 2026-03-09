package p2201_2300.p2235_add_two_integers;

public class Runner {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("Test 1: " + s.sum(12, 5));   // 17
        System.out.println("Test 2: " + s.sum(-10, 4));  // -6
        System.out.println("Test 3: " + s.sum(0, 0));    // 0
    }
}