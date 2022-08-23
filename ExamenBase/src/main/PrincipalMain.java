package main;

import javax.swing.JOptionPane;

import model.Persona;

public class PrincipalMain {

	public static void main(String[] args) {
		String nombre = (String) JOptionPane.showInputDialog(null,"Ingresa tu nombre.");
		String edad = (String) JOptionPane.showInputDialog(null,"Ingresa tu edad.");
		String sexo = (String) JOptionPane.showInputDialog(null,"Ingresa tu sexo indicando(H O M).");
		String altura = (String) JOptionPane.showInputDialog(null,"Ingresa tu altura en metros.");
		String peso = (String) JOptionPane.showInputDialog(null,"Ingresa tu peso en kg.");
		Persona persona = new Persona(nombre, Integer.valueOf(edad), sexo.charAt(0),Double.valueOf(peso) ,Double.valueOf(altura));
		JOptionPane.showMessageDialog(null, persona.toString());
		
	}

}
