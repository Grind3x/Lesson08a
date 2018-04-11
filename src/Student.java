import java.io.Serializable;
import java.util.Objects;

public class Student extends Human implements Serializable {
        private String group;
        private long zach;

    public Student() {

    }

    public Student(String secondName, String firstName, int age, boolean sex, long zach) {
        super(secondName, firstName, age, sex);
        this.zach = zach;
    }

    public long getZach() {
        return zach;
    }

    public void setZach(long zach) {
        this.zach = zach;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;


        return Objects.equals(this.getFirstName(), student.getFirstName()) &
                Objects.equals(this.getSecondName(), student.getSecondName()) &
                Objects.equals(this.getAge(), student.getAge()) &
                Objects.equals(this.isSex(), student.isSex()) &
                Objects.equals(group, student.group) &
                Objects.equals(zach, student.zach);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.getFirstName(), this.getSecondName(), this.getAge(), this.isSex(), zach, group);
    }

    @Override
    public String toString() {
        return super.getSecondName() + " " + super.getFirstName() + ", зч №" + this.getZach() ;
    }
}
