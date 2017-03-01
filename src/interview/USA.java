package interview;

/**
 * Created by max on 2/26/17.
 */
public class USA {
    public static void main(String[] args) {
        System.out.println(compareVersions("1", "1.1.0"));//-1
        System.out.println(compareVersions("1.1.0", "1"));//1
//        System.out.println(compareVersions(null, "1.1"));//thwors
//        System.out.println(compareVersions("1.0", "2."));//thwors
//        System.out.println(compareVersions("2.1.a", "3"));//throws
        System.out.println(compareVersions("1", "1.0") );//0
        System.out.println(compareVersions("1.2.5", "1.2.4"));//1
        //System.out.println(compareVersions("1.2.5", "1.3"));//
    }

    static int compareVersions(String v1, String v2) throws IllegalArgumentException {
        if (v1 == null || v2 == null || v1.endsWith(".") || v2.endsWith(".") ||
                v1.matches(".*[a-z].*") || v2.matches(".*[a-z].*")) {
            throw new IllegalArgumentException();
        }
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");
        int revert = 1;
        if(arr1.length > arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
            revert = -1;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                return -1 * revert;
            } else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                return 1 * revert;
            }
        }
        for (int i = arr1.length; i < arr2.length; i++) {
            if(Integer.parseInt(arr2[i]) > 0) {
                return -1 * revert;
            }
        }
        return 0;
    }
}
