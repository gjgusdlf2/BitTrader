package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;
import service.EmployeeServiceImpl;
import sun.java2d.Spans;

public class CreateCommand extends Command{
	 public CreateCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request,response);
		EmployeeDTO emp = new EmployeeDTO();
		System.out.println("=======몇번일까요??=====");
		emp.setBirthDate(request.getParameter("birthday"));
		emp.setEmployeeId(request.getParameter("empno"));
		emp.setManager(request.getParameter("manager"));
		emp.setName(request.getParameter("name"));
		emp.setNotes(request.getParameter("desc"));
		emp.setPhoto(request.getParameter("photo"));
		EmployeeServiceImpl.getInstance().registEmployee(emp);
	}
}
