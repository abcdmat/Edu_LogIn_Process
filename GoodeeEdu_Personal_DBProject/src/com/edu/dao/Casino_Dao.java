package com.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.db.Casino_DB;
import com.edu.dto.Casino_Dto;

public class Casino_Dao extends Casino_DB {
	//TODO 회원가입/ 로그인/ 삭제 /ID/PW 찾기 	
	/* 로그인정보에서 가장 뒤의 JOB에 따라서 직급이 정해진다. (default) p - 플레이어 a- admin 
	 *  핸드폰 번호나 email을 가지고 아이디, 비밀번호 찾기 가능
	 * */
	
	/*
	 * 회원가입시 가장 뒤의 JOB FLAG를 디폴트 값으로 입력되도록 생성해야한다. 디폴트 값은 'P'로 플레이어를 나타낸다.
	 * 친구 ID 입력시 친구에게 500의 머니 증정( 친구아이디가 없으면 없다고 나오게 하라)
	 * 회원가입할때 ID ,PW, NAME, PHONE, EMAIL + 친구아이디 선택입력
	 * 로그인후 P냐 A냐에 따라서 다른 작업이 가능
	 */
	
	//회원가입
	public boolean signIn(Casino_Dto dto)  {
		int result = 0;
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO CASINODB ( SEQ, ID, PW, NAME, PHONE, EMAIL, REGISTER_DATE, FRIEND_ID, JOB) "
										+ "VALUES (CASINO_SEQ.NEXTVAL, ? , ? , ? , ? , ?, sysdate, ?, 'P')";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getID());
			stmt.setString(2, dto.getPW());
			stmt.setString(3, dto.getNAME());
			stmt.setString(4, dto.getPHONE());
			stmt.setString(5, dto.getEMAIL());

			stmt.setString(6, dto.getFRIEND_ID());				
			
			
			result = stmt.executeUpdate();
			if(result == 0 ) {
				drawSomeThing("회원가입에 실패했습니다. 다시 시도해주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return (result == 0)? true : false;
	}
	
	//아이디, 패스워드, 이메일, 핸드폰 번호, 친구아이디를 각각 확인하는 매서드
	public boolean checkID(String iD)  {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB  WHERE ID = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, iD);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
			if(data == null ) {
				drawSomeThing("없는아이디입니다. 다시 입력해 주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (data ==null) ? true: false;
	}
	public boolean checkPW(Casino_Dto dto) {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB  WHERE PW = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getPW());
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (rs==null) ? true: false;
	}
	public boolean checkEmail(String email)  {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB  WHERE EMAIL = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
			if(data != null ) {
				drawSomeThing("이미 가입된 이메일 입니다. 다른 이메일 주소를 입력하세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (data!=null) ? true: false;
	}
	public boolean checkPhone(String phone) {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB  WHERE PHONE = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, phone);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
			if(data != null ) {
				drawSomeThing("이미 가입된 핸드폰 번호입니다 다른 번호를 입력해 주세요" );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (data!=null) ? true: false;
	}
	public boolean checkFID(String fId)  {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB  WHERE ID = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, fId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
			if(data == null ) {
				drawSomeThing("친구 아이디가 없습니다. 다시 입력해 주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (data==null) ? true: false;
	}
	//로그인
	public Casino_Dto login(Casino_Dto dto) {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB WHERE ID = ? AND PW = ?";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getID());
			stmt.setString(2, dto.getPW());
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return data;
	}
	public ArrayList<Casino_Dto> selectAll(){
		ArrayList<Casino_Dto>dtoList = new ArrayList<Casino_Dto>();
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto dto;
		String sql = "SELECT * FROM CASINODB c";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 dto = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						) ;
				 dtoList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		
		return dtoList;
	}
	
	public Casino_Dto findID(String iD) {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB WHERE ID = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, iD);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return data;
	}
	
	public String findID(String nAME, String eMAIL) {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB WHERE NAME = ? AND EMAIL = ?";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nAME);
			stmt.setString(2, eMAIL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return (data == null)? "null": data.getID();
	}

	public Casino_Dto findPW(String iD, String eMAIL) {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB WHERE ID = ? AND PHONE = ?";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, iD);
			stmt.setString(2, eMAIL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return data;
	}
	
	//회원가입용 아이디 체크 메서드
	public boolean checkID_SignIn(String iD)  {
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Casino_Dto data = null;
		String sql = "SELECT * FROM CASINODB  WHERE ID = ? ";
		sql.trim();
		sql= " ".concat(sql).concat(" ");
		
		try {
			conn= getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, iD);
			rs = stmt.executeQuery();
			while(rs.next()) {
				 data = new Casino_Dto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),						
						rs.getString(5),					
						rs.getString(6),
						rs.getString(7),						
						rs.getString(8),						
						rs.getString(9)
						);
			}
			if(data != null ) {
				drawSomeThing("이미 있는아이디 입니다. 다시 입력해 주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (data !=null) ? true: false;
	}
	
	public boolean checkSeq(int seq) {
		boolean isc= false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT FROM CASINODB e WHERE SEQ = ? ";
		sql.trim();
		sql = " ".concat(sql).concat(" ") ;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return isc;
	}
	
	public boolean delete(int seq) {
		boolean isc= false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM CASINODB e WHERE SEQ = ? ";
		sql.trim();
		sql = " ".concat(sql).concat(" ") ;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, seq);
			isc = stmt.execute();
			if(isc=false) {
				drawSomeThing("해당 아이디는 없습니다. 다른 아이디를 찾아주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		
		
		return isc;
	}
	public boolean updatepW(String pW , String iD) {
		boolean isc = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE CASINODB SET PW = ? WHERE ID = ?";
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pW);
			stmt.setString(2, iD);
			isc = stmt.execute();
			if(isc) {
				drawSomeThing("업데이트가 실행되지 않았습니다. 다시 시도해 주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isc;
	}
	
	public boolean updatEMail(String eMail , String iD) {
		boolean isc = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE CASINODB SET EMAIL = ? WHERE ID = ?";
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, eMail);
			stmt.setString(2, iD);
			isc = stmt.execute();
			if(isc) {
				drawSomeThing("업데이트가 실행되지 않았습니다. 다시 시도해 주세요");
			} 
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closed(conn, stmt, rs);
			}
		return isc;
	}
	
	public boolean updatePhone(String Phone , String iD) {
		boolean isc = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "UPDATE CASINODB SET PHONE = ? WHERE ID = ?";
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Phone);
			stmt.setString(2, iD);
			isc = stmt.execute();
			if(isc) {
				drawSomeThing("업데이트가 실행되지 않았습니다. 다시 시도해 주세요");
			} 
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closed(conn, stmt, rs);
			}
		return isc;
	}
	
	private void drawSomeThing(String str) {
		try {
			Thread.sleep(200);
			System.err.println(str);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
