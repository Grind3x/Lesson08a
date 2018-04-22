package com.gmail.grind3x.DAO;

import com.gmail.grind3x.Group;

public interface GroupDAO {
    public void saveGroup (Group group);
    public Group loadGroupByName (String groupName);
}

