import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
/**
 * 
 * @author Lucas
 *
 */
public class Vista extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField lblGetNombre;
	private JTextField lblGetApellido;
	private JTextField lblGetId;
	private JTextField lblGetTelefono;
	private JTextField lblGetDni;
	//private JTable table;
	private Modelo miMod;
	private JPanel panel_2;
	
	
	private DefaultTableModel dtm;
	private JTable table;
	private JTable table_1;
	private JTextField getnpista;
	private JTextField getfecha;
	private JTextField getsocio;
	private DefaultTableModel dtm1;
	private JTextField txtTipoid;
	private JTextField txtReserva;
	private JTextField txtpista;
	private JTable table_2;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lucas\\Desktop\\Julio\\Entornos\\Proyecto Integrador\\Archivos\\Java\\Imagenes\\favicon.png"));
		setTitle("Gesti\u00F3n Club deportivo Lucas Martinez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(Color.GRAY);
		tabbedPane.addTab("Socios", null, panel, null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		JLabel lblId = new JLabel("ID Socio:");
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		
		JLabel lblDni = new JLabel("DNI:");
		
		lblGetNombre = new JTextField();
		lblGetNombre.setColumns(10);
		
		lblGetApellido = new JTextField();
		lblGetApellido.setColumns(10);
		
		lblGetId = new JTextField();
		lblGetId.setColumns(10);
		
		lblGetTelefono = new JTextField();
		lblGetTelefono.setColumns(10);
		
		lblGetDni = new JTextField();
		lblGetDni.setColumns(10);
		
		
		JScrollPane scrollPane_socios = new JScrollPane();

		
		table = new JTable();
		dtm = new DefaultTableModel(new Object[][] {

		}, new String[] { "Nombre", "Apellidos", "numsocio", "Telefono", "Dni",  });
		
		table.setModel(dtm);
		scrollPane_socios.setViewportView(table);	
		//table = new JTable();
		
		
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String nombre	= lblGetNombre.getText();// Recogemos valores de los campos de texto al igual que el Scanner
			String apellido = lblGetApellido.getText();
			String numsocio = lblGetId.getText();
			String telefono = lblGetTelefono.getText();
			String dni = lblGetDni.getText();
			Object [] fila = {nombre,apellido,numsocio,telefono,dni};
			dtm.addRow(fila);
			miMod.Insertarsocio(nombre, apellido, Integer.parseInt( numsocio) , dni, Integer.parseInt(telefono));
		
			
			
		//int numsocio1=	Integer.valueOf("").parseInt(numsocio);
		//	miMod.AgregarSocio( numsocio1, apellido,  numsocio,  telefono,  dni);

			
		}
	
			
			
				
			}
	
		);
		
		table_1 = new JTable();
		
		JLabel lblSocios = new JLabel("Socios");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JLabel lblDarDeAlta = new JLabel("Dar de alta a nuevo socio: ");
		lblDarDeAlta.setBackground(Color.RED);
		lblDarDeAlta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JButton btneliminarsocio = new JButton("Eliminar socio");
		btneliminarsocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.removeRow(table.getSelectedRow());
				miMod.BorrarSocio( lblGetId.getText());
				
			}
		});
		
		JButton btnConsultar = new JButton("Consultar Socios");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String [][]socios =miMod.ObtenerSocios("SELECT * FROM appfinal.SOCIOS");
				//String [] socios = miMod.ObtenerSocios("SELECT * FROM appfinal.SOCIOS");
				
				for (int i=0; i<socios.length;i++){  //recorrido de filas
					
					
					String num_socio = socios[i][0];
					String nombre = socios[i][1];
					String ape = socios[i][2];
					String dni = socios[i][3];
					String tfno = socios[i][4];

					Object [] fila = {nombre,ape,num_socio,tfno,dni};
					
					
					//dtm.addRow(  socios[i] ); 
					dtm.addRow(  fila );
					
				}


				
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblGetNombre, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(lblGetApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(53)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblGetId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(lblGetTelefono, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblId)
							.addGap(85)
							.addComponent(lblTelfono)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
							.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(115))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(45)
							.addComponent(lblGetDni, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(161)
					.addComponent(lblDarDeAlta)
					.addContainerGap(187, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSocios, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_socios, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE))
					.addGap(79))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(235)
					.addComponent(btnDarDeAlta)
					.addGap(22)
					.addComponent(btneliminarsocio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConsultar)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblDarDeAlta)
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(lblApellido)
						.addComponent(lblDni)
						.addComponent(lblId)
						.addComponent(lblTelfono))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGetNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGetApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGetId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGetTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGetDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDarDeAlta)
						.addComponent(btnConsultar)
						.addComponent(btneliminarsocio))
					.addGap(16)
					.addComponent(lblSocios, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(scrollPane_socios, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panel.setLayout(gl_panel);
		dtm1 = new DefaultTableModel(new Object[][] {

		}, new String[] { "Nº", "Tipo", "Nº Socio", "Fecha Reserva", "ID Tipo Pista", "Hora Reserva" });
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Pistas", null, panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("\r\n");
		
		JLabel lblNuestrasPistas_1 = new JLabel("Nuestras Pistas: ");
		lblNuestrasPistas_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblNPista_1 = new JLabel("N\u00BA Pista:");
		
		txtpista = new JTextField();
		txtpista.setColumns(10);
		
		JLabel txtTipo = new JLabel("Tipo Pista:");
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"", "Padel ", "Tenis", "Futbol 10", "Spinning", "Baloncest"}));
		
		JButton btnAadirPista = new JButton("A\u00F1adir Pista");
		btnAadirPista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnEliminarPista = new JButton("Eliminar Pista");
		
		JButton btnConsultarPista = new JButton("Consultar Pista");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(189, Short.MAX_VALUE)
					.addComponent(lblNuestrasPistas_1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(177))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNPista_1))
						.addComponent(txtpista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTipo)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(comboTipo, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAadirPista)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEliminarPista)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConsultarPista)))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNuestrasPistas_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNPista_1)
						.addComponent(txtTipo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtpista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAadirPista)
						.addComponent(btnEliminarPista)
						.addComponent(btnConsultarPista))
					.addGap(80)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		panel_2.setLayout(gl_panel_2);
		
		JPanel boxpista = new JPanel();
		boxpista.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Reserva", null, boxpista, null);
		
		JLabel lblNuestrasPistas = new JLabel("Reserve una pista:");
		lblNuestrasPistas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JScrollPane scrollPanereserva = new JScrollPane();
		
		JLabel lblNPista = new JLabel("N\u00BA Pista:");
		
		JLabel lblTipoDePista = new JLabel("Tipo de pista:");
		
		JLabel lblFechaReserva = new JLabel("Fecha reserva:");
		
		JLabel lblNSocio = new JLabel("N\u00BA Socio:");
		JLabel lblIdTipoPista = new JLabel("ID Tipo pista:");

		
		getnpista = new JTextField();
		getnpista.setColumns(10);
		
		getfecha = new JTextField();
		getfecha.setColumns(10);
		
		getsocio = new JTextField();
		getsocio.setColumns(10);
		
		txtTipoid = new JTextField();
		txtTipoid.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Tenis", "Futbol 10", "Padel", "Baloncesto"}));
		
		table_1 = new JTable();
		
		table_1.setModel(dtm1);
		scrollPanereserva.setViewportView(table_1);	
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pista	= getnpista.getText();// Recogemos valores de los campos de texto al igual que el Scanner
				String fecha = getfecha.getText();
				String Tipoid = txtTipoid.getText();
				String socio = getsocio.getText();
				String tipo = (String)comboBox.getSelectedItem();
				String lblHoraReserva= txtReserva.getText();
				//String Tipoid = txtTipoid.getText();
				Object [] fila = {pista,tipo,socio,fecha, Tipoid, lblHoraReserva };
				dtm1.addRow(fila);
			}
		});
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm1.removeRow(table_1.getSelectedRow());

			}
		});
		
		JLabel lblHoraReserva = new JLabel("Hora Reserva:");
		
		txtReserva = new JTextField();
		txtReserva.setColumns(10);
		
	
		

		//table = new JTable();
		GroupLayout gl_boxpista = new GroupLayout(boxpista);
		gl_boxpista.setHorizontalGroup(
			gl_boxpista.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_boxpista.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPanereserva, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(gl_boxpista.createSequentialGroup()
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_boxpista.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoDePista)
								.addComponent(lblNPista))
							.addGap(18)
							.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getnpista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_boxpista.createSequentialGroup()
							.addGap(131)
							.addComponent(btnReservar)))
					.addGap(24)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_boxpista.createSequentialGroup()
							.addComponent(lblFechaReserva)
							.addGap(220))
						.addGroup(gl_boxpista.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNuestrasPistas, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_boxpista.createSequentialGroup()
									.addGap(33)
									.addComponent(lblNSocio)
									.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_boxpista.createSequentialGroup()
											.addGap(69)
											.addComponent(btnCancelarReserva))
										.addGroup(gl_boxpista.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_boxpista.createSequentialGroup()
													.addComponent(getfecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
													.addComponent(lblHoraReserva))
												.addGroup(gl_boxpista.createSequentialGroup()
													.addComponent(getsocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
													.addComponent(lblIdTipoPista)
													.addGap(14)))))))))
					.addGap(18)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
						.addComponent(txtReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTipoid, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_boxpista.setVerticalGroup(
			gl_boxpista.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_boxpista.createSequentialGroup()
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_boxpista.createSequentialGroup()
							.addGap(95)
							.addGroup(gl_boxpista.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNPista)
								.addComponent(getnpista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_boxpista.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoDePista)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNSocio)
								.addComponent(getsocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdTipoPista)
								.addComponent(txtTipoid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_boxpista.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNuestrasPistas, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_boxpista.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaReserva)
								.addComponent(getfecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHoraReserva)
								.addComponent(txtReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(44)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelarReserva)
						.addComponent(btnReservar))
					.addGap(31)
					.addComponent(scrollPanereserva, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
					.addContainerGap())
		);
		boxpista.setLayout(gl_boxpista);
		contentPane.setLayout(gl_contentPane);
	}
	public void setMiMod(Modelo miMod) {
		this.miMod = miMod;
	}
}
