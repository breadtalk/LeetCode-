class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] points1, int[] points2){
                if(points1[0] != points2[0]){
                    return Integer.compare(points1[0], points2[0]);
                }
                else{
                    return Integer.compare(points1[1], points2[1]);
                }
            }
        });
        
        int count = 1; 
        int lowerBound = points[0][0];
        int higherBound = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= higherBound){
                if(points[i][0] > lowerBound){
                    lowerBound = points[i][0];
                }
                if(points[i][1] < higherBound){
                    higherBound = points[i][1];
                }
            }
            else{
                count++;
                lowerBound = points[i][0];
                higherBound = points[i][1];
            }
        }
        return count;
    }
}
