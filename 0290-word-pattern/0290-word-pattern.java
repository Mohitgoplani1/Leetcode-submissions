class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() == str.length)
        {
            Set<Character> set = new HashSet<>();
            Set<String> sets = new HashSet<>();
            Set<String> combine = new HashSet<>();
            for(int i=0; i<pattern.length(); i++)
            {
                set.add(pattern.charAt(i));
                sets.add(str[i]);
                combine.add(pattern.charAt(i)+ "-" +str[i]) ;
            }
            if(set.size() == sets.size() && combine.size() == set.size())
            {
                return true;
            }
        }
        return false;
    }
}