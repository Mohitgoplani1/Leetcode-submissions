class Solution {
    public boolean isValid(String word) {
        if(word.length()<3) return false;
        int vow=0,con=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(!Character.isLetterOrDigit(c))
            return false;
            char ch=Character.toLowerCase(c);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vow+=1;
            }
            else if(!Character.isDigit(ch)) con+=1;
        }
        if(vow>=1 && con>=1) return true;
        else return false;
    }
}