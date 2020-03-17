package Play_with_Data_Structures.Demo10MaxHeap;


import java.util.*;
import java.util.PriorityQueue;

public class Solution2 {
    private class Freq implements Comparable<Freq>{
        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another){
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }


    // 改变java标准库中类的可变属性
    private class FreqComparator implements Comparator<Freq>{

        @Override
        public int compare(Freq a, Freq b){
             return a.freq - b.freq; // 谁的频率小，谁靠前
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
//        PriorityQueue<Freq> pq = new PriorityQueue<>(new Comparator<Freq>(){
//            @Override
//            public int compare(Freq a, Freq b){
//                 return a.freq - b.freq; // 谁的频率小，谁靠前
//            }
//        }); // 也只可以直接传递比较器
        for (int key : map.keySet()) {
            if (pq.size() < k)
                // 入队
                pq.add(new Freq(key, map.get(key)));
            // 比较队首元素
            else if (map.get(key) > pq.peek().freq){
                // 出队
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }
}
