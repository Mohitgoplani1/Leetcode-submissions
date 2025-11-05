class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int total = 0;
        int prev = neededTime[0]; // max time kept so far in current same-color run

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Remove the cheaper one between prev and current
                total += Math.min(prev, neededTime[i]);
                // Keep the more expensive one as the survivor in the run
                prev = Math.max(prev, neededTime[i]);
            } else {
                // New color run starts
                prev = neededTime[i];
            }
        }
        return total;
    }
}
