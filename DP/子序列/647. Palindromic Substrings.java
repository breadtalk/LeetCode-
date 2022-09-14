中心扩散法比较好理解


class Solution {
 
    public int countSubstrings(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result = result + countHelper(s, i, i);
            result = result + countHelper(s, i, i+1);
        }
        return result;
    }
    public int countHelper(String s, int i, int j){
        int subResult = 0; 
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            subResult++;
            i--;
            j++;
        }
        return subResult;
    }
}



dp解法

class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = false;
            }
        }
        
        int result = 0;
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        result++;
                        dp[i][j] = true;
                    }
                    else if(dp[i+1][j-1]){
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }
}
