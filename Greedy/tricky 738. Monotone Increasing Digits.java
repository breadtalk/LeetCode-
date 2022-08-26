非常tricky 右到左走一遍
然后要找出从哪一个位置开始都变成9
比较这两个数字的区别
21345
332



class Solution {
    public int monotoneIncreasingDigits(int n) {
        if(n < 10){
            return n;
        }
        ArrayList<Integer> intList= new ArrayList<>();
        while(n > 0){
            intList.add(0, n % 10);
            n = n / 10;
        }
        int flag = intList.size();
        for(int i = intList.size()-1; i > 0; i--){
                if(intList.get(i-1) > intList.get(i)){
                intList.set(i, 9);
                intList.set(i-1, intList.get(i-1)-1);
                flag = i;
            }

        }

        for(int k = flag; k < intList.size(); k++){
            intList.set(k,9);
        }
        
        int returnValue = 0;
        for(int i = 0; i < intList.size(); i++){
            returnValue = returnValue*10 + intList.get(i);
        }
        return returnValue;
    }
}
        
