package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Categorie;
import metier.Produit;

public class ProduitDAO {

     public void addProduit(Produit p,int idCat) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getInstance();
		try {
		    PreparedStatement ps;
			ps = conn.prepareStatement("insert into produit values(?,?,?,?,?)");
		    ps.setString(1,p.getRefProduit());
		    ps.setString(2,p.getNomProduit());
		    ps.setDouble(3,p.getPrix());
		    ps.setInt(4,p.getQuantite());
		    ps.setInt(5,idCat);
		    ps.executeUpdate();
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public List<Produit> getproduitsParMC(String mc) {
		List<Produit> prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getInstance();
		try {
		    PreparedStatement ps;
			ps = conn.prepareStatement("select * from produit where NOM_PRODUIT like ?");
		    ps.setString(1,"%"+mc+"%");
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	Produit p=new Produit();
		    	p.setRefProduit(rs.getString("REF_PRODUIT"));
		    	p.setNomProduit(rs.getString("NOM_PRODUIT"));
		    	p.setPrix(rs.getDouble("Prix_PRODUIT"));
		    	p.setQuantite(rs.getInt("QTE_PRODUIT"));
		        int idCat=rs.getInt("ID_CAT");
		        PreparedStatement ps2=conn.prepareStatement("Select * from categorie where ID_CAT=?");
		        ps2.setInt(1,idCat);
		        ResultSet rs2=ps2.executeQuery();
		        if(rs2.next())
		        {
		        	Categorie cat=new Categorie();
		        	cat.setIdCat(rs2.getInt("ID_CAT"));
		        	cat.setNomCat(rs2.getString("NOM_CAT"));
		            p.setCategorie(cat);
		        }
		        ps2.close();
		        prods.add(p);
		    }
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	
	public List<Produit> getproduitsParCAT(int idCat) {
		List<Produit> prods=new ArrayList<Produit>();
		Connection conn=SingletonConnection.getInstance();
		try {
		    PreparedStatement ps;
			ps = conn.prepareStatement("select * from produit where ID_CAT=?");
		    ps.setInt(1,idCat);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	Produit p=new Produit();
		    	p.setRefProduit(rs.getString("REF_PRODUIT"));
		    	p.setNomProduit(rs.getString("NOM_PRODUIT"));
		    	p.setPrix(rs.getDouble("Prix"));
		    	p.setQuantite(rs.getInt("QUANTITE"));
		        
		        PreparedStatement ps2=conn.prepareStatement("Select * from categorie where ID_CAT=?");
		        ps2.setInt(1,idCat);
		        ResultSet rs2=ps2.executeQuery();
		        if(rs2.next())
		        {
		        	Categorie cat=new Categorie();
		        	cat.setIdCat(rs2.getInt("ID_CAT"));
		        	cat.setNomCat(rs2.getString("NOM_CAT"));
		            p.setCategorie(cat);
		        }
		        prods.add(p);
		    }
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}
}