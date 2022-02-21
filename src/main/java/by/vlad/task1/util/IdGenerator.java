package by.vlad.task1.util;

public class IdGenerator {
    private Integer id = 1;
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
        Integer currId = this.id;
        this.id = this.id + 1;
        return currId;
    }
}
