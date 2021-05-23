/*
    author: danceli
    leetcode: 11.ContainerWithMostWater
*/

public class ContainerWithMostWater {
    //暴力: O(n²)
//    public static int maxArea(int[] arr) {
//        int max = 0;
//        for(int i = 0; i < arr.length - 1; i++) {
//            for(int j = i + 1; j < arr.length; j++) {
//                int area = (j - i) * Math.min(arr[i], arr[j]);
//                max = Math.max(max, area);
//            }
//        }
//        return max;
//    }

    //左右指针: O(n)
    public static int maxArea(int[] arr) {
        int max = 0;
        for(int i = 0, j = arr.length - 1; i < j; ) {
            int minHeight = arr[i] < arr[j] ? arr[i++] : arr[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int ret = maxArea(arr);
        System.out.println(ret);
    }
}
