class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> subList = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        sumHelper(k, n, 1);
        return result;
    }
    public void sumHelper(int k, int n, int startPoint){
        if (sum == n && subList.size() == k){
            result.add(new LinkedList(subList));
            return;
        }
        if(subList.size() == k){
            return;
        }
        if (sum > n){
            return;
        }
        for (int i = startPoint; i <= 9-(k - subList.size()) + 1; i++){
            subList.add(i);
            sum = sum + i;
            sumHelper(k, n, i+1);
            sum = sum - subList.removeLast();
        }
    }
    
}
