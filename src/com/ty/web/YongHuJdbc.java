package com.ty.web;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class YongHuJdbc {
    public List<YongHu> chaxun() {
        List <YongHu> yonghulist=new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wubiaoliancha", "root", "");
            String sql="select yonghu.id yhid,yonghu.title yhtitle,jiaose.id jsid,jiaose.title jstitle,quanxian.id qxid,quanxian.title qxtitle from yonghu,jiaose,jiaosequanxianbiao,quanxian,yonghujiaosebiao\n" +
                    "  where yonghu.id=yonghujiaosebiao.yonghuid\n" +
                    "  and jiaose.id=yonghujiaosebiao.jiaoseid\n" +
                    "  and jiaose.id=jiaosequanxianbiao.jiaoseid\n" +
                    "  and quanxian.id=jiaosequanxianbiao.quanxianid order by yhid,jsid";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i=0;
            int yhid=0;
            int jsid=0;
            YongHu yongHu=null;
            JiaoSe jiaoSe=null;
            List <JiaoSe> jiaoselist=new ArrayList();
            List <QuanXian> quanxianlist=new ArrayList();
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
                    quanxianlist.add(quanXian);
                    yhid=yongHu.getId();
                    jsid=jiaoSe.getId();
                }
                if(yhid==rs.getInt("yhid")&&jsid==rs.getInt("jsid")&&i>0){
                    QuanXian quanXian=new QuanXian();
                    quanXian.setId(rs.getInt("qxid"));
                    quanXian.setTitle(rs.getString("qxtitle"));
                    quanxianlist.add(quanXian);
                }
                if(jsid!=rs.getInt("jsid")){
                    jiaoSe.setQuanXianList(quanxianlist);
                    jiaoselist.add(jiaoSe);
                    quanxianlist=new ArrayList();
                    jiaoSe=new JiaoSe();
                    jiaoSe.setId(rs.getInt("jsid"));
                    jiaoSe.setTitle(rs.getString("jstitle"));

                    QuanXian quanXian=new QuanXian();
                    quanXian.setId(rs.getInt("qxid"));
                    quanXian.setTitle(rs.getString("qxtitle"));
                    quanxianlist.add(quanXian);
                    jsid=jiaoSe.getId();
                }
                if(yhid!=rs.getInt("yhid")){
                    yongHu.setJiaoseList(jiaoselist);
                    yonghulist.add(yongHu);

                    jiaoselist=new ArrayList();

                    yongHu=new YongHu();
                    yongHu.setId(rs.getInt("yhid"));
                    yongHu.setTitle(rs.getString("yhtitle"));
                    jiaoSe=new JiaoSe();
                    jiaoSe.setId(rs.getInt("jsid"));
                    jiaoSe.setTitle(rs.getString("jstitle"));

                    yhid=yongHu.getId();
                    jsid=jiaoSe.getId();
                }
                i++;
            }
            jiaoSe.setQuanXianList(quanxianlist);
            jiaoselist.add(jiaoSe);
            yongHu.setJiaoseList(jiaoselist);
            yonghulist.add(yongHu);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yonghulist;
    }

    public static void main(String[] args) {
        List<YongHu> chaxun = new YongHuJdbc().chaxun();
        for(int i=0;i<chaxun.size();i++){
            System.out.println(chaxun.get(i).getTitle());
            for(int j=0;j<chaxun.get(i).getJiaoseList().size();j++){
                System.out.println(chaxun.get(i).getJiaoseList().get(j).getTitle());
                for(int x=0;x<chaxun.get(i).getJiaoseList().get(j).getQuanXianList().size();x++){
                    System.out.println(chaxun.get(i).getJiaoseList().get(j).getQuanXianList().get(x).getTitle());
                }
            }
        }
    }
}
