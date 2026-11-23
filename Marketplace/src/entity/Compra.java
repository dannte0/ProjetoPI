package entity;

import java.time.LocalDateTime;

public class Compra 
{
	private int id_anucio;
	private LocalDateTime dataHora;
	private int id_usuario;

	
	public Compra() 
	{
		this.id_anucio = 0;
		this.dataHora = LocalDateTime.now();
		this.id_usuario = 0;
	}

	
	public int getAnuncioIdProduto() 
	{
		return id_anucio;
	}

	
	public void setAnuncioIdProduto(int id_anucio) 
	{
		this.id_anucio = id_anucio;
	}

	
	public LocalDateTime getDataHora() 
	{
		return dataHora;
	}

	
	public void setDataHora(LocalDateTime dataHora) 
	{
		this.dataHora = dataHora;
	}

	
	public int getUsuarioIdComprador() 
	{
		return id_usuario;
	}

	
	public void setUsuarioIdComprador(int id_usuario) 
	{
		this.id_usuario = id_usuario;
	}
}