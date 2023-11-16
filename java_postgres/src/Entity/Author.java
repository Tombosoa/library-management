package Entity;

public class Author extends User{
    public Author(String id, String name, String sex){
        super(id, name, sex);
    }

    public Author(String name, String sex){
        super(name, sex);
    }

}
