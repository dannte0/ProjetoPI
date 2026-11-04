package entity;

public class Vendedor extends Usuario 
{
	private String CPF;
	
	public Vendedor()
	{
		super();
		this.CPF = "";
	}
	
	public String getCPF() 
	{
		return CPF;
	}
	
	public void setCPF(String cpf) 
	{
		CPF = cpf;
	}
}
