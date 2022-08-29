第一用recursive写 第二用DP写

class Solution {
    public int fib(int n) {
        return fibHelper(n);
    }
    public int fibHelper(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibHelper(n - 1) + fibHelper(n - 2);
    }
}
