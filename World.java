package GameLab;
public class World {
    // Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {

    Room entrRoom = new Room("You are at the entrance.");
    Room livRoom = new Room("You are in the living room.");
    Room diningRoom = new Room("You are in the dining room.");
    Room kitchenRoom = new Room("You are in the kitchen.");
    Room bathRoom = new Room("You are in the bathroom");
    Room basementRoom = new Room("You are in the basement");
    Room upStairs = new Room("You are upstairs");
    Room bedRoom = new Room("You are in the bedroom");

    Item bedroomKey = new Item("key", "bedroom key.");
    Item walkingCane = new Item("cane", "sturdy cane.");
    Item scissors = new Item("scissors", "old pair of scissors");
    Item mirror = new Item("mirror", "mirror");
    Item tvRemote = new Item("remote", "tv remote");
    Item blanket = new Item("blanket", "blanket");
    Item batteries = new Item("batteries", "batteries");
    
    entrRoom.addExit('e',livRoom);
    entrRoom.addExit('w',diningRoom);
    entrRoom.addExit('u',upStairs);

    livRoom.addExit('w',entrRoom);
    livRoom.addExit('n',kitchenRoom);
    livRoom.setItem(walkingCane);
    livRoom.setItem(tvRemote);
    livRoom.setItem(blanket);

    diningRoom.addExit('e',entrRoom);
    diningRoom.addExit('n',bathRoom);

    bathRoom.addExit('s', diningRoom);
    bathRoom.setItem(mirror);

    kitchenRoom.addExit('s',livRoom);
    kitchenRoom.addExit('d',basementRoom);
    kitchenRoom.setItem(scissors);

    basementRoom.addExit('u', kitchenRoom);
    basementRoom.setItem(bedroomKey);
    basementRoom.setItem(batteries);

    upStairs.addExit('n',bedRoom);
    upStairs.addExit('d',entrRoom);

    bedRoom.addExit('s',upStairs);

    return entrRoom;
    }
}