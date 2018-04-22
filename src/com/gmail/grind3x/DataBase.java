package com.gmail.grind3x;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class DataBase implements Serializable {
    private String name;
    private Group[] groupArr;
    private int count;

    public DataBase() {
        count++;
        groupArr = new Group[0];
        name = "Base#" + count;
    }

    public boolean addGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }

        for (Group gr:groupArr) {
            if (gr.equals(group)) {
                return false;
            }
        }
        groupArr = Arrays.copyOf(groupArr, groupArr.length + 1);
        groupArr[groupArr.length - 1] = group;
        return true;
    }

    public Group getGroup(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        for (Group group : groupArr) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public boolean removeGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }
        if (isGroupInBase(group)) {
            for (int i = 0; i < groupArr.length; i++) {
                if (groupArr[i].equals(group)) {
                    groupArr[i] = null;
                }
            }

            for (int i = 0; i < groupArr.length; i++) {
                if (groupArr[i] == null && i != groupArr.length - 1) {
                    groupArr[i] = groupArr[i + 1];
                    groupArr[i + 1] = null;
                }
            }
            groupArr = Arrays.copyOfRange(groupArr, 0, groupArr.length - 2);
            return true;
        }
        return false;
    }

    public boolean isGroupInBase(Group group) {
        if (group == null) {
            throw new IllegalArgumentException();
        }

        for (Group gr : groupArr) {
            if (gr.equals(group)) {
                return true;
            }
        }
        return false;
    }

    public DataBase(Group[] groupArr) {
        this.groupArr = groupArr;
    }

    public Group[] getGroupArr() {
        return groupArr;
    }

    public void setGroupArr(Group[] groupArr) {
        this.groupArr = groupArr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataBase:" + Arrays.toString(groupArr) + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataBase dataBase = (DataBase) o;
        return count == dataBase.count &&
                Objects.equals(name, dataBase.name) &&
                Arrays.equals(groupArr, dataBase.groupArr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, count);
        result = 31 * result + Arrays.hashCode(groupArr);
        return result;
    }
}
