package com.ac.spring.gogo.trytry;

import java.util.*;

public class Test {
  public static void main(String[] args) {
    //        ListNode l3 = new ListNode(3);
    //        ListNode l2 = new ListNode(2, l3);
    //        ListNode l1 = new ListNode(1, l2);
    //
    //        ListNode l13 = new ListNode(3);
    //        ListNode l12 = new ListNode(2, l3);
    //        ListNode l11 = new ListNode(1, l2);
    //
    //        ListNode listNode = mergeTwoLists(l1, l11);
    //        removeDuplicates(new int[]{1, 1, 3});
    //        removeElement(new int[]{3, 2, 2, 3}, 3);
    //        maxSubArray(new int[]{-2, 1});
    //        String s = countAndSay(4);
    //        int[] ints = plusOne(new int[]{9,9});
    //        String s = addBinary(
    //
    // "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
    //
    // "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
    //        String s = addBinary(
    //                "11",
    //                "1");
    //        int total = climbStairs(6);
    //        System.out.println(total);)
    //        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    //        merge(new int[]{0}, 0, new int[]{1}, 1);

    //    TreeNode treeNode = initTree();
    //        preIterate(treeNode);
    //        postIterate(treeNode);

    //        levelIterate(treeNode, new Stack<>());
    //    midIterate(treeNode, new Stack<>());
    //    sortedArrayToBST(new int[] {1, 23, 4});
    //    System.out.println(getRow(3));
    //    maxProfit(new int[] {7, 1, 5, 3, 6, 4});
    ListNode l1 = initListNode();
    ListNode l2 = initListNode1();
    addTwoNumbers(l1, l2);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode l3 = null;
    int new1 = 0;
    int addLevel = 0;
    int total = 0;
    while (l1 != null && l2 != null) {

      total = l1.val + l2.val;
      if (head == null) {
        new1 = total % 10;
        addLevel = total / 10;

        head = new ListNode(new1);
        l3 = head;
      } else {

        if (addLevel == 1) {
          total++;
        }
        new1 = total % 10;
        ListNode head2 = new ListNode(new1);
        addLevel = total / 10;
        l3.next = head2;
        l3 = l3.next;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      total = l1.val + addLevel;
      new1 = total % 10;
      addLevel = total / 10;
      ListNode head2 = new ListNode(new1);
      l3.next = head2;
      l3 = l3.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      total = l2.val + addLevel;
      new1 = total % 10;
      addLevel = total / 10;
      ListNode head2 = new ListNode(new1);
      l3.next = head2;
      l3 = l3.next;
      l2 = l2.next;
    }
    if (addLevel == 1) {
      ListNode head2 = new ListNode(1);
      l3.next = head2;
    }
    return head;
  }

  public static int maxProfit(int[] prices) {
    int min = prices[0], max = 0, max1 = 0;
    for (int i = 1; i < prices.length; i++) {
      if (max1 > (prices[i] - min)) {
        min = prices[i];
        max1 = 0;
      } else {
        max += (prices[i] - min);
        max1 = (prices[i] - min);
      }
    }
    return max;
  }

  public static List<Integer> getRow(int rowIndex) {
    return generate(rowIndex).getLast();
  }

  public static TreeNode sortedArrayToBST(int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public static LinkedList<List<Integer>> generate(int numRows) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    if (numRows == 0) {
      return result;
    }
    List<Integer> l1 = new ArrayList<>();
    for (int i = 0, j = 0; i < numRows; j++) {

      if (j > i) {
        i++;
        j = 0;
        ArrayList<Integer> objects = new ArrayList<>(l1);
        result.add(objects);
        l1.clear();
      }
      int t1 = get(result, i - 1, j - 1, i) + get(result, i - 1, j, i);
      l1.add(t1 == 0 ? 1 : t1);
    }
    return result;
  }

  private static int get(List<List<Integer>> result, int i, int j, int numRows) {
    if (i < 0 || j < 0 || j > numRows - 1) {
      return 0;
    }
    return result.get(i).get(j);
  }

  private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = (end - start) / 2 + start;
    TreeNode treeNode = new TreeNode(nums[mid]);
    treeNode.left = sortedArrayToBST(nums, 1, mid - 1);
    treeNode.right = sortedArrayToBST(nums, mid + 1, end);
    return treeNode;
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      List<Integer> l1 = new ArrayList();
      for (int i = 0; i < count; i++) {
        TreeNode treeNode = queue.poll();

        l1.add(treeNode.val);
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        }
        if (treeNode.right != null) {
          queue.add(treeNode.right);
        }
      }
      result.addFirst(l1);
    }
    return result;
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1Copy = Arrays.copyOf(nums1, m);
    int p = m - 1;
    int p1 = m + n - 1, p2 = n - 1;
    while (p >= 0 && p2 >= 0) {
      if (nums1Copy[p] > nums2[p2]) {
        nums1[p1] = nums1Copy[p];
        p--;
        p1--;
        continue;
      }
      nums1[p1] = nums2[p2];
      p2--;
      p1--;
    }
    if (p >= 0) {
      System.arraycopy(nums1Copy, 0, nums1, 0, p + 1);
    }
    if (p2 >= 0) {
      System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
  }

  static TreeNode initTree() {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    treeNode1.left = treeNode2;
    TreeNode treeNode3 = new TreeNode(3);
    treeNode1.right = treeNode3;
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    treeNode3.right = treeNode5;
    return treeNode1;
  }

  /**
   * 树前序遍历
   *
   * @param root
   */
  static void preIterate(TreeNode root) {
    System.out.println(root.val);
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }
    preIterate(root.left);
    preIterate(root.right);
  }

  static void levelIterate(TreeNode root, Stack<TreeNode> stack) {
    stack.push(root);
    if (root == null) {
      return;
    }
    if (stack.empty()) {
      stack.push(root.left);
      stack.push(root.right);
    } else {
      while (!stack.empty()) {
        TreeNode pop = stack.pop();
        System.out.println(pop);
      }
    }
    if (root.left == null && root.right == null) {
      return;
    }

    levelIterate(root.left, stack);
    levelIterate(root.right, stack);
  }

  static void midIterate(TreeNode root, Stack<TreeNode> stack) {
    if (root == null) {
      return;
    }
    if (stack.empty()) {
      stack.push(root.left);
      stack.push(root.right);
    } else {
      while (!stack.empty()) {
        TreeNode pop = stack.pop();
        System.out.println(pop);
      }
    }
    if (root.left == null && root.right == null) {
      return;
    }

    midIterate(root.left, stack);
    stack.push(root);
    midIterate(root.right, stack);
  }

  // todo
  static void postIterate(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      System.out.println(root.val);
      return;
    }
    postIterate(root.left);
    postIterate(root.right);
  }

  public static int climbStairs(int n) {
    int total = 0;
    total += climbStair(1, n);
    total += climbStair(2, n);
    return total;
  }

  private static int climbStair(int count, int remain) {
    System.out.print(count + " ");
    int total = 0;
    if (remain - count == 0) {
      System.out.println();
      return 1;
    }
    if (remain - count < 0) {
      return 0;
    }
    total += climbStair(1, remain - count);
    total += climbStair(2, remain - count);
    return total;
  }

  public static String addBinary(String a, String b) {
    Stack stack = new Stack<>();
    int a1 = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    int total = 0;
    int t1 = 0;
    int t2 = 0;
    for (; i >= 0 || j >= 0; i--, j--) {
      t1 = 0;
      t2 = 0;
      if (i >= 0) {
        t1 = a.charAt(i) - '0';
      }
      if (j >= 0) {
        t2 = b.charAt(j) - '0';
      }
      total = t1 + t2 + a1;
      stack.push(total % 2);
      a1 = total / 2;
    }
    if (a1 == 1) {
      stack.push(a1);
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.empty()) {
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  public static int[] plusOne(int[] digits) {
    if (digits == null) {
      return digits;
    }
    int n1 = 0;
    for (int i = digits.length - 1; i >= 0; i--) {

      if (i == digits.length - 1) {
        n1 = digits[i] + 1;
      } else {
        n1 = digits[i];
      }

      digits[i] = n1 % 10;
      if (i > 0) {
        digits[i - 1] += n1 / 10;
      }
    }
    int n2 = n1 / 10;
    if (n2 <= 0) {
      return digits;
    }
    int[] t1 = new int[digits.length + 1];
    for (int i = t1.length - 1; i > 1; i--) {
      t1[i] = Integer.valueOf(digits[i - 1]);
    }
    t1[0] = n2;
    return t1;
  }

  public static String countAndSay(int n) {
    return getPre(n);
  }

  private static String getPre(int n) {
    if (n == 1) {
      return "1";
    }
    return doNext(getPre(n - 1));
  }

  private static String doNext(String preStr) {
    char t1 = preStr.charAt(0);
    int count = 0;
    StringBuffer s1 = new StringBuffer();
    for (int i = 0; i < preStr.length(); i++) {
      if (t1 == preStr.charAt(i)) {
        count++;
      } else {
        s1.append(count).append(t1);
        count = 0;
        count++;
        t1 = preStr.charAt(i);
      }
    }
    if (count > 0) {
      s1.append(count).append(t1);
    }
    System.out.println(s1);
    return s1.toString();
  }

  public static int maxSubArray(int[] nums) {
    return sectionMax(nums, 0, nums.length - 1);
  }

  private static int sectionMax(int[] nums, int left, int right) {

    if (left == right) {
      return nums[left];
    }
    int max = Integer.MIN_VALUE;
    int mid = (left + right) / 2;
    int leftMax = sectionMax(nums, left, mid);
    int rightMax = sectionMax(nums, mid + 1, right);
    int midMax = crossMax(nums, left, mid, right);
    int postiveMax = Math.max(leftMax, rightMax);
    postiveMax = Math.max(midMax, postiveMax);
    max = Math.max(max, postiveMax);
    return max;
  }

  private static int crossMax(int[] nums, int left, int mid, int right) {
    int sum = 0;
    int leftSum = Integer.MIN_VALUE;
    ;
    for (int i = mid; i >= left; i--) {
      sum += nums[i];
      leftSum = Math.max(leftSum, sum);
    }

    sum = 0;
    int rightSum = Integer.MIN_VALUE;
    ;
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      rightSum = Math.max(rightSum, sum);
    }
    return leftSum + rightSum;
  }

  public static int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = nums.length - 1; i <= j; ) {
      if (nums[i] != val) {
        i++;
        continue;
      }
      if (nums[j] != val) {
        //                t1 = nums[i];
        nums[i] = nums[j];
        //                nums[j] = t1;
        j--;
        i++;
        continue;
      }
      j--;
    }
    return i;
  }

  //    public static int removeElement(int[] nums, int val) {
  //        int t1;
  //        int t2 = 0;
  //        for (int i = 0, j = nums.length - 1; i <= j; ) {
  //            if (nums[i] != val) {
  //                i++;
  //                t2++;
  //                continue;
  //            }
  //            if (nums[j] != val) {
  //                t1 = nums[i];
  //                nums[i] = nums[j];
  //                nums[j] = t1;
  //                j--;
  //                i++;
  //                t2++;
  //                continue;
  //            }
  //            j--;
  //        }
  //        return t2;
  //    }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int num = 1;
    int t1 = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != t1) {
        t1 = nums[i];
        nums[num] = t1;
        num++;
      } else {
        continue;
      }
    }
    return num;
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode l3 = l1;
    ListNode l4 = l2;
    ListNode l5 = null;
    while (l3 != null && l4 != null) {
      if (l3.val <= l4.val) {
        if (l5 == null) {
          l5 = l3;
        } else {
          ListNode l6 = l3;
          l5.next = l6;
        }
        l3 = l3.next;

        continue;
      }
      if (l5 == null) {
        l5 = l4;
      } else {
        l5.next = l4;
      }
      l4 = l4.next;
    }
    return l1;
  }
  //    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  //
  //    }

  private static ListNode iterate(ListNode listNode) {

    if (listNode.next == null) {
      return listNode;
    }
    return iterate(listNode.next);
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  static ListNode initListNode() {

    ListNode l3 = new ListNode(2);
    ListNode l2 = new ListNode(7);
    ListNode l1 = new ListNode(3);
    l1.next = l2;
    //    l2.next = l3;
    return l1;
  }

  static ListNode initListNode1() {

    ListNode l3 = new ListNode(9);
    ListNode l2 = new ListNode(2);
    ListNode l1 = new ListNode(9);
    l1.next = l2;
    //        l2.next = l3;
    return l1;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return val + "";
    }
  }
}
