package packageTP2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;



public class AppSuperCheapAuto extends JFrame {
	private Ecouteur ec = new Ecouteur();
	private DefaultTableModel modele;
	
	private JPanel panelClient;
	private JLabel jlNumMembre;
	private JLabel jlNomClient;
	private JLabel jlPointsBoni;
	private JTextField tfNumMembre;
	private JTextField tfNomClient;
	private JTextField tfPointsBoni;
	private JPanel panelCommande;
	private JLabel jlCommande;
	private JLabel jlArticle;
	private JLabel jlPrixUni;
	private JLabel jlQte;
	private JTextField tfPrixUni;
	private JTextField tfQte;
	private JComboBox jcBoxArticle;
	private JButton btnAchat;
	private JButton btnTerminer;
	private JPanel panelFacture;
	private JScrollPane scrollPane;
	private JTable table;
	private JRadioButton btnRadioComptant;
	private JRadioButton btnRadioCredit;
	private JButton btnPayer;
	private JLabel labelMontantDonne;
	private JLabel labelMontantRemis;
	private JTextField tfMontantDonne;
	private JTextField tfMontantRemis;
	private JButton btnAnnuNouvComm;

	/*********************************
	 *             Main              *
	 *********************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppSuperCheapAuto frame = new AppSuperCheapAuto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/********************************
	 *        Constructeur          *
	 ********************************/
	public AppSuperCheapAuto() {
		setTitle("Options");
		setBounds(100, 100, 497, 548);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelClient = new JPanel();
		panelClient.setBackground(Color.GREEN);
		panelClient.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelClient.setBounds(10, 11, 461, 92);
		getContentPane().add(panelClient);
		panelClient.setLayout(null);
		
		jlNumMembre = new JLabel("Num\u00E9ro de la carte de membre:");
		jlNumMembre.setFont(new Font("Dialog", Font.BOLD, 13));
		jlNumMembre.setBounds(10, 11, 246, 14);
		panelClient.add(jlNumMembre);
		
		jlNomClient = new JLabel("Nom du client:");
		jlNomClient.setFont(new Font("Dialog", Font.BOLD, 13));
		jlNomClient.setBounds(10, 34, 246, 14);
		panelClient.add(jlNomClient);
		
		jlPointsBoni = new JLabel("Nombre de points boni \u00E0 ce jour");
		jlPointsBoni.setFont(new Font("Dialog", Font.BOLD, 13));
		jlPointsBoni.setBounds(10, 59, 246, 14);
		panelClient.add(jlPointsBoni);
		
		tfNumMembre = new JTextField();
		tfNumMembre.setBounds(365, 9, 86, 20);
		panelClient.add(tfNumMembre);
		tfNumMembre.setColumns(10);
		
		tfNomClient = new JTextField();
		tfNomClient.setColumns(10);
		tfNomClient.setBounds(311, 32, 140, 20);
		panelClient.add(tfNomClient);
		
		tfPointsBoni = new JTextField();
		tfPointsBoni.setColumns(10);
		tfPointsBoni.setBounds(365, 57, 86, 20);
		panelClient.add(tfPointsBoni);
		
		panelCommande = new JPanel();
		panelCommande.setBackground(Color.ORANGE);
		panelCommande.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCommande.setBounds(10, 114, 304, 114);
		getContentPane().add(panelCommande);
		panelCommande.setLayout(null);
		
		jlCommande = new JLabel("Commande");
		jlCommande.setFont(new Font("Dialog", Font.BOLD, 13));
		jlCommande.setBounds(10, 11, 85, 14);
		panelCommande.add(jlCommande);
		
		jlArticle = new JLabel("Article");
		jlArticle.setFont(new Font("Dialog", Font.BOLD, 12));
		jlArticle.setBounds(10, 33, 58, 14);
		panelCommande.add(jlArticle);
		
		jlPrixUni = new JLabel("Prix unitaire:");
		jlPrixUni.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		jlPrixUni.setBounds(10, 59, 101, 16);
		panelCommande.add(jlPrixUni);
		
		jlQte = new JLabel("Qté en Stock:");
		jlQte.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		jlQte.setBounds(197, 59, 101, 16);
		panelCommande.add(jlQte);
		
		tfPrixUni = new JTextField();
		tfPrixUni.setBounds(6, 82, 85, 26);
		panelCommande.add(tfPrixUni);
		tfPrixUni.setColumns(10);
		
		tfQte = new JTextField();
		tfQte.setColumns(10);
		tfQte.setBounds(207, 82, 85, 26);
		panelCommande.add(tfQte);
		
		jcBoxArticle = new JComboBox();
		jcBoxArticle.setBounds(71, 28, 221, 27);
		panelCommande.add(jcBoxArticle);
		
		btnAchat = new JButton("Achat");
		btnAchat.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnAchat.setBounds(324, 115, 147, 57);
		getContentPane().add(btnAchat);
		
		btnTerminer = new JButton("Terminer");
		btnTerminer.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnTerminer.setBounds(326, 171, 147, 57);
		getContentPane().add(btnTerminer);
		
		panelFacture = new JPanel();
		panelFacture.setBackground(Color.RED);
		panelFacture.setBounds(10, 240, 461, 266);
		getContentPane().add(panelFacture);
		panelFacture.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 449, 114);
		panelFacture.add(scrollPane);
		
