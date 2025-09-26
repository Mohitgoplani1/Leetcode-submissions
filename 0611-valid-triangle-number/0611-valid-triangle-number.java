import java.util.*;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        // convert to List<Integer>
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i], b = nums[j];
                for (int k = j + 1; k < nums.length; k++) { // <-- pick third element after j
                    int c = nums[k];
                    if (check(a, b, c)) count++;
                }
            }
        }
        return count;
    }

    private boolean check(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
