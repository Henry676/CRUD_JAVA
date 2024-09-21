import javax.swing.*;
import java.awt.event.*;

public class Formulario extends JFrame implements ActionListener,FocusListener,KeyListener{
	public JLabel errorAlfabetico;
	public JLabel actualizador;
	public JLabel etiqueta1;
	public JLabel etiqueta2;
	public JLabel etiqueta3;
	public JButton boton1;
	public JButton boton2;
	public JTextField campoTexto1;
	public JTextField campoTexto2;
	public JTextField campoTexto3;
	String cadena1;
	String cadena2;
	String cadena3;
	int a=0,longitud1,longitud2,longitud3;


		public Formulario(){
			setLayout(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			etiqueta1 = new JLabel("Favor de ingresar su nombre");
			etiqueta1.setBounds(260,25,220,25);
			add(etiqueta1);
			etiqueta2 = new JLabel("Favor de ingresar su domicilio");
			etiqueta2.setBounds(260,55,220,25);
			add(etiqueta2);
			etiqueta3 = new JLabel("Favor de ingresar su e-mail");
			etiqueta3.setBounds(260,85,220,25);
			add(etiqueta3);

			boton1 = new JButton("Actualizar");
			boton1.setBounds(80,120,150,25);
			add(boton1);

			boton2 = new JButton("Cerrar");
			boton2.setBounds(240,120,150,25);
			add(boton2);

			campoTexto1 = new JTextField();
			campoTexto1.setBounds(25,25,230,25);
			add(campoTexto1);

			campoTexto2 = new JTextField();
			campoTexto2.setBounds(25,55,230,25);
			add(campoTexto2);

			campoTexto3 = new JTextField();
			campoTexto3.setBounds(25,85,230,25);
			add(campoTexto3);

			boton1.addActionListener(this);
			boton2.addActionListener(this);

			campoTexto1.addFocusListener(this);
			campoTexto2.addFocusListener(this);
			campoTexto3.addFocusListener(this);


			campoTexto1.addKeyListener(this);
			campoTexto2.addKeyListener(this);
			campoTexto3.addKeyListener(this);

		}//Fin constructor

	public void focusGained(FocusEvent e){
		
		
		
	}

	public void focusLost(FocusEvent e){
		
		cadena1 = campoTexto1.getText();
		 cadena2 = campoTexto2.getText();
		 cadena3 = campoTexto3.getText();
		 
			
			 longitud1 = cadena1.length();
			 longitud2 = cadena2.length();
			 longitud3 = cadena3.length();
		

			for(int x=0; x<longitud1; x++){
				char caracter = cadena1.charAt(x);
				int caracterCode = (int) caracter;

				if(caracterCode >=65 && caracterCode <= 122){
					a++;
				}else{
					a=0;
				}
			}
			if(e.getSource()==campoTexto1){
			if(a>0){
				JOptionPane.showMessageDialog(null,"Nombre escrito correctamente");
			}else{
				JOptionPane.showMessageDialog(null,"El nombre no es alfabetico");
			}
		}
		}

	public void keyPressed(KeyEvent e){

	}

	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==10){
					etiqueta1.setText(campoTexto1.getText());
					etiqueta2.setText(campoTexto2.getText());
					etiqueta3.setText(campoTexto3.getText());
				
		}
		if(e.getKeyCode()==27){
				System.exit(0);
				
		}

	}

	public void keyTyped(KeyEvent e){

	}


			public void actionPerformed(ActionEvent accion){

				if(accion.getSource()==boton1){
					etiqueta1.setText(campoTexto1.getText());
					etiqueta2.setText(campoTexto2.getText());
					etiqueta3.setText(campoTexto3.getText());
				
				}
				if(accion.getSource()==boton2){
					System.exit(0);
				}
			}//Fin de evento de acciones


							public static void main (String args[]){
								Formulario miFormulario = new Formulario();

								miFormulario.setBounds(500,200,490,200);
								miFormulario.setVisible(true);

						}//Fin main


}//Fin del codigo