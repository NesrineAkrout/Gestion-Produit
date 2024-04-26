package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.CategorieDAO;
import dao.ProduitDAO;
import metier.Produit;

public class GestionProduit extends JFrame{
	private JLabel jLabelTitre,jLabelRef,jLabelDes,jLabelPrix;
	private JTextField jTextFieldRef,jTextFieldDes,jTextFieldPrix;
	private JButton jButtonSupp,jButtonEnreg;
	private JTable jTable;
	private ProduitModel produitModel;
    private CategorieDAO catDAO=new CategorieDAO();
    private ProduitDAO proDAO=new ProduitDAO();
    private JScrollPane scroll1;
    public GestionProduit()
    {
    	super.setTitle("Gestion Produit");
    	super.setSize(800,450);
    	super.setLocationRelativeTo(null);
    	super.setResizable(true);
    	super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	JPanel jPanelN=new JPanel();
    	jPanelN.setLayout(null);
    	add(jPanelN);
    	jPanelN.setBackground(new Color(220,210,220));
    	
    	jLabelTitre=new JLabel("Gestion Produit");
    	jLabelTitre.setBounds(250, 10, 800, 30);
    	jLabelTitre.setFont(new Font("Arial",Font.BOLD,24));
    	jLabelTitre.setForeground(new Color(0,0,205));
    	jPanelN.add(jLabelTitre);
    	
    	jLabelRef=new JLabel("Reference");
    	jLabelRef.setBounds(60, 60, 800, 30);
    	jLabelRef.setFont(new Font("Arial",Font.BOLD,16));
    	jLabelRef.setForeground(new Color(0,0,0));
    	jPanelN.add(jLabelRef);
    	
    	jTextFieldRef=new JTextField();
    	jTextFieldRef.setBounds(200, 60,150, 30);
    	jTextFieldRef.setFont(new Font("Arial",Font.PLAIN,14));
    	jPanelN.add(jTextFieldRef);
    	
    	jLabelDes=new JLabel("Designation");
    	jLabelDes.setBounds(60, 100, 800, 30);
    	jLabelDes.setFont(new Font("Arial",Font.BOLD,16));
    	jLabelDes.setForeground(new Color(0,0,0));
    	jPanelN.add(jLabelDes);
    	
    	jTextFieldDes=new JTextField();
    	jTextFieldDes.setBounds(200,100,150, 30);
    	jTextFieldDes.setFont(new Font("Arial",Font.PLAIN,14));
    	jPanelN.add(jTextFieldDes);
    	
    	jLabelPrix=new JLabel("Prix");
    	jLabelPrix.setBounds(60, 140, 800, 30);
    	jLabelPrix.setFont(new Font("Arial",Font.BOLD,16));
    	jLabelPrix.setForeground(new Color(0,0,0));
    	jPanelN.add(jLabelPrix);
    	
    	jTextFieldPrix=new JTextField();
    	jTextFieldPrix.setBounds(200,140,150, 30);
    	jTextFieldPrix.setFont(new Font("Arial",Font.PLAIN,14));
    	jPanelN.add(jTextFieldPrix);
    	
    	jButtonEnreg=new JButton("Enregistrer");
    	jButtonEnreg.setBounds(60,230,140,30);
    	jButtonEnreg.setFont(new Font("Arial",Font.BOLD,15));
    	jButtonEnreg.setForeground(Color.BLACK);
    	jButtonEnreg.setBackground(new Color(173,216,230));
    	jButtonEnreg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Produit p=new Produit(jTextFieldRef.getText(),jTextFieldDes.getText(),5.600,7);
    			proDAO.addProduit(p,1);
			}
    		});
    	jPanelN.add(jButtonEnreg);
    	jButtonSupp=new JButton("Supprimer");
    	jButtonSupp.setBounds(220,230,140,30);
    	jButtonSupp.setFont(new Font("Arial",Font.BOLD,15));
    	jButtonSupp.setForeground(Color.BLACK);
    	jButtonSupp.setBackground(new Color(173,216,230));
    	jButtonSupp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Produit p=new Produit(jTextFieldRef.getText(),jTextFieldDes.getText(),5.600,7);
    			proDAO.addProduit(p,1);
			}
	
    		});
    	
    	
    	jPanelN.add(jButtonSupp);
    	
    	
    }
	public static void main(String[] args) {
		
		GestionProduit gp=new GestionProduit();
		gp.setVisible(true);
		
	}

}
