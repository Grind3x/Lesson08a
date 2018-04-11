import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    int compareMode = 0;

    public StudentComparator(int compareMode) {
        this.compareMode = compareMode;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == o2) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else {
            switch (compareMode) {
                case 0:
                    return o1.getSecondName().compareTo(o2.getSecondName());
                case 1:
                    return o1.getFirstName().compareTo(o2.getFirstName());
                case 2:
                    return o1.getAge() > o2.getAge() ? 1 : -1;
                case 3:
                    return o1.isSex() ? 1 : -1;
                case 4:
                    return o1.getZach() > o2.getZach() ? 1 : -1;
                case 5:
                    return o1.getGroup().compareTo(o2.getGroup());
            }

        }
        return 0;
    }
}
