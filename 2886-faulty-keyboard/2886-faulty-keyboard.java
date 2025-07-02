class Solution {
    public String finalString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'i'){
                sb.reverse();
            }else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}