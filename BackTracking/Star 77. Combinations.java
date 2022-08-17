用模板

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }
    public void combineHelper(int n, int k, int startPoint){
        if(subList.size() == k){
            result.add(new LinkedList(subList)); //这里一定要新建一个list 不然的话return的时候就全return完了 变成空子集了
            return; // 一定要记住return
        }
        for(int i = startPoint; i <= n; i++){
            subList.add(i);
            combineHelper(n, k, i+1);
            subList.removeLast(); //backtracking step here 
        }
    }
}

优化 剪枝操作
class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }
    public void combineHelper(int n, int k, int startPoint){
        if(subList.size() == k){
            result.add(new LinkedList(subList));
            return;
        }
        for(int i = startPoint; i <= n-(k-subList.size())+1; i++){ //k-subList.size() 就是还剩下的要取的子集长度 停在n-这个长度+1就可以了
            subList.add(i);
            combineHelper(n, k, i+1);
            subList.removeLast();
        }
    }
}
