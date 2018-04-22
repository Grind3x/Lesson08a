package com.gmail.grind3x.DAO.Impl;

import com.gmail.grind3x.DAO.DataBaseDAO;
import com.gmail.grind3x.DataBase;

import java.io.*;

public class DataBaseDAOFileImplementation implements DataBaseDAO {
    @Override
    public void saveDataBase(DataBase dataBase) {
        if (dataBase == null) {
            throw new IllegalArgumentException("Null Data Base!");
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataBase.getName()))) {
            oos.writeObject(dataBase);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public DataBase loadDataBaseByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null Data Base name!");
        }
        DataBase db = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name))) {
            db = (DataBase)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return db;
    }
}
