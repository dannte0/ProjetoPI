package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDao;
import entity.Categoria;
import entity.Produto;

public class CategoriaController 
{
    
    GenericDao gDao = new GenericDao();

    public void createCategoria(Categoria c) throws ClassNotFoundException, SQLException 
    {
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Categoria (nome, descricao) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setString(1, c.getNome());
        ps.setString(2, c.getDescricao());
        
        ps.execute();
        ps.close();
        conn.close();
    }
    
    public List<Categoria> findAllCategoria() throws ClassNotFoundException, SQLException
    {
    	List<Categoria> categorias = new ArrayList<>();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id, nome FROM Categoria ORDER BY nome ASC";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
        {
            Categoria cat = new Categoria();
            cat.setId(rs.getInt("id"));
            cat.setNome(rs.getString("nome"));
            categorias.add(cat);
        }
        rs.close();
        ps.close();
        conn.close();
    	return categorias;
    }
    
	public Categoria findOneCategoria(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		Categoria c = new Categoria();
		String sql = "SELECT nome FROM categoria WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			c.setNome(rs.getString("nome"));

		}
		rs.close();
		ps.close();
		conn.close();
		return c;
	}
    
}