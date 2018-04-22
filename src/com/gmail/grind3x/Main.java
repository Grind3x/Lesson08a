package com.gmail.grind3x;

import com.gmail.grind3x.Controller.DataBaseController;
import com.gmail.grind3x.Controller.GroupController;
import com.gmail.grind3x.DAO.DataBaseDAO;
import com.gmail.grind3x.DAO.GroupDAO;
import com.gmail.grind3x.DAO.Impl.DataBaseDAOFileImplementation;
import com.gmail.grind3x.DAO.Impl.GroupDAODataBaseImplementation;
import com.gmail.grind3x.DAO.Impl.GroupDAOJsonFileImplementation;

public class Main {
    public static void main(String[] args) {
        Group group = new Group("A-21");
        Student stOne = new Student("Иванов", "Иван", 18, true, 10000022);
        Student stTwo = new Student("Петров", "Василий", 17, true, 10000002);
        Student stThree = new Student("Сидорова", "Катерина", 18, false, 10000003);
        Student stFour = new Student("Заснежный", "Игор", 18, true, 10000004);
        Student stFive = new Student("Каптур", "Федор", 19, true, 10000005);
        Student stSix = new Student("Мухов", "Николай", 17, true, 10000006);
        Student stSeven = new Student("Золотая", "Виктория", 17, false, 10000007);
        Student stEight = new Student("Каменских", "Анастасия", 18, false, 10000008);
        Student stNine = new Student("Жуков", "Петр", 17, true, 10000009);
        Student stTen = new Student("Ларин", "Владислав", 18, true, 10000010);
        Student stEleven = new Student("Галкин", "Сергей", 17, true, 10000011);

        group.addStudent(stOne);
        group.addStudent(stTwo);
        group.addStudent(stThree);
        group.addStudent(stFour);
        group.addStudent(stFive);
        group.addStudent(stSix);
        group.addStudent(stSeven);
        group.addStudent(stEight);
        group.addStudent(stNine);
        group.addStudent(stTen);

        GroupDAO groupDaoJson = new GroupDAOJsonFileImplementation();
        GroupController controllerOne = new GroupController(groupDaoJson);
        controllerOne.saveGroup(group);
        System.out.println(controllerOne.loadGroupByName("A-21"));
        DataBase db = new DataBase();
        GroupDAO groupDaoDataBase = new GroupDAODataBaseImplementation(db);
        GroupController controllerTwo = new GroupController(groupDaoDataBase);
        controllerTwo.saveGroup(group);
        System.out.println(db);

        DataBaseDAO dbDao = new DataBaseDAOFileImplementation();
        DataBaseController dbController = new DataBaseController(dbDao);
        dbController.saveDataBase(db);
        DataBase dbTwo = dbController.loadDataBaseByName("Base#1");
        System.out.println(dbTwo);
        }

    }

