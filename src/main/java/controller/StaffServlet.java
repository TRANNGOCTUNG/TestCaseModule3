package controller;

import dao.StaffDao;
import model.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staff")
public class StaffServlet extends HttpServlet {
    private StaffDao staffDao;
    public void init() {
        staffDao = new StaffDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    showNewFrom(request,response);
                    break;
                case "edit":
                    showEditFrom(request,response);
                    break;
                case "delete":
                    deleteStaff(request,response);
                    break;
                default:
                    listStaff(request,response);
                    break;
            }
        }catch (SQLException e){
            throw new ServletException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    insertStaff(request,response);
                    break;
                case  "edit":
                    updateStaff(request,response);
                    break;
            }
        }catch ( SQLException e){
            throw new ServletException(e);
        }

    }
    private void listStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
        List<Staff> staffList = staffDao.selectAllStaff();
        request.setAttribute("staffList",staffList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showNewFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        Staff newStaff = staffDao.selectStaff(id);
        request.setAttribute("newStaff",newStaff);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request,response);
    }
    private void insertStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        double salary = request.getDateHeader("salary");
        String department_name = request.getParameter("department_name");
        Staff newUsers = new Staff(name,email,country,phone_number,salary,department_name);
        staffDao.insertStaff(newUsers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        requestDispatcher.forward(request,response);
    }
    private void updateStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        double salary = request.getDateHeader("salary");
        String department_name = request.getParameter("department_name");
        Staff user = new Staff(id,name,email,country,phone_number,salary,department_name);
        staffDao.updateStaff(user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
        requestDispatcher.forward(request,response);
    }
    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        staffDao.deleteStaff(id);
        List<Staff> staffList = staffDao.selectAllStaff();
        request.setAttribute("staffList",staffList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        requestDispatcher.forward(request,response);

    }
}
