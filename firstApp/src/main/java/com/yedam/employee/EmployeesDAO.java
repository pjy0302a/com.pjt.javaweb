package com.yedam.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesDAO {
	// Sqlite 연결정보
	String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";

	// 각 메서드에서 공통적으로 사용하는 필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 싱글톤
	private static EmployeesDAO instance = new EmployeesDAO();

	private EmployeesDAO() {
	}

	public static EmployeesDAO getInstance() {
		return instance;
	}

	// JDBC Driver 로딩
	// DB 서버 접속
	// -> connect() 메서드

	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,"hr","hr");
		} catch (Exception e) {
			System.out.println("DB 접속 실패");
		}
	}

	// 자원해제 -> disconnect() 메서드
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("정상적으로 자원이 해제되지 않았습니다.");
		}
	}

	// PreparedStatement 객체 생성
	// SQL 실행
	// 결과값 출력 or 연산
	// -> 각 CRUD 메서드로 반복적으로 사용
	
	//jobs
	public List<HashMap<String, String>> selectJobs(){
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		try {
			connect();
			String select = "SELECT * FROM JOBS ORDER BY JOB_ID";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("jobId",rs.getString("JOB_Id"));
				map.put("jobTitle",rs.getString("JOB_Title"));
				list.add(map);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	// 전체조회
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM employees ORDER BY employee_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getString("commission_pct"));
				emp.setManagerId(rs.getString("manager_id"));
				emp.setDepartmentId(rs.getString("department_id"));

				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	// 단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = null;
		try {
			connect();
			String select = "SELECT * FROM employees WHERE employee_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();

				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_Number"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setJobId(rs.getString("job_Id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getString("commission_pct"));
				emp.setManagerId(rs.getString("manager_id"));
				emp.setDepartmentId(rs.getString("department_id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return emp;

	}
	
	// 등록
	public void insert(Employee emp) {
		try {
			connect();
			String insert = "INSERT INTO employees (employee_id, last_name, email, job_id, hire_date) "
					+ "VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1,emp.getEmployeeId());
			//pstmt.setString(2, emp.getFirstName());
			pstmt.setString(2,emp.getLastName());
			pstmt.setString(3, emp.getEmail());
			//pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setString(4, emp.getJobId());
			pstmt.setString(5, emp.getHireDate());
			//pstmt.setInt(8, emp.getSalary());
			//pstmt.setString(9,emp.getCommissionPct());
			//pstmt.setString(10,emp.getManagerId());
			//pstmt.setString(11,emp.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 등록되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 수정
	public void update(Employee emp) {
		try {
			connect();
			String update = "UPDATE employees SET salary = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			
			pstmt.setInt(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 수정되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	// 삭제
	public void delete(int employeeId) {
		try {
			connect();
			String delete = "DELETE FROM employees WHERE employee_id";
			pstmt = conn.prepareStatement(delete);
			
			pstmt.setInt(1, employeeId);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 삭제 되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		};
	}
}
