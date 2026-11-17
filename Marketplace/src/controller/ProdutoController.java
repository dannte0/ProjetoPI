package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDao;
import entity.Produto;

public class ProdutoController 
{
	GenericDao gDao = new GenericDao();	
	
	public void createProduto(Produto p) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "INSERT INTO Produto (nome, descricao, id_categoria) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, p.getNome());
		ps.setString(2, p.getDescricao());
		ps.setInt(3, p.getId_categoria());
		ps.execute();
	    ps.close();
	    conn.close();
		
	}
	
	public void deleteProduto(Produto p) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "DELETE produto WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ps.execute();
		ps.close();
		conn.close();
	}
	
	public void updateProduto(Produto p) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "UPDATE produto SET nome = ?, descricao = ?, status = ?, id_categoria = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getDescricao());
		ps.setString(3, p.getStatus());
		ps.setInt(4, p.getId_categoria());
		ps.setInt(5, p.getId());
		ps.execute();
		ps.close();
		conn.close();
	}
	
	public Produto findOneProduto(Produto p) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "SELECT produto.nome, produto.descricao, produto.status, categoria.nome AS cat FROM produto INNER JOIN categoria ON produto.id_categoria = categoria.id WHERE produto.id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, p.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			p.setStatus(rs.getString("status"));
			p.setNome_categoria(rs.getString("cat"));
		}
		rs.close();
		ps.close();
		conn.close();
		return p;
	}
	
	public List<Produto> findAllProduto() throws ClassNotFoundException, SQLException
	{
		List<Produto> lista = new ArrayList<>();
		Connection conn = gDao.getConnection();
		String sql = "SELECT produto.id, produto.nome, produto.descricao, produto.status, categoria.nome AS cat FROM produto INNER JOIN categoria ON produto.id_categoria = categoria.id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Produto p = new Produto();
				 
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			p.setStatus(rs.getString("status"));
			p.setNome_categoria(rs.getString("cat"));
				
			lista.add(p);
		}
		 
		rs.close();
		ps.close();
		conn.close();
		return lista;
	}
}
