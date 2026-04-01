package service;

import java.util.ArrayList;
import model.Person;

public class GenericService<T extends Person> implements ICrudGenericService<T> {

    protected ArrayList<T> list = new ArrayList<>();

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void update(int id, T newT) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.set(i, newT);
                return;
            }
        }
        System.out.println("Khong tim thay ID");
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                return;
            }
        }
        System.out.println("Khong tim thay ID");
    }

    @Override
    public ArrayList<T> getAll() {
        return list;
    }
}
