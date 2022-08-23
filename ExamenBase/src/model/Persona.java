package model;

import java.util.Random;

public class Persona {
	//Atributos
	private String nombre;
	private Integer edad;
	private String NSS;
	private Double peso;
	private Double altura;
	private  Character sexo;
	
	//CONSTANTES
	private final  Integer FALTA_PESO = -1;
	private final  Integer NORMAL_PESO = 0;
	private final  Integer SOBRE_PESO = 1;
	private final  Character HOMBRE = 'H';

	
	public Persona(String nombre, Integer edad, Character sexo, Double peso, Double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.NSS = generateNSS();
		this.peso = peso;
		this.altura = altura;
		this.sexo = sexo;
	}
	
	public Persona() {
		this.nombre = "";
		this.edad = 0;
		this.peso = (double) 0;
		this.altura = (double) 0;
		this.NSS = generateNSS();
		this.sexo = this.HOMBRE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Character getSexo() {
		return sexo;
	}
	
	public void setSexo(Character sexo) {
			this.sexo = sexo;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getNSS() {
		return NSS;
	}
	
	private String generateNSS() {
		Random rand = new Random();
        int result = rand.nextInt();
        String NSS = Integer.toHexString(result);
		return NSS;
	}
	public boolean esMayorEdad() {
		return this.edad >= 18;
	}
	@SuppressWarnings("unused")
	private boolean comprobarSexo(char sexo) {
		return sexo == 'H' || sexo == 'M';
	}
	public Integer calcularIMC() {
		Double result = this.peso/(Math.pow(this.altura,2));
			if(this.sexo == 'H') {
			if(result<20) return this.FALTA_PESO;
			else if(result==20 && result<=25) return this.NORMAL_PESO;
			else return this.SOBRE_PESO;
		}else {
			if(result<19) return this.FALTA_PESO;
			else if(result==19 && result<=24) return this.NORMAL_PESO;
			else return this.SOBRE_PESO;
		}
	}
	@Override
	public String toString() {
		String esMayor = this.edad>=18?"Usted es mayor de edad\n":"Usted no es mayor de edad";
		Integer result = this.calcularIMC();
		String estatusPeso = "";
		switch (result) {
		case 0: {
			estatusPeso = "Peso normal";
			break;
		}
		case 1: {
			estatusPeso = "Sobrepeso";
			break;
		}
		default:
			estatusPeso = "Desnutricion";
			break;
		}
		return "Buen dia " + this.nombre + "! Estos son tus resultados:\n"+
		"Estas en: "+ estatusPeso + "\n"+ esMayor+"\nDatos ingresados: "+
		"nombre=" + nombre + ", edad=" + edad + ", NSS=" + NSS + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura;
	}
	
	
	
	
	
}
