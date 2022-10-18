package com.junxiao.heap;

import java.util.*;

public class TopKwords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for(String str: words) {
            Integer count  = map.get(str);
            if(count == null || count < 1) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, (a, b) ->  {
            if (a.getValue() < b.getValue()) {
                return  1;
            } else if (a.getValue() > b.getValue()) {
                return -1;
            }else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        List<String> res = new ArrayList<>();
        while(k > 0) {
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}
