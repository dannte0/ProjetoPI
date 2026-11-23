package entity;

public class Anuncio 
{
	private int id;
	private double valor;
	private String status;
	private int id_usuario;
	
	public Anuncio() 
	{
		this.id = 0;
		this.valor = 0.00d;
		this.status = "";
		this.setId_usuario(0);
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public double getValor() 
	{
		return valor;
	}

	public void setValor(double valor) 
	{
		this.valor = valor;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public int getId_usuario() 
	{
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) 
	{
		this.id_usuario = id_usuario;
	}
}
