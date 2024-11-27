public class Oldman extends NPC{

    public Oldman(String name, String description) {
        super("oldman", "An oldman sleeping on the couch.");
    }

    int count = 0;

        @Override
        public void talk() {
            if (count == 0){
                say("zzz...zzz...");
                String[] options = {
                    "Wake up the oldman.",
                    "Leave him alone."
                    };
                getResponse(options);
                count++;
            }
            else if (count == 1){
                say("zzzZZZ...zzz...\n");
                String[] options = {
                    "Wake him up AGAIN.",
                    "Leave him alone."
                    };
                getResponse(options);
                count++;
            }
            else{
                Game.print("You decide not to bother him anymore.\n");
            }
        }
        

        @Override
        public void response(int option) {
            if(count == 0){
                switch(option) {
                    case 1:
                    say("Huh! What's going on let me sleep!");
                    break;
                    case 2:
                    say("zzz...zzz...");
                    Game.print("The oldman continues to snore.");
                    break;
                }
            
            }
            else if(count == 1){
                switch(option) {
                    case 1:
                    say("What is it now! Not again, leave me alone.");
                    Game.print("The oldman throws his wallet at you. You pick it up.\n");
                    Item wallet = new Item("wallet", "you bothered the oldman for this.");
                    Game.inventory.add(wallet); //make a wallet class later.
                    break;

                    case 2:
                    say("zzzZZZ...zzzZZZ...");
                    Game.print("The oldman continues to snore.\n");
                    break;
                }
            }
        }

}
