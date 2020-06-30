package com.example.mode.strategy;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StrategyFactory {
    static ConcurrentHashMap<String,StrategyEnum2> map = null;
    static {
        map = new ConcurrentHashMap<String,StrategyEnum2>();
        map.put("+",StrategyEnum2.ADD);
        map.put("-",StrategyEnum2.SUB);
    }
    static StrategyEnum2 getStrategy(String str){
        return map.get(str);
    }
}
