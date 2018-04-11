import com.google.gson.Gson;
import java.io.*;

public class GroupFileDao implements GroupDao {

    public GroupFileDao() {

    }

    @Override
    public void saveGroup(Group group) {
        try (PrintWriter pw = new PrintWriter(new File(group.getName() + ".json"))) {
            Gson gson = new Gson();
            pw.println(gson.toJson(group));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group loadGroupByName(String groupName) {
        Group newGroup = new Group(groupName);
        try(BufferedReader reader =  new BufferedReader(new FileReader(new File(groupName + ".json")))) {
            Gson gson = new Gson();
            newGroup = gson.fromJson(reader.readLine(), Group.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return newGroup;
    }
}
