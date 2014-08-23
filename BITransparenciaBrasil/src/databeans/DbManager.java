package databeans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.Constants;

public class DbManager {

	private Connection conn = null;
	private Connection conn2 = null;
	private Connection tconn = null;
	private static DbManager instance;

	private DbManager() {
		
	}

	public static DbManager getInstance() {
		if (instance == null) {
			instance = new DbManager();
			instance.getConnection();
		}

		return instance;
	}
	
	public static DbManager getCleanInstance() {
		if (instance == null) {
			instance = new DbManager();
		}
		return instance;
	}
	
	public CallableStatement executeProcedure(String sql) throws SQLException{
		 getConnection();
		 CallableStatement cs = conn.prepareCall(sql);
		 return cs;	
	}

	public int executeSimpleUpdate(String sql) throws SQLException {
		getConnection();
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(sql);
		stmt.close();
		return i;
	}

	public int executeSimpleUpdate(String sql, Connection connLocal) throws SQLException {
		Statement stmt = connLocal.createStatement();
		return stmt.executeUpdate(sql);
	}

	public ResultSet executeSimpleQuery(String sql) throws SQLException {
		getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
	}

	public Connection getConnection() {
		try {
			if ( !conexaoValida() ) {
				//System.out.println("Conexão com o banco inválida. Reiniciando...");
				Context initContext = new InitialContext();
				//DataSource ds = (DataSource) initContext.lookup("java:/comp/env/MySqlDS");
				DataSource ds = (DataSource) initContext.lookup(Constants.JNDI_DB_ACCESS);
				conn = ds.getConnection();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public Connection getNewConnection() {
		Connection tmp = null;
		try {
			Context initContext = new InitialContext();
			//DataSource ds = (DataSource) initContext.lookup("java:/comp/env/MySqlDS");
			DataSource ds = (DataSource) initContext.lookup(Constants.JNDI_DB_ACCESS);
			tmp = ds.getConnection();
			//tmp.setAutoCommit(false);
			return tmp;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			tmp = null;
		}
		return null;
	}
	
	public Connection getNamedConnection(String jndiName) {
		try {
			Context initContext = new InitialContext();
			//DataSource ds = (DataSource) initContext.lookup("java:/comp/env/MySqlDS");
			DataSource ds = (DataSource) initContext.lookup(jndiName);
			Connection tmp = ds.getConnection();
			//tmp.setAutoCommit(false);
			return tmp;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public PreparedStatement getPreparedStatement(String sql) {
		getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pstmt;
	}

	private boolean conexaoValida() {
		try {
			if (conn == null || conn.isClosed()) return false;
			Statement stmt = conn.createStatement();
			ResultSet tmp = stmt.executeQuery("SELECT 1 FROM DUAL");
			if (tmp.next()) {
				tmp.close();
				stmt.close();
				return true;
			}
			tmp.close();
			stmt.close();
		} catch (Exception ex) {
			//ex.printStackTrace();
			return false;
		}
		return false;
	}
	
	private boolean conexaoValida2() {
		try {
			if (conn2 == null) return false;
			Statement stmt = conn2.createStatement();
			ResultSet tmp = stmt.executeQuery("SELECT 1 FROM DUAL");
			if (tmp.next()) {
				tmp.close();
				stmt.close();
				return true;
			}
			tmp.close();
			stmt.close();
		} catch (Exception ex) {
			//ex.printStackTrace();
			return false;
		}
		return false;
	}

	public void clear() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			//Não foi possível fechar a conexão. Nada acontece neste ponto
			//Espera-se que a conexão seja fechada automaticamente em outro momento
			//CachedConnectionManager ?
		} finally {
			conn = null;
		}
	}
	
	public void clear2() {
		try {
			if (conn2 != null && !conn2.isClosed()) {
				conn2.close();
			}
		} catch (Exception e) {
			//Não foi possível fechar a conexão. Nada acontece neste ponto
			//Espera-se que a conexão seja fechada automaticamente em outro momento
			//CachedConnectionManager ?
		} finally {
			conn2 = null;
		}
	}

	public void connect() throws SQLException {
		try {
			//if ( !conexaoValida() ) {
				//System.out.println("Conexão com o banco inválida. Reiniciando...");
				Context initContext = new InitialContext();
				//DataSource ds = (DataSource) initContext.lookup("java:/comp/env/MySqlDS");
				DataSource ds = (DataSource) initContext.lookup(Constants.JNDI_DB_ACCESS);
				conn = ds.getConnection();
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void connect(String jndiName) throws SQLException {
		try {
			//if ( !conexaoValida2() ) {
				//System.out.println("Acessando DataSource = " + jndiName);
				Context initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup(jndiName);
				conn2 = ds.getConnection();
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		ResultSet rs = null;
		if (sql == null || sql.trim().length() == 0) {
			throw new IllegalArgumentException("Parametro de SQL Inválido");
		}
		try {
			if (!this.conexaoValida()) connect();

			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		if (sql == null || sql.trim().length() == 0) {
			throw new IllegalArgumentException("Parametro de SQL Inválido");
		}
		try {
			connect();

			Statement st = conn.createStatement();
			int i = st.executeUpdate(sql);
			st.close();
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	public ResultSet executeQuery(String sql, String jndiName) throws SQLException {
		ResultSet rs = null;
		if (sql == null || sql.trim().length() == 0) {
			throw new IllegalArgumentException("Parametro de SQL Inválido");
		}
		try {
			connect(jndiName);

			Statement st = conn2.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return rs;
	}

	public int executeUpdate(String sql, String jndiName) {
		if (sql == null || sql.trim().length() == 0) {
			throw new IllegalArgumentException("Parametro de SQL Inválido");
		}
		try {
			connect(jndiName);

			Statement st = conn2.createStatement();
			int i = st.executeUpdate(sql);
			st.close();
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}
	
	//Transaction -------------------------------------
	public Connection initTransaction() {
		try {
			
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup(Constants.JNDI_DB_ACCESS);
			tconn = ds.getConnection();
			tconn.setAutoCommit(false);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tconn;
	}
	
	public void commitTransaction() {
		if(validTransaction()) {
			try {
				tconn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					tconn.close();
					tconn = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public PreparedStatement getTransactPreparedStatement(String sql) {
		if (!validTransaction()) return null;
		PreparedStatement pstmt = null;
		try {
			pstmt = tconn.prepareStatement(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return pstmt;
	}
	
	public void rollbackTransaction() {
		if(validTransaction()) {
			try {
				tconn.rollback();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					tconn.close();
					tconn = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private boolean validTransaction() {
		try {
			if (tconn != null && !tconn.isClosed() && tconn.getAutoCommit() == false) return true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public void clearAll() {
		try {
			clear();
			clear2();
		} catch (Exception e) {
			//Não foi possível fechar a conexão. Nada acontece neste ponto
			//Espera-se que a conexão seja fechada automaticamente em outro momento
			//CachedConnectionManager ?
		} finally {
			conn = null;
			conn2 = null;
		}
	}

}
