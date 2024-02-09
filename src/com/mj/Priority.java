package com.mj;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Priority {
    public String[] findRelativeRanks(int[] score) {
        return new String[1];
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] sum = new int[mat.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0] );
        for(int i=0;i<sum.length;i++){
            pq.add(new int[] {sum[i],i});
            if(pq.size()>k){
                pq.remove();
            }
        }
        int ans[] = new int[k];
        int j=0;
        while(pq.size()>0){
            ans[j++]=pq.poll()[1];
        }
        return ans;

}

// public void setOperation(){
//     Set<Integer> set = new HashSet();
// }

}
