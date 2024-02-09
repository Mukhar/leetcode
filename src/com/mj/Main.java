package com.mj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] nums = { 3, 1, 4, 2 };
        Solution ss = new Solution();
        int[][] points = { { 1, 2 }, { 2, 3 }, { 2, 4 }, { 4, 5 } };
        int[] plants = { 2, 2, 3, 5 };
        int capacity = 5;
        int[][] grid = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SEE";

        // ss.maxDistance(grid);
        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2 = { "ec", "oc", "ceo" };
        // ss.wordSubsets(words1, words2);
        // ss.exist(board, word);
        // ss.containsNearbyDuplicate(new int[] {1,0,1,1},1);
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // ss.deleteAndEarn(nums);
        // testtrie();

        int ans = ss.countMinLetters("aabbba");
        System.out.println(ans);
    }

    public static void testtrie() {
        Trie obj = new Trie();
        String word = "mukhar";
        obj.insert(word);
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith("muk");
    }

    public static List<String> gg(int n) {
        List<String> li = new ArrayList<>();

        // backtrack(li, new StringBuilder(), 0, 0, n);

        return li;
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;

            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
        }

        return ans;
    }

    // public int[] minOperations(String boxes) {
    // int left=0;
    // int right =0;
    // for (int i = 0; i < boxes.length(); i++) {
    // if(boxes.charAt(i)==1){
    // right++;
    // }
    // }
    // for (int i = 0; i < boxes.length(); i++) {
    // }
    // }
    public static int minPartitions(String n) {
        char ch[] = n.toCharArray();
        int max = 0;
        for (char c : ch) {
            max = Math.max(max, Integer.parseInt(Character.toString(c)));
        }
        return max;
    }

    public static void backtrack(List<String> list, StringBuilder curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            list.add(curr.toString());
        }
        if (open < max) {
            curr.append('(');
            backtrack(list, curr, open + 1, close, max);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (close < max) {
            curr.append(')');
            backtrack(list, curr, open, close + 1, max);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> ns = new HashSet<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!ns.contains(ch)) {
                ns.add(ch);
                max = Math.max(max, ns.size());
                right++;
            } else {
                ns.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode head = newList;
        int carry = 0;
        while (l1 != null & l2 != null) {
            int ans = l1.val + l2.val + carry;
            carry = ans / 10;
            newList.next = new ListNode(ans % 10);

            l1 = l1.next;
            l2 = l2.next;
            newList = newList.next;
        }
        while (l1 != null) {
            int ans = l1.val + carry;
            carry = ans / 10;
            newList.next = new ListNode(ans % 10);
            newList = newList.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int ans = l2.val + carry;
            carry = ans / 10;
            newList.next = new ListNode(ans % 10);
            newList = newList.next;
            l2 = l2.next;
        }
        return head.next;
    }

    public static int minSubarray(int[] nums, int p) {
        int sum = Arrays.stream(nums).sum();
        int ans = sum % p;
        if (ans == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int n = nums.length;
        int val = 0;
        System.out.println(ans);
        int a = Integer.MAX_VALUE;
        while (i <= j && j < n) {
            if (val % p == ans) {
                a = Math.min(a, j - i);
                j++;
            }
            if (val < ans) {
                val += nums[j++];
            } else if (val > ans) {
                val -= nums[i++];
            }
        }
        return a;

    }
    // public int climbStairs(int n) {
    // if(li.!=-1)
    // return (int)li.get(n);

    // if(n==0){
    // return 1;
    // }
    // this.li[n] = climbStairs(n-1)+climbStairs(n-2);
    // return this.li[n];
    // }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs1 = new HashSet<>();
        for (int in : nums1) {
            hs.add(in);
        }
        int[] ans = new int[hs.size()];
        int j = 0;
        for (int in : nums2) {
            if (hs.contains(in)) {
                ans[j++] = in;
                hs.remove(in);
            }
        }
        return Arrays.copyOf(ans, --j);
    }

    public static boolean valieParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (Character character : str.toCharArray()) {
            if (character == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != character) {
                return false;
            }

        }
        return stack.isEmpty();
    }

    public static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> newSet = new HashSet<>();
        for (Character character : jewels.toCharArray()) {
            newSet.add(character);
        }
        HashMap<Character, Integer> newMap = new HashMap<>();
        for (Character character : stones.toCharArray()) {
            if (!newMap.containsKey(character))
                newMap.put(character, 1);
            else
                newMap.put(character, newMap.get(character) + 1);
        }
        int ans = 0;
        for (Character character : newSet) {
            if (newMap.containsKey(character)) {
                ans += (int) newMap.get(character);
            }
        }
        return ans;
    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String string : operations) {

            if (string.contains("--")) {
                ans -= 1;

            } else if (string.contains("++")) {
                ans += 1;
            }
        }
        return ans;
    }

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> newMap = new HashMap<>();
        HashMap<Integer, Integer> newMap1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (newMap.containsKey(key)) {
                int val = newMap.get(key);
                newMap.put(key, val + 1);
            } else {
                newMap.put(key, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (newMap1.containsKey(key)) {
                int val = newMap1.get(key);
                newMap1.put(key, val + 1);
            } else {
                newMap1.put(key, 1);
            }
        }
        for (Integer keyy : newMap.keySet()) {
            if (newMap1.containsKey(keyy)) {
                for (int i = 0; i < Math.max(newMap.get(keyy), newMap1.get(keyy)); i++) {
                    list.add(keyy);
                }
            }

        }
        int[] ex = list.stream().mapToInt(i -> i).toArray();
        return ex;
    }

    public int fib(int n) {
        int a[] = new int[31];
        a[0] = 0;
        a[1] = 1;

        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode newhead = head;
        int temp = head.val;
        while (head != null) {
            if (head.next != null && head.next.val == temp) {
                head.next = head.next.next;
            } else {
                head = head.next;
                temp = head.val;
            }
        }
        return newhead;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (stack.size() > 0 || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        rights.add(root);

        while (rights.size() > 0) {
            TreeNode el = rights.pop();
            list.add(el.val);
            if (el.right != null) {
                rights.add(el.right);
            }
            if (el.left != null) {
                rights.add(el.left);
            }
        }
        return list;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n - 1;
        int j = m - 1;
        int fin = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[i] > nums1[j]) {
                nums1[fin--] = nums2[i--];
            } else {
                nums1[fin--] = nums1[j--];
            }
        }
        while (j >= 0) {
            nums1[fin--] = nums2[j--];
        }

    }

    public int maxSubArray(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = temp + nums[i];
            if (temp < 0) {
                max = Math.max(temp, max);
                temp = 0;
            } else {
                max = Math.max(temp, max);
            }
        }
        return max;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.containsKey(target - nums[i]) && i != numsSet.get(target - nums[i])) {
                int aa[] = { i, numsSet.get(target - nums[i]) };
                return aa;
            }
        }
        return nums;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int max = 0;
        int a[];
        if (n < m) {
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < nums2.length; k++) {
                    if (nums1[i] == nums2[k]) {
                        max = Math.max(max, k);
                    }
                }
            }
        }
        // for (int i : a) {

        // }
        return nums1;
    }

    public int firstUniqChar(String s) {
        int charList[] = new int[26];
        int val = "a".codePointAt(0);
        for (Character ch : s.toCharArray()) {
            charList[(int) ch - val] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charList[(int) s.charAt(i) - val] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> col = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            HashSet<Character> newSet = new HashSet<>();
            HashSet<Character> newSet1 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !newSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !newSet1.add(board[j][i])) {
                    return false;
                }
                if (board[i][j] != '.' && !col.add(board[i][j] + "seen in block" + i / 3 + "-" + j / 3))
                    return false;
            }
        }

        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> newMap = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            if (!newMap.containsKey(ch))
                newMap.put(ch, (Integer) 1);
            else {
                Integer vald = newMap.get(ch);
                newMap.put(ch, (Integer) vald + 1);
            }
        }
        HashMap<Character, Integer> newMap1 = new HashMap<Character, Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            if (!newMap1.containsKey(ch))
                newMap1.put(ch, (Integer) 1);
            else {
                Integer vald = newMap1.get(ch);
                newMap1.put(ch, (Integer) vald + 1);
            }
        }
        for (Character ch : newMap1.keySet()) {
            if (!newMap.containsKey(ch)) {
                return false;
            }
            if (newMap.get(ch) < newMap1.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String s) {
        Stack<Character> list1 = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            if (ch == '{')
                list1.push('}');
            else if (ch == '[')
                list1.push(']');
            else if (ch == '(')
                list1.push(')');
            else if (list1.empty() || list1.pop() != ch)
                return false;
        }
        return true;
    }

    // public long getPalindrome(long left, boolean even){
    // long res = left;
    // if(!even){
    // res=res/10;
    // }
    // while(left>0){
    // res=res*10+left%10;
    // left=left/10;
    // }
    // int[] ss = new int[5];
    // Arrays.sort(ss ,(int[] a, int[] b) -> a[0] < b[0]);
    // List<int[] > ll = new ArrayList();
    // for(int i=0;i<score1.length;i++){
    // ll.add(i,score[i]);
    // HashMap<Integer,Integer> hm = new HashMap<>();
    // for(int i=0;i<score.length;i++){
    // hm.put(i, score[i]);
    // }
    // return res;

    // }
    // }

    public String categorizeBox(int length, int width, int height, int mass) {
        String c = "Neither";
        String b = "Bulky";
        String h = "Heavy";
        String bb = "Both";
        int l = 10000;
        if (mass >= 100) {
            c = h;
        }
        Long lb = new Long(length * width);
        long hh = new Long(height);
        if (length >= l || width >= l || height >= l || lb * height >= 1000000000) {
            if (c == h) {
                c = bb;
            } else {
                c = b;
            }
        }
        return c;
    }

    public int maxPoints(int[][] points) {
        HashMap<Double, Set<Coordinate>> hm = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i; j < points.length; j++) {
                double slope = Double.valueOf(points[i][1] - points[j][1])
                        / Double.valueOf(points[i][0] - points[j][0]);
                Set<Coordinate> s = hm.getOrDefault(hm, new HashSet<Coordinate>());
                s.add(new Coordinate(points[i][0], points[i][1]));
                s.add(new Coordinate(points[j][0], points[j][1]));
            }
        }
        int max = 0;
        for (double s : hm.keySet()) {
            Set<Coordinate> set = hm.get(s);
            max = Math.max(max, set.size());
        }
        return max;

    }

}

class Coordinate {
    private final double x;
    private final double y;
    private int hashCode;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
        this.hashCode = Objects.hash(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return this.hashCode;

    }

    class Solution {
        public int maxPoints(int[][] points) {

            HashMap<Double, Integer> hm = new HashMap();
            for (int i = 0; i < points.length; i++) {
                for (int j = i; j < points.length; j++) {
                    double slope = new Double(points[i][1] - points[j][1]) / new Double(points[i][0] - points[j][0]);
                    hm.put(slope, hm.getOrDefault(slope, 0) + 1);
                }
            }
            int max = 0;
            List<Integer> l = new ArrayList(hm.values());
            for (int i : l) {
                max = Math.max(max, i);
            }
            return max;
        }
    }

    List<Integer> postOrderList = new ArrayList();

    // public List<Integer> postorderTraversal(TreeNode root) {

    // }

    void helper(TreeNode node, List<Integer> ll) {
        if (node == null)
            return;
        helper(node.left, ll);
        helper(node.right, ll);
        ll.add(node.val);
    }

}
