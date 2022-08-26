先从右到左走一遍 标记每个字母最后出现的位置 
再从左到右走一遍 当i等于max span的时候就是切点 花花酱 youtube视频有图


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> returnList = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = s.length()-1; i>=0; i--){
            char temp = s.charAt(i);
            if(!map.containsKey(temp)){
                map.put(temp, i);
            }
        }
        int maxlength = 0; 
        int count = 0; 
        for(int j = 0; j < s.length(); j++){
            count++;
            maxlength = Math.max(maxlength, map.get(s.charAt(j)));
            if(maxlength == j){
                returnList.add(count);
                count = 0;
                maxlength = 0;
            }
        }
        
        return returnList;
    }
}
