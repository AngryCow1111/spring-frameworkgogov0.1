package com.ac.spring.gogo.trytry;


import java.util.Stack;

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
//        long reverse = reverse(121);
//        System.out.println(121 == reverse);
//        boolean palindrome = isPalindrome(121);
//        System.out.println(16 >> 1);
//        System.out.println("sss".substring(7));
//        int iii = romanToInt("IV");
//        String s = longestCommonPrefix(new String[]{"cac", "cab"});
//        boolean valid = isValid("{[]}");

//        System.out.println(1 & 1);

//        mergeTwoLists(new ListNode(1, null), new ListNode(2, null));
//        int length = lengthOfLastWord("      ");
//        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        plusOne(new int[]{9});
//        merge(new int[]{1, 2, 3, 0, 0, 0}, 6, new int[]{2, 5, 6}, 3);
//        ListNode1 l7 = new ListNode1(0);
//        ListNode1 l6 = new ListNode1(0);
//        ListNode1 l5 = new ListNode1(0);
//        ListNode1 l4 = new ListNode1(0);
//        ListNode1 l3 = new ListNode1(0);
//        ListNode1 l2 = new ListNode1(0);
//        ListNode1 l1 = new ListNode1(-1);
//        l6.next = l7;
//        l5.next = l6;
//        l4.next = l5;
//        l3.next = l4;
//        l2.next = l3;
//        l1.next = l2;
//        ListNode1 listNode1 = deleteDuplicates(l1);
//        System.out.println(listNode1);
        int max = maxSubArray(new int[]{-2, 1});
//        int max = getMax(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 1);
        System.out.println(max);
    }

    private static int getMax(int[] nums, int len) {
        int total = 0;
        int max = nums[0];
        int count = 0;
        for (int i = 0; ; ) {
            if (count < len) {
                count++;
                total += nums[i];
                i++;
            } else {
                if (max < total) {
                    max = total;
                }
                i -= len - 1;
                count = 0;
                total = 0;
            }
            if (i >= nums.length) {
                if (max < total) {
                    max = total;
                }
                return max;
            }
        }
    }

    public static int maxSubArray(int[] nums) {
        int max = getMax(nums, 1);

        for (int i = 2; i <= nums.length; i++) {
            if (max < getMax(nums, i)) {
                max = getMax(nums, i);
            }
        }
        return max;
    }

    public static ListNode1 deleteDuplicates(ListNode1 head) {
        int t1 = head.val;
        ListNode1 l1 = new ListNode1(-1);
        ListNode1 l2 = l1;
        while (head != null) {
            if (head.val != l2.val) {
                l2.next = head;
                head = head.next;
                l2 = l2.next;
            } else {
                l2.next = head;
                head = head.next;
            }
        }
        if (l2.next != null) {
            l2.next = null;
        }
        if (t1 == -1) {
            return l1;
        }
        return l1.next;
    }

    public static class ListNode1 {
        int val;
        ListNode1 next;

        ListNode1(int x) {
            val = x;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int t = 0;
        for (int i = 0, j = 0; i < nums1.length; i++) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                t = nums1[i];
                nums1[i] = nums2[j];
                nums1[i] = t;
                j++;
            }
        }
    }

    public static int[] plusOne(int[] digits) {
        int t1 = 0;
        if (digits[0] == 9) {
            digits = new int[digits.length + 1];
        }
        for (int i = digits.length - 1; t1 / 10 > 0; i--) {
            if (i == digits.length - 1) {
                digits[i]++;
            }
            if (i < 0) {

            }
            digits[i] += t1 / 10;
            t1 = digits[i];
        }
        return digits;
    }

    public static int lengthOfLastWord(String s) {
        int a1 = s.lastIndexOf(" ");
        if (a1 == -1) {
            return s.length();
        }
        if (a1 == s.length() - 1) {
            return s.length() - 1;
        }
        return s.length() - a1 - 1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode t1 = l1;
        while (t1 != null) {
            int v1 = t1.val;
            t1 = t1.next;
        }
        return l1;
    }

    public static int removeDuplicates(int[] nums) {
        int a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & a) == 1) {
            }
        }
        return 0;
    }

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if ('(' == c1 || '[' == c1 || '{' == c1) {
                stack.push(c1);
                continue;
            }
            char c2 = (char) stack.pop();
            if (c2 != getMatch(c1)) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private static char getMatch(char c2) {
        switch (c2) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return 0;
        }
    }

    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//
//        if (strs.length == 1) {
//            return strs[0];
//        }
//        int i = 0, j = 0;
//        char c1 = 0;
//        String s1 = "";
//        for (; ; i++) {
//            if (i == 0) {
//                String ss1 = strs[i];
//                if (j > ss1.length() - 1) {
//                    return s1;
//                }
//                if (ss1.equals("")) {
//                    return s1;
//                }
//                c1 = ss1.charAt(j);
//                continue;
//            }
//            if (i == 1) {
//                String ss2 = strs[i];
//                if (j > ss2.length() - 1) {
//                    return s1;
//                }
//                if (ss2.equals("")) {
//                    return s1;
//                }
//                char c2 = ss2.charAt(j);
//
//
//                if (c2 != c1) {
//                    return s1;
//                }
//            } else {
//                if (strs.length == 2) {
//                    s1 += c1;
//                    i = -1;
//                    j++;
//                    continue;
//                }
//                if (!strs[i].startsWith(s1 + c1)) {
//                    return s1;
//                }
//                if (i == strs.length - 1) {
//                    s1 += c1;
//                    i = -1;
//                    j++;
//                    continue;
//                }
//            }
//
//        }

        int len = strs.length;
        if (len == 0)
            return "";

        String s = strs[0];
        for (int i = 1; i < len; ) {
            if (strs[i].indexOf(s) != 0) {
                s = s.substring(0, s.length() - 1);
                if (s.equals(""))
                    return s;
            } else {
                i++;
            }
        }
        return s;
    }

    public static int romanToInt(String s) {
        int total = 0;
        int len = s.length();
        int a1 = getValueByChar(s.charAt(len - 1));
        total += a1;
        for (int i = len - 2; i >= 0; i--) {
            int a2 = getValueByChar(s.charAt(i));
            if (a2 < a1) {
                total -= a2;
            } else {
                total += a2;
            }
            a1 = a2;
        }
        return total;
    }

    private static int getValueByChar(char char1) {
        switch (char1) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private static int reverse(int x) {
        long rs = 0;

        for (; ; x /= 10) {
            if ((x % 10 == 0 && x / 10 == 0)) {
                return (int) rs;
            }
            rs = rs * 10 + x % 10;
            if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE) {
                return 0;
            }

        }
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
