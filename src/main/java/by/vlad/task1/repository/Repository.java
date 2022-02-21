package by.vlad.task1.repository;

import by.vlad.task1.entity.CustomArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
    private List<CustomArray> repository = new ArrayList<>();
    private static Repository instance;

    private Repository(){
    }

    public static Repository getInstance() {
        if (instance == null){
            instance = new Repository();
        }

        return instance;
    }

    public void add(CustomArray customArray){
        repository.add(customArray);
    }

    public boolean remove(CustomArray customArray){
        return repository.remove(customArray);
    }

    public CustomArray get(int index){
        return repository.get(index);
    }

    public List<CustomArray> query(Specification specification){
        List<CustomArray> customArrays = repository.stream().filter(o -> specification.specify(o)).collect(Collectors.toList());
        return customArrays;
    }

    public List<CustomArray> sort(Comparator<CustomArray> comparator){
        List<CustomArray> customArrays = repository.stream().sorted(comparator).collect(Collectors.toList());
        return customArrays;
    }
}