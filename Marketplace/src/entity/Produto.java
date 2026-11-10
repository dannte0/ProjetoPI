package entity;

public class Produto 
{
	private int id;
	private String nome;
	private String descricao;
	private String status;
	private int id_categoria;
	private int id_anuncio;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getId_anuncio() 
	{
		return id_anuncio;
	}
	
	public void setId_anuncio(int id_anuncio) 
	{
		this.id_anuncio = id_anuncio;
	}
	
	public int getId_categoria() 
	{
		return id_categoria;
	}
	
	public void setId_categoria(int id_categoria) 
	{
		this.id_categoria = id_categoria;
	}
	
	public String getStatus() 
	{
		return status;
	}
	
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getDescricao() 
	{
		return descricao;
	}
	
	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}
}
