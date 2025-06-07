class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        for(int a:nums){
            if(h.contains(a)){
                return true;
            }
            h.add(a);
        }
        return false;
    }
}