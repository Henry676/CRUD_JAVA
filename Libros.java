import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.ImageIcon;



public class Libros extends JFrame implements MouseListener,KeyListener,ActionListener,FocusListener,ChangeListener{
	
	int intentoActual=1, intentoAnterior=0, inicioGlobal = 0;
	public JPanel Portada,IngresoDatos, Formulario,registroLibros,usuarios,prestamos,muestraUsuarios,muestraLibros,muestraPrestamos;
	public JLabel portada,inicioSesion,formulario,bienvenida,usuario,codigo,imagen,anuncio,superTitulo,estante,plantita,linea,listaUsuarios,listaLibros,listaPrestamos;
	public JLabel e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,e21,e22,e23,e24,e25,e26,e27,e28,e29,e30,e31,e32,e33,e34,e35,e36,e37,e38,e39,e40;
	public JTextField campo1,titulo,codigoLibro,autor,editorial,categoria,apellidoPaterno,apellidoMaterno,nombreS,correoE,telNum,adress,codigoID,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
	public JTextArea registro,historial,usuariosBD,librosBD,prestamosBD;
	public JPasswordField campo2;
	public JButton CrearCuenta,IniciarSesion,registrarLibro,modificarLibro,quitarLibro,dardeAltaUsuario,actualizador,baja,b1,b2,consultaLibro;
	
	public JSeparator s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35;
	public JLabel imagenLibro;
	
	
	public JCheckBox box;
	public JMenuBar barra;
	public JMenu inicio;
	public JMenuItem bajaUsuario;
	public JMenuItem sesion;
	public JMenuItem home;
	public JMenuItem altaUsuario;
	public JMenu acciones;
	public JMenuItem RegistrarLibro;
	public JMenuItem modificarDatos;
	public JMenu consultar;
	public JMenuItem UsuariosRegistrados;
	public JMenuItem Prestamos;
	public JMenuItem registroPrestamos;
	public JMenuItem PrestamosVigentes;
	public JMenuItem LibrosRegistrados;

	int CuentaNoCreada = 0,apartadoUsuario = 0, apartadoFormulario = 0, apartadoLibros = 0,apartadoSeguridad=0,apartadoCuenta=0;
	//Declaraciones codigo formulario
	public JScrollPane scroll,scroll2,scroll3,scroll4;
	public JLabel errorAlfabetico;
	
	public JLabel etiqueta1,etiqueta2,etiqueta3,etiqueta4,etiqueta5,etiqueta6,etiqueta7,etiqueta8,etiqueta9,etiqueta10;
	public JButton boton1,boton2,boton3;
	public ButtonGroup genero;
	public JRadioButton genero1,genero2;
	public JTextField campoTexto1,campoTexto2,campoTexto3,campoTexto4,campoTexto6,campoTexto7,campoTexto8,campoTexto9;
	public JPasswordField campoTexto5;
	String cadena1;
	String cadena2;
	String cadena3;
	String cadena4;
	String cadena5;
	String cadena6;
	String apellidoP,apellidoM,nombre,nacimiento,password,numero,email,Usuario,domicilio,vacio1,vacio2;
	String g1,g2,CompararPassword="",CompararUsuario="";
	int a=0,longitud1,longitud2,longitud3,longitud4,longitud5,longitud6,cerrado=0,Inicio=0,Inicio2=0;
	int x=0;
	//Fin declaraciones del codigo formulario

	char echo;


