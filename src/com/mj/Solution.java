package com.mj;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode tn=new TreeNode();
        if(nums.length==0){
            return tn;
        }
        tn = helper(nums);
        return tn;
    }
    public TreeNode helper(int[] nums){
    TreeNode newNode=new TreeNode();
    if(nums.length==0){
        return null;
    }
    int max = maxAt(nums);
    newNode.left = helper(Arrays.copyOf(nums, max));
    newNode.right = helper(Arrays.copyOfRange(nums, max+1, nums.length));
       return newNode; 
    }
    public int maxAt(int[] nums){
        int positions = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]>nums[positions]){
                positions=i;
            }
        }
        return positions;
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;
        Arrays.parallelSort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int end= points[0][1];
        int count=1;
        for (int i = 0; i < points.length; i++) {
            if(points[i][0]<=end){    
            end=Math.min(end,points[i][1]);
            }
            else{
                count+=1;
                end=points[i][1];
            }
        }
        return count;
     }
     public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        Arrays.parallelSort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start=intervals[0][0];
        int end = intervals[0][1];
        int count =0; 
        for (int i = 1; i < intervals.length-1; i++) {
            if(intervals[i][0]<end || intervals[i][1]>intervals[i+1][0]){
                count+=1;
            }
            else{
                end=Math.max(end, intervals[0][1]);
            }
        }   
        return count;
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int p[][] ={p1,p2,p3,p4};
        HashSet<Integer> hs1 = new HashSet<>();        
        for(int i=0;i<p.length;i++){
            hs1.add(31*p[i][0]+p[i][1]);
        }
        if(hs1.size()!=4){
            return false;
        }
        int[] p11=p[0];
        int[] p21=p[1];
        int[] p31=p[2];
        int[] p41=p[3];
        float l1=dist(p11,p21);
        float l2=dist(p31,p21);
        float l3=dist(p31,p41);
        float l4=dist(p11,p41);
        float l5=dist(p11,p31);
        float l6=dist(p21,p41);
        HashSet<Float> hs = new HashSet<>();
        hs.add(l1);
        hs.add(l2);
        hs.add(l3);
        hs.add(l4);
        hs.add(l5);
        hs.add(l6);
        if(hs.size()!=2){
            return false;
        }
        
      return true;
    }
     public float dist(int[] p1, int[] p2){
         return (float )Math.sqrt(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2));
     }
     public String removeDuplicateLetters(String s) {
        TreeSet<Character> ts = new TreeSet<>();
        for (Character character : s.toCharArray()) {
            ts.add(character);
        }
        StringBuilder sb= new StringBuilder();
        for (Character character : ts) {
            sb.append(character);
        }
        return sb.toString();
    }
    
    public int wateringPlants(int[] plants, int capacity) {
     int ans = 0;
     int curr = capacity;
        for (int i = 0; i < plants.length; i++) {
        if(curr>=plants[i]){
            curr-=plants[i];
            ans+=1;
        }
        else{
            ans=ans+2*i +1;
            curr=capacity-plants[i];  
        } 
     }
     return ans;   
    }

    // public boolean hasValidPath(int[][] grid) {
    // }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int ans = helper(nums1,nums2,0,0);
        int[][] dp = new int[nums1.length+1][nums2.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1]=1+dp[i][j];
                }
                else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[nums1.length-1][nums2.length-1];
    }
    public int helper(int[] nums1, int[] nums2, int i, int j){
        if(i>nums1.length || j>nums2.length){
            return 0;
        }
        if(nums1[i] == nums2[j]){
            return 1+helper(nums1, nums2, i+1, j+1);
        }
        else{
            return Math.max(helper(nums1, nums2, i+1, j), helper(nums1, nums2, i, j+1));
        }
    }
    public int numIslands(char[][] grid) {
        int ans=0;
        char[][] visited = new char[grid.length][grid[0].length];
            
        for(int i = 0; i<grid.length;i++){
                for (int j = 0;j<grid[0].length;j++){
                    if(visited[i][j]!='1'){
                        ans+=1;
                        helper(grid,visited,i,j);
                    }
                }
            }
        return ans;
    }
    public void  helper( char[][] grid, char[][] visited, int i , int j){
        if( visited[i][j] == '1' )
            return ;
        else {
            visited[i][j] = '1';
            helper(grid,visited,i+1,j);
            helper(grid,visited,i,j+1);
            helper(grid,visited,i-1,j);
            helper(grid,visited,i,j-1);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); 
        if(nums.length==0)
            return new ArrayList<>(res);        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum= nums[i]+nums[j]+nums[k];
                if(sum==0)
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(sum>0){
                    k--;
                }
                else if(sum<0)
                    j++;
            }
        
        }
        return new ArrayList<>(res);
    }
    public int maxDistance(int[][] grid) {
        int ans = -1;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions= new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]==1){
                    queue.add(new int[] {i,j});
                    grid[i][j]=0;
                }
                else
                    grid[i][j]=-1;
            }
        }
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for (int[] dir: directions) {
                int x = point[0]+dir[0];
                int y = point[1]+dir[1];
                if(x>=0 && y>=0 && x<grid[0].length && y<grid.length && grid[x][y]==-1)
                {
                queue.add(new int[] {x,y});    
                grid[x][y]=grid[point[0]][point[1]]+1;
                ans = Math.max(ans,grid[x][y]);
            }
            }
        }
        return ans;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans=new ArrayList<>();
        int[] arr1= new int[26];
        int[] arr2=arr1.clone();
        
        for(String str : words2){
            arr1 = new int[26];
            for(int j=0; j<str.length(); j++)
                arr1[(int)str.charAt(j) - 97] += 1;
            for(int k=0; k<26; k++)
                arr2[k] = Math.max(arr2[k],arr1[k]);
        }
        
        for(String word: words1){
            int[] arr = new int[26];
            boolean flag = true;
            for(int j=0; j< word.length(); j++){
                arr[(int) word.charAt(j) - 97] += 1;         
            }
            for(int l=0; l<26; l++){
                if(arr[l]<arr2[l]){
                    flag = false;
                    break;
                }}
            if(flag == true)
                ans.add(word);
        }return ans;
    }

}