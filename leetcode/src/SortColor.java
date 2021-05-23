import java.util.Arrays;

public class SortColor {

//    //暴力搜索
//    public static void sortColor(int[] nums) {
//        int[] count = new int[3];
//        for(int i = 0; i < nums.length; i++) {
//            count[nums[i]]++;
//        }
//        int index = 0;
//        for(int i = 0; i < count.length; i++) {
//            for(int j = 0; j < count[i]; j++) {
//                nums[index++] = i;
//            }
//        }
//
//    }

    public static void sortColor(int[] nums) {
        int zero = -1;
        int i = 0;
        int two = nums.length;
        while(i < two) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if(nums[i] == 2) {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }
}
