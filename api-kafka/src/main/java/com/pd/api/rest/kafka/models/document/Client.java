package com.pd.api.rest.kafka.models.document;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "clients")
public class Client {
	 @Id
	 @Field("Client_Id")
	 private Integer clientId;
	 @Field("User_Name")
	 private String userName;
	 @Field("Password")
	 private String password;
	 @Field("Name")
	 private String name;
	 @Field("Last_Name")
	 private String lastName;
	 @Field("Email")
	 private String email;
	 @Field("Age")
	 private Integer age;
	 @Field("Height")
	 private Float height;
	 @Field("Weight")
	 private Float weight;
	 @Field("IMC")
	 private Float imc;
	 @Field("GEB")
	 private Float geb;
	 @Field("ETA")
	 private Float eta;
	 @Field("Created_At")
	 private Date createdAt;
	 @Field("Updated_At")
	 private Date updatedAt;
	 
	 
	public Client() {} 
	public Client(Integer clientId, String userName, String password, String name, String lastName, String email,
			Integer age, Float height, Float weight, Float imc, Float geb, Float eta, Date createdAt, Date updatedAt) {
		this.clientId = clientId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.imc = imc;
		this.geb = geb;
		this.eta = eta;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
	 
	 
	
}
