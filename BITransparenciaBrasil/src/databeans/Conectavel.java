package databeans;

import java.sql.*;

/**
  * Classe para manipulacao de conexoes ao banco oracle.
  */
public interface Conectavel {
  public Connection getConnection() throws SQLException;
  public ResultSet executeQuery(String sql) throws SQLException;
  public ResultSet executeQueryScrollable(String sql) throws SQLException;
  public int executeUpdate(String sql) throws SQLException;
  public Statement getStatement() throws SQLException;
  public PreparedStatement getPrepStatement(String sql) throws SQLException;
  public CallableStatement getCallStatement(String sql) throws SQLException;
  public void clear();
  public void closeConn();
  public Connection getConnection(boolean autoCommit) throws SQLException;
  public ResultSet executeQuery(String sql, boolean autoCommit) throws SQLException;
  public int executeUpdate(String sql, boolean autoCommit) throws SQLException;
  public Statement getStatement(boolean autoCommit) throws SQLException;
  public PreparedStatement getPrepStatement(String sql, boolean autoCommit) throws SQLException;
  public void setAutoCommit(boolean autoCommit);
  public void newConnection() throws SQLException;
}
