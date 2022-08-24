class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = 0;
        int costSum = 0; 
        int[] difference = new int[gas.length];
        for(int i = 0; i < gas.length; i++){
            gasSum = gas[i] + gasSum;
            costSum= cost[i] + costSum;
            difference[i] = gas[i] - cost[i];
        }
        if(gasSum < costSum){                             //如果gas少于cost 无论如何都走不完
            return -1;
        }
        
        int sum = 0; 
        int returnPoint = 0;                             //gas大于cost 先算每一站这两个东西的difference 然后找起点
        for(int j = 0; j < difference.length; j++){      
            sum = sum + difference[j];
            if(sum <0 ){                                  //如果sum of difference 小于0 肯定不是起点 sum归零重新开始
                returnPoint = j + 1;
                sum = 0;
            }
            
        }
        return returnPoint;
        
    }
}
