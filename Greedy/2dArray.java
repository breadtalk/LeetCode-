import java.util.*;

public class test {
  public static void main(String[] args) {
    ArrayList<int[]> a = new ArrayList<>();
    int[] b = new int[]{1,2,3};
    int[] c = new int[]{4,5,6};
    int[] d = new int[]{7,8,9};
    int[] e = new int[]{10,11,12};
    a.add(0,b);
    a.add(0,c);
    a.add(0,d);
    a.add(0,e);
    System.out.println(a.size());
    for(int i = 0; i < a.size(); i++){
      for (int j:a.get(i)){
        System.out.print(j);
      }
      System.out.println();
    }
    int[][] finalList = new int[a.size()][a.get(0).length];
    finalList = a.toArray(new int[a.size()][a.get(0).length]);
    System.out.println("printing 2D array");
    for(int k = 0; k < finalList.length; k++){
      for (int l = 0; l<finalList[0].length; l++){
        System.out.print(finalList[k][l]);
      }
      System.out.println();
    }
  }
}
