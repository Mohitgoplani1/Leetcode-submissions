class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        unordered_map<string,int>mp;
        for (int i=0;i<emails.size();i++){
            string b="";
            int j=0;
            while (j<emails[i].size() && emails[i][j]!='@'){
                if (emails[i][j]=='+'){
                    while (emails[i][j]!='@'){j++;}
                    break;
                }
                if (emails[i][j]!='.'){b+=emails[i][j];}
                j++;
            }
            while (j<emails[i].size()){b+=emails[i][j];j++;}
            mp[b]++;
        }
        return mp.size();
    }
};