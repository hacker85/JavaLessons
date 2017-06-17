package collections;

public class SortArrays {
    public static void main(String[] args) {
        int[] a = {1,3,4,6,8,9,0,0,0};
        int[] b = {2,4,7};
        for (int i : sort(a, b)) {
            System.out.println(i);
        }
    }
    static int[] sort(int[] a, int[] b) {
        int kl = a.length;
        int l = b.length;
        boolean bIsDone = false;
        int[] returnArray = new int[kl];
        for(int i = 0, j = 0, q = 0; i < kl; i++) {
            if(a[q] < b[j] || bIsDone) {
                returnArray[i] = a[q];
                q++;
            } else {
                returnArray[i] = b[j];
                if(j < l - 1) {
                    j++;
                } else {
                    bIsDone = true;
                }
            }
        }
        return returnArray;
    }
}
