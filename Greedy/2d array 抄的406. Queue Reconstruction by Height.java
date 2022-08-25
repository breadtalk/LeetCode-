思路 首先按照身高排序
排完了以后按照priority插好 

这道题不会写


1. 2D array 如何用comparator sort 写法
2. arraylist add 再一个已经有的index上 自动后移
3. arraylist<int[]> 怎么转化为2D array

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] people1, int[] people2){
                if(people1[0] != people2[0]){
                    return(people2[0] - people1[0]);  //descending order of height
                }
                else{
                    return(people1[1] - people2[1]);  //same height ascending order of position
                }
            }
        });
            
            // for(int i = 0; i < people.length; i++){
            //     System.out.println(people[i][0] + " " + people[i][1]);
            // }
            // return people;
        
        ArrayList<int[]> returnList = new ArrayList<>();
        for(int i= 0; i < people.length; i++){
            returnList. add(people[i][1], people[i]);
        }
        return returnList.toArray(new int[people.length][2]);
    }
}
