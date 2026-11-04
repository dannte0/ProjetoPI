package entity;

public class Status 
{
	private int id;
	private String descricao;
	
	public Status() 
	{
		this.id = 0;
		this.descricao = "";
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
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
