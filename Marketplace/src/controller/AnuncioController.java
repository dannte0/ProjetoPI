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
import entity.Anuncio;


public class AnuncioController
{
    GenericDao gDao = new GenericDao();

    public void createAnuncio(Anuncio anu) throws ClassNotFoundException, SQLException 
    {
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Anuncio (valor, status, id_usuario) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setDouble(1, anu.getValor());
        ps.setString(2, anu.getStatus());
        ps.setInt(3, anu.getId_usuario());
        
        ps.execute();
        ps.close();
        conn.close();
    }

    public Anuncio findOneAnuncio(Anuncio anu) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "SELECT anuncio.valor, anuncio.status FROM anuncio WHERE anuncio.id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, anu.getId());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			anu.setValor(rs.getString("valor"));
			anu.setStatus(rs.getString("status"));
		}
		rs.close();
		ps.close();
		conn.close();
		return anu;
	}

	public List<Anuncio> findAllAnuncio() throws ClassNotFoundException, SQLException
	{
		List<Anuncio> lista = new ArrayList<>();
		Connection conn = gDao.getConnection();
		String sql = "SELECT anuncio.id, anuncio.valor, anuncio.status FROM anuncio";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Anuncio anu = new Anuncio();
				 
			anu.setId(rs.getInt("id"));
			anu.setValor(rs.getString("valor"));
			anu.setStatus(rs.getString("status"));
				
			lista.add(anu);
		}
		 
		rs.close();
		ps.close();
		conn.close();
		return lista;
	}

	public void updateAnuncio(Anuncio anu) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "UPDATE anuncio SET valor = ?, status = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, anu.getValor());
		ps.setString(2, anu.getStatus());
		ps.setInt(3, anu.getId());
		ps.execute();
		ps.close();
		conn.close();
	}

	public void deleteAnuncio(Anuncio anu) throws ClassNotFoundException, SQLException
	{
		Connection conn = gDao.getConnection();
		String sql = "DELETE anuncio WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, anu.getId());
		ps.execute();
		ps.close();
		conn.close();
	}
}