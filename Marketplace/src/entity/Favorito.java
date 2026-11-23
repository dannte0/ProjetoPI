package entity;

public class Favorito 
{
	private int id_usuario;
	private int id_anuncio;

	
	public Favorito() 
	{
		this.id_usuario = 0;
		this.id_anuncio = 0;
	}

	
	public int getUsuarioId() 
	{
		return id_usuario;
	}
	

	public void setUsuarioId(int id_usuario) 
	{
		this.id_usuario = id_usuario;
	}

	
	public int getAnuncioProdutoIdProduto() 
	{
		return id_anuncio;
	}

	
	public void setAnuncioProdutoIdProduto(int id_anuncio) 
	{
		this.id_anuncio = id_anuncio;
	}
}