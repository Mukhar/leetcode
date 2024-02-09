package com.mj;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;


public class Solution {
    int[][] directions= new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

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
    
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] pall = new long[n]; 
        long start = 0;
        long end = 0;
        start = (long)Math.pow(10, intLength-1);
        end = (long) Math.pow(10, intLength)-1;
        int i=0;
        for(int nums :queries){
            if(nums<=end-start-1){
                String fh = (""+(start+nums-1));
                String sh = (new StringBuffer(fh)).reverse().toString();
                pall[i++]=Long.parseLong(fh+sh.substring(intLength%2));
            }
            else{
                pall[i++]=-1;
            }
        }
        return pall;
    }
    public boolean isPalindrome(int x) {
        int num = x;
        if (num<0){
            return false;
        }
        String str = String.valueOf(num);
        int l = 0;
        int r = str.length() - 1;
        while(l<r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++; 
            r--;
        }
        return true;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0, end = products.length-1;
        int remain = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while(start<=end && (products[start].length()<=i) || products[start].charAt(i)!= c){
                start+=1;
            }
            while(start<=end && (products[end].length()<=i) || products[end].charAt(i)!= c){
                end-=1;
            }
            remain = end-start+1;
            List<String> res1;
                res1 = new ArrayList<String>();
            for (int j = 0; j < Math.min(3,remain); j++) {
                res1.add(products[start+j]);    
            }
            result.add(res1);
        }
        return result;
        
    }
    public boolean exist(char[][] board, String word) {
        char[][] visited =Arrays.stream(board).map(char[] ::clone).toArray(char[][]::new) ;      
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    for (int k = 0; k < board.length; k++) 
                        for (int l = 0; l < board[0].length; l++)
                            visited[k][l]='0';  
                    boolean ans = helper(board, visited, word,i,j, 0);
                        if(ans){
                            return true;
                        }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, char[][] visited, String word,int i, int j, int n){
        int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        
        if(n==word.length()){
            return true;
        }
        if(i>=0 && j>=0 && i<board.length && j < board[0].length && visited[i][j]!='1' && board[i][j]==word.charAt(n)){
            visited[i][j]='1';
            boolean ans = false;
            for(int[] point : directions){
                int x=i+point[0];
                int y=j+point[1];
                if(x>=0 && y>=0 && x<board.length && y < board[0].length)
                   ans = ans || helper(board, visited, word, x, y, n+1);
            }
            visited[i][j]='0';
            return ans;
    }
    return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> freq = new HashSet();
        if(nums.length==1 || k==0){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i>k){
                freq.remove(nums[i-k-1]);
            if(!freq.add(nums[i])){
                return true;
            }

            }
        }
        return false;
}
public int divisorSubstrings(int num, int k) {
    int count =0;
    StringBuilder s = new StringBuilder(Integer.toString(num));
    Set<String> set = new HashSet<>();
    for(int i=0;i<s.length();i++){
        set.add(s.substring(i,i+k));    
    }
    set.remove("0");
    return set.size();
}
    List<List<Integer>> l1 = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> l3 = new ArrayList();
        helper(root,targetSum,l3);
        return this.l1;
    }
    public void helper(TreeNode node, int targetSum,List<Integer> l2){
        if(node==null){
            return;
        }
        
            // System.out.println(targetSum);
        if(node.left==null && node.right==null && targetSum==node.val){
            List<Integer> newL = new ArrayList<Integer>();
            newL.addAll(new ArrayList<>(l2));
            this.l1.add(newL);
            return;
        }
        l2.add(node.val);
        helper(node.left,targetSum-node.val,l2);
        helper(node.right,targetSum-node.val,l2);
        l2.remove(l2.size()-1);
    }
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap();
         for (int i = 0; i < nums.length; i++) {
            if(hm.putIfAbsent(nums[i], 1)!=null){
                hm.replace(nums[i], 1+hm.get(nums[i]));
            }
            
        }
        int sum=0;
        while(hm.size()>0){
            int key= getMaxVal(hm);
            int val = hm.get(key);
            sum+=val;
            hm.replace(key,val-1);
            if(hm.containsKey(key+1))
                hm.remove(key+1);
            if(hm.containsKey(key-1))
                hm.remove(key-1);
        }
        return sum;
    }
    public int getMaxVal(HashMap<Integer,Integer> hm){
        int ans=0;
        int max= 0;
        for (Integer number: hm.keySet()) {
            if(hm.get(number)>max){
                ans=number;
                max=hm.get(number);
            }
        }
        return ans;
    }
    // public int numIslands(char[][] grid) {
    //     int count =0;
    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             if(grid[i][j]!='2' && grid[i][j]=='1'){
    //                 count+=1;
    //                 dfs(grid,i,j);
    //             }    
    //         }
    //     }   
    //    return count;
    
    // }
    public void dfs(char[][] grid,int i,int j){
        
        for(int[] dir :directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(grid[x][y]!='2' && grid[x][y]!='0'){
                grid[x][y]='2';
                dfs(grid,x,y);
            }
        }
    }

    // public int[] dailyTemperatures(int[] temperatures) {
    //     Stack<int[]> v = new Stack();
    //     Stack<Integer> i = new Stack();
    //     int[] ans = new int[temperatures.length];
    //     if(temperatures.length<=1)
    //         return new int[1];
    //     int index =0;
    //     v.add(new int[] {temperatures[index],index});
    //     i.add(index++);
    //     while(v.size()>0 && index<temperatures.length){
    //         while(temperatures[index] > v.peek()[0]){
    //             v.pop();
    //             int ind = i.pop();
    //             ans[ind]=index-ind;
    //         }
    //         v.add(temperatures[index]);
    //         i.add(index++);
    //     }
    //     return ans;
    // }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[0]-b[0]);
    
        for(int i=0;i<points.length;i++){
            pq.add(new int[] {points[i][0],points[i][1]});
        }
        int[][] ans = new int[k][2];
        while(k>0){
            ans[k--]=pq.poll();
    
        } 
    return ans;
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int i=0,j=0;

        while(i <nums1.length && j< nums2.length){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }
            if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
    }
    while(i<nums1.length){
        if(nums1[i]==nums2[j-1]){
            return nums1[i]; 
        }
        i++;
    }
    while(j<nums2.length){
        if(nums1[i-1]==nums2[j]){
            return nums2[j]; 
        }
        j++;
    }
    return -1;
}
public long minOperations(int[] nums1, int[] nums2, int k) {
    int ans = 0;
    List<Integer> s = new ArrayList<>();
    for(int i=0;i<nums1.length;i++){
        int x = nums1[i]-nums2[i];
        ans^= Math.abs(x);
        s.add(x);
    }

    if(k==0 || ans !=0)
        return -1;
    if(ans ==0 ){
        return s.size()/2;
    }
    return -1;
}

public boolean lemonadeChange(int[] bills) {
    int[] note = new int[3];
    boolean ans = true;
    for(int i=0;i<bills.length;i++){
        if(bills[i]==5){
            note[0]++;
        }
        else if (bills[i]==10){
            if(note[0]>=1){
                note[0]--;
                note[1]++;
            }
            else{
                return false;
            }
        }
        else{
            if(note[1]>=1 && note[0]>=1) {
                note[1]--;
                note[0]--;
                note[2]++;
            } 
            else if(note[1]<1 && note[0]>=3){
                note[0]-=3;
                note[2]++;
            }
            else{
                ans=false;
                return false;
            }
        }
    }
    return ans; 
}

public int countMinLetters(String s) {
    int max = 0;
    if (s.length() <= 1)
        return 0;
    int i = 1;
    int point = 0;
    int count = 0;
    while (i < s.length()) {
        if (s.charAt(i) != s.charAt(i - 1)) {
            max = Math.max(max, i - point);
            count ++;
            point = i;
        }
        i++;
    }
    return (count +1 )*max - s.length();
}
}