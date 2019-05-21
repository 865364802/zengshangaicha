import com.ty.web.JiaoSe;
import com.ty.web.QuanXian;
import com.ty.web.YongHu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestYongHuJdbc {
    public List <YongHu> chaxun(){
        List <YongHu> yhlist=new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wubiaoliancha", "root", "");
            String sql="select yonghu.id yhid,yonghu.title yhtitle,jiaose.id jsid,jiaose.title jstitle,quanxian.id qxid,quanxian.title qxtitle from yonghu,yonghujiaosebiao,jiaose,jiaosequanxianbiao,quanxian" +
                    " where yonghu.id=yonghujiaosebiao.yonghuid" +
                    " and jiaose.id=yonghujiaosebiao.jiaoseid" +
                    " and jiaose.id=jiaosequanxianbiao.jiaoseid" +
                    " and quanxian.id=jiaosequanxianbiao.quanxianid order by yhid,jsid";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i=0;
            int yhid=0;
            int jsid=0;
            YongHu yongHu=null;
            JiaoSe jiaoSe=null;
            List jslist=new ArrayList();

            List qxlist=new ArrayList();
            while (rs.next()){
                if(i==0){
                    yongHu=new YongHu();
                    yongHu.setId(rs.getInt("yhid"));
                    yongHu.setTitle(rs.getString("yhtitle"));
                    jiaoSe=new JiaoSe();
                    jiaoSe.setId(rs.getInt("jsid"));
                    jiaoSe.setTitle(rs.getString("jstitle"));
                    QuanXian quanXian=new QuanXian();
                    quanXian.setId(rs.getInt("qxid"));
                    quanXian.setTitle(rs.getString("qxtitle"));
                    qxlist.add(quanXian);
                    yhid=yongHu.getId();
                    jsid=jiaoSe.getId();
                }
                if(yhid==rs.getInt("yhid")&&jsid==rs.getInt("jsid")&&i>0){
                    QuanXian quanXian=new QuanXian();
                    quanXian.setId(rs.getInt("qxid"));
                    quanXian.setTitle(rs.getString("qxtitle"));
                    qxlist.add(quanXian);
                }
                if(yhid==rs.getInt("yhid")&&jsid!=rs.getInt("jsid")){
                    jiaoSe.setQuanXianList(qxlist);
                    jslist.add(jiaoSe);

                    qxlist=new ArrayList();

                    yongHu=new YongHu();
                    yongHu.setId(rs.getInt("yhid"));
                    yongHu.setTitle(rs.getString("yhtitle"));

                    QuanXian quanXian=new QuanXian();
                    quanXian.setId(rs.getInt("qxid"));
                    quanXian.setTitle(rs.getString("qxtitle"));
                    qxlist.add(quanXian);

                    jsid=jiaoSe.getId();
                }
                if(yhid!=rs.getInt("yhid")){
                    yongHu.setJiaoseList(jslist);
                    yhlist.add(yongHu);
                    jiaoSe.setQuanXianList(qxlist);
                    jslist.add(jiaoSe);

                    jslist=new ArrayList();
                    qxlist=new ArrayList();

                    yongHu=new YongHu();
                    yongHu.setId(rs.getInt("yhid"));
                    yongHu.setTitle(rs.getString("yhtitle"));
                    jiaoSe=new JiaoSe();
                    jiaoSe.setId(rs.getInt("jsid"));
                    jiaoSe.setTitle(rs.getString("jstitle"));
                    QuanXian quanXian=new QuanXian();
                    quanXian.setId(rs.getInt("qxid"));
                    quanXian.setTitle(rs.getString("qxtitle"));
                    qxlist.add(quanXian);
                    yhid=yongHu.getId();
                    jsid=jiaoSe.getId();
                }
                i++;
            }
            yongHu.setJiaoseList(jslist);
            yhlist.add(yongHu);
            jiaoSe.setQuanXianList(qxlist);
            jslist.add(jiaoSe);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yhlist;
    }

    public static void main(String[] args) {
        List<YongHu> chaxun = new TestYongHuJdbc().chaxun();

        for(int i=0;i<chaxun.size();i++){
            System.out.println(chaxun.get(i).getTitle());
            for(int j=0;j<chaxun.get(i).getJiaoseList().size();j++){
                System.out.println(chaxun.get(j).getJiaoseList().get(j).getTitle());
                for(int x=0;x<chaxun.get(i).getJiaoseList().get(j).getQuanXianList().size();x++){
                    System.out.println(chaxun.get(i).getJiaoseList().get(j).getQuanXianList().get(x).getTitle());
                }
            }
        }
    }
}
