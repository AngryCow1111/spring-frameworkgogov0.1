package com.ac.spring.gogo.trytry;


/**
 * Test1
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/7/29
 */
public class Test1 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] nums = new int[]{2, 5, 5, 11};
//        int[] ints = twoSum(nums, 10);
//        String[] strings = String.valueOf(Math.abs(-123)).split("");
//        String num = "";
//        for (int i = strings.length - 1; i >= 0; i--) {
//            num += strings[i];
//        }
//        if (str.indexOf("-") != -1) {
//            num = "-" + num;
//        }
//        return Integer.valueOf(num);
        int reverse = reverse(-123);

    }

    private static int reverse(int x) {
        int rs = 0;
        for (; x % 10 != 0; rs = rs * 10 + x % 10, x /= 10) ;
        return rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE ? 0 : rs;
    }

//    public static int[] twoSum(int[] nums, int target) {

//        int i = 0, j = nums.length - 1;
//        while (true) {
//            if (target == nums[i] + nums[j]) {
//                return new int[]{i, j};
//            }
//            if (j - 1 <= i) {
//                i++;
//                j=nums.length - 1;
//            } else {
//                j--;
//            }
//            continue;
//        }
//        int[] indexs = new int[2];
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (hashMap.containsKey(nums[i])) {
//                indexs[0] = i;
//                indexs[1] = hashMap.get(nums[i]);
//                return indexs;
//            }
//            hashMap.put(target - nums[i], i);
//        }
//        return indexs;
//    }
}
