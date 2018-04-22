package com.gmail.grind3x.DAO.Impl;

import com.gmail.grind3x.DAO.GroupDAO;
import com.gmail.grind3x.DataBase;
import com.gmail.grind3x.Group;

public class GroupDAODataBaseImplementation implements GroupDAO {
    private DataBase dataBase;

    public GroupDAODataBaseImplementation(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void saveGroup(Group group) {
        dataBase.addGroup(group);
    }

    @Override
    public Group loadGroupByName(String groupName) {
        return dataBase.getGroup(groupName);
    }
}
