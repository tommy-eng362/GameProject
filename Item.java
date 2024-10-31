package GameLab;

public class Item {
    private String iname;
    private String idescrip;

    public Item (String in, String id){
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
}
