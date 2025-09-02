package Test.ListToArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ArrayToList array变了，list要变；list变了，array也要变
 * 重写Comparator的compare方法
 */
public class Main {
    public static void main(String[] args) {
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{2,3});
        result.add(new int[]{1,2});
        int[][] array = result.toArray(new int[0][]);

//        List<int[]> ints1 = Arrays.asList(array);

        Comparator<int[]> sort = new Comparator<>() {
            public int compare(int[] p1,int[] p2){
                return p1[0]-p2[0];
            }
        };
        for (int[] ints : array) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        Collections.sort(result,sort);
        //遍历result
        for (int[] ints : result) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        //改变result，观察array变不变
        result.get(0)[0] = 5;
        for (int[] ints : array) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
