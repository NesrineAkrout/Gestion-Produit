package dao;
import java.sql.Connection;

import metier.Categorie;
import metier.Produit;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getInstance();
		
		
		
		CategorieDAO catdao=new CategorieDAO();
		//ProduitDAO prddao=new ProduitDAO();
        catdao.addCategorie(new Categorie("Ordinateurs"));
	  catdao.addCategorie(new Categorie("Imprimantes"));
      catdao.addCategorie(new Categorie("CD"));
		//prddao.addProduit(new Produit("P1","HP",4000,33), 10);
		//prddao.addProduit(new Produit("P2","HP 98",6500,33), 10);
		//prddao.addProduit(new Produit("P3","Imp",4000,33), 11);
		//prddao.addProduit(new Produit("P4","aze",4000,33), 11);
		//prddao.addProduit(new Produit("P5","art",4000,33), 12);
	}

}
