package Operations;

import java.util.List;

public interface CrudOperations {
    public <T> List<T> findAll();
    public <T> List<T> saveAll(List<T> toSave);
     public <T> T save(T toSave);
     public <T> T delete(T toDelete);
}
