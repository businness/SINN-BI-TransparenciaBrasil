package databeans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLExecuteBean {
	private boolean firstResultSet = false;
	private ResultSet rs = null;
	private String jndiName;
	public SQLExecuteBean() {
		try {
			DbManager.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public SQLExecuteBean(String jndiName) {
		try {
			this.jndiName = jndiName; 
			//DbManager.getInstance().connect(this.jndiName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet execSQLStatement( String statement ) throws Exception{
		try{
			rs =  DbManager.getInstance().executeQuery(statement, this.jndiName);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw(ex);
		}
		return rs;
	}

	public void fechaConexao(){
		DbManager.getInstance().clear();
	}
	
	public void fechaConexao2(){
		DbManager.getInstance().clear2();
	}

	public boolean isFirstResultSet(){
		return firstResultSet;
	}
}
