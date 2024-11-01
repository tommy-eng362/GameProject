package GameLab;

public class Safe extends Item {

    public Safe(String in, String id){
        super("safe", "A safe");
    }
    
    public void open(){
        
        if(getItem2("combination") == null){
            Game.print("The safe is locked and you don't have the combination.");
        }

        else{
            Game.print("Using the combination, you open the safe and find a diamond inside. Naturally, you pocket the diamond.");
            Item diamond = new Item("diamond", "a diamond ");
            inventory.add(diamond);
        }

        
    }
}
