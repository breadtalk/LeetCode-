按照右边际排序
排完以后第一个元素是最右边的元素 以它为highBound lowBound
然后for loop走一圈
如果没有overlap 更新highBound lowBound
如果有overlap 选取左边际更左的删除保证留下的可用长度最长 更新highbound lowbound

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] intervals1, int[] intervals2){
                if(intervals1[1]!=intervals2[1]){
                    return(intervals2[1] - intervals1[1]);
                }
                else{
                    return(intervals1[0] - intervals2[0]);
                }
            }
        });
        int highBound = intervals[0][1];
        int lowBound = intervals[0][0];     
        int count = 0;
        int i = 1; 
        
        while(i < intervals.length){
            if(intervals[i][1] <= lowBound){
                highBound = intervals[i][1];
                lowBound = intervals[i][0];
                i=i+1;
            }
            else{
                count++;
                if(intervals[i][0] > lowBound){
                    lowBound = intervals[i][0];
                    highBound = intervals[i][1];
                }
                i=i+1;
                
            }
        }
        return count;
    }
}
