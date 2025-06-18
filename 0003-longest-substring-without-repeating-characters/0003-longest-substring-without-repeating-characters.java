class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int start=0,end=0,max=0;
        Set<Character> h=new HashSet<Character>();
        while(end<n){
            
                if(h.isEmpty() || !h.contains(s.charAt(end))){
                h.add(s.charAt(end));
                max=Math.max(max,end-start+1);
                end++;
                }
                else{
                   h.remove(s.charAt(start));
                   start++; 
                } 
            }
            return max;
        }
    }
