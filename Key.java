

public class Key extends Item{

    public Key(String in, String id){
        super("key", "A key to the bedroom.");
    }

    public void use(){
        if(currentRoom.getExit('n') == null){
            Game.print("Use the key on the bedroom.");
        }
        else if(currentRoom.getExit('n').getName().equals("bed room")){
            Game.print("You use the key to open the bedroom door.");
            currentRoom.getExit('n').setLock(false);
        }
        else{
            Game.print("Use the key on the bedroom.");
        }

    }
}