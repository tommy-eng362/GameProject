import java.util.HashMap;

public class Room {

    private String description;
    private String name;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private Item i;
    private HashMap<String,Item> inven = new HashMap<>();
    public boolean lock = false;

    public Room(String describe, String name) {
    description = describe;
    this.name = name;
    }

    public Room getExit(char direct) {
    if (direct == 'e') {
    return east;
    }

    else if (direct == 'w') {
    return west;
    }

    else if (direct == 'n') {
    return north;
    }

    else if (direct == 's') {
    return south;
    }

    else if (direct == 'u') {
    return up;
    }

    else if (direct == 'd') {
    return down;
    }

    else {
    return null;
    }
}

public void addExit(char direct, Room robject) {
    if (direct == 'e') {
    east = robject;
    }
    else if (direct == 'w') {
    west = robject;
    }
    else if (direct == 'n') {
    north = robject;
    }
    else if (direct == 's') {
    south = robject;
    }
    else if (direct == 'u') {
    up = robject;
    }
    else if (direct == 'd') {
    down = robject;
    }
    else {
    robject = null;
    }
}

public String toString() {
    return description;
} 

public void setItem(Item i){
    this.i = i;
    inven.put(i.getN(),i);
}

public Item getItem(String name){
    return inven.get(name);
}

public Item takeItem(){
    Item it = i;
    i = null;
    return it;
}

public void removeItem(String name) {
    inven.remove(name);
}

public void setLock(boolean lock){
    this.lock = lock; //variable lock is now true
}

public boolean getLock(){
    return lock;
}

public void setName(String name){
    this.name = name;
}

public String getName(){
    return name;
}


}