package Entity;

public class Subscribers extends User{
    public Subscribers(String id, String name, String sex){
        super(id,name, sex);
    }
    public Subscribers( String name, String sex){
        super(name, sex);
    }

    public Subscribers(String name) {
        super(name);
    }
}
