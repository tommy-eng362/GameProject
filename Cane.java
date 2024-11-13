

public class Cane extends Item{

    public Cane(String in, String id){
        super("cane", "A sturdy walking cane.");
    }

    public void use(){
        if(getItem2("vase") == null){
            Game.print("You can't use the cane yet.");
        }

        else{
            Game.print("You use the cane to smash open the vase. You find a key inside the vase.");

            if(getItem2("key") == null){
                Key key = new Key("key", "bedroom key");
                inventory.add(key);
            }
        }
    }
}

