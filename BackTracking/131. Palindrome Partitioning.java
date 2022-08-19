跟取所有子集的思路是一样的
切割substring的时候从startPoint切割到i

class Solution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> subList= new LinkedList<>();
    
    public List<List<String>> partition(String s) {
        partitionHelper(s, 0);
        return result;
    }
    
    public void partitionHelper(String s, int startIndex){
        if (startIndex >= s.length()){
            result.add(new LinkedList(subList));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            String temp = s.substring(startIndex, i + 1);
            if(isPalindrome(temp)){
                subList.add(temp);
            }
            else{
                continue;
            }
            partitionHelper(s, i+1);
            subList.removeLast();
        }
    }
    
    public boolean isPalindrome(String s){
        int i = 0; 
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
        
    }
}


