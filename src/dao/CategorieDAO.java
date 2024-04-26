package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Categorie;
import metier.Produit;

public class CategorieDAO {
	
public void addCategorie(Categorie c) {
		Connection conn=SingletonConnection.getInstance();
		
		try {
		    PreparedStatement ps;
			ps = conn.prepareStatement("insert into categorie(NOM_CAT) values(?)");
		    ps.setString(1,c.getNomCat());
		    ps.executeUpdate();
		    ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		}
	}
public List<Categorie> getallCategories() {
	List<Categorie> cats=new ArrayList<Categorie>();
	Connection conn=SingletonConnection.getInstance();
	try {
	    PreparedStatement ps;
		ps = conn.prepareStatement("select * from categorie");
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    	Categorie c=new Categorie();
	    	c.setIdCat(rs.getInt("ID_CAT"));
	    	c.setNomCat(rs.getString("NOM_CAT"));
	        cats.add(c);
	    }
	    ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cats;
}


public Categorie getCategorie(int idCat) {
	Categorie cat=null;
	ProduitDAO pdao=new ProduitDAO();
	Connection conn=SingletonConnection.getInstance();
	try {
	    PreparedStatement ps;
		ps = conn.prepareStatement("select * from categorie where ID_CAT=?");
		ps.setInt(1,idCat);
	    ResultSet rs=ps.executeQuery();
	    if(rs.next())
	    {
	    	cat=new Categorie();
	    	cat.setIdCat(rs.getInt("ID_CAT"));
	    	cat.setNomCat(rs.getString("NOM_CAT"));
	    	List<Produit> prods=pdao.getproduitsParCAT(idCat);
	    	cat.setProduits(prods);
	    }
	    ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cat;
}
}
