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
接下来看一下优化过程如下：

已经选择的元素个数：path.size();

还需要的元素个数为: k - path.size();

在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历

为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。

举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。

从2开始搜索都是合理的，可以是组合[2, 3, 4]。

这里大家想不懂的话，建议也举一个例子，就知道是不是要+1了。

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
