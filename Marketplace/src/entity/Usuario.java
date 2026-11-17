package entity;

public class Usuario 
{
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String CPF;
	private String telefone;
	
	public Usuario() 
	{
		this.id = 0;
		this.nome = "";
		this.email = "";
		this.senha = "";
		this.CPF = "";
		this.telefone = "";
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getSenha() 
	{
		return senha;
	}
	
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	
	public String getTelefone() 
	{
		return telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}	
	
	public String getCPF() 
	{
		return this.CPF;
	}
	
	public void setCPF(String cpf) 
	{
		this.CPF = cpf;
	}
}
