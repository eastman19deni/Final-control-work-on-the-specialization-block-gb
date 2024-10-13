package Menu;

import java.util.concurrent.atomic.AtomicInteger;

public class AnimalIndex {
       protected int index;

    public AnimalIndex() {
        this.index = 1;
    }

    public int getIndex(){
        return this.index;
    }

    public void upIndex (){
        index++;
    }
}
