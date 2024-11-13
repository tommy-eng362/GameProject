

public class Vase extends Item {

    public Vase(String in, String id){
        super("vase", "A vase");
    }

    public void use(){
        Game.print("You hear something inside. Try breaking it with something.");
    }
}
