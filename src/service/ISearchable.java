package service;

import java.util.ArrayList;

public interface ISearchable<T> {

    ArrayList<T> searchByName(String keyword);
}
