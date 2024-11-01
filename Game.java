package GameLab;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        runGame();
    }

    static ArrayList<Item> inventory = new ArrayList<Item>();

    public static Room currentRoom = World.buildWorld();

    public static Room getRoom(){
        return currentRoom;
    }

    public static void print(Object obj) {
        System.out.println(obj.toString());
    }

    public static Item getItem2(String name){
        for(Item c : inventory){
            if(c.getN().equals(name)){
                return c;
            }
        }
        return null;
    }

    public static void runGame() {
       // Room currentRoom = World.buildWorld();
        Scanner input = new Scanner(System.in);

        String command;
        do {
            System.out.println(currentRoom);
            System.out.print("Where do you want to go? ");
            command = input.nextLine();
            String[] words = command.split(" ");//split method

            switch(words[0]/* arraylist inventory */) {
                case "e":
                case "w":
                case "n":
                case "s":
                case "u":
                case "d":
                    currentRoom = currentRoom.getExit(command.charAt(0));
                    break;

                case "x":
                    System.out.println("Bye! Thanks for walking through my game.");
                    break;

                case "t":
                    Item i = currentRoom.getItem(words[1]);
                    if(currentRoom.getItem(words[1]) == null){
                        System.out.println("No items taken\n");
                    }
                    else{
                        inventory.add(currentRoom.getItem(words[1]));
                        System.out.println("You try to pick up "+words[1]); //new
                        System.out.println("You pick up the " +i.getD()+"\n");
                        currentRoom.removeItem(words[1]);
                    }
                    break;

                case "i":
                    if(inventory.size() == 0){
                        System.out.println("Inventory empty");
                    }
                    else{
                        for(Item item : inventory){
                            System.out.println(item +"\n");
                        }
                    }
                    break;

                case "l": //look at items in inventory and the room
                if(currentRoom.getItem(words[1]) != null){
                    System.out.println(currentRoom.getItem(words[1]).getD() + "\n");
                }
                else{
                    boolean found = false;

                    for(Item c : inventory){
                        if(c.getN().equals(words[1])){
                            System.out.println(c.getD() + "\n");
                            found = true;      
                        }
                    }

                    if(found == false)
                        System.out.println("There is no such item.\n");
                }
                break;

                case "use":
                    System.out.println("You try to use the " + words[1]+".");

                    if(currentRoom.getItem(words[1]) != null){
                        currentRoom.getItem(words[1]).use();
                    }

                    else{
                        if(getItem2(words[1]) == null){
                            System.out.println("There is no item.");
                        }
                        else{
                            getItem2(words[1]).use();
                            System.out.println();
                            }
                        }
                    break;
        
                    case "o":
                    System.out.println("You try to open the " + words[1]+".");

                    if(currentRoom.getItem(words[1]) != null){
                        currentRoom.getItem(words[1]).open();
                    }

                    else{
                        if(getItem2(words[1]) == null){
                            System.out.println("There is no item.");
                        }
                        else{
                            getItem2(words[1]).open();
                            System.out.println();
                            }
                        }
                    break;
                    
                default:
                System.out.println("I don't know what you mean.");
                }
            } while(!command.equals("x"));
        
            input.close();
        }
     }










     //System.out.println(currentRoom);
//System.out.println("\nNow we'll move east!");
//currentRoom = currentRoom.getExit('e');
//System.out.println(currentRoom);
//System.out.println("\nNow we'll move west!");
//currentRoom = currentRoom.getExit('w');
//System.out.println(currentRoom);