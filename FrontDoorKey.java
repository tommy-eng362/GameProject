public class FrontDoorKey extends Item{

    public FrontDoorKey(String in, String id){
        super("entrancekey", "The key to escape.");
    }

    public void use(){
        if(Game.currentRoom.getExit('s') == null){
            Game.print("Use the key in the entrance");
        }
        else if(Game.currentRoom.getExit('s').getName().equals("entrance")){
            Game.print("You use the key to open the entrance door.");
            Game.currentRoom.getExit('s').setLock(false);
        }
        else{
            Game.print("Use the key on the entrance door.");
        }

    }

}