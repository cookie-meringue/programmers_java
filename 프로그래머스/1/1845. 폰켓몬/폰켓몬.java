import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int N = nums.length;

        int size = N / 2;

        if (set.size() <= size) {
            return set.size();
        }
        return size;

        // nCr = n! / (r!(n-r)!)

        //return factorial(set.size()) / (factorial(size) * factorial(set.size() - size));
    }

    private int factorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }

        return result;
    }
}