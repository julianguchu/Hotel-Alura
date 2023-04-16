package proyectoAlura.proyectoalura.vistas;




import java.awt.Panel;

import java.io.IOException;


import javax.swing.*;

import proyectoAlura.proyectoalura.Eventos.EventosBotones;




public class VistaLogin  extends JFrame{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel panel;
	 private  JTextField username;
	  private  JPasswordField password;
	 private JButton botonSesion;
	 private JLabel labelUsuario, labelContrasena;
	public  VistaLogin () throws IOException {
		setSize(500, 500);
		setTitle("Login Alura Hotel");
		organizarPanel();
		add(panel);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void organizarPanel()   {
		this.panel= new Panel();
		
		this.panel.setLayout(null);
		this.panel.setSize(300, 300);
		
		
		
		
		 
		
		labelUsuario = new JLabel();
		labelUsuario.setText("Usename:");
		labelUsuario.setBounds(130, 200, 60, 30);
		username= new JTextField() ;
		username.setBounds(250, 205, 120, 20);
		  
		labelContrasena = new JLabel();
		labelContrasena.setText("Password");
		labelContrasena.setBounds(130, 260, 60, 30);
		password= new JPasswordField();
		password.setBounds(250, 265, 120, 20);
		
		botonSesion = new JButton ();
		botonSesion.setName("botonLogin");
		botonSesion.setText("Iniciar Sesión");
		botonSesion.setBounds(200, 350, 120, 30);
		botonSesion.addActionListener( new EventosBotones(this));
	
		this.panel.add(labelUsuario);
		this.panel.add(username);
		this.panel.add(labelContrasena);
		this.panel.add(password);
		this.panel.add(botonSesion);
		
	
	}
	public Panel getPanel() {
	
		return panel;
	}
	public JTextField getUsername() {
		return username;
	}
	public void setUsername(JTextField username) {
		this.username = username;
	}
	public JTextField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	public JButton getBotonSesion() {
		return botonSesion;
	}
	public void setBotonSesion(JButton botonSesion) {
		this.botonSesion = botonSesion;
	}
	public JLabel getLabelUsuario() {
		return labelUsuario;
	}
	public void setLabelUsuario(JLabel labelUsuario) {
		this.labelUsuario = labelUsuario;
	}
	public JLabel getLabelContrasena() {
		return labelContrasena;
	}
	public void setLabelContrasena(JLabel labelContrasena) {
		this.labelContrasena = labelContrasena;
	}
	public void setPanel(Panel panel) {
		this.panel = panel;
	}
	


}
