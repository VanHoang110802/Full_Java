package service;

import java.util.ArrayList;

public interface ICrudGenericService<T> {

    void add(T t);

    void update(int id, T t);

    void delete(int id);

    ArrayList<T> getAll();
}
