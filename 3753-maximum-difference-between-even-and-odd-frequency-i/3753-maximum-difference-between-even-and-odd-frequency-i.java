class Solution {
    public int maxDifference(String s) {
        int min=s.length();
        int max=0;
        int[] map=new int[26];
        for(char ch:s.toCharArray()){
            map[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(map[i]%2==0 && map[i]>0){
                min=Math.min(min,map[i]);
            }
            else if(map[i]%2!=0 && map[i]>0){
                max=Math.max(max,map[i]);
            }
        }
        return max-min;
    }
}