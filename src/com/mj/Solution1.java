package com.mj;

import java.util.Arrays;
import java.util.List;

class Solution1 {
    public int minChanges(String s) {
        int sum = 0;
        // char[] arr = s.toCharArray();
        int change = 0;
        for (int i = 0; i < s.length(); i++) {
            int sa = Integer.valueOf(s.charAt(i));
            sum += sa;
        }
        if (sum == 0) {
            return 0;
        } else {
            for (int i = 0; i < s.length() - 1; i += 2)
                if (s.substring(i, i + 2).compareTo("01") == 0 || s.substring(i, i + 2).compareTo("10") == 0)
                    change++;

            return change;
        }

    }
     public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] memo = new int[nums.size() + 1][target + 1];
                for (int[] arr : memo) {
                    Arrays.fill(arr, -1);
                }
   
        return helper(nums, target, 0, 0,  memo);

        
    }
    public int helper(List<Integer> nums, int tg , int i, int ind,int[][] memo){
        if(tg==0){
            return i;
        }
        if(ind>nums.size() || tg <0){
            return -1;
        }
        if (memo[ind][tg] != -1) {
            return memo[ind][tg];
        }
        int result = Math.max(helper(nums, tg, i, ind + 1, memo), helper(nums, tg - nums.get(ind), i + 1, ind + 1, memo));
        memo[ind][tg] = result;
        return result;
    }
}