string 和 string比较不能用 ==
要用equals


class Solution {
    List<String> result = new ArrayList<>();
    LinkedList<String> subList = new LinkedList<>();
    
    public List<String> restoreIpAddresses(String s) {
        restoreHelper(s, 0);
        return result;
    }
    public void restoreHelper(String s, int startIndex){
        if(startIndex >= s.length() && subList.size() == 4){
            String temp = "";
            for(int i = 0; i < 4; i++){
                temp = temp + subList.get(i) + ".";
            }
            result.add(temp.substring(0, temp.length()-1));
            return;
        }
        
        if(startIndex >= s.length() || subList.size() > 4){
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++){
            String temp = s.substring(startIndex, i+1);
            if(isValidNumber(temp)){
                subList.add(temp);

            }
            else{
                break;
            }
            restoreHelper(s, i+1);
            subList.removeLast();
        }
        
    }
    public boolean isValidNumber(String s){
        if(s.substring(0,1).equals("0") && s.length() > 1){
            return false;
        }
        if(Integer. parseInt(s) < 0 || Integer. parseInt(s) > 255){
            return false;
        }
        return true;
    }
    
}
