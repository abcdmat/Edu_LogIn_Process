package com.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.db.Casino_DB;
import com.edu.dto.Casino_Dto;

public class Casino_Dao extends Casino_DB {
	//TODO ȸ������/ �α���/ ���� /ID/PW ã�� 	
	/* �α����������� ���� ���� JOB�� ���� ������ ��������. (default) p - �÷��̾� a- admin 
	 *  �ڵ��� ��ȣ�� email�� ������ ���̵�, ��й�ȣ ã�� ����
	 * */
	
	/*
	 * ȸ�����Խ� ���� ���� JOB FLAG�� ����Ʈ ������ �Էµǵ��� �����ؾ��Ѵ�. ����Ʈ ���� 'P'�� �÷��̾ ��Ÿ����.
	 * ģ�� ID �Է½� ģ������ 500�� �Ӵ� ����( ģ�����̵� ������ ���ٰ� ������ �϶�)
	 * ȸ�������Ҷ� ID ,PW, NAME, PHONE, EMAIL + ģ�����̵� �����Է�
	 * �α����� P�� A�Ŀ� ���� �ٸ� �۾��� ����
	 */
	
	//ȸ������
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
				drawSomeThing("ȸ�����Կ� �����߽��ϴ�. �ٽ� �õ����ּ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
		}
		return (result == 0)? true : false;
	}
	
	//���̵�, �н�����, �̸���, �ڵ��� ��ȣ, ģ�����̵� ���� Ȯ���ϴ� �ż���
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
				drawSomeThing("���¾��̵��Դϴ�. �ٽ� �Է��� �ּ���");
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
				drawSomeThing("�̹� ���Ե� �̸��� �Դϴ�. �ٸ� �̸��� �ּҸ� �Է��ϼ���");
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
				drawSomeThing("�̹� ���Ե� �ڵ��� ��ȣ�Դϴ� �ٸ� ��ȣ�� �Է��� �ּ���" );
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
				drawSomeThing("ģ�� ���̵� �����ϴ�. �ٽ� �Է��� �ּ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closed(conn, stmt, rs);
			
		}
		return (data==null) ? true: false;
	}
	//�α���
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
	
	//ȸ�����Կ� ���̵� üũ �޼���
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
				drawSomeThing("�̹� �ִ¾��̵� �Դϴ�. �ٽ� �Է��� �ּ���");
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
				drawSomeThing("�ش� ���̵�� �����ϴ�. �ٸ� ���̵� ã���ּ���");
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
				drawSomeThing("������Ʈ�� ������� �ʾҽ��ϴ�. �ٽ� �õ��� �ּ���");
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
				drawSomeThing("������Ʈ�� ������� �ʾҽ��ϴ�. �ٽ� �õ��� �ּ���");
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
				drawSomeThing("������Ʈ�� ������� �ʾҽ��ϴ�. �ٽ� �õ��� �ּ���");
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