		modele = new DefaultTableModel();
		table = new JTable(modele);
		scrollPane.setViewportView(table);
		
		btnRadioComptant = new JRadioButton("Paiement comptant");
		btnRadioComptant.setForeground(Color.WHITE);
		btnRadioComptant.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnRadioComptant.setBounds(6, 145, 163, 23);
		panelFacture.add(btnRadioComptant);
		
		btnRadioCredit = new JRadioButton("Paiement crédit");
		btnRadioCredit.setForeground(Color.WHITE);
		btnRadioCredit.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnRadioCredit.setBounds(181, 145, 138, 23);
		panelFacture.add(btnRadioCredit);
		
		btnPayer = new JButton("Payer");
		btnPayer.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnPayer.setBounds(322, 132, 133, 68);
		panelFacture.add(btnPayer);
		
		labelMontantDonne = new JLabel("Montant donnée:");
		labelMontantDonne.setForeground(Color.WHITE);
		labelMontantDonne.setFont(new Font("Dialog", Font.BOLD, 12));
		labelMontantDonne.setBounds(17, 196, 115, 14);
		panelFacture.add(labelMontantDonne);
		
		labelMontantRemis = new JLabel("Montant remis:");
		labelMontantRemis.setForeground(Color.WHITE);
		labelMontantRemis.setFont(new Font("Dialog", Font.BOLD, 12));
		labelMontantRemis.setBounds(17, 230, 115, 14);
		panelFacture.add(labelMontantRemis);
		
		tfMontantDonne = new JTextField();
		tfMontantDonne.setColumns(10);
		tfMontantDonne.setBounds(220, 190, 99, 26);
		panelFacture.add(tfMontantDonne);
		
		tfMontantRemis = new JTextField();
		tfMontantRemis.setColumns(10);
		tfMontantRemis.setBounds(220, 224, 99, 26);
		panelFacture.add(tfMontantRemis);
		
		btnAnnuNouvComm = new JButton("<html>\n<p>Annuler Commande /</p>\n<p>Nouvelle Commande</p>\n</html>");
		btnAnnuNouvComm.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnAnnuNouvComm.setBounds(322, 202, 133, 48);
		panelFacture.add(btnAnnuNouvComm);
		
		modele.addColumn("Produit");
		modele.addColumn("Quantit�");
		modele.addColumn("Prix");
		
		tfNumMembre.addActionListener(ec);

	}
	
	public class Ecouteur implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}
		
	}
}
