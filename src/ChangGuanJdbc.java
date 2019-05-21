import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangGuanJdbc {
        public List<ChangGuanInfo> chaxun(){
            List <ChangGuanInfo> changGuanList=new ArrayList();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiyu", "root", "");
                String sql="select guandibiao.id gdid,guandibiao.title gdtitle,changdibiao.id cdid,changdibiao.title cdtitle from " +
                        " guandibiao,changguanchangdibiao,changdibiao "+
                        "where guandibiao.id=changguanchangdibiao.changguanid and changguanchangdibiao.changdiid=changdibiao.id";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int i=0;
                int curid=0;
                ChangGuanInfo changGuanInfo=null;
                List <ChangDi> changDiList=new ArrayList();
                while (rs.next()){
                    if(i==0){
                        changGuanInfo=new ChangGuanInfo();
                        changGuanInfo.setId(rs.getInt("gdid"));
                        changGuanInfo.setTitle(rs.getString("gdtitle"));
                        ChangDi changDi=new ChangDi();
                        changDi.setTitle(rs.getString("cdtitle"));
                        changDi.setId(rs.getInt("cdid"));
                        changDiList.add(changDi);
                        curid=changGuanInfo.getId();
                    }
                    if(curid==rs.getInt("gdid")&&i>0){
                        ChangDi changDi=new ChangDi();
                        changDi.setTitle(rs.getString("cdtitle"));
                        changDi.setId(rs.getInt("cdid"));
                        changDiList.add(changDi);
                    }
                    if(curid!=rs.getInt("gdid")){
                        changGuanInfo.setChangDiList(changDiList);
                        changGuanList.add(changGuanInfo);
                        changDiList=new ArrayList();
                        changGuanInfo=new ChangGuanInfo();
                        changGuanInfo.setId(rs.getInt("gdid"));
                        changGuanInfo.setTitle(rs.getString("gdtitle"));
                        ChangDi changDi=new ChangDi();
                        changDi.setTitle(rs.getString("cdtitle"));
                        changDi.setId(rs.getInt("cdid"));
                        changDiList.add(changDi);
                        curid=changGuanInfo.getId();
                    }
                    i++;
                }
                changGuanInfo.setChangDiList(changDiList);
                changGuanList.add(changGuanInfo);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return changGuanList;
        }
    public static void main(String[] args) {
        ChangGuanJdbc changGuanJdbc=new ChangGuanJdbc();
        List<ChangGuanInfo> cglist = changGuanJdbc.chaxun();
        for(int i=0;i<cglist.size();i++){
            System.out.println(cglist.get(i).getTitle());
        for(int x=0;x<cglist.get(i).getChangDiList().size();x++){
            System.out.println("场地:"+cglist.get(i).getChangDiList().get(x).getTitle());
             }
        }
    }

}
