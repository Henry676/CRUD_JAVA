import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.ImageIcon;

public class bajaCuenta extends JFrame implements ActionListener,FocusListener{

public JButton boton1, boton2;
public JTextField field1;
public JPasswordField pass2;
public JLabel usuariO,passworD,imagen;

	public bajaCuenta(){
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("warning.png")).getImage());
		setTitle("Alerta");
		boton1 = new JButton("Eliminar cuenta");
		boton1.setBackground(Color.BLACK);
		boton1.setForeground(Color.WHITE);
		boton1.setBounds(50,175,180,30);
		add(boton1);
		boton2 = new JButton("Cancelar");
		boton2.setBackground(Color.BLACK);
		boton2.setForeground(Color.WHITE);
		boton2.setBounds(235,175,180,30);
		add(boton2);
		usuariO = new JLabel("Ingrese su nombre de usuario");
		usuariO.setForeground(Color.BLACK);
		usuariO.setBounds(50,40,200,18);
		add(usuariO);
		passworD = new JLabel("Ingrese su contrasenia");
		passworD.setForeground(Color.BLACK);
		passworD.setBounds(50,110,200,18);
		add(passworD);
		field1 = new JTextField();
		field1.setBounds(50,65,365,30);
		add(field1);
		pass2 = new JPasswordField();
		pass2.setBounds(50,135,365,30);
		add(pass2);

			ImageIcon w = new ImageIcon("Caution.jpg");
			imagen = new JLabel(w);
			imagen.setBounds(0,0,500,215);
			Icon ye = new ImageIcon(w.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(ye);
			add(imagen);

		boton1.addActionListener(this);
		boton2.addActionListener(this);
	}

	public void actionPerformed (ActionEvent e){
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String AccionSQL = "";
		String compr1 = "";
		String compr2 = "";
		int nRegistros = 0, found1 = 0, found2 = 0;
		compr1 = field1.getText();
		compr2 = pass2.getText();
		if(e.getSource() == boton2){
			dispose();
		}
		if(e.getSource() == boton1 ){
			System.out.println("Accediendo a base de datos");
			try{
					AccionSQL = "SELECT Password, Usuario FROM cuentausuario WHERE Password = ? AND Usuario = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root","");
					System.out.println("CONEXION EXITOSA");
					

					pst = cn.prepareStatement(AccionSQL);
					pst.setString(1,pass2.getText());
					pst.setString(2,field1.getText());
					
					rs = pst.executeQuery();
				if(rs.next()){
					
					nRegistros++;
					compr2 = "";
						compr1 = "";
					
					JOptionPane.showMessageDialog(null,"Cuenta encontrada");
					found1++;
					found2++;
					
				}else{
					JOptionPane.showMessageDialog(null,"Es posible que un dato sea erroneo o la cuenta no existe");
				}
					
		}catch (Exception excepcion){
			System.out.println("Algo salio mal: " + excepcion.getMessage());
	}
		
		try{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(cn != null) cn.close();
		}catch(SQLException ex){
			System.out.println("Algo salio mal: "+ex.getMessage());
		}

		if(found1 > 0 && found2 > 0){

			try{
					AccionSQL = "DELETE FROM cuentausuario WHERE Password = ? AND Usuario = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root","");
					System.out.println("CONEXION EXITOSA");
					JOptionPane.showMessageDialog(null,"La cuenta ha sido dada de baja");
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,pass2.getText());
					pst.setString(2,field1.getText());
					
					pst.executeUpdate();
					found1 = 0;
					found2 = 0;
					dispose();
		}catch (Exception m){
			System.out.println("Algo salio mal: " + m.getMessage());
	}
			}

	}
}

	public void focusGained(FocusEvent e){
		
		
		
	}

	public void focusLost(FocusEvent e){
		
		

		}


	public static void main (String args[]){
		bajaCuenta ventanita = new bajaCuenta();
		ventanita.setBounds(420,290,500,250);
		ventanita.setVisible(true);

	}
}