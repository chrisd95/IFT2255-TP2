package Repositories;

import java.util.ArrayList;

public interface CrudRepository<T,ID> {
    public T find(ID id);
    public ArrayList<T> findAll();
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(ID id);
}
