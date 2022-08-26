class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] intervals1, int[] intervals2){
                if(intervals1[0] != intervals2[0]){
                    return Integer.compare(intervals1[0], intervals2[0]);
                }
                else{
                    return Integer.compare(intervals1[1], intervals2[1]);
                }
            }
        });
        
        ArrayList<int[]> returnList = new ArrayList<>();
        int lowerBound = intervals[0][0];
        int upperBound = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > upperBound){
                int[] temp = new int[]{lowerBound, upperBound};
                returnList.add(temp);
                lowerBound = intervals[i][0];
                upperBound = intervals[i][1];
            }
            else if(intervals[i][1] > upperBound){
                upperBound = intervals[i][1];
            }
            else{
                continue;
            }
        }
        int[] temp = new int[]{lowerBound, upperBound};
        returnList.add(temp);
        
        return returnList.toArray(new int[returnList.size()][2]);
        
    }
}
