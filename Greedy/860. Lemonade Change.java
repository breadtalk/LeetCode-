class Solution {
    public boolean lemonadeChange(int[] bills) {
        int numOf5 = 0;
        int numOf10 = 0;
        int numOf20 = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                numOf5++;
            }
            else if(bills[i] == 10){
                numOf10++;
                if(numOf5 > 0){
                    numOf5--;
                }
                else{
                    return false;
                }
            }
            else{
                if(numOf10 > 0 && numOf5 > 0){
                    numOf10--;
                    numOf5--;
                    numOf20++;
                }
                else if(numOf5 >= 3){
                    numOf5 = numOf5 - 3;
                    numOf20++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
