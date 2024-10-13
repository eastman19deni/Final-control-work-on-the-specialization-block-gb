package Animals.Pets;

import Animals.BaseAnimal;

public abstract class Pets extends BaseAnimal {

    public Pets(String name, String type, int year, int month, int day, String commands) {
        super(name, type, year, month, day, commands);
    }
    
    public Pets(){
    }
}
