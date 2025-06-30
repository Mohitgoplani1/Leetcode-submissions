import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check for nums that have nums[i] + 1
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                max = Math.max(max, map.get(key) + map.get(key + 1));
            }
        }

        return max;
    }
}
