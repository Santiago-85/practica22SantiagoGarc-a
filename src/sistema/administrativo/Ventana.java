
package sistema.administrativo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Ventana extends JFrame{
    Usuario usuSistema[] = new Usuario[10];
    JPanel panelInicioSesion = new JPanel();
    JPanel panelControl = new JPanel();
    JPanel panelCrearUsuario = new JPanel();
    int control = 2;
    Cliente clientes[] = new Cliente[100];
    int controlClientes = 0;
    JPanel panelControlClientes =new JPanel(); 
    
    //Metodo Constructor     
    public Ventana(){
    objetos();
    crearAdmin();
    crearClientes();
    }
    
    public void crearAdmin(){
    usuSistema[0] = new Usuario();
        usuSistema[0].nombreUsuario = "admin";
        usuSistema[0].nombre = "administrador";
        usuSistema[0].contra = "123456";
        //Usuario temporal para pruebas
         usuSistema[1] = new Usuario();
        usuSistema[1].nombreUsuario = "juan";
        usuSistema[1].nombre = "juan";
        usuSistema[1].contra = "12";
        }
    public void crearClientes(){
        clientes[0] = new Cliente();
        clientes[0].nombre = "cliente 1";
        clientes[0].edad = 22;
        clientes[0].genero = 'M';
        clientes[0].nit = 150;
        
        clientes[1] = new Cliente();
        clientes[1].nombre = "Cliente 2";
        clientes[1].edad = 22;
        clientes[1].genero = 'F';
        clientes[1].nit = 250;
    }
   
    public void objetos(){
      
      this.getContentPane().add(panelInicioSesion);
      panelInicioSesion.setLayout(null);
      
      JLabel lblLogin = new JLabel("Login");
      lblLogin.setBounds(20, 7, 100, 15);
      panelInicioSesion.add(lblLogin);
      
      JLabel lblUsuario = new JLabel("Usuario");
      lblUsuario.setBounds(60, 20, 100, 15);
      panelInicioSesion.add(lblUsuario);
      
      JLabel lblContra = new JLabel("Contraseña");
      lblContra.setBounds(60, 100, 100, 15);
      panelInicioSesion.add(lblContra);
      
      JTextField txtUsuario = new JTextField();
      txtUsuario.setBounds(150, 40, 200, 25);
      panelInicioSesion.add(txtUsuario);
      
      JTextField txtContra = new JTextField();
      txtContra.setBounds(150, 100, 200, 25);
      panelInicioSesion.add(txtContra);
      
      JButton btnIngresar = new JButton("Ingresar");
      btnIngresar.setBounds(120, 145, 180, 35);
      panelInicioSesion.add(btnIngresar);
      ActionListener ingresar = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent ae) {
            if(txtUsuario.getText().equals("") || txtContra.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }else{
                recorrerUsuarios(txtUsuario.getText(), txtContra.getText());
                String nombreUsuario = txtUsuario.getText();
                String contra = txtContra.getText();
               
            
              
          }

         
          }
      
      };
      btnIngresar.addActionListener(ingresar);
      
      JButton btnCrearUsuario = new JButton("Registrarse");
      btnCrearUsuario.setBounds(120, 185, 180, 35);
      panelInicioSesion.add(btnCrearUsuario);
      ActionListener crearUsuario = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
              crearUsuario();
               panelCrearUsuario.setVisible(true);
          }
      };
      btnCrearUsuario.addActionListener(crearUsuario);
      
    }
    public void recorrerUsuarios(String nombreUsuario, String contra){
        boolean encontrado = false;
            for(int i = 0; i<10; i++){
                if(usuSistema[i] != null){
                    if(usuSistema[i].nombreUsuario.equals(nombreUsuario) && usuSistema[i].contra.equals(contra)){
                    JOptionPane.showMessageDialog(null, "Bienvenido al Sistema usuario " + nombreUsuario);
                    panelControl();
                    encontrado = true;
                 break;
            }else{
                    encontrado = false;
        
                }    
            } 
        }
        if(encontrado == false){
         JOptionPane.showMessageDialog(null, "Datos Incorrectos");
        }
       
    }
    public void panelControl(){
      this.getContentPane().add(panelControl);
      panelControl.setLayout(null);
      this.setSize(600, 500);
      this.setTitle("Control Principal");
      panelInicioSesion.setVisible(false);
      
      JButton btnAdminClientes = new JButton("Administracion de Clientes");
      btnAdminClientes.setBounds(150, 10, 250, 25);
      panelControl.add(btnAdminClientes);
      ActionListener administrarClientes = new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
                panelControlCli();
                panelControlClientes.setVisible(true);
              }
      };
      btnAdminClientes.addActionListener(administrarClientes);
              
      JButton btnAdminProductos = new JButton("Administracion de Productos");
      btnAdminProductos.setBounds(150, 80, 250, 25);
      panelControl.add(btnAdminProductos);
      
      JButton btnReportes = new JButton("Reportes");
      btnReportes.setBounds(150, 150, 250, 25);
      panelControl.add(btnReportes);
    }
    
    public void crearUsuario(){
        this.getContentPane().add(panelCrearUsuario);
        panelCrearUsuario.setLayout(null);
        this.setSize(500, 450);
        this.setTitle("Registro de Nuevo Usuario");
        panelInicioSesion.setVisible(false);
        
        JLabel lblRegistro = new JLabel("Registro de Usuario");
        lblRegistro.setBounds(20, 20, 150, 20);
        panelCrearUsuario.add(lblRegistro);
        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(50, 50, 150, 20);
        panelCrearUsuario.add(lblUsuario);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(50, 100, 150, 20);
        panelCrearUsuario.add(lblNombre);
        
        JLabel lblContra = new JLabel("Contraseña");
        lblContra.setBounds(50, 150, 150, 20);
        panelCrearUsuario.add(lblContra);
        
        JLabel lblConfirmar = new JLabel("Confirmar Contraseña");
        lblConfirmar.setBounds(50, 200, 150, 20);
        panelCrearUsuario.add(lblConfirmar);
        
        JTextField txtUsuario = new JTextField();
            txtUsuario.setBounds(200, 50, 150, 20);
            panelCrearUsuario.add(txtUsuario);
         
         JTextField txtNombre = new JTextField();
            txtNombre.setBounds(200, 100, 150, 20);
            panelCrearUsuario.add(txtNombre);
            
         JTextField txtContra = new JTextField();
            txtContra.setBounds(200, 150, 150, 20);
            panelCrearUsuario.add(txtContra);
            
         JTextField txtConfirmar = new JTextField();
         txtConfirmar.setBounds(200, 200, 150, 20);
        panelCrearUsuario.add(txtConfirmar);
        
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(130, 300, 200, 35);
        panelCrearUsuario.add(btnRegistrar);
        ActionListener registro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtUsuario.getText().equals("") || txtNombre.getText().equals("") || txtContra.getText().equals("") || txtConfirmar.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los datos");
                }else{
                        if(txtContra.getText().equals(txtConfirmar.getText())){
                            guardarUsuario(txtUsuario.getText(), txtNombre.getText(), txtContra.getText());
                            txtUsuario.setText("");
                            txtNombre.setText("");
                            txtContra.setText("");
                            txtConfirmar.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                     }
                }
            }
        };
        btnRegistrar.addActionListener(registro);
            
         JButton btnVolver = new JButton("volver al Inicio");
        btnVolver.setBounds(130, 350, 200, 35);
        panelCrearUsuario.add(btnVolver);
        ActionListener volverInicio = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
                panelInicioSesion.setVisible(true);
                panelCrearUsuario.setVisible(false);
                volverInicio();
            }  
        };
        btnVolver.addActionListener(volverInicio);
    }
    public void volverInicio(){
        this.setTitle("Sistema Administrativo De Clientes y Recursos");
        this.setSize(450, 350);
    }
    
    public void guardarUsuario(String nombre, String nombreUsuario, String contra){
        int posicion = 0;
        if(control < 10){
            for(int i = 0; i < 9; i++){
                if(usuSistema[i] == null){
                    posicion = i;
                    break;
              }
        }    
              //System.out.println("La posicion es " + posicion);
                usuSistema[posicion] = new Usuario();
                usuSistema[posicion].nombreUsuario = nombre;
                usuSistema[posicion].nombre = nombreUsuario;
                usuSistema[posicion].contra = contra;
                control++;
                JOptionPane.showMessageDialog(null, "Usuario Registrado, Total de Usuarios " + control);
                
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar mas usuarios");
        }
       
    }
    
     public void panelControlCli(){
         this.getContentPane().add(panelControlClientes);
        panelControlClientes.setLayout(null);
        this.setSize(750, 500);
        this.setTitle("Administracion de Clientes");
        panelControl.setVisible(false);
        
        DefaultTableModel datosTabla = new DefaultTableModel();
        datosTabla.addColumn("Nombre");
        datosTabla.addColumn("Edad");
        datosTabla.addColumn("Género");
        datosTabla.addColumn("Nit");
        
        for(int i = 0; i<100; i++){
                if(clientes[i] != null){
                   String fila [] = {clientes[i].nombre, String.valueOf(clientes[i].edad) , String.valueOf(clientes[i].genero), String.valueOf(clientes[i].nit)}; 
                   datosTabla.addRow(fila);
                }
        }
        
        
        
        
        JTable tablaClientes = new JTable(datosTabla);
        JScrollPane barraTablaClientes = new JScrollPane(tablaClientes);
        barraTablaClientes.setBounds(10, 10, 300, 300);
        panelControlClientes.add(barraTablaClientes);
        
        JButton btnCargarArchivo = new JButton("Buscar archivo CSV");
        btnCargarArchivo.setBounds(350, 10, 200, 25);
        panelControlClientes.add(btnCargarArchivo);
        ActionListener buscarArchivo = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 File archivoSeleccionado;
                 JFileChooser ventanaSeleccion = new JFileChooser();
                 ventanaSeleccion.showOpenDialog(null);
                 archivoSeleccionado = ventanaSeleccion.getSelectedFile();
                 System.out.println("La ubicacion del archivo es " + archivoSeleccionado.getPath());
                 leerArchivoCSV(archivoSeleccionado.getPath());
             }
         };
        btnCargarArchivo.addActionListener(buscarArchivo);
     }
     
     public void leerArchivoCSV(String ruta){
         try{
             BufferedReader archivoTemporal = new BufferedReader(new FileReader(ruta));
             String lineaLeida = "";
             while(lineaLeida != null){
                 lineaLeida = archivoTemporal.readLine();
                 if(lineaLeida != null){
                     System.out.println(lineaLeida);
                 }
             }
             archivoTemporal.close();
         }catch(IOException error){
             JOptionPane.showMessageDialog(null, "No se pudo abrir el archivo CSV");
         }
     }
}
