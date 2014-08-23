package databeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.Constants;

public class DataBean {

    private Connection conn;
    private DataSource ds;
    private Statement stmt;

    private static DataBean instance;

    public DataBean() {
        try {
            Context initContext = new InitialContext();
            ds = (DataSource) initContext.lookup(Constants.JNDI_DB_ACCESS);
            //conn = ds.getConnection();
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DataBean getInstance() {
      if (instance == null) {
          instance = new DataBean();
      }
      return instance;
    }

    public int executeSimpleUpdate(String sql) throws SQLException {
        getConnection();
        stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }

    public ResultSet executeSimpleQuery(String sql) throws SQLException {
        getConnection();
        stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ds.getConnection();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public Connection getConnectionStandAlone() {
        try {
            return ds.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void clear() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }

    public void addPreparedStatement(PreparedStatement ps,
                                     int pParameter,
                                     int pType,
                                     String pValue) throws Exception {
        if (!validaNull(pValue)) {
            switch (pType) {
            case Types.DOUBLE:
                ps.setDouble(pParameter, Double.parseDouble(pValue));
                break;
            case Types.VARCHAR:
                ps.setString(pParameter, pValue);
                break;
            case Types.INTEGER:
                ps.setInt(pParameter, Integer.parseInt(pValue));
                break;
            default:
                throw new Exception("No Procedimento addPreparedStatement, falta tratar o parameter " + pType);
            }
        } else {
            ps.setNull(pParameter, pType);
        }
    }

    public boolean validaNull(String pValue) {
        if (pValue != null && pValue.length() > 0) {
            return false;
        }
        return true;
    }

    public Exception fncException(Exception ex) throws Exception {
        return new Exception(ex);
    }
    
    public static String getMetadataInfo() {
		String resultado = "";
		try {
			ResultSet r = DataBean.getInstance().executeSimpleQuery("select ora_database_name dbname from dual");
			if (r.next()) {
				resultado = "Banco de Dados: " + r.getString("dbname");
			}
			r.close();
		} catch (Exception e) {
			//LoggerManager.doLog("", e);
		} finally {
			DataBean.getInstance().clear();
		}
		return resultado;
	}
    
    public static String getParamValue(String codigo) {
		String resultado = "";
		try {
			ResultSet r = DataBean.getInstance().executeSimpleQuery("select sypa_tx_nome_param pvalue from sys_params where sypa_tx_cod_param = '" + codigo + "'");
			if (r.next()) {
				resultado = r.getString("pvalue");
			}
			r.close();
		} catch (Exception e) {
			//LoggerManager.doLog("", e);
		} finally {
			DataBean.getInstance().clear();
		}
		return resultado;
	}
}
