package dao;

import java.sql.Connection;

public class RelatorioDao {
	private Connection connection;
	
	public RelatorioDao(){
		this.connection = new ConexaoBD().getConnection();
	}

}
