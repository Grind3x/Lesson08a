package com.gmail.grind3x.DAO;

import com.gmail.grind3x.DataBase;

public interface DataBaseDAO {
    public void saveDataBase(DataBase dataBase);
    public DataBase loadDataBaseByName(String name);
}
