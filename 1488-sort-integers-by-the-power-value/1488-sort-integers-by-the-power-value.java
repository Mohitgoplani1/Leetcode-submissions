class Solution {
    public int getPower(int n, Map<Integer, Integer> dp){
        if(n == 1) return 0;
        if(dp.get(n) != null) return dp.get(n);
        int count = 0;
        if(n%2 == 0){
            count = 1 + getPower(n/2, dp);
        }
        else count = 1 + getPower(3*n + 1, dp);
        dp.put(n, count);
        return count;
    }
    public int getKth(int lo, int hi, int k) {
        int[][] arr = new int[hi - lo + 1][2];
        Map<Integer, Integer> dp = new HashMap<>();
        int index = 0;
        for(int i = lo ; i <= hi ; i++){
            arr[index][0] = i;
            arr[index][1] = getPower(i, dp);
            index++;
        }
        Arrays.sort(arr, (a, b) -> (a[1] - b[1]));
       
        return arr[k-1][0];
    }
}