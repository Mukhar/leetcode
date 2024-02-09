package com.mj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

class DataStream {
HashMap<Integer,Integer> hm;
Queue<Integer> q ;
int kk = 0;
    public DataStream(int value, int k) {
        this.hm = new HashMap<>();
        this.kk=k;
        this.q = new LinkedList<>();
    }
    
    public boolean consec(int num) {
        boolean ans = false;
        this.q.add(num);
        if(q.size()<this.kk){
            ans = false;
        }
        if(this.q.size()>kk){
            int a = q.poll();
            int up = hm.get(a);
            hm.put(a,up-1);
        }
        if(hm.containsKey(num)){
            int val  = hm.get(num);
            hm.put(num,val+1);
        }
        else{
            hm.put(num,1);
        }
        if(hm.containsKey(num) && kk == hm.get(num)){
                ans = true;
            }
        
        return ans;
    }
}