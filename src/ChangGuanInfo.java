import java.util.ArrayList;
import java.util.List;

public class ChangGuanInfo {
    private int id;
    private String title;
    List <ChangDi> changDiList=new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChangDi> getChangDiList() {
        return changDiList;
    }

    public void setChangDiList(List<ChangDi> changDiList) {
        this.changDiList = changDiList;
    }
}
