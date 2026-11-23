package entity;

public class Favorito 
{
	private int id_usuario;
	private int anuncioProdutoIdProduto;

	
	public Favorito() 
	{
		this.id_usuario = 0;
		this.anuncioProdutoIdProduto = 0;
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
		return anuncioProdutoIdProduto;
	}

	
	public void setAnuncioProdutoIdProduto(int anuncioProdutoIdProduto) 
	{
		this.anuncioProdutoIdProduto = anuncioProdutoIdProduto;
	}
}