package by.vlad.task2.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Integer, CustomArrayStatistic> paramMap = new HashMap<>();

    private Warehouse(){
    }

    public static Warehouse getInstance() {
        if (instance == null){
            instance = new Warehouse();
        }

        return instance;
    }

    public CustomArrayStatistic put(Integer key, CustomArrayStatistic value){
        return paramMap.put(key, value);
    }

    public CustomArrayStatistic get(Integer key){
        return paramMap.get(key);
    }

    public CustomArrayStatistic replace(Integer key, CustomArrayStatistic value){
        return paramMap.replace(key, value);
    }

    public CustomArrayStatistic remove(Integer key){
        return paramMap.remove(key);
    }
}