	public Libros(){
		
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Font fuente = new Font("CASTELLAR",Font.BOLD,25);
		Font fuente1 = new Font("CASTELLAR",Font.BOLD,38);
		Font fuente2 = new Font("Arial",Font.BOLD,18);
		Font fuente3 = new Font("Bookman Old Style",Font.PLAIN,17);
		Font fuente4 = new Font("Arial",Font.PLAIN,16);
		Font fuente5 = new Font("CASTELLAR",Font.PLAIN,16);
		Font fuente6 = new Font("Bookman Old Style",Font.BOLD,16);
		setIconImage(new ImageIcon(getClass().getResource("Libro logo.jpg")).getImage());
		setTitle("Libreria HERTZ");

		//Panel 0, portada

		Portada = new JPanel();
		Portada.setLayout(null);
		Portada.setBounds(0,0,1200,680);
		Portada.setVisible(true);
		add(Portada);

		superTitulo = new JLabel("Control de libros HERTZ");
		superTitulo.setBounds(300,30,680,100);
		superTitulo.setFont(fuente1);
		superTitulo.setForeground(Color.YELLOW);
		Portada.add(superTitulo);
	
		ImageIcon librito = new ImageIcon("Estante2.png");
		imagen = new JLabel(librito);
		imagen.setBounds(450,200,300,175);
		Icon librote = new ImageIcon(librito.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
		imagen.setIcon(librote);
		Portada.add(imagen);

		ImageIcon estanteria = new ImageIcon("Estante.png");
		imagen = new JLabel(estanteria);
		imagen.setBounds(0,265,300,300);
		Icon librosEstantes = new ImageIcon(estanteria.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
		imagen.setIcon(librosEstantes);
		Portada.add(imagen);

		ImageIcon estanteria2 = new ImageIcon("Estante.png");
		imagen = new JLabel(estanteria2);
		imagen.setBounds(900,265,300,300);
		Icon librosEstantes2 = new ImageIcon(estanteria2.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
		imagen.setIcon(librosEstantes2);
		Portada.add(imagen);

		ImageIcon planta = new ImageIcon("Plantita.png");
		imagen = new JLabel(planta);
		imagen.setBounds(555,460,90,160);
		Icon plantota = new ImageIcon(planta.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
		imagen.setIcon(plantota);
		Portada.add(imagen);


		ImageIcon cover = new ImageIcon("Fondo principal3.jpg");
		imagen = new JLabel(cover);
		imagen.setBounds(0,0,1200,680);
		Portada.add(imagen);

	
		/*Icon Icono = new ImageIcon(cover.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
		imagen.setIcon(Icono);
		IngresoDatos.add(imagen);*/

		
		//Panel 1 de ingresar usuario y contraseña
		IngresoDatos = new JPanel();
		IngresoDatos.setLayout(null);
		IngresoDatos.setBackground(Color.CYAN);
		IngresoDatos.setBounds(0,0,1200,680);
		IngresoDatos.setVisible(false);
		add(IngresoDatos);
		
		ImageIcon foto = new ImageIcon("Usuario icono.png");
		imagen = new JLabel(foto);
		imagen.setBounds(525,100,150,150);
		Icon icono = new ImageIcon(foto.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
		imagen.setIcon(icono);
		IngresoDatos.add(imagen);


		bienvenida = new JLabel("Bienvenid@ al sistema de control de libros");
		bienvenida.setForeground(Color.WHITE);
		bienvenida.setFont(fuente);
		bienvenida.setBounds(225,10,780,100);
		IngresoDatos.add(bienvenida);

		usuario = new JLabel("Usuario");
		usuario.setFont(fuente2);
		usuario.setForeground(Color.WHITE);
		usuario.setBounds(420,270,100,32);
		IngresoDatos.add(usuario);

		campo1 = new JTextField("Ingrese su nombre de usuario");
		campo1.setBounds(420,300,390,32);
		campo1.setForeground(new Color(128,128,128));
		IngresoDatos.add(campo1);

		codigo = new JLabel("Contrasenia");
		codigo.setFont(fuente2);
		codigo.setForeground(Color.WHITE);
		codigo.setBounds(420,330,390,32);
		IngresoDatos.add(codigo);


		campo2 = new JPasswordField("********************");
		box = new JCheckBox();
		campo2.setLayout(new BorderLayout(0,0));
		campo2.setForeground(new Color(128,128,128));
		campo2.setEchoChar('*');
		box.setOpaque(false);
		ImageIcon ojo = new ImageIcon("Ojo abierto.png");
		Icon open = new ImageIcon(ojo.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
		box.setIcon(open);
		campo2.add(box,BorderLayout.EAST);
		campo2.setBounds(420,370,390,32);
		IngresoDatos.add(campo2);

		anuncio = new JLabel("No tiene cuenta? Crea una gratuitamente");
		anuncio.setFont(fuente2);
		anuncio.setForeground(Color.WHITE);
		anuncio.setBounds(420,400,390,32);
		IngresoDatos.add(anuncio);

		CrearCuenta = new JButton("Crear cuenta");
		CrearCuenta.setBackground(Color.BLACK);
		CrearCuenta.setFont(fuente2);
		CrearCuenta.setForeground(Color.CYAN);
		CrearCuenta.setBounds(420,440,180,32);
		IngresoDatos.add(CrearCuenta);

		IniciarSesion = new JButton("Iniciar Sesion");
		IniciarSesion.setBackground(Color.BLACK);
		IniciarSesion.setFont(fuente2);
		IniciarSesion.setForeground(Color.CYAN);
		IniciarSesion.setBounds(620,440,180,32);
		IngresoDatos.add(IniciarSesion);

		ImageIcon fondoInicio = new ImageIcon("FondoPrincipal.png");
		inicioSesion = new JLabel(fondoInicio);
		inicioSesion.setBounds(0,0,1200,680);
		IngresoDatos.add(inicioSesion);
		
		//Fin panel 1
	

		
		//Inicio panel 2 (formulario)
		Formulario = new JPanel();
		Formulario.setLayout(null);
		Formulario.setBounds(0,0,1200,680);
		Formulario.setBackground(Color.WHITE);
		Formulario.setVisible(false);
		add(Formulario);

			etiqueta1 = new JLabel("Ingrese su apellido paterno");
			etiqueta1.setBounds(25,10,380,25);
			etiqueta1.setForeground(Color.WHITE);
			etiqueta1.setFont(fuente3);
			Formulario.add(etiqueta1);
			etiqueta2 = new JLabel("Ingrese su apellido materno");
			etiqueta2.setForeground(Color.WHITE);
			etiqueta2.setFont(fuente3);
			etiqueta2.setBounds(450,10,380,25);
			Formulario.add(etiqueta2);
			etiqueta3 = new JLabel("Ingrese su nombre");
			etiqueta3.setForeground(Color.WHITE);
			etiqueta3.setFont(fuente3);
			etiqueta3.setBounds(850,10,380,25);
			Formulario.add(etiqueta3);
			etiqueta4 = new JLabel("Ingrese su fecha de nacimiento");
			etiqueta4.setForeground(Color.WHITE);
			etiqueta4.setFont(fuente3);
			etiqueta4.setBounds(25,190,380,25);
			Formulario.add(etiqueta4);
			etiqueta5 = new JLabel("Ingrese una contrasenia");
			etiqueta5.setForeground(Color.WHITE);
			etiqueta5.setFont(fuente3);
			etiqueta5.setBounds(450,190,380,25);
			Formulario.add(etiqueta5);
			etiqueta6 = new JLabel("Ingrese su numero telefonico");
			etiqueta6.setForeground(Color.WHITE);
			etiqueta6.setFont(fuente3);
			etiqueta6.setBounds(850,190,380,25);
			Formulario.add(etiqueta6);

			etiqueta7 = new JLabel("Ingrese su correo electronico");
			etiqueta7.setForeground(Color.WHITE);
			etiqueta7.setFont(fuente3);
			etiqueta7.setBounds(25,370,380,25);
			Formulario.add(etiqueta7);

			etiqueta8 = new JLabel("Ingrese un nombre de usuario");
			etiqueta8.setForeground(Color.WHITE);
			etiqueta8.setFont(fuente3);
			etiqueta8.setBounds(450,370,380,25);
			Formulario.add(etiqueta8);
			
			etiqueta9 = new JLabel("Genero");
			etiqueta9.setForeground(Color.WHITE);
			etiqueta9.setFont(fuente3);
			etiqueta9.setBounds(25,490,380,25);
			Formulario.add(etiqueta9);

			etiqueta10 = new JLabel("Ingrese su domicilio");
			etiqueta10.setForeground(Color.WHITE);
			etiqueta10.setFont(fuente3);
			etiqueta10.setBounds(850,370,380,25);
			Formulario.add(etiqueta10);

			boton1 = new JButton("Guardar datos");
			boton1.setBackground(Color.BLACK);
			boton1.setForeground(Color.WHITE);
			boton1.setFont(fuente3);
			boton1.setBounds(350,570,215,25);
			Formulario.add(boton1);

			boton2 = new JButton("Cancelar");
			boton2.setBackground(Color.BLACK);
			boton2.setForeground(Color.WHITE);
			boton2.setFont(fuente3);
			boton2.setBounds(575,570,215,25);
			Formulario.add(boton2);

			boton3 = new JButton("Siguiente");
			boton3.setBackground(Color.BLACK);
			boton3.setForeground(Color.WHITE);
			boton3.setFont(fuente3);
			boton3.setBounds(800,570,215,25);
			Formulario.add(boton3);

			campoTexto1 = new JTextField();
			campoTexto1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto1.setOpaque(false);
        	getContentPane().add(campoTexto1);
			//campoTexto1.setBackground(Color.WHITE);
			campoTexto1.setForeground(Color.WHITE);
			campoTexto1.setBounds(25,35,230,25);
			s1 = new JSeparator();
			s1.setBounds(25,60,230,3);
			Formulario.add(s1);
			Formulario.add(campoTexto1);

			campoTexto2 = new JTextField();
			campoTexto2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto2.setOpaque(false);
        	getContentPane().add(campoTexto2);
			//campoTexto2.setBackground(Color.WHITE);
			campoTexto2.setForeground(Color.WHITE);
			campoTexto2.setBounds(450,35,230,25);
			s2 = new JSeparator();
			s2.setBounds(450,60,230,3);
			Formulario.add(s2);
			Formulario.add(campoTexto2);

			campoTexto3 = new JTextField();
			campoTexto3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto3.setOpaque(false);
        	getContentPane().add(campoTexto3);
			//campoTexto3.setBackground(Color.WHITE);
			campoTexto3.setForeground(Color.WHITE);
			campoTexto3.setBounds(850,35,230,25);
			s3 = new JSeparator();
			s3.setBounds(850,60,230,3);
			Formulario.add(s3);
			Formulario.add(campoTexto3);

			campoTexto4 = new JTextField();
			campoTexto4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto4.setOpaque(false);
        	getContentPane().add(campoTexto4);
			//campoTexto4.setBackground(Color.WHITE);
			campoTexto4.setForeground(Color.WHITE);
			campoTexto4.setBounds(25,215,230,25);
			s4 = new JSeparator();
			s4.setBounds(25,240,230,3);
			Formulario.add(s4);
			Formulario.add(campoTexto4);

			campoTexto5 = new JPasswordField();
			campoTexto5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto5.setOpaque(false);
        	getContentPane().add(campoTexto5);
			//campoTexto5.setBackground(Color.WHITE);
			campoTexto5.setForeground(Color.WHITE);
			campoTexto5.setBounds(450,215,230,25);
			s5 = new JSeparator();
			s5.setBounds(450,240,230,3);
			Formulario.add(s5);
			Formulario.add(campoTexto5);

			campoTexto6 = new JTextField();
			campoTexto6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto6.setOpaque(false);
        	getContentPane().add(campoTexto6);
			//campoTexto6.setBackground(Color.WHITE);
			campoTexto6.setForeground(Color.WHITE);
			campoTexto6.setBounds(850,215,230,25);
			s6 = new JSeparator();
			s6.setBounds(850,240,230,3);
			Formulario.add(s6);
			Formulario.add(campoTexto6);

			campoTexto7 = new JTextField();
			campoTexto7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto7.setOpaque(false);
        	getContentPane().add(campoTexto7);
			//campoTexto7.setBackground(Color.WHITE);
			campoTexto7.setForeground(Color.WHITE);
			campoTexto7.setBounds(25,395,230,25);
			s7 = new JSeparator();
			s7.setBounds(25,415,230,3);
			Formulario.add(s7);
			Formulario.add(campoTexto7);

			campoTexto8 = new JTextField();
			campoTexto8.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto8.setOpaque(false);
        	getContentPane().add(campoTexto8);
			//campoTexto8.setBackground(Color.WHITE);
			campoTexto8.setForeground(Color.WHITE);
			campoTexto8.setBounds(450,395,230,25);
			s8 = new JSeparator();
			s8.setBounds(450,415,230,3);
			Formulario.add(s8);
			Formulario.add(campoTexto8);

			campoTexto9 = new JTextField();
			campoTexto9.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			campoTexto9.setOpaque(false);
        	getContentPane().add(campoTexto9);
			//campoTexto9.setBackground(Color.WHITE);
			campoTexto9.setForeground(Color.WHITE);
			campoTexto9.setBounds(850,395,230,25);
			s9 = new JSeparator();
			s9.setBounds(850,415,230,3);
			Formulario.add(s9);
			Formulario.add(campoTexto9);

			registro = new JTextArea("");
			scroll = new JScrollPane(registro);
			scroll.setBounds(350,450,665,100);
			add(scroll);
			registro.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			registro.setBackground(Color.BLUE);
			registro.setForeground(Color.WHITE);
			registro.setFont(fuente4);
			registro.setEditable(false);
			Formulario.add(scroll);

			genero = new ButtonGroup();

			genero1 = new JRadioButton("Masculino");
			genero1.setBounds(25,525,130,15);
			genero1.setBackground(new Color(0,0,0,0));
			genero1.setOpaque(false);
			genero1.setContentAreaFilled(false);
			genero1.setBorderPainted(false);
			genero1.setForeground(Color.WHITE);
			genero1.setFont(fuente3);
			Formulario.add(genero1);

			

			genero2 = new JRadioButton("Femenino");
			genero2.setBounds(170,525,130,15);
			genero2.setBackground(new Color(0,0,0,0));
			genero2.setOpaque(false);
			genero2.setContentAreaFilled(false);
			genero2.setBorderPainted(false);
			genero2.setForeground(Color.WHITE);
			genero2.setFont(fuente3);
			Formulario.add(genero2);


			genero.add(genero1);
			genero.add(genero2);

		
			ImageIcon formulita = new ImageIcon("Formulario.jpg");
			formulario = new JLabel(formulita);
			formulario.setBounds(0,0,1200,680);
			Formulario.add(formulario);
			
			//Fin del panel 2(Formulario)

			//Inicio panel 3 (registro de datos del usuario) libreria
			
			barra = new JMenuBar();
			barra.setBackground(Color.WHITE);
			setJMenuBar(barra);


			  sesion = new JMenuItem("Iniciar sesion");
			  sesion.setBackground(Color.WHITE);
			  sesion.setForeground(Color.RED);
			  home = new JMenuItem("Salir");
			  home.setBackground(Color.WHITE);
			  home.setForeground(Color.RED);

			  PrestamosVigentes = new JMenuItem("Consultar prestamos vigentes");
			  PrestamosVigentes.setBackground(Color.WHITE);
			  PrestamosVigentes.setForeground(Color.RED);


			inicio = new JMenu("Inicio");
			barra.add(inicio);
			inicio.add(sesion);
			inicio.add(home);
			inicio.setForeground(Color.RED);
			inicio.setFont(fuente4);
			acciones = new JMenu("Acciones");
			barra.add(acciones);
			acciones.setForeground(Color.RED);
			acciones.setFont(fuente4);
			altaUsuario = new JMenuItem("Seccion de usuarios");
			altaUsuario.setBackground(Color.WHITE);
			altaUsuario.setForeground(Color.RED);
			acciones.add(altaUsuario);
			RegistrarLibro = new JMenuItem("Seccion de Libros");
			RegistrarLibro.setBackground(Color.WHITE);
			RegistrarLibro.setForeground(Color.RED);
			acciones.add(RegistrarLibro);
			modificarDatos = new JMenuItem("Modificar Datos personales");
			modificarDatos.setBackground(Color.WHITE);
			modificarDatos.setForeground(Color.RED);
			acciones.add(modificarDatos);
			bajaUsuario = new JMenuItem("Eliminar cuenta");
			bajaUsuario.setBackground(Color.WHITE);
			bajaUsuario.setForeground(Color.RED);
			acciones.add(bajaUsuario);
			Prestamos = new JMenuItem("Seccion de prestamos");
			Prestamos.setBackground(Color.WHITE);
			Prestamos.setForeground(Color.RED);
			acciones.add(Prestamos);

			consultar = new JMenu("Consultas");
			barra.add(consultar);
			consultar.setForeground(Color.RED);
			consultar.setFont(fuente4);
				  registroPrestamos = new JMenuItem("Mostrar historial de prestamos");
			  registroPrestamos.setBackground(Color.WHITE);
			  registroPrestamos.setForeground(Color.RED);
			  consultar.add(registroPrestamos);

			 UsuariosRegistrados = new JMenuItem("Mostrar usuarios registrados");
			  UsuariosRegistrados.setBackground(Color.WHITE);
			  UsuariosRegistrados.setForeground(Color.RED);
			consultar.add(UsuariosRegistrados);
			LibrosRegistrados = new JMenuItem("Mostrar libros registrados por categoria");
			LibrosRegistrados.setBackground(Color.WHITE);
			LibrosRegistrados.setForeground(Color.RED);
			consultar.add(LibrosRegistrados);
			

			//Fin del panel 3 (libreria)

			//Panel 4 (panel de registrar libros)

			registroLibros = new JPanel();
			registroLibros.setLayout(null);
			registroLibros.setBounds(0,0,1200,680);
			//Libreria.setBackground()
			registroLibros.setVisible(false);
			add(registroLibros);

			e8 = new JLabel("Titulo");
			e8.setBounds(50,40,180,50);
			e8.setForeground(Color.WHITE);
			e8.setFont(fuente4);
			registroLibros.add(e8);

			e9 = new JLabel("Codigo");
			e9.setBounds(50,140,180,50);
			e9.setForeground(Color.WHITE);
			e9.setFont(fuente4);
			registroLibros.add(e9);

			e10 = new JLabel("Autor");
			e10.setBounds(50,240,180,50);
			e10.setForeground(Color.WHITE);
			e10.setFont(fuente4);
			registroLibros.add(e10);

			e11 = new JLabel("Editorial");
			e11.setBounds(50,340,180,50);
			e11.setForeground(Color.WHITE);
			e11.setFont(fuente4);
			registroLibros.add(e11);

			e12 = new JLabel("Categoria");
			e12.setBounds(50,440,180,50);
			e12.setForeground(Color.WHITE);
			e12.setFont(fuente4);
			registroLibros.add(e12);

			registrarLibro = new JButton("Registrar libro");
			registrarLibro.setBounds(300,525,150,36);
			registrarLibro.setBackground(Color.YELLOW);
			registrarLibro.setForeground(Color.BLACK);
			registroLibros.add(registrarLibro);

			modificarLibro = new JButton("Modificar datos de un libro");
			modificarLibro.setBounds(480,525,200,36);
			modificarLibro.setBackground(Color.YELLOW);
			modificarLibro.setForeground(Color.BLACK);
			registroLibros.add(modificarLibro);

			quitarLibro = new JButton("Eliminar libro");
			quitarLibro.setBounds(710,525,150,36);
			quitarLibro.setBackground(Color.YELLOW);
			quitarLibro.setForeground(Color.BLACK);
			registroLibros.add(quitarLibro);

			titulo = new JTextField("Ingresar titulo del libro");
			titulo.setForeground(Color.YELLOW);
			titulo.setBounds(50,70,225,28);
			titulo.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			titulo.setOpaque(false);
			s18 = new JSeparator();
			s18.setBounds(50,98,225,28);
			s18.setBackground(Color.WHITE);
			registroLibros.add(s18);
			registroLibros.add(titulo);

			codigoLibro = new JTextField("Ingresar codigo del libro");
			codigoLibro.setForeground(Color.YELLOW);
			codigoLibro.setBounds(50,170,225,28);
			codigoLibro.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			codigoLibro.setOpaque(false);
			s19 = new JSeparator();
			s19.setBounds(50,198,225,28);
			s19.setBackground(Color.WHITE);
			registroLibros.add(s19);
			registroLibros.add(codigoLibro);
		
			autor = new JTextField("Ingresar el autor del libro");
			autor.setForeground(Color.YELLOW);
			autor.setBounds(50,270,225,28);
			autor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			autor.setOpaque(false);
			s20 = new JSeparator();
			s20.setBounds(50,298,225,28);
			s20.setBackground(Color.WHITE);
			registroLibros.add(s20);
			registroLibros.add(autor);

			editorial = new JTextField("Ingresar editorial");
			editorial.setForeground(Color.YELLOW);
			editorial.setBounds(50,370,225,28);
			editorial.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			editorial.setOpaque(false);
			s21 = new JSeparator();
			s21.setBounds(50,398,225,28);
			s21.setBackground(Color.WHITE);
			registroLibros.add(s21);
			registroLibros.add(editorial);

			categoria = new JTextField("Ingresar la categoria del libro");
			categoria.setForeground(Color.YELLOW);
			categoria.setBounds(50,470,225,28);
			categoria.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			categoria.setOpaque(false);
			s22 = new JSeparator();
			s22.setBounds(50,498,225,28);
			s22.setBackground(Color.WHITE);
			registroLibros.add(s22);
			registroLibros.add(categoria);

			ImageIcon lib = new ImageIcon("RegistrarLibros.png");
			imagen = new JLabel(lib);
			imagen.setBounds(300,110,350,400);
			Icon l = new ImageIcon(lib.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(l);
			registroLibros.add(imagen);

			ImageIcon lib2 = new ImageIcon("RegistrarLibros2.png");
			imagen = new JLabel(lib2);
			imagen.setBounds(610,190,400,325);
			Icon li = new ImageIcon(lib2.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(li);
			registroLibros.add(imagen);

			ImageIcon fd = new ImageIcon("FondoLibro.jpg");
			imagen = new JLabel(fd);
			imagen.setBounds(0,0,1200,680);
			registroLibros.add(imagen);	

			//Fin panel de registrar libros

			//Panel 5 dar de alta usuarios
			usuarios = new JPanel();
			usuarios.setLayout(null);
			usuarios.setBounds(0,0,1200,680);
			usuarios.setVisible(false);
			add(usuarios);

			e20 = new JLabel("Apellido Paterno");
			e20.setBounds(50,25,180,50);
			e20.setForeground(Color.WHITE);
			e20.setFont(fuente4);
			usuarios.add(e20);

			e21 = new JLabel("Apellido Materno");
			e21.setBounds(50,100,180,32);
			e21.setForeground(Color.WHITE);
			e21.setFont(fuente4);
			usuarios.add(e21);

			e22 = new JLabel("Nombre(s)");
			e22.setBounds(50,160,180,32);
			e22.setForeground(Color.WHITE);
			e22.setFont(fuente4);
			usuarios.add(e22);

			e23 = new JLabel("Correo electronico");
			e23.setBounds(50,220,180,32);
			e23.setForeground(Color.WHITE);
			e23.setFont(fuente4);
			usuarios.add(e23);

			e24 = new JLabel("Telefono");
			e24.setBounds(50,280,180,32);
			e24.setForeground(Color.WHITE);
			e24.setFont(fuente4);
			usuarios.add(e24);

			e25 = new JLabel("Domicilio");
			e25.setBounds(50,340,180,32);
			e25.setForeground(Color.WHITE);
			e25.setFont(fuente4);
			usuarios.add(e25);

			e26 = new JLabel("Crear o ingresar ID (Para modificar o eliminar datos)");
			e26.setBounds(50,400,425,32);
			e26.setForeground(Color.WHITE);
			e26.setFont(fuente4);
			usuarios.add(e26);

			dardeAltaUsuario = new JButton("Dar de alta");
			dardeAltaUsuario.setForeground(Color.CYAN);
			dardeAltaUsuario.setBackground(Color.BLACK);
			//dardeAltaUsuario.setFont(fuente4);
			dardeAltaUsuario.setBounds(380,570,180,38);
			usuarios.add(dardeAltaUsuario);

			actualizador = new JButton("Actualizar datos del usuario");
			actualizador.setForeground(Color.CYAN);
			actualizador.setBackground(Color.BLACK);
			//actualizador.setFont(fuente4);
			actualizador.setBounds(580,570,220,38);
			usuarios.add(actualizador);

			baja = new JButton("Dar de baja un usuario");
			baja.setForeground(Color.CYAN);
			baja.setBackground(Color.BLACK);
			//baja.setFont(fuente4);
			baja.setBounds(820,570,180,38);
			usuarios.add(baja);

			apellidoPaterno = new JTextField("Ingrese su apellido paterno");
			apellidoPaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			apellidoPaterno.setOpaque(false);
			apellidoPaterno.setForeground(new Color(128,128,128));
			apellidoPaterno.setBounds(50,70,225,32);
			s11 = new JSeparator();
			s11.setBounds(50,102,225,32);
			s11.setBackground(Color.WHITE);
			usuarios.add(s11);
			usuarios.add(apellidoPaterno);

			apellidoMaterno = new JTextField("Ingrese su apellido materno");
			apellidoMaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			apellidoMaterno.setOpaque(false);
			apellidoMaterno.setForeground(new Color(128,128,128));
			apellidoMaterno.setBounds(50,130,225,32);
			s12 = new JSeparator();
			s12.setBounds(50,162,225,32);
			s12.setBackground(Color.WHITE);
			usuarios.add(s12);
			usuarios.add(apellidoMaterno);

			nombreS = new JTextField("Ingresar nombre(s)");
			nombreS.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			nombreS.setOpaque(false);
			nombreS.setForeground(new Color(128,128,128));
			nombreS.setBounds(50,190,225,32);
			s13 = new JSeparator();
			s13.setBounds(50,222,225,32);
			s13.setBackground(Color.WHITE);
			usuarios.add(s13);
			usuarios.add(nombreS);

			correoE = new JTextField("Ingrese su e-mail");
			correoE.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			correoE.setOpaque(false);
			correoE.setForeground(new Color(128,128,128));
			correoE.setBounds(50,250,225,32);
			s14 = new JSeparator();
			s14.setBounds(50,282,225,32);
			s14.setBackground(Color.WHITE);
			usuarios.add(s14);
			usuarios.add(correoE);

			telNum = new JTextField("Ingrese su numero telefonico");
			telNum.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			telNum.setOpaque(false);
			telNum.setForeground(new Color(128,128,128));
			telNum.setBounds(50,310,225,32);
			s15 = new JSeparator();
			s15.setBounds(50,342,225,32);
			s15.setBackground(Color.WHITE);
			usuarios.add(s15);
			usuarios.add(telNum);

			adress = new JTextField("Ingrese su domicilio");
			adress.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			adress.setOpaque(false);
			adress.setForeground(new Color(128,128,128));
			adress.setBounds(50,370,225,32);
			s16 = new JSeparator();
			s16.setBounds(50,402,225,32);
			s16.setBackground(Color.WHITE);
			usuarios.add(s16);
			usuarios.add(adress);

			codigoID = new JTextField("ID");
			codigoID.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			codigoID.setOpaque(false);
			codigoID.setForeground(new Color(128,128,128));
			codigoID.setBounds(50,430,225,32);
			s17 = new JSeparator();
			s17.setBounds(50,462,225,32);
			s17.setBackground(Color.WHITE);
			usuarios.add(s17);
			usuarios.add(codigoID);

			ImageIcon regis = new ImageIcon("altaUsuario.png");
			imagen = new JLabel(regis);
			imagen.setBounds(670,130,300,300);
			Icon reg = new ImageIcon(regis.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(reg);
			usuarios.add(imagen);

			ImageIcon backG = new ImageIcon("FondoUsuario.jpg");
			imagen = new JLabel(backG);
			imagen.setBounds(0,0,1200,680);
			usuarios.add(imagen);


			//Panel 6 realizar prestamos

			prestamos = new JPanel();
			prestamos.setLayout(null);
			prestamos.setBounds(0,0,1200,680);
			//Libreria.setBackground()
			prestamos.setVisible(false);
			add(prestamos);

			e27 = new JLabel("Nombre(s):");
			e27.setBounds(50,25,180,50);
			e27.setForeground(Color.WHITE);
			e27.setFont(fuente4);
			prestamos.add(e27);

			e28 = new JLabel("Domicilio:");
			e28.setBounds(50,100,180,32);
			e28.setForeground(Color.WHITE);
			e28.setFont(fuente4);
			prestamos.add(e28);

			e29 = new JLabel("Numero de telefono:");
			e29.setBounds(50,160,180,32);
			e29.setForeground(Color.WHITE);
			e29.setFont(fuente4);
			prestamos.add(e29);

			e30 = new JLabel("Correo electronico:");
			e30.setBounds(50,220,180,32);
			e30.setForeground(Color.WHITE);
			e30.setFont(fuente4);
			prestamos.add(e30);

			e31 = new JLabel("Fecha del prestamo:");
			e31.setBounds(50,280,250,32);
			e31.setForeground(Color.WHITE);
			e31.setFont(fuente4);
			prestamos.add(e31);

			e32 = new JLabel("Fecha de devolucion:");
			e32.setBounds(50,340,180,32);
			e32.setForeground(Color.WHITE);
			e32.setFont(fuente4);
			prestamos.add(e32);

			e33 = new JLabel("Ingresar ID del libro a tomar:");
			e33.setBounds(50,400,320,32);
			e33.setForeground(Color.WHITE);
			e33.setFont(fuente4);
			prestamos.add(e33);

			e34 = new JLabel("Ingrese su ID personal:");
			e34.setBounds(50,460,225,32);
			e34.setForeground(Color.WHITE);
			e34.setFont(fuente4);
			prestamos.add(e34);

			c1 = new JTextField("Ingresar nombre(s)");
			c1.setBounds(50,70,225,32);
			c1.setForeground(Color.RED);
			c1.setOpaque(false);
			c1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s23 = new JSeparator();
			s23.setBounds(50,102,225,32);
			s23.setBackground(Color.WHITE);
			prestamos.add(s23);
			prestamos.add(c1);

			c2 = new JTextField("Ingresar domicilio");
			c2.setBounds(50,130,225,32);
			c2.setForeground(Color.RED);
			c2.setOpaque(false);
			c2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s24 = new JSeparator();
			s24.setBounds(50,162,225,32);
			s24.setBackground(Color.WHITE);
			prestamos.add(s24);
			prestamos.add(c2);

			c3 = new JTextField("Ingresar # de telefono");
			c3.setBounds(50,190,225,32);
			c3.setForeground(Color.RED);
			c3.setOpaque(false);
			c3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s25 = new JSeparator();
			s25.setBounds(50,222,225,32);
			s25.setBackground(Color.WHITE);
			prestamos.add(s25);
			prestamos.add(c3);

			c4 = new JTextField("Ingrese su correo");
			c4.setBounds(50,250,225,32);
			c4.setForeground(Color.RED);
			c4.setOpaque(false);
			c4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s26 = new JSeparator();
			s26.setBounds(50,282,225,32);
			s26.setBackground(Color.WHITE);
			prestamos.add(s26);
			prestamos.add(c4);

			c5 = new JTextField("Ingrese la fecha");
			c5.setBounds(50,310,225,32);
			c5.setForeground(Color.RED);
			c5.setOpaque(false);
			c5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s27 = new JSeparator();
			s27.setBounds(50,342,225,32);
			s27.setBackground(Color.WHITE);
			prestamos.add(s27);
			prestamos.add(c5);

			c6 = new JTextField("Ingrese la fecha");
			c6.setBounds(50,370,225,32);
			c6.setForeground(Color.RED);
			c6.setOpaque(false);
			c6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s29 = new JSeparator();
			s29.setBounds(50,402,225,32);
			s29.setBackground(Color.WHITE);
			prestamos.add(s29);
			prestamos.add(c6);

			c7 = new JTextField("Ingrese ID");
			c7.setBounds(50,430,225,32);
			c7.setForeground(Color.RED);
			c7.setOpaque(false);
			c7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s30 = new JSeparator();
			s30.setBounds(50,462,225,32);
			s30.setBackground(Color.WHITE);
			prestamos.add(s30);
			prestamos.add(c7);

			c8 = new JTextField("Ingrese ID");
			c8.setBounds(50,490,225,32);
			c8.setForeground(Color.RED);
			c8.setOpaque(false);
			c8.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			s31 = new JSeparator();
			s31.setBounds(50,522,225,32);
			s31.setBackground(Color.WHITE);
			prestamos.add(s31);
			prestamos.add(c8);

			b1 = new JButton("Registrar prestamo");
			b1.setBounds(450,570,180,38);
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			prestamos.add(b1);

			b2 = new JButton("Devolver libro");
			b2.setBounds(650,570,180,38);
			b2.setForeground(Color.WHITE);
			b2.setBackground(Color.BLACK);
			prestamos.add(b2);

			ImageIcon pres = new ImageIcon("prestamo.png");
			imagen = new JLabel(pres);
			imagen.setBounds(445,75,600,450);
			Icon pr = new ImageIcon(pres.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(pr);
			prestamos.add(imagen);

			ImageIcon fp = new ImageIcon("FondoPrestamo.jpg");
			imagen = new JLabel(fp);
			imagen.setBounds(0,0,1200,680);
			prestamos.add(imagen);	

		
			//Panel 7 consulta de usuarios registrados

			muestraUsuarios = new JPanel();
			muestraUsuarios.setLayout(null);
			muestraUsuarios.setBounds(0,0,1200,680);
			muestraUsuarios.setVisible(false);
			add(muestraUsuarios);


			usuariosBD = new JTextArea("");
			scroll2 = new JScrollPane(usuariosBD);
			scroll2.setBounds(50,100,760,400);
			add(scroll2);
			usuariosBD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			usuariosBD.setEditable(false);
			usuariosBD.setFont(fuente4);
			usuariosBD.setBackground(Color.BLACK);
			usuariosBD.setForeground(Color.WHITE);
			muestraUsuarios.add(scroll2);

			listaUsuarios = new JLabel("Lista de usuarios dados de alta en la base de datos");
			listaUsuarios.setBounds(100,50,1000,30);
			listaUsuarios.setFont(fuente);
			listaUsuarios.setForeground(Color.PINK);
			muestraUsuarios.add(listaUsuarios);

			ImageIcon pers = new ImageIcon("listaUsuarios.png");
			imagen = new JLabel(pers);
			imagen.setBounds(860,200,300,300);
			Icon p = new ImageIcon(pers.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(p);
			muestraUsuarios.add(imagen);

			ImageIcon f = new ImageIcon("FondoPurple.jpg");
			imagen = new JLabel(f);
			imagen.setBounds(0,0,1200,680);
			Icon morado = new ImageIcon(f.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(morado);
			muestraUsuarios.add(imagen);

			//Panel 8 consulta de libros registrados

			muestraLibros = new JPanel();
			muestraLibros.setLayout(null);
			muestraLibros.setBounds(0,0,1200,680);
			muestraLibros.setVisible(false);
			add(muestraLibros);

			consultaLibro = new JButton("Buscar libro");
			consultaLibro.setBounds(750,530,200,35);
			muestraLibros.add(consultaLibro);

			c9 = new JTextField("Ingrese la categoria de su libro");
			c9.setForeground(new Color(128,128,128));
			c9.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			c9.setOpaque(false);
			c9.setBounds(525,530,200,32);
			s10 = new JSeparator();
			s10.setBounds(525,562,200,32);
			muestraLibros.add(s10);
			muestraLibros.add(c9);

			librosBD = new JTextArea("");
			scroll3 = new JScrollPane(librosBD);
			scroll3.setBounds(390,100,760,400);
			add(scroll3);
			librosBD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			librosBD.setEditable(false);
			librosBD.setFont(fuente4);
			muestraLibros.add(scroll3);

			listaLibros = new JLabel("Lista de libros registrados");
			listaLibros.setBounds(425,50,1000,30);
			listaLibros.setFont(fuente);
			muestraLibros.add(listaLibros);

			ImageIcon redBook = new ImageIcon("Libreria logo.png");
			imagen = new JLabel(redBook);
			imagen.setBounds(65,280,300,175);
			Icon book = new ImageIcon(redBook.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(book);
			muestraLibros.add(imagen);

			ImageIcon background = new ImageIcon("Fondito.jpg");
			imagen = new JLabel(background);
			imagen.setBounds(0,0,1200,680);
			Icon amarillo = new ImageIcon(background.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(amarillo);
			muestraLibros.add(imagen);

			//Panel 10 consulta de prestamos
			muestraPrestamos = new JPanel();
			muestraPrestamos.setLayout(null);
			muestraPrestamos.setBounds(0,0,1200,680);
			muestraPrestamos.setVisible(false);
			add(muestraPrestamos);

			prestamosBD = new JTextArea("");
			scroll4 = new JScrollPane(prestamosBD);
			scroll4.setBounds(50,100,760,400);
			add(scroll4);
			prestamosBD.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			prestamosBD.setEditable(false);
			prestamosBD.setFont(fuente4);
			prestamosBD.setBackground(new Color(204,255,255));
			muestraPrestamos.add(scroll4);

			listaPrestamos = new JLabel("Historial de prestamos");
			listaPrestamos.setBounds(150,50,1000,30);
			listaPrestamos.setFont(fuente);
			muestraPrestamos.add(listaPrestamos);

			ImageIcon prss = new ImageIcon("pres.png");
			imagen = new JLabel(prss);
			imagen.setBounds(860,200,300,300);
			Icon pt = new ImageIcon(prss.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(pt);
			muestraPrestamos.add(imagen);

			ImageIcon g = new ImageIcon("FondoPres.jpg");
			imagen = new JLabel(g);
			imagen.setBounds(0,0,1200,680);
			Icon green = new ImageIcon(g.getImage().getScaledInstance(imagen.getWidth(),imagen.getHeight(),Image.SCALE_DEFAULT));
			imagen.setIcon(green);
			muestraPrestamos.add(imagen);


		b1.addActionListener(this);
		b2.addActionListener(this);
		consultaLibro.addActionListener(this);
		baja.addActionListener(this);
		actualizador.addActionListener(this);
		dardeAltaUsuario.addActionListener(this);
		CrearCuenta.addActionListener(this);
		CrearCuenta.addKeyListener(this);
		IniciarSesion.addActionListener(this);
		IniciarSesion.addKeyListener(this);
		registrarLibro.addActionListener(this);
		modificarLibro.addActionListener(this);
		quitarLibro.addActionListener(this);
		campo1.addKeyListener(this);
		campo2.addKeyListener(this);
		box.addActionListener(this);

		//Acciones paneles
		addKeyListener(this);
		altaUsuario.addActionListener(this);
		IngresoDatos.setFocusable(true);
		IngresoDatos.addKeyListener(this);
		Formulario.addKeyListener(this);
		

			//Acciones del formulario

			boton1.addActionListener(this);
			boton2.addActionListener(this);
			boton1.addKeyListener(this);
			boton2.addKeyListener(this);
			boton3.addActionListener(this);
			boton3.addKeyListener(this);

			campoTexto1.addFocusListener(this);
			campoTexto2.addFocusListener(this);
			campoTexto3.addFocusListener(this);
			campoTexto4.addFocusListener(this);
			campoTexto5.addFocusListener(this);
			campoTexto6.addFocusListener(this);


			campoTexto1.addKeyListener(this);
			campoTexto2.addKeyListener(this);
			campoTexto3.addKeyListener(this);
			campoTexto4.addKeyListener(this);
			campoTexto5.addKeyListener(this);
			campoTexto6.addKeyListener(this);
			genero2.addKeyListener(this);
			genero1.addKeyListener(this);

			registro.addKeyListener(this);

			genero1.addChangeListener(this);
			genero2.addChangeListener(this);

			//acciones menus e items
			RegistrarLibro.addActionListener(this);
			UsuariosRegistrados.addActionListener(this);
			registroPrestamos.addActionListener(this);
			PrestamosVigentes.addActionListener(this);
			sesion.addActionListener(this);
			modificarDatos.addActionListener(this);
			LibrosRegistrados.addActionListener(this);
			Prestamos.addActionListener(this);
			home.addActionListener(this);
			bajaUsuario.addActionListener(this);

			c9.addMouseListener(this);
			campo1.addMouseListener(this);
			campo2.addMouseListener(this);
			apellidoPaterno.addMouseListener(this);
			apellidoMaterno.addMouseListener(this);
			nombreS.addMouseListener(this);
			correoE.addMouseListener(this);
			telNum.addMouseListener(this);
			adress.addMouseListener(this);
			codigoID.addMouseListener(this);
			titulo.addMouseListener(this);
			codigoLibro.addMouseListener(this);
			autor.addMouseListener(this);
			editorial.addMouseListener(this);
			categoria.addMouseListener(this);
			c1.addMouseListener(this);
			c2.addMouseListener(this);
			c3.addMouseListener(this);
			c4.addMouseListener(this);
			c5.addMouseListener(this);
			c6.addMouseListener(this);
			c7.addMouseListener(this);
			c8.addMouseListener(this);
	}

	public void mouseEntered(MouseEvent e){
	
		}

	public void mouseExited(MouseEvent e){
	
	}

	public void mousePressed(MouseEvent e){

	}
	public void mouseReleased(MouseEvent e){
		}

	public void mouseClicked(MouseEvent e){
		vacio1 = campo1.getText();
		vacio2 = campo2.getText();
		campo2.setEchoChar('*');
		if(e.getSource() == c1){
			c1.setText("");
			c1.setForeground(Color.WHITE);
		}
		if(e.getSource() == c2){
			c2.setText("");
			c2.setForeground(Color.WHITE);
		}
		if(e.getSource() == c3){
			c3.setText("");
			c3.setForeground(Color.WHITE);
		}
		if(e.getSource() == c4){
			c4.setText("");
			c4.setForeground(Color.WHITE);
		}
		if(e.getSource() == c5){
			c5.setText("");
			c5.setForeground(Color.WHITE);
		}
		if(e.getSource() == c6){
			c6.setText("");
			c6.setForeground(Color.WHITE);
		}
		if(e.getSource() == c7){
			c7.setText("");
			c7.setForeground(Color.WHITE);
		}
		if(e.getSource() == c8){
			c8.setText("");
			c8.setForeground(Color.WHITE);
		}
		if(e.getSource() == titulo){
			titulo.setText("");
			titulo.setForeground(Color.WHITE);
		}
		if(e.getSource() == codigoLibro){
			codigoLibro.setText("");
			codigoLibro.setForeground(Color.WHITE);
		}
		if(e.getSource() == autor){
			autor.setText("");
			autor.setForeground(Color.WHITE);
		}
		if(e.getSource() == editorial){
			editorial.setText("");
			editorial.setForeground(Color.WHITE);
		}
		if(e.getSource() == categoria){
			categoria.setText("");
			categoria.setForeground(Color.WHITE);
		}
		if(e.getSource() == apellidoPaterno){
			apellidoPaterno.setText("");
			apellidoPaterno.setForeground(Color.WHITE);
		}
		if(e.getSource() == apellidoMaterno){
			apellidoMaterno.setText("");
			apellidoMaterno.setForeground(Color.WHITE);
		}
		if(e.getSource() == nombreS){
			nombreS.setText("");
			nombreS.setForeground(Color.WHITE);
		}
		if(e.getSource() == correoE){
			correoE.setText("");
			correoE.setForeground(Color.WHITE);
		}
		if(e.getSource() == telNum){
			telNum.setText("");
			telNum.setForeground(Color.WHITE);
		}
		if(e.getSource() == adress){
			adress.setText("");
			adress.setForeground(Color.WHITE);
		}
		if(e.getSource() == codigoID){
			codigoID.setText("");
			codigoID.setForeground(Color.WHITE);
		}
		if(e.getSource() == c9){
			System.out.println("Jalando ando");
			c9.setText("");
			c9.setForeground(Color.WHITE);
		}
		if(e.getSource() == campo1 && vacio1.equals("Ingrese su nombre de usuario")){
			campo1.setText("");
			campo1.setForeground(Color.BLACK);
		}
		if(e.getSource() == campo2 && vacio2.equals("********************")){
			campo2.setText("");
			campo2.setForeground(Color.BLACK);
		}

		if(e.getSource() == campo1 && vacio2.equals("")){
			campo2.setText("********************");
			campo2.setForeground(new Color(128,128,128));
		}
		if(e.getSource() == campo2 && vacio1.equals("")){
			campo1.setText("Ingrese su nombre de usuario");
			campo1.setForeground(new Color(128,128,128));
		}
		
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==27){
				JOptionPane.showMessageDialog(null,"Ha tecleado la tecla de cerrado, que tenga un buen dia :)");
				System.exit(0);
		}

	}

	public void keyReleased(KeyEvent e){
	
		if(e.getKeyCode()==10){

				if(apartadoUsuario >= 3 || apartadoUsuario>=0 ){
				apartadoUsuario++;
				CompararPassword = new String(campo2.getPassword());
				CompararUsuario = campo1.getText();
				
					if(password.equals(CompararPassword) && Usuario.equals(CompararUsuario)){
						CompararPassword = "";
						CompararUsuario = "";
						campo1.setText("");
						campo2.setText("");
						apartadoSeguridad++;
						apartadoUsuario=0;
						apartadoCuenta=0;
						Inicio++;
					JOptionPane.showMessageDialog(null,"Bienvenid@ a nuestra seccion de libros");
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					Portada.setVisible(true);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
					setTitle("Control de libros");

					/*Aqui se abrira el contenido de la libreria*/
				}else{
					JOptionPane.showMessageDialog(null,"Contrasenia o usuario incorrecto");
				}
			
		}	
	}

	}


	public void keyTyped(KeyEvent e){

	}

	public void focusGained(FocusEvent e){
		
		
		
	}

	public void focusLost(FocusEvent e){
		
		cadena1 = campoTexto1.getText();
		 cadena2 = campoTexto2.getText();
		 cadena3 = campoTexto3.getText();
		 cadena4 = campoTexto4.getText();
		 cadena5 = campoTexto5.getText();
		 cadena6 = campoTexto6.getText();
		 
			
			 longitud1 = cadena1.length();
			 longitud2 = cadena2.length();
			 longitud3 = cadena3.length();
			 longitud4 = cadena4.length();
			 longitud5 = cadena5.length();
			 longitud6 = cadena6.length();
		

			for(int x=0; x<longitud1; x++){
				char caracter = cadena1.charAt(x);
				int caracterCode = (int) caracter;

				if(caracterCode >=65 && caracterCode <= 122){
					a++;
				}else{
					a=0;
				}
			}

		}

	public void actionPerformed(ActionEvent operacion){

		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String AccionSQL = "";
		String cade = "";
		int nRegistros = 0;
		String comprobador = "";
		comprobador = boton1.getText();


		if(operacion.getSource() == bajaUsuario && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == altaUsuario && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == RegistrarLibro && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == modificarDatos && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == UsuariosRegistrados && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == Prestamos && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == registroPrestamos && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == PrestamosVigentes && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");
		if(operacion.getSource() == LibrosRegistrados && inicioGlobal == 0) JOptionPane.showMessageDialog(null,"No tiene acceso a estos menus si no ha iniciado sesion");

		if(operacion.getSource() == b2 && inicioGlobal>0){
			System.out.println("Accediendo base de datos libreria");
				try{
					int res = 0;
					AccionSQL = "DELETE FROM prestamos WHERE ID_Libro = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,c7.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"EL libro ha sido devuelto exitosamente");
					res = JOptionPane.showConfirmDialog(null,"Desea devolver otro libro?");
					
					if(res == 0){
						c1.setText("Ingresar nombre(s)");
						c1.setForeground(Color.RED);
						c2.setText("Ingresar domicilio");
						c2.setForeground(Color.RED);
						c3.setText("Ingresar # de telefono");
						c3.setForeground(Color.RED);
						c4.setText("Ingrese su correo");
						c4.setForeground(Color.RED);
						c5.setText("Ingrese la fecha");
						c5.setForeground(Color.RED);
						c6.setText("Ingrese la fecha");
						c6.setForeground(Color.RED);
						c7.setText("Ingrese ID");
						c7.setForeground(Color.RED);
						c8.setText("Ingrese ID");
						c8.setForeground(Color.RED);
					}
						if(res == 1){
							JOptionPane.showMessageDialog(null,"Accion hecha");
						}
							if(res == 2){
								c1.setText("Ingresar nombre(s)");
								c1.setForeground(Color.RED);
								c2.setText("Ingresar domicilio");
								c2.setForeground(Color.RED);
								c3.setText("Ingresar # de telefono");
								c3.setForeground(Color.RED);
								c4.setText("Ingrese su correo");
								c4.setForeground(Color.RED);
								c5.setText("Ingrese la fecha");
								c5.setForeground(Color.RED);
								c6.setText("Ingrese la fecha");
								c6.setForeground(Color.RED);
								c7.setText("Ingrese ID");
								c7.setForeground(Color.RED);
								c8.setText("Ingrese ID");
								c8.setForeground(Color.RED);
							}
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		}

		if(operacion.getSource() == b1 && inicioGlobal>0){
				System.out.println("Accediendo base de datos libreria");
				try{
					int r = 0;
					AccionSQL = "INSERT INTO prestamos VALUES(?,?,?,?,?,?,?,?)";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					JOptionPane.showMessageDialog(null,"El prestamo se ha hecho exitosamente");
					r = JOptionPane.showConfirmDialog(null,"Desea realizar otro prestamo?");
					pst = cn.prepareStatement(AccionSQL);
					if(r == 0){
								c1.setText("Ingresar nombre(s)");
								c1.setForeground(Color.RED);
								c2.setText("Ingresar domicilio");
								c2.setForeground(Color.RED);
								c3.setText("Ingresar # de telefono");
								c3.setForeground(Color.RED);
								c4.setText("Ingrese su correo");
								c4.setForeground(Color.RED);
								c5.setText("Ingrese la fecha");
								c5.setForeground(Color.RED);
								c6.setText("Ingrese la fecha");
								c6.setForeground(Color.RED);
								c7.setText("Ingrese ID");
								c7.setForeground(Color.RED);
								c8.setText("Ingrese ID");
								c8.setForeground(Color.RED);
					}
						if(r == 1){
							JOptionPane.showMessageDialog(null,"Accion hecha");
						}
							if(r == 2){
								c1.setText("Ingresar nombre(s)");
								c1.setForeground(Color.RED);
								c2.setText("Ingresar domicilio");
								c2.setForeground(Color.RED);
								c3.setText("Ingresar # de telefono");
								c3.setForeground(Color.RED);
								c4.setText("Ingrese su correo");
								c4.setForeground(Color.RED);
								c5.setText("Ingrese la fecha");
								c5.setForeground(Color.RED);
								c6.setText("Ingrese la fecha");
								c6.setForeground(Color.RED);
								c7.setText("Ingrese ID");
								c7.setForeground(Color.RED);
								c8.setText("Ingrese ID");
								c8.setForeground(Color.RED);
							}

					pst.setString(1,c1.getText());
					pst.setString(2,c2.getText());
					pst.setString(3,c3.getText());
					pst.setString(4,c4.getText());
					pst.setString(5,c5.getText());
					pst.setString(6,c6.getText());
					pst.setString(7,c7.getText());
					pst.setString(8,c8.getText());
					pst.executeUpdate();

		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		}
		if(box.isSelected() == true){
			ImageIcon ojo = new ImageIcon("Ojo cerrado.png");
			Icon open = new ImageIcon(ojo.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
			echo = campo2.getEchoChar();
			box.setIcon(open);
			campo2.setEchoChar((char)0);
		}else{
			ImageIcon ojo = new ImageIcon("Ojo abierto.png");
			Icon open = new ImageIcon(ojo.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
			box.setIcon(open);
			campo2.setEchoChar(echo);
		}

if(operacion.getSource() == LibrosRegistrados && inicioGlobal>0){
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(true);
					muestraPrestamos.setVisible(false);
		
	}
if(operacion.getSource() == consultaLibro && inicioGlobal>0){
			
			System.out.println("Accediendo base de datos libreria");
			try{

					
					AccionSQL = "SELECT * FROM registrolibros WHERE Categoria = ?";
					cade = "\t\t\t\tLibros registrados\n\nCodigo:\t\tTitulo:\t\t\tAutor:\t\tEditorial:\t\tCategoria:";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);
					pst.setString(1,c9.getText());
					rs = pst.executeQuery();
				
					while(rs.next()){
						cade = cade + "\n" +
								rs.getString("Codigo") + "\t" + "\t" +
								rs.getString("Titulo") + "\t" + "\t" +
								rs.getString("Autor") + "\t" + "\t" +
								rs.getString("Editorial") + "\t" + "\t" +
								rs.getString("Categoria")  ;
							nRegistros++;
					}
					System.out.println(nRegistros);
					if(nRegistros == 0) cade = cade + "\n\tNo se encontraron registros\n";
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		librosBD.setText(cade);

		try{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(cn != null) cn.close();
		}catch(SQLException e){
			System.out.println("Algo salio mal: "+e.getMessage());
		}
		c9.setText("Ingrese la categoria de su libro");
			c9.setForeground(new Color (128,128,128));
		}
		if(operacion.getSource() == UsuariosRegistrados && inicioGlobal > 0){//Continuar aqui en consultas-------------------------------------------
			
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(true);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
			System.out.println("Accediendo base de datos libreria");
			try{
					AccionSQL = "SELECT * FROM altausuarios";
					cade = "\t\t\tUsuarios registrados\n\nApellido paterno:\tApellido Materno:\tNombre(s):\t\t          ID:";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);
					rs = pst.executeQuery();

					while(rs.next()){
						cade = cade + "\n" +
								rs.getString("Apellido_Paterno") + "\t\t"  +
								rs.getString("Apellido_Materno") + "\t\t"  +
								rs.getString("Nombres") + "\t\t"  +
								rs.getString("ID") + "\t";
							nRegistros++;
					}
					System.out.println(nRegistros);
					if(nRegistros == 0) cade = cade + "\tNo se encontraron registros\n";
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		usuariosBD.setText(cade);

		try{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(cn != null) cn.close();
		}catch(SQLException e){
			System.out.println("Algo salio mal: "+e.getMessage());
		}

}
		if(operacion.getSource() == altaUsuario && inicioGlobal > 0){
			IngresoDatos.setVisible(false);
					registroLibros.setVisible(false);			
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(true);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);

		}
		if(operacion.getSource() == baja && inicioGlobal > 0){
			System.out.println("Accediendo base de datos libreria");
				try{
					int a = 0;
					AccionSQL = "DELETE FROM altausuarios WHERE ID = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,codigoID.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Los datos del usuario han sido dados de baja");
					a = JOptionPane.showConfirmDialog(null,"Desea dar de baja otro usuario?");
					if(a == 0){
								apellidoPaterno.setText("Ingrese su apellido paterno");
								apellidoPaterno.setForeground(new Color(128,128,128));
								apellidoMaterno.setText("Ingresar su apellido materno");
								apellidoMaterno.setForeground(new Color(128,128,128));
								nombreS.setText("Ingresar nombre(s)");
								nombreS.setForeground(new Color(128,128,128));
								correoE.setText("Ingrese su e-mail");
								correoE.setForeground(new Color(128,128,128));
								telNum.setText("Ingrese su numero telefonico");
								telNum.setForeground(new Color(128,128,128));
								adress.setText("Ingrese su numero domicilio");
								adress.setForeground(new Color(128,128,128));
								codigoID.setText("ID");
								codigoID.setForeground(new Color(128,128,128));
					}
						if(a == 1){
							JOptionPane.showMessageDialog(null,"Accion hecha");
						}
							if(a == 2){
								apellidoPaterno.setText("Ingrese su apellido paterno");
								apellidoPaterno.setForeground(new Color(128,128,128));
								apellidoMaterno.setText("Ingresar su apellido materno");
								apellidoMaterno.setForeground(new Color(128,128,128));
								nombreS.setText("Ingresar nombre(s)");
								nombreS.setForeground(new Color(128,128,128));
								correoE.setText("Ingrese su e-mail");
								correoE.setForeground(new Color(128,128,128));
								telNum.setText("Ingrese su numero telefonico");
								telNum.setForeground(new Color(128,128,128));
								adress.setText("Ingrese su numero domicilio");
								adress.setForeground(new Color(128,128,128));
								codigoID.setText("ID");
								codigoID.setForeground(new Color(128,128,128));
								
							}
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		}
		if(operacion.getSource() == actualizador && inicioGlobal > 0){//Modifica y Actualiza datos del usuario en la base de datos segun su ID
			System.out.println("Accediendo base de datos libreria");
				try{
					int b = 0;
					AccionSQL = "UPDATE altausuarios SET Apellido_Paterno = ?, Apellido_Materno = ?, Nombres = ?, Correo = ?, Telefono = ?, Domicilio = ?, ID = ? WHERE ID = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,apellidoPaterno.getText());
					pst.setString(2,apellidoMaterno.getText());
					pst.setString(3,nombreS.getText());
					pst.setString(4,correoE.getText());
					pst.setString(5,telNum.getText());
					pst.setString(6,adress.getText());
					pst.setString(7,codigoID.getText());
					pst.setString(8,codigoID.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Los datos del usuario han sido actualizados");
					JOptionPane.showConfirmDialog(null,"Desea actualizar otro usuario en base a su ID?");

					if(b == 0){
								
								codigoID.setText("ID");
								codigoID.setForeground(new Color(128,128,128));
					}
						if(b == 1){
							JOptionPane.showMessageDialog(null,"Accion hecha");
						}
							if(b == 2){
								apellidoPaterno.setText("Ingrese su apellido paterno");
								apellidoPaterno.setForeground(new Color(128,128,128));
								apellidoMaterno.setText("Ingresar su apellido materno");
								apellidoMaterno.setForeground(new Color(128,128,128));
								nombreS.setText("Ingresar nombre(s)");
								nombreS.setForeground(new Color(128,128,128));
								correoE.setText("Ingrese su e-mail");
								correoE.setForeground(new Color(128,128,128));
								telNum.setText("Ingrese su numero telefonico");
								telNum.setForeground(new Color(128,128,128));
								adress.setText("Ingrese su numero domicilio");
								adress.setForeground(new Color(128,128,128));
								codigoID.setText("ID");
								codigoID.setForeground(new Color(128,128,128));
								
							}
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
}
		if(operacion.getSource() == dardeAltaUsuario && inicioGlobal > 0){
			System.out.println("Accediendo base de datos libreria");
				try{
					int c = 0;
					AccionSQL = "INSERT INTO altausuarios VALUES(?,?,?,?,?,?,?)";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,apellidoPaterno.getText());
					pst.setString(2,apellidoMaterno.getText());
					pst.setString(3,nombreS.getText());
					pst.setString(4,correoE.getText());
					pst.setString(5,telNum.getText());
					pst.setString(6,adress.getText());
					pst.setString(7,codigoID.getText());
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null,"El usuario ha sido dado de alta a la base de datos exitosamente");
					JOptionPane.showConfirmDialog(null,"Desea dar de alta a otro usuario?");
					if(c == 0){
								
								apellidoPaterno.setText("Ingrese su apellido paterno");
								apellidoMaterno.setText("Ingresar su apellido materno");
								nombreS.setText("Ingresar nombre(s)");
								correoE.setText("Ingrese su e-mail");
								telNum.setText("Ingrese su numero telefonico");
								adress.setText("Ingrese su numero domicilio");
								codigoID.setText("ID");
					}
						if(c == 1){
							JOptionPane.showMessageDialog(null,"Accion hecha");
						}
							if(c == 2){
								apellidoPaterno.setText("Ingrese su apellido paterno");
								apellidoMaterno.setText("Ingresar su apellido materno");
								nombreS.setText("Ingresar nombre(s)");
								correoE.setText("Ingrese su e-mail");
								telNum.setText("Ingrese su numero telefonico");
								adress.setText("Ingrese su numero domicilio");
								codigoID.setText("ID");
								
							}



		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		}
		if(operacion.getSource() == sesion){
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(true);
					
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
		}
		if(operacion.getSource() == RegistrarLibro && inicioGlobal >0){
			
					
					JOptionPane.showMessageDialog(null,"Ya puede registrar libros");
					registroLibros.setVisible(true);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
				
				
		}
		if(operacion.getSource() == registrarLibro && inicioGlobal > 0){
			System.out.println("Accediendo base de datos libreria");
				try{
					int d = 0;
					AccionSQL = "INSERT INTO registrolibros VALUES(?,?,?,?,?)";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,codigoLibro.getText());
					pst.setString(2,titulo.getText());
					pst.setString(3,autor.getText());
					pst.setString(4,editorial.getText());
					pst.setString(5,categoria.getText());
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null,"El libro ha sido registrado a la base de datos exitosamente");
					JOptionPane.showConfirmDialog(null,"Desea registrar otro libro?");

					if(d == 0){
								
								titulo.setText("Ingresar el titulo del libro");
								titulo.setForeground(Color.YELLOW);
								codigoLibro.setText("Ingresar codigo del libro ");
								codigoLibro.setForeground(Color.YELLOW);
								autor.setText("Ingresar nombre(s)");
								autor.setForeground(Color.YELLOW);
								editorial.setText("Ingrese su e-mail");
								editorial.setForeground(Color.YELLOW);
								categoria.setText("Ingrese su numero telefonico");
								categoria.setForeground(Color.YELLOW);
								
					}
						if(d == 1){
							JOptionPane.showMessageDialog(null,"Accion hecha");
						}
							if(d == 2){
								titulo.setText("Ingresar el titulo del libro");
								titulo.setForeground(Color.YELLOW);
								codigoLibro.setText("Ingresar codigo del libro ");
								codigoLibro.setForeground(Color.YELLOW);
								autor.setText("Ingresar nombre(s)");
								autor.setForeground(Color.YELLOW);
								editorial.setText("Ingrese su e-mail");
								editorial.setForeground(Color.YELLOW);
								categoria.setText("Ingrese su numero telefonico");
								categoria.setForeground(Color.YELLOW);
								
							}

		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		}

		if(operacion.getSource() == modificarLibro && inicioGlobal > 0){
			System.out.println("Accediendo base de datos libreria");
				try{
					AccionSQL = "UPDATE registrolibros SET Codigo = ?, Titulo = ?, Autor = ?, Editorial = ?, Categoria = ? WHERE Codigo = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					JOptionPane.showMessageDialog(null,"Los datos del libro han sido actualizados");
					JOptionPane.showConfirmDialog(null,"Desea modificar los datos de otro libro en base a su titulo?");
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,codigoLibro.getText());
					pst.setString(2,autor.getText());
					pst.setString(3,titulo.getText());
					pst.setString(4,editorial.getText());
					pst.setString(5,categoria.getText());
					pst.setString(6,codigoLibro.getText());
					pst.executeUpdate();
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
			}
		}
			if(operacion.getSource() == quitarLibro && inicioGlobal > 0){
			System.out.println("Accediendo base de datos libreria");
				try{
					AccionSQL = "DELETE FROM registrolibros WHERE Codigo = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					JOptionPane.showMessageDialog(null,"El libro registrado con dicho codigo ha sido eliminado");
					JOptionPane.showConfirmDialog(null,"Desea quitar otro libro");
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,codigoLibro.getText());
					
					pst.executeUpdate();
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
}
	if(operacion.getSource() == bajaUsuario && inicioGlobal > 0){
				bajaCuenta ventanita = new bajaCuenta();
		ventanita.setBounds(420,290,500,250);
		ventanita.setVisible(true);
	}
			if(operacion.getSource() == modificarDatos && inicioGlobal > 0){
			
					boton1.setText("Actualizar datos");

					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(false);
					Formulario.setVisible(true);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);	
			}
		if(operacion.getSource() == Prestamos && inicioGlobal > 0){//-------------------------Pendiente, registro de prestamos
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(true);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);

		}
		if(operacion.getSource() == registroPrestamos && inicioGlobal > 0){
					
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(true);
					System.out.println("Accediendo base de datos libreria");
			try{
					AccionSQL = "SELECT * FROM prestamos";
					cade = "\t\t\tHistorial de prestamos\n\nNombre(s):\t\tFecha de prestamo\tFecha de devolucion\tID_Libro:";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");
					System.out.println("CONEXION EXITOSA");
					
					pst = cn.prepareStatement(AccionSQL);
					rs = pst.executeQuery();

					while(rs.next()){
						cade = cade + "\n" +
								rs.getString("NombrePersona") + "\t\t"  +
								rs.getString("FechaPres") + "\t\t"  +
								rs.getString("FechaDevo") + "\t\t"  +
								rs.getString("ID_Libro") + "\t";
							nRegistros++;
					}
					System.out.println(nRegistros);
					if(nRegistros == 0) cade = cade + "\tNo se encontraron registros\n";
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		prestamosBD.setText(cade);

		try{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(cn != null) cn.close();
		}catch(SQLException e){
			System.out.println("Algo salio mal: "+e.getMessage());
		}
				
				
			}
		if(operacion.getSource() == CrearCuenta ){
			boton1.setText("Guardar datos");
					apartadoSeguridad++;
					apartadoUsuario++;
					registro.setText("");
					campoTexto1.setText("");
					campoTexto2.setText("");
					campoTexto3.setText("");
					campoTexto4.setText("");
					campoTexto5.setText("");
					campoTexto6.setText("");
					campoTexto7.setText("");
					campoTexto8.setText("");

					apellidoP = "";
					apellidoM = "";
					nombre = "";
					nacimiento = "";
					password = "";
					numero = "";
					email = "";


					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(false);
					Formulario.setVisible(true);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
					setTitle("Creacion de cuenta [MiLibro]");
					setIconImage(new ImageIcon(getClass().getResource("Formulariosimbolo.jpg")).getImage());
					

		}

			if(operacion.getSource() == IniciarSesion ){
				campo2.setEchoChar('*');
				Inicio++;
				CompararPassword = new String(campo2.getPassword());
				CompararUsuario = campo1.getText();
				System.out.println("Accediendo base de datos libreria");
			try{
					AccionSQL = "SELECT Password, Usuario FROM cuentausuario WHERE Password = ? AND Usuario = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");
					System.out.println("CONEXION EXITOSA");
					

					pst = cn.prepareStatement(AccionSQL);
					pst.setString(1,campo2.getText());
					pst.setString(2,campo1.getText());
					
					rs = pst.executeQuery();
				if(rs.next()){
					
					nRegistros++;
					CompararPassword = "";
						CompararUsuario = "";
						campo1.setText("Ingrese su nombre de usuario");
						campo1.setForeground(new Color(128,128,128));
						campo2.setText("********************");
						campo2.setEchoChar('*');
						campo2.setForeground(new Color(128,128,128));
						apartadoSeguridad++;
						Inicio++;
						inicioGlobal++; 
					JOptionPane.showMessageDialog(null,"Bienvenid@ a nuestra seccion de libros, ya tiene acceso a los menus");
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					Portada.setVisible(true);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
					setTitle("Control de libros");
				}else{
					JOptionPane.showMessageDialog(null,"Es posible que un dato sea erroneo o la cuenta no existe");
				}
					
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
		
		try{
			if(rs != null) rs.close();
			if(pst != null) pst.close();
			if(cn != null) cn.close();
		}catch(SQLException e){
			System.out.println("Algo salio mal: "+e.getMessage());
		}

				
			}

			if(operacion.getSource() == boton1 && comprobador.equals("Actualizar datos")){
				try{
					AccionSQL = "UPDATE cuentausuario SET Apellido_P = ?, Apellido_M = ?, Name = ?, Password = ?, Telefono = ?, email = ?, Usuario = ?, Domicilio = ? WHERE Name = ?";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					JOptionPane.showMessageDialog(null,"Sus datos personales han sido actualizados");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,campoTexto1.getText());
					pst.setString(2,campoTexto2.getText());
					pst.setString(3,campoTexto3.getText());
					pst.setString(4,campoTexto4.getText());
					pst.setString(5,campoTexto5.getText());
					pst.setString(6,campoTexto6.getText());
					pst.setString(7,campoTexto7.getText());
					pst.setString(8,campoTexto8.getText());
					pst.setString(9,campoTexto3.getText());
					pst.executeUpdate();
		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
			}
			}
				if(operacion.getSource()==boton1 && comprobador.equals("Guardar datos")){
					apartadoUsuario++;
					apellidoP = campoTexto1.getText();
					apellidoM =	campoTexto2.getText();
					nombre =	campoTexto3.getText();
					nacimiento = campoTexto4.getText();
					password = new String(campoTexto5.getPassword());
					numero = campoTexto6.getText();
					Usuario = campoTexto8.getText();
					email = campoTexto7.getText();
					domicilio = campoTexto9.getText();//*************************************************



					if(apellidoP.equals("") || apellidoM.equals("") || nombre.equals("") || nacimiento.equals("") || password.equals("") || numero.equals("") || email.equals("") || Usuario.equals("")){
						JOptionPane.showMessageDialog(null,"Es obligatorio de llenar todos los campos");
					}else{
						apartadoCuenta++;
						apartadoFormulario++;
					registro.setText("\t\tDatos capturados: \n\n\tApellido paterno: \n\t" + apellidoP + "\n\n\tApellido Materno: \n\t" + apellidoM + "\n\n\tNombre registrado: \n\t" + nombre + "\n\n\tFecha de nacimiento: \n\t" + nacimiento + "\n\n\tContrasenia: \n\t" + password + "\n\n\tNumero de telefono: \n\t" + numero +  "\n\n\tNombre de usuario: \n\t" + Usuario + "\n\n\tCorreo electronico: \n\t" + email + "\n\n\tDomicilio registrado: \n\t"+ domicilio + "\n\n\tGenero : \n\t" + g1+g2);
					CuentaNoCreada = 1;
					System.out.println("Accediendo base de datos libreria");
				try{
					AccionSQL = "INSERT INTO cuentausuario VALUES(?,?,?,?,?,?,?,?,?)";
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/libreria","root","");//No se conecta a la base de datos
					System.out.println("CONEXION EXITOSA");
					JOptionPane.showMessageDialog(null,"Datos guardados exitosamente en la base de datos");
					
					pst = cn.prepareStatement(AccionSQL);

					pst.setString(1,campoTexto1.getText());
					pst.setString(2,campoTexto2.getText());
					pst.setString(3,campoTexto3.getText());
					pst.setString(4,campoTexto4.getText());
					pst.setString(5,campoTexto5.getText());
					pst.setString(6,campoTexto6.getText());
					pst.setString(7,campoTexto7.getText());
					pst.setString(8,campoTexto8.getText());
					pst.setString(9,campoTexto9.getText());
					pst.executeUpdate();

		}catch (Exception e){
			System.out.println("Algo salio mal: " + e.getMessage());
	}
						}
				}

				if(operacion.getSource() == boton3){

					JOptionPane.showMessageDialog(null,"Datos capturados exitosamente");
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(true);
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
				
					genero.clearSelection();
				
					setIconImage(new ImageIcon(getClass().getResource("Libro logo.jpg")).getImage());
					setTitle("Libreria HERTZ");
				}


				if(operacion.getSource()==boton2){
					campoTexto1.setText("");
					campoTexto2.setText("");
					campoTexto3.setText("");
					campoTexto4.setText("");
					campoTexto5.setText("");
					campoTexto6.setText("");
					campo1.setText("Ingrese su nombre de usuario");
					campo1.setForeground(new Color(128,128,128));
					campo2.setText("********************");
					campo2.setForeground(new Color(128,128,128));
					genero.clearSelection();
					

					apellidoP = "";
					apellidoM = "";
					nombre = "";
					nacimiento = "";
					password = "";
					numero = "";
					
					setIconImage(new ImageIcon(getClass().getResource("Libro logo.jpg")).getImage());
					
					JOptionPane.showMessageDialog(null,"Captura de datos cancelado");
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(true);
					Portada.setVisible(false);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
				}

				if(operacion.getSource() == home){
					if(inicioGlobal > 0){
						JOptionPane.showMessageDialog(null,"Usted ha cerrado su sesion, que tenga buen dia :)");
					}
					inicioGlobal = 0;
					setIconImage(new ImageIcon(getClass().getResource("Libro logo.jpg")).getImage());
					registroLibros.setVisible(false);
					IngresoDatos.setVisible(false);
					
					Portada.setVisible(true);
					Formulario.setVisible(false);
					usuarios.setVisible(false);
					muestraUsuarios.setVisible(false);
					prestamos.setVisible(false);
					muestraLibros.setVisible(false);
					muestraPrestamos.setVisible(false);
				}
		}
	

	public void stateChanged(ChangeEvent accion){

							if(genero1.isSelected()==true){
								g1 = "Masculino";
							}else{
								g1="";
							}
							if(genero2.isSelected()==true){
								g2 = "Femenino";
							}else{
								g2="";
							}
						}

	public static void main(String args[]){
			Libros ventana = new Libros();
			ventana.setVisible(true);
			ventana.setBounds(100,50,1200,680);
			ventana.setResizable(false);
	}
}