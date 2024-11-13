public class World {
    // Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {

    Room entrRoom = new Room("You are at the entrance.", "entrance");
    Room livRoom = new Room("You are in the living room.","living room");
    Room diningRoom = new Room("You are in the dining room.", "dining room");
    Room kitchenRoom = new Room("You are in the kitchen.", "kitchen");
    Room bathRoom = new Room("You are in the bathroom", "bath room");
    Room basementRoom = new Room("You are in the basement", "basement");
    Room upStairs = new Room("You are upstairs", "upstairs");
    Room bedRoom = new Room("You are in the bedroom", "bed room");

    Item cup = new Item("cup", "plastic cup");
    Item tape = new Item("tape", "it's duct tape.");
    Item scissors = new Item("scissors", "old pair of scissors");
    Item mirror = new Item("mirror", "mirror");
    Item tvRemote = new Item("remote", "Tv remote.");
    Item blanket = new Item("blanket", "blanket");
    Item batteries = new Item("batteries", "batteries");

    Safe safe = new Safe("safe", "a large safe"); 
    Combination combination = new Combination("combination", "A combination of numbers. Possibly for a safe.");

    Vase vase = new Vase("vase", " A vase. Something is inside..."); //vase contains key
    Cane cane = new Cane("cane", "A sturdy walking cane."); //paired with vase

    entrRoom.addExit('e',livRoom);
    entrRoom.addExit('w',diningRoom);
    entrRoom.addExit('u',upStairs);
    entrRoom.setLock(false);

    livRoom.addExit('w',entrRoom);
    livRoom.addExit('n',kitchenRoom);
    livRoom.setItem(cane);
    livRoom.setItem(tvRemote);
    livRoom.setItem(blanket);
    livRoom.setLock(false);

    diningRoom.addExit('e',entrRoom);
    diningRoom.addExit('n',bathRoom);
    diningRoom.setItem(safe);
    diningRoom.setLock(false);

    bathRoom.addExit('s', diningRoom);
    bathRoom.setItem(mirror);
    bathRoom.setLock(false);

    kitchenRoom.addExit('s',livRoom);
    kitchenRoom.addExit('d',basementRoom);
    kitchenRoom.setItem(scissors);
    kitchenRoom.setItem(cup);
    kitchenRoom.setItem(tape);
    kitchenRoom.setLock(false);

    basementRoom.addExit('u', kitchenRoom);
    basementRoom.setItem(vase);
    basementRoom.setItem(batteries);
    basementRoom.setItem(combination);
    basementRoom.setLock(false);

    upStairs.addExit('n',bedRoom);
    upStairs.addExit('d',entrRoom);
    upStairs.setLock(false);

    bedRoom.addExit('s',upStairs);
    bedRoom.setLock(true);

    return entrRoom;
    }
}