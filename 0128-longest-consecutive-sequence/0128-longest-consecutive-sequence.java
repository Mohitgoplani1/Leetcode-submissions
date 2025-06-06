class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> h1=new HashSet<>();
        for(int num:nums){
            h1.add(num);
        }
        int max=0;
        for(int num:h1){
            if(!h1.contains(num-1)){
                int curr=1;
                while(h1.contains(num+curr)){
                    curr++;
                }
                max=Math.max(max,curr);
            }
        }
        return max;
    }
}