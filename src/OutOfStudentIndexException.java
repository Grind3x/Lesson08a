public class OutOfStudentIndexException extends Exception {

    @Override
    public String getMessage() {
        return "Going beyond the Student Array";
    }

}
