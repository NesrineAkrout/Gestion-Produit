package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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

public class CatalogueSwing extends JFrame
{  // private JFrame jFrame=new JFrame();
	private JLabel jLabelMC=new JLabel("Mot Clé");
	private JTextField jTextFieldMC=new JTextField(12);
	private JButton jButtonOk=new JButton("OK");
	private JTable jTable;
	private ProduitModel produitModel;
    private CategorieDAO catDAO=new CategorieDAO();
    private ProduitDAO proDAO=new ProduitDAO();
    public CatalogueSwing()
    {
    	
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel jPanelN=new JPanel();
       // JPanel jPanelN=(JPanel)this.getContentPane();
        jPanelN.setLayout(new FlowLayout());
        jPanelN.add(jLabelMC);
        jPanelN.add(jTextFieldMC);
        jPanelN.add(jButtonOk);
        this.add(jPanelN,BorderLayout.NORTH);
        produitModel=new ProduitModel();
        jTable=new JTable(produitModel);
       // jTable=new JTable(dm)
       JScrollPane jScrollPane=new JScrollPane(jTable);
       this.add(jScrollPane,BorderLayout.CENTER);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
        jButtonOk.addActionListener(
        		new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String mc=jTextFieldMC.getText();
				List<Produit>prods=proDAO.getproduitsParMC(mc);
			    produitModel.loadData(prods);
			
			}
		});
    }
    
    
    public static void main(String args[]) 
	{
		new CatalogueSwing();
	}
	
}
