For the int operation be careful about the int range


class Solution {
    public boolean judgeSquareSum(int c) {
        int i=0;
        int j=(int)Math.sqrt(c);
        int difference = c - j*j;
        while(i<=j){
            difference = c - j*j;
            if (i*i == difference){
                return true;
            }
            else if(i*i > difference){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
           
    }
}


