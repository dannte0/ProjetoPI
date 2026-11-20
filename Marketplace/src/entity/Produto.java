package entity;

public class Produto 
{
	private int id;
	private String nome;
	private String descricao;
	private int id_categoria;
	private String marca;
	private String condicao;
	private String cor;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getId_categoria() 
	{
		return id_categoria;
	}
	
	public void setId_categoria(int id_categoria) 
	{
		this.id_categoria = id_categoria;
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
	
	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public String getCondicao() 
	{
		return condicao;
	}

	public void setCondicao(String condicao) 
	{
		this.condicao = condicao;
	}

	public String getCor() 
	{
		return cor;
	}

	public void setCor(String cor) 
	{
		this.cor = cor;
	}

}
