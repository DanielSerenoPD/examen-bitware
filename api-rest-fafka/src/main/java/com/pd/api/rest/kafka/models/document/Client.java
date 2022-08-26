package com.pd.api.rest.kafka.models.document;
import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "clients")
public class Client {
	 @Id
	 @JsonProperty("Usuario_ID")
	 private String clientId;
	 @JsonProperty("Nombre_Usuario")
	 private String userName;
	 @JsonProperty("Contraseña")
	 private String password;
	 @JsonProperty("Nombre")
	 private String name;
	 @JsonProperty("Apellidos")
	 private String lastName;
	 @JsonProperty("Correo_Electronico")
	 private String email;
	 @JsonProperty("Edad")
	 private Integer age;
	 @JsonProperty("Altura")
	 private Float height;
	 @JsonProperty("Peso")
	 private Float weight;
	 @JsonProperty("IMC")
	 private Float imc;
	 @JsonProperty("GEB")
	 private Float geb;
	 @JsonProperty("ETA")
	 private Float eta;
	 @JsonProperty("Fecha_Creacion")
	 @CreatedDate
	 private Date createdAt = new Date();
	 @JsonProperty("Fecha_Actualizacion")
	 @LastModifiedDate
	 private Date updatedAt = new Date();
	 
	 
	public Client() {} 
	public Client(String Cliente_ID, String Nombre_Usuario, String Contraseña, String Nombre, String Apellidos, String Correo_Electronico,
			Integer Edad, Float Altura, Float Peso, Float IMC, Float GEB, Float ETA) {
		this.clientId = Cliente_ID;
		this.userName = Nombre_Usuario;
		this.password = Contraseña;
		this.name = Nombre;
		this.lastName = Apellidos;
		this.email = Correo_Electronico;
		this.age = Edad;
		this.height = Altura;
		this.weight = Peso;
		this.imc = IMC;
		this.geb = GEB;
		this.eta = ETA;
	}
	public String getClientId() {
		return clientId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Float getImc() {
		return imc;
	}
	public void setImc(Float imc) {
		this.imc = imc;
	}
	public Float getGeb() {
		return geb;
	}
	public void setGeb(Float geb) {
		this.geb = geb;
	}
	public Float getEta() {
		return eta;
	}
	public void setEta(Float eta) {
		this.eta = eta;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	@Override
	public String toString() {
		return "Client [Cliente_ID=" + clientId + ", Nombre_Usuario=" + userName + ", Contraseña=" + password
				+ ", Nombre=" + name + ", Apellidos=" + lastName + ", Correo_Electronico=" + email
				+ ", Edad=" + age + ", Altura=" + height + ", Peso=" + weight + ", IMC=" + imc + ", GEB=" + geb
				+ ", ETA=" + eta + ", Fecha_Creacion=" + createdAt + ", Fecha_Actualizacion=" + updatedAt
				+ "]";
	}
	
}
