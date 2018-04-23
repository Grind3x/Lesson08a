package com.gmail.grind3x.Controller;

import com.gmail.grind3x.DAO.GroupDAO;
import com.gmail.grind3x.Group;

public class GroupController {
    private GroupDAO groupDAO;

    public GroupController(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        if (groupDAO == null) {
            throw new IllegalArgumentException();
        }
        this.groupDAO = groupDAO;
    }

    public Group loadGroupByName (String groupName) {
        if (groupName == null) {
            throw new IllegalArgumentException();
        }
        return groupDAO.loadGroupByName(groupName);
    }

    public void saveGroup(Group group) {
        groupDAO.saveGroup(group);
    }
}
