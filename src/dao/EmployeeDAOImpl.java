package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {
		return instance;
	}
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			String sql = EmployeeSQL.REGISTER.toString();
			Connection conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1) ? "입력성공" : "입력 실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<EmployeeDTO> selectEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO selectEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmployees() {
		int res = 0;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean b = false;
		System.out.println("=========블린=========");
		try {
			PreparedStatement ps =  DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(EmployeeSQL.ACCESS.toString());
			ps.setString(1, emp.getEmployeeId());
			ps.setString(2, emp.getName());
			ResultSet rs =  ps.executeQuery();
			System.out.println("==========들까?========");
			if(rs.next()){
				System.out.println("==========b======"+b);
				b = true;}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b; 
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

}
