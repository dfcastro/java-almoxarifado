package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ConexaoBD;
import dao.MaterialDao;
import model.Material;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
	/*	MaterialDao materialdao = new MaterialDao();
		Material material = new Material();
		material.setCodigoMaterial("3");
		material.setNomeMaterial("teste3");
		material.setTipoMaterial("copa3");
		material.setUnidadeMaterial("un3");
		
		materialdao.adiciona(material);
	System.out.println("adicionado"); */
		MaterialDao conecta = new MaterialDao();
		List<Material> materiais = conecta.getListaById(2);
		for (Material material : materiais) {
			  System.out.println("Nome: " + material.getCodigoMaterial());
			  System.out.println("Email: " + material.getNomeMaterial());
			  System.out.println("Endereço: " + material.getUnidadeMaterial());
			  System.out.println("Endereço: " + material.getTipoMaterial());
			
			}
	
		
		
}
	}
