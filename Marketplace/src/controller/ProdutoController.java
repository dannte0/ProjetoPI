package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.GenericDao;
import entity.Produto;

public class ProdutoController 
{
	GenericDao gDao = new GenericDao();	
	
	public void createProduto(Produto p) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "INSERT INTO Produto (nome, descricao, status, id_anuncio, id_categoria) VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, p.getNome());
		ps.setString(2, p.getDescricao());
		ps.setString(3, p.getStatus());
		ps.setInt(4, p.getId_anuncio());
		ps.setInt(5, p.getId_categoria());
		ps.execute();
	    ps.close();
	    conn.close();
		
	}
}
