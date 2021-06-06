public class MinimumSizeSubarraySum {

    //leetcode209

    //暴力解法
//    public static int minSubArrayLen(int target, int[] nums) {
//        int min = Integer.MAX_VALUE;
//        //从左边开始遍历，窗口的左边界
//        for(int i = 0; i < nums.length; i++) {
////            如果刚开始第一个元素添进去就大于等于target的话,就只有一个元素
//            int sum = nums[i];
//            if(sum >= target) return 1;
//            //向右边遍历找到窗口的右边界
//            for(int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if(sum >= target) {
//                    min = Math.min(min, j - i + 1);
//                }
//            }
//        }
//        return min;
//    }


    //滑动窗口

    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int l = 0, r = -1;
        int sum = 0;
        while(l < nums.length) {
            if(r + 1 < nums.length && sum < target) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if(sum >= target) {
                min = Math.min(min, r - l + 1);
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        int ret = minSubArrayLen(target, arr);
        System.out.println(ret);

    }
}
