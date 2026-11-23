package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDao;
import entity.Favorito;

public class FavoritoController 
{
    GenericDao gDao = new GenericDao();

    public void createFavorito(Favorito fav) throws ClassNotFoundException, SQLException 
    {
        Connection conn = gDao.getConnection();
        String sql = "INSERT INTO Favorito (id_usuario, id_anuncio) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, fav.getUsuarioId());
        ps.setInt(2, fav.getAnuncioProdutoIdProduto());
        
        ps.execute();
        ps.close();
        conn.close();
    }

    public List<Favorito> findFavoritosByUsuario(int usuarioId) throws ClassNotFoundException, SQLException
    {
        List<Favorito> lista = new ArrayList<>();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id_usuario, id_anuncio FROM Favorito WHERE id_usuario = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, usuarioId);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            Favorito fav = new Favorito();
            fav.setUsuarioId(rs.getInt("id_usuario"));
            fav.setAnuncioProdutoIdProduto(rs.getInt("id_anuncio"));
            lista.add(fav);
        }
         
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }

    public List<Favorito> findAllFavorito() throws ClassNotFoundException, SQLException
    {
        List<Favorito> lista = new ArrayList<>();
        Connection conn = gDao.getConnection();
        String sql = "SELECT id_usuario, id_anuncio FROM Favorito";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            Favorito fav = new Favorito();
            fav.setUsuarioId(rs.getInt("id_usuario"));
            fav.setAnuncioProdutoIdProduto(rs.getInt("id_anuncio"));
            lista.add(fav);
        }
         
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }

    public void deleteFavorito(Favorito fav) throws ClassNotFoundException, SQLException
    {
        Connection conn = gDao.getConnection();
        String sql = "DELETE FROM Favorito WHERE id_usuario = ? AND id_anuncio = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ps.setInt(1, fav.getUsuarioId());
        ps.setInt(2, fav.getAnuncioProdutoIdProduto());
        
        ps.execute();
        ps.close();
        conn.close();
    }
}