package com.gmail.grind3x.Controller;

import com.gmail.grind3x.DAO.DataBaseDAO;
import com.gmail.grind3x.DataBase;

public class DataBaseController {
    private DataBaseDAO dataBaseDAO;

    public DataBaseController(DataBaseDAO dataBaseDAO) {
        this.dataBaseDAO = dataBaseDAO;
    }

    public DataBaseDAO getDataBaseDAO() {
        return dataBaseDAO;
    }

    public void setDataBaseDAO(DataBaseDAO dataBaseDAO) {
        this.dataBaseDAO = dataBaseDAO;
    }

    public DataBase loadDataBaseByName(String name){
        return dataBaseDAO.loadDataBaseByName(name);
    }

    public void saveDataBase (DataBase dataBase) {
        dataBaseDAO.saveDataBase(dataBase);
    }
}
