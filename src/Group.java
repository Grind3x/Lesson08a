import java.io.Serializable;
import java.util.*;

public class Group implements Commissar, Serializable {
    private String name;
    private Student[] studentArr = new Student[10];
    private int stIndex = -1;

    public Group() {
        name = "defaultName";
    }

    public Group(String name) {
        this.name = name;
    }

    @Override
    public Student[] eighteenAgeOld() {
        Student[] stArr = Arrays.copyOf(studentArr, 10);
        for (int i = 0; i < stArr.length; i++) {
            if (stArr[i] != null) {
                if ((!stArr[i].isSex()) || (stArr[i].getAge() < 18)) {
                    stArr[i] = null;
                }
            }
        }
        Arrays.sort(stArr, Comparator.nullsLast(new StudentComparator(0)));
        return stArr;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (!isStudentInGroup(student)) {
            try {
                if (stIndex == 9) {
                    throw new OutOfStudentIndexException();
                }
                studentArr[++stIndex] = student;
                student.setGroup(this.getName());
            } catch (OutOfStudentIndexException e) {
                e.printStackTrace();
            }
        }
    }

    public void delStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        if (stIndex >= 0) {
            for (int i = 0; i < studentArr.length; i++) {
                if (student.equals(studentArr[i])) {
                    student.setGroup(null);
                    int k = i;
                    while (k < studentArr.length - 1) {
                        studentArr[k] = studentArr[k + 1];
                        studentArr[k + 1] = null;
                        k++;
                    }
                    break;
                }
            }
        }
    }

    public Student findStudentbySecondName(String secondName) {
        Student tmp = null;
        for (Student st : studentArr) {
            if (st != null) {
                if (secondName.equals(st.getSecondName())) {
                    tmp = st;
                    break;
                }
            }
        }
        return tmp;
    }

    public Student findStudentByZachNumber(Long zachNumber) {
        Student tmp = null;
        for (Student st : studentArr) {
            if (st != null) {
                if (zachNumber.equals(st.getZach())) {
                    tmp = st;
                    break;
                }
            }
        }
        return tmp;
    }

    public boolean isStudentInGroup(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        boolean retVal = false;
        for (Student st : studentArr) {
            if (student.equals(st)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }
    //TODO: Don't work. Repair later.
    public void interactiveAdd() {
        try {
            String fName = getFirstName();
            String sName = getSecondName();
            boolean sex = getSex();
            int age = getAge();
            long zach = getZach();
            Student student = new Student(sName, fName, age, sex, zach);
            addStudent(student);

            } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private String getFirstName() {
        System.out.println("Введите имя");
        Scanner sc = new Scanner(System.in);
        String fName = sc.nextLine();
        return fName;
    }

    private String getSecondName() {
        System.out.println("Введите Фамилию");
        Scanner sc = new Scanner(System.in);
        String sName = sc.nextLine();
        return sName;
    }

    //TODO: Don't work. Repair later.
    private int getAge() {
        System.out.println("Введите возраст");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        return age;
    }

    private boolean getSex() {
        String sSex = "";
        boolean sex = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите пол (муж/жен)");
            sSex = sc.nextLine();
            switch (sSex) {
                case ("муж"):
                    sex = true;
                    return sex;
                case ("жен"):
                    sex = false;
                    return sex;
            }
        } while (!sSex.equals("муж") | !sSex.equals("жен"));
        return false;
    }

    //TODO: Don't work. Repair later.
    private long getZach() {
        long zach = 0;
        boolean done = false;
        Scanner sc = new Scanner(System.in);
            for (; !done; ) {
                try {
                    System.out.println("Введите номер зачетки");
                    zach = sc.nextLong();
                    done = true;
                } catch (InputMismatchException e) {
                    e.printStackTrace();
            }
        }
        return zach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sort(int compareMode) {
        Arrays.sort(studentArr, Comparator.nullsLast(new StudentComparator(compareMode)));
    }

    public Student[] getStudentArr() {
        return studentArr;
    }

    public void setStudentArr(Student[] studentArr) {
        this.studentArr = studentArr;
    }

    @Override
    public String toString() {
        String retVal = "Список студентов:" + '\n';
        for (Student st : studentArr) {
            retVal += (st + "\n");
        }
        return retVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return stIndex == group.stIndex &&
                Objects.equals(name, group.name) &&
                Arrays.equals(studentArr, group.studentArr);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(name, stIndex);
        result = 31 * result + Arrays.hashCode(studentArr);
        return result;
    }
}
