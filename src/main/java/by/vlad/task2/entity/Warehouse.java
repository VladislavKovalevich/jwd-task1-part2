package by.vlad.task2.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Integer, CustomArrayParameter> paramMap = new HashMap<>();

    private Warehouse(){
    }

    public static Warehouse getInstance() {
        if (instance == null){
            instance = new Warehouse();
        }

        return instance;
    }

    public CustomArrayParameter put(Integer key, CustomArrayParameter value){
        return paramMap.put(key, value);
    }

    public CustomArrayParameter get(Integer key){
        return paramMap.get(key);
    }

    public CustomArrayParameter replace(Integer key, CustomArrayParameter value){
        return paramMap.replace(key, value);
    }

    public CustomArrayParameter remove(Integer key){
        return paramMap.remove(key);
    }
}
