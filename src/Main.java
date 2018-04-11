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

        GroupFileDao gfd = new GroupFileDao();
        gfd.saveGroup(group);

        System.out.println(gfd.loadGroupByName("A-21"));

        }

    }

