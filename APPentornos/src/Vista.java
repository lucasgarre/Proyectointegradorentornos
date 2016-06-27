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
	private JTextField lblGetPoblacion;
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
		tabbedPane.addTab("Alta socios", null, panel, null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n: ");
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		
		JLabel lblDni = new JLabel("DNI:");
		
		lblGetNombre = new JTextField();
		lblGetNombre.setColumns(10);
		
		lblGetApellido = new JTextField();
		lblGetApellido.setColumns(10);
		
		lblGetPoblacion = new JTextField();
		lblGetPoblacion.setColumns(10);
		
		lblGetTelefono = new JTextField();
		lblGetTelefono.setColumns(10);
		
		lblGetDni = new JTextField();
		lblGetDni.setColumns(10);
		
		
		JScrollPane scrollPane_socios = new JScrollPane();

		
		table = new JTable();
		dtm = new DefaultTableModel(new Object[][] {

		}, new String[] { "Nombre", "Apellidos", "Poblacion", "Telefono", "Dni" });
		
		table.setModel(dtm);
		scrollPane_socios.setViewportView(table);	
		//table = new JTable();
		
		
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String nombre	= lblGetNombre.getText();// Recogemos valores de los campos de texto al igual que el Scanner
			String apellido = lblGetApellido.getText();
			String poblacion = lblGetPoblacion.getText();
			String telefono = lblGetTelefono.getText();
			String dni = lblGetDni.getText();
			Object [] fila = {nombre,apellido,poblacion,telefono,dni};
			dtm.addRow(fila);

			
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
							.addComponent(lblGetPoblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(lblGetTelefono, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPoblacin)
							.addGap(85)
							.addComponent(lblTelfono)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
							.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(115))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(74)
							.addComponent(lblGetDni, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(235)
					.addComponent(btnDarDeAlta)
					.addContainerGap(358, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_socios, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(73, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSocios, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
							.addComponent(btneliminarsocio)
							.addGap(125))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(161)
					.addComponent(lblDarDeAlta)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(lblDarDeAlta)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblDni)
								.addComponent(lblPoblacin)
								.addComponent(lblTelfono))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGetNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGetApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGetPoblacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGetTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGetDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnDarDeAlta)
							.addGap(16)
							.addComponent(lblSocios, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(20)
									.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane_socios, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(22, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(160)
							.addComponent(btneliminarsocio)
							.addGap(117))))
		);
		panel.setLayout(gl_panel);
		
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
		
		getnpista = new JTextField();
		getnpista.setColumns(10);
		
		getfecha = new JTextField();
		getfecha.setColumns(10);
		
		getsocio = new JTextField();
		getsocio.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Tenis", "Futbol 10", "Padel", "Baloncesto"}));
		
		table_1 = new JTable();
		dtm1 = new DefaultTableModel(new Object[][] {

		}, new String[] { "Nº", "Tipo", "Nº Socio", "Fecha" });
		
		table_1.setModel(dtm1);
		scrollPanereserva.setViewportView(table_1);	
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pista	= getnpista.getText();// Recogemos valores de los campos de texto al igual que el Scanner
				String fecha = getfecha.getText();
				String socio = getsocio.getText();
				String tipo = (String)comboBox.getSelectedItem();
				Object [] fila = {pista,tipo,socio,fecha };
				dtm1.addRow(fila);
			}
		});
		
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm1.removeRow(table_1.getSelectedRow());

			}
		});
		

		//table = new JTable();
		GroupLayout gl_boxpista = new GroupLayout(boxpista);
		gl_boxpista.setHorizontalGroup(
			gl_boxpista.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_boxpista.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPanereserva, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(gl_boxpista.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_boxpista.createSequentialGroup()
							.addComponent(lblNPista)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(getnpista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_boxpista.createSequentialGroup()
							.addComponent(lblTipoDePista)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(95)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNSocio)
						.addComponent(lblFechaReserva))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
						.addComponent(getfecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(getsocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(244, Short.MAX_VALUE))
				.addGroup(gl_boxpista.createSequentialGroup()
					.addContainerGap(214, Short.MAX_VALUE)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_boxpista.createSequentialGroup()
							.addComponent(btnReservar)
							.addGap(69)
							.addComponent(btnCancelarReserva))
						.addComponent(lblNuestrasPistas, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
					.addGap(205))
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
								.addComponent(lblNSocio)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getsocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_boxpista.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNuestrasPistas, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_boxpista.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFechaReserva)
								.addComponent(getfecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(44)
					.addGroup(gl_boxpista.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReservar)
						.addComponent(btnCancelarReserva))
					.addGap(31)
					.addComponent(scrollPanereserva, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
					.addContainerGap())
		);
		boxpista.setLayout(gl_boxpista);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		tabbedPane.addTab("Pistas", null, panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNuestrasPistas_1 = new JLabel("Nuestras Pistas: ");
		lblNuestrasPistas_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(189, Short.MAX_VALUE)
					.addComponent(lblNuestrasPistas_1, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(177))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNuestrasPistas_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		panel_2.setLayout(gl_panel_2);
		contentPane.setLayout(gl_contentPane);
	}
	public void setMiMod(Modelo miMod) {
		this.miMod = miMod;
	}
}
