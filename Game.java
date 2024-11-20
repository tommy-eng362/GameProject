
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Game {
    public static void main(String[] args) {
        textfile();
        runGame();
    }

    public static void textfile(){ //load method (maybe)
        try {
            Scanner input = new Scanner(new File("RoomDescriptions.txt"));
            while(input.hasNextLine()) {
                Thread.sleep(1000); // sleep for 1 second
                String name = input.nextLine();
                String description = input.nextLine();
                

                if(!name.equals("#") && !description.equals("#")){
                    roomDescriptions.put(name,description);
                    System.out.println(name);
                    System.out.println(description);
                }
            }
            input.close();
        } 
        catch (FileNotFoundException e) {
        System.out.println("File not found!!!");
        } 
        catch (InterruptedException ex) {
            System.out.println("Bummer.");
        }
    }

    static ArrayList<Item> inventory = new ArrayList<Item>();
    public static HashMap<String, String> roomDescriptions = new HashMap<String,String>(); //key: room name, value: room description

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
                    Room nextRoom = currentRoom.getExit(command.charAt(0));
                    if(nextRoom == null){
                        System.out.println("There is no exit.");
                        break;
                    }

                    if (nextRoom.getLock() == true){
                        System.out.println("You cannot enter. The room is locked.");
                    }
                    else{
                        currentRoom = nextRoom;
                    }
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