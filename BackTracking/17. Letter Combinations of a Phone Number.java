



class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder subList = new StringBuilder();
    
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> numString = new HashMap<>();
        numString.put(2, "abc");
        numString.put(3, "def");
        numString.put(4, "ghi");
        numString.put(5, "jkl");
        numString.put(6, "mno");
        numString.put(7, "pqrs");
        numString.put(8, "tuv");
        numString.put(9, "wxyz");
        
        if(digits == null || digits.length() == 0){
            return result;
        }
        
        combinationHelper(digits, 0, numString);
        return result;
        
        
    }
    
    public void combinationHelper(String digits, int index, HashMap<Integer, String> numString){
        if(index == digits.length()){
            result.add(subList.toString());
            return;
        }
        
        

        char currChar = digits.charAt(index);
        int currIndex = Character.getNumericValue(currChar);
        String currString = numString.get(currIndex);
        
        for(int i = 0; i < currString.length(); i++){
            subList.append(currString.charAt(i));
            combinationHelper(digits, index+1, numString);
            subList.deleteCharAt(subList.length()-1);
        }
        
    }
}
