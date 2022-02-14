package by.vlad.task2.util;

public class IdGenerator {
    private static Integer id = 1;
    private static IdGenerator instance;

    private IdGenerator(){

    }

    public static IdGenerator getInstance() {
        if (instance == null){
            instance = new IdGenerator();
        }
        return instance;
    }

    public Integer getId(){
        Integer currId = id;
        id = id + 1;
        return currId;
    }
}
