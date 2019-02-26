package com.interview.test.interviewtest;

public class Corrida implements Comparable<Object>{
	int codPiloto;
	String hora;
	String piloto;
	int volta;
	String tempoVolta;
	String velocidadeMedia;
	
	
	public Corrida(int codPiloto, String hora, String piloto, int volta, String tempoVolta, String velocidadeMedia) {
		super();
		this.codPiloto = codPiloto;
		this.hora = hora;
		this.piloto = piloto;
		this.volta = volta;
		this.tempoVolta = tempoVolta;
		this.velocidadeMedia = velocidadeMedia;
	}
	
	


	public int getCodPiloto() {
		return codPiloto;
	}




	public void setCodPiloto(int codPiloto) {
		this.codPiloto = codPiloto;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public String getPiloto() {
		return piloto;
	}




	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}




	public int getVolta() {
		return volta;
	}




	public void setVolta(int volta) {
		this.volta = volta;
	}




	public String getTempoVolta() {
		return tempoVolta;
	}




	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}




	public String getVelocidadeMedia() {
		return velocidadeMedia;
	}




	public void setVelocidadeMedia(String velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}




	@Override
	public int compareTo(Object object) {
		Corrida corrida = (Corrida) object;
		return this.volta - corrida.volta;
	}
	
	
}
