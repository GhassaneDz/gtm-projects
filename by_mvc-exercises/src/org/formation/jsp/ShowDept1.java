package org.formation.jsp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/show-departement-1")
public class ShowDept1 extends HttpServlet {
 
	private DeptNumService deptNumMapper = new NumDeptMapper();
  
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String deptNum = request.getParameter("dept-num");

    if (deptNum == null) {
      deptNum = "";
    }
    
    deptNum = deptNum.trim();
    
    String deptName = deptNumMapper.findDept(deptNum);
    DeptPair deptInfo = new DeptPair(deptNum, deptName);
    request.setAttribute("deptInfo1", deptInfo);
    
    
    String address;
    if (deptNum.isEmpty()) {
      address = "/WEB-INF/results/missing-num.jsp";
    } else if (deptName != null) {
      address = "/WEB-INF/results/show-departement-1.jsp";
    } else {
      address = "/WEB-INF/results/unknown-num-1.jsp";
    }
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
