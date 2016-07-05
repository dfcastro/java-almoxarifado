package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Material;

public class MaterialDao {
	private Connection connection;

	public MaterialDao() {
		this.connection = new ConexaoBD().getConnection();
	}

	public void adiciona(Material material) {
		String sql = "insert into material " + "(codigoMaterial,nomeMaterial,unidadeMaterial,tipoMaterial)"
				+ " values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			int index = 0;
			// seta os valores
			stmt.setString(++index, material.getCodigoMaterial());
			stmt.setString(++index, material.getNomeMaterial());
			stmt.setString(++index, material.getUnidadeMaterial());
			stmt.setString(++index, material.getTipoMaterial());

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Material> getLista() {
		try {
			List<Material> materiais = new ArrayList<Material>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from material");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Material material = new Material();
				material.setIdMaterial(rs.getLong("idMaterial"));
				material.setCodigoMaterial(rs.getString("codigoMaterial"));
				material.setNomeMaterial(rs.getString("nomeMaterial"));
				material.setUnidadeMaterial(rs.getString("unidadeMaterial"));
				material.setTipoMaterial(rs.getString("tipoMaterial"));
				// adicionando o objeto à lista
				materiais.add(material);
			}
			rs.close();
			stmt.close();
			return materiais;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Material> getListaById(long id) {
		try {
			List<Material> materiais = new ArrayList<Material>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from material where idMaterial=" + id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Material material = new Material();
				material.setIdMaterial(rs.getLong("idMaterial"));
				material.setCodigoMaterial(rs.getString("codigoMaterial"));
				material.setNomeMaterial(rs.getString("nomeMaterial"));
				material.setUnidadeMaterial(rs.getString("unidadeMaterial"));
				material.setTipoMaterial(rs.getString("tipoMaterial"));
				// adicionando o objeto à lista
				materiais.add(material);
			}
			rs.close();
			stmt.close();
			return materiais;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void Altera(Material material) {
		String sql = "update material set codigoMateriale=?, nomeMaterial=?, unidadeMaterial=?," + "tipoMaterialo=? where idMaterial=?";
		int index = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(++index, material.getCodigoMaterial());
			stmt.setString(++index, material.getNomeMaterial());
			stmt.setString(++index, material.getUnidadeMaterial());
			stmt.setString(++index, material.getTipoMaterial());
			stmt.setLong(++index, material.getIdMaterial());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Material material) {
		int index =0;
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
			stmt.setLong(++index, material.getIdMaterial());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
