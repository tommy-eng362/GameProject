

public class Combination extends Item {

    public Combination(String in, String id){
        super("combination", "A piece of paper with a combination");
    }

    public void use(){
        System.out.println("You found the combination to the safe! If you find the safe try opening it.");
    }
}
