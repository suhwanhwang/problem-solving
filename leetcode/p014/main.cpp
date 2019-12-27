class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans;
        
        if (strs.size() == 0) {
            return "";
        }
        
        string f = strs[0];
        for (int i = 0; i < f.size(); ++i) {
            for (int j = 1; j < strs.size(); ++j) {
                if (f[i] != strs[j][i]) {
                    return ans;
                }
            }
            ans += f[i];
        }
        
        return ans;
    }
};
