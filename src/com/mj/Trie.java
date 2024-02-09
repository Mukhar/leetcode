package com.mj;

import java.util.HashMap;

class Trie {
    HashMap<Character,HashMap> hm = new HashMap();
    public Trie() {
        this.hm=new HashMap<Character,HashMap>();   
    }
    
    public void insert(String word) {
        HashMap<Character,HashMap> hm1 = this.hm;
        for(char c: word.toCharArray()){
            if(!hm1.containsKey(c)){
                hm1.put(c,new HashMap<Character,HashMap>());
                hm1=hm1.get(c);
            }
            else{
                hm1=hm.get(c);
            }
        }
        hm1.replace(word.charAt(word.length()-1),null);

    }
    
    public boolean search(String word) {
        HashMap<Character,HashMap> hm1 = this.hm;
        for(char c: word.toCharArray()){
            if(hm1.containsKey(c)){
                hm1=hm1.get(c);
            }
            else{
                return false;
            }
        }

         return hm1.size()==0?true:false;

    }
    
    public boolean startsWith(String prefix) {
        HashMap<Character,HashMap> hm1 = this.hm;
        for(char c: prefix.toCharArray()){
            if(hm1.containsKey(c)){
                hm1=hm1.get(c);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */