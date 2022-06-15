package com.mj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
	// write your code here

        int nums1[] = {1,2,3,0,0,0};

        int nums2[] = {2,5,6};
        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
}

public List<Integer> inOrderTraversal(TreeNode root){
    List<Integer> list= new ArrayList<>();
    if (root==null)
        return list;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr=root;
    while(stack.size()>0 || curr!=null){    
        while(curr!=null){   
            stack.push(curr);
            curr=curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
        curr=curr.right;
    }
    return list;
}

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list=new ArrayList<>();
    Stack<TreeNode> rights = new Stack<TreeNode>();
    rights.add(root);

    while(rights.size()>0){
        TreeNode el= rights.pop();
        list.add(el.val);
        if(el.right!=null){
            rights.add(el.right);
        }
        if(el.left!=null){
            rights.add(el.left);
        }        
    }
    return list;
}
public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i=n-1;
    int j=m-1;
    int fin=m+n-1;
    while(i>=0 && j>=0){
        if(nums2[i]>nums1[j]){
            nums1[fin--]=nums2[i--];
        }
        else{
            nums1[fin--]=nums1[j--];
        }   
    }
    while(j>=0){
        nums1[fin--]=nums2[j--];
    }
    
}

    public int maxSubArray(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i <nums.length ; i++) {
            temp=temp+nums[i];
            if (temp<0){
               max=Math.max(temp, max);
                temp=0;
            }
               else{
                max=Math.max(temp, max);
            }
        }
        return max;
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numsSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.containsKey(target-nums[i]) && i !=numsSet.get(target-nums[i]))
            {
            int aa[] = {i,numsSet.get(target-nums[i])};
            return aa;
            } 
        }
        return nums;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int max=0;
        int a[];
        if(n<m){
            for (int i = 0; i < m; i++) {
                for (int k = 0; k < nums2.length; k++) {
                if(nums1[i]==nums2[k]){
                    max=Math.max(max,k );                   
                }
            }
        }  
    }
    return nums1;
    }
    public int firstUniqChar(String s) {
        int charList[]=new int[26] ; 
        int val= "a".codePointAt(0);
        for (Character ch : s.toCharArray()) {
            charList[(int)ch - val]+=1;
        }
        for (int i=0;i<s.length();i++){
            if(charList[(int)s.charAt(i)-val] == 1){
                return i;
            }
        }
        return -1;
    }
    public static boolean isValidSudoku(char[][] board) {
        HashSet col = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            HashSet<Character> newSet = new HashSet<>();
            HashSet<Character> newSet1 = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.' && !newSet.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.' && !newSet1.add(board[j][i])){
                    return false;
                }
                if(board[i][j]!='.' && !col.add(board[i][j] + "seen in block" + i/3+"-"+j/3))
                return false;
            }
        }
        
        return true;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> newMap = new HashMap<Character,Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            if(!newMap.containsKey(ch))
                newMap.put(ch, (Integer)1);
            else
                {
                    Integer vald = newMap.get(ch);
                newMap.put(ch, (Integer) vald+1);
            }
        }
        HashMap<Character,Integer> newMap1 = new HashMap<Character,Integer>();
        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            if(!newMap1.containsKey(ch))
                newMap1.put(ch, (Integer)1);
            else
                {
                    Integer vald = newMap1.get(ch);
                newMap1.put(ch, (Integer) vald+1);
            }
        }
        for (Character ch : newMap1.keySet()) {
            if(!newMap.containsKey(ch)){
                return false;
            }
            if(newMap.get(ch)<newMap1.get(ch)){
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
                else if(ch == '[')
                    list1.push(']');
                else if(ch == '(')
                    list1.push(')');
                else if( list1.empty() || list1.pop()!=ch)
                        return false;
                }
            return true;
    }
}
