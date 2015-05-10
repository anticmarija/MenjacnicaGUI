package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmObrisiKurs;
	private JMenuItem mntmI;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	
	
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	protected Component frame;
	

	private static MenjacnicaGUI menjacnica = new MenjacnicaGUI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
					
					frame.getTextArea().append("");
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				ugasiAplikaciju();
			}
		});
		
		
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFile = new JFileChooser();
				int returnVal = jFile.showOpenDialog(contentPane);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
	
				textArea.setText(textArea.getText()+jFile.getSelectedFile().getAbsolutePath());
					
				}	
			}
		});
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/NewFolder.gif")));
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				ugasiAplikaciju();
					
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane,
						"Autor: Marija Antic, Verzija 1.0", "O programu",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmAbout.setIcon(null);
		mnHelp.add(mntmAbout);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u0160ifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		
		popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		mntmDodajKurs = new JMenuItem("Dodaj kurs");
		mntmDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKursGUI prozor = new DodajKursGUI();
				prozor.setVisible(true);
			}
		});
		popupMenu.add(mntmDodajKurs);
		
		mntmObrisiKurs = new JMenuItem("Obrisi kurs");
		mntmObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ObrisiKursGUI prozor = new ObrisiKursGUI();
				prozor.setVisible(true);
			}
		});
		popupMenu.add(mntmObrisiKurs);
		
		mntmI = new JMenuItem("Izvrsi zamenu");
		mntmI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI();
				prozor.setVisible(true);
			}
		});
		popupMenu.add(mntmI);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(130, 10));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnNewButton = new JButton("Dodaj kurs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodajKursGUI prozor = new DodajKursGUI();
				prozor.setVisible(true);
			
			}
		});
		btnNewButton.setPreferredSize(new Dimension(120, 26));
		btnNewButton.setSize(new Dimension(100, 26));
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Obrisi kurs");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ObrisiKursGUI prozor = new ObrisiKursGUI();
				prozor.setVisible(true);
			}
		});
		btnNewButton_1.setPreferredSize(new Dimension(120, 26));
		btnNewButton_1.setSize(new Dimension(100, 26));
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Izvrsi zamenu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI();
				prozor.setVisible(true);
			}
		});
		btnNewButton_2.setPreferredSize(new Dimension(120, 26));
		panel.add(btnNewButton_2);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(350, 16));
		scrollPane_1.add(textArea);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
		public static void ugasiAplikaciju() {
			int opcija = JOptionPane.showConfirmDialog(menjacnica.getContentPane(),
					"Da li ZAISTA zelite da izadjete iz aplikacije", "Izlazak",
					JOptionPane.YES_NO_CANCEL_OPTION);

			if (opcija == JOptionPane.YES_OPTION)
				System.exit(0);
			
			else return;
		}
		
		public void dodajUTextArea (String tekst) {
			textArea.append(tekst);
		}
		
	}
	
