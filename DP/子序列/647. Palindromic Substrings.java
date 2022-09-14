没用dp用的中心扩散法比较好理解
dp的遍历顺序没理解

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
