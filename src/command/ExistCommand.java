package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;


public class ExistCommand extends Command{
	public ExistCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request,response);
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmployeeId(request.getParameter("empno"));
		emp.setName(request.getParameter("name"));
		boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
		if(exist) {
			System.out.println("접속가능");
		}else {
			System.out.println("접속불가");
			super.setDomain("home");
			super.setPage("main");
			super.execute();
		}
		System.out.println("ExistComman 내부:"+Receiver.cmd.getView());
	}
}
