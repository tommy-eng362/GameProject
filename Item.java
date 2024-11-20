import java.io.Serializable;

public class Item extends Game implements Serializable  {
    private String iname;
    private String idescrip;

    public Item (String in, String id){
        super();
        iname = in;
        idescrip = id;
    }

    public void setN(String in) {
        iname = in;
    }

    public void setD(String id) {
        idescrip = id;
    }

    public String getN(){
        return iname;
    }

    public String getD(){
        return idescrip;
    }

    public String toString(){
        return iname;
    }

    public void open(){
        System.out.println("You can't open that!");
    }

    public void use(){
        System.out.println("You can't use that!");
    }
}
