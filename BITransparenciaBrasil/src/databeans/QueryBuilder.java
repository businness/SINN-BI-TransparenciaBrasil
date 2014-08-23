package databeans;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class QueryBuilder {
	
	public static Collection getCandidatos(String estado, String cargo) {
		String sql = "select candidato_foto, candidato_nome, candidato_numero, r.cargo_nome, candidato_apelido, p.partido_sigla " +
					 " from dim_candidato c, dim_estado e, dim_cargo r, dim_partido p " +
					 " where c.sk_estado = e.sk_estado and c.sk_cargo = r.sk_cargo and c.sk_partido = p.sk_partido " +
					 " and c.sk_cargo in ("+cargo+") ";
		if (cargo != null && !cargo.trim().equals("1") && 
			estado != null && estado.trim().length() > 0 && !estado.trim().equalsIgnoreCase("null")) {
			sql += " and e.estado_sigla = '" + estado + "'";
		}
		sql += " order by r.cargo_nome";
		Collection<String[]> dadosCandidato = new ArrayList<String[]>();
		try {
			ResultSet rs = DbManager.getInstance().executeQuery(sql);
			while (rs.next()) {
				dadosCandidato.add(new String[]{rs.getString("candidato_foto"), rs.getString("candidato_nome"), rs.getString("candidato_numero"), rs.getString("cargo_nome"), rs.getString("candidato_apelido"), rs.getString("partido_sigla") });
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.getInstance().clear();
		}
		return dadosCandidato;
	}
	
	public static String nomeEstado(String estado) {
		if (estado == null || estado.trim().length() == 0 || estado.trim().equalsIgnoreCase("null")) return "";
		String sql = "select sk_estado, estado_nome from dim_estado where estado_sigla = '" + estado + "'";
		try {
			ResultSet rs = DbManager.getInstance().executeQuery(sql);
			if (rs.next()) return rs.getString("estado_nome");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.getInstance().clear();
		}
		return "";
	}

}
