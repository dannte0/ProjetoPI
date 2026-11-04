package entity;

public class Anuncio 
{
	private int id;
	private double valor;
	private int id_vendedor;
	
	public Anuncio() 
	{
		this.id = 0;
		this.valor = 0.00d;	
		this.setId_vendedor(0);
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

	public int getId_vendedor() 
	{
		return id_vendedor;
	}

	public void setId_vendedor(int id_vendedor) 
	{
		this.id_vendedor = id_vendedor;
	}
}
