import com.ty.web.YongHu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangGuanServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
            if (op.equals("chaxun")) {
                chaxun(req,resp);
        }
    }
    public  void chaxun(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChangGuanInfo> cglist = new ChangGuanJdbc().chaxun();
        req.setAttribute("cglist", cglist);
        req.getRequestDispatcher("/changguan.jsp").forward(req, resp);
    }
 }
