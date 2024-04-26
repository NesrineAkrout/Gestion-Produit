package metier;
import java.util.List;
import java.util.ArrayList;
public class Categorie {
	
	private int idCat;
	private String nomCat;
	private List<Produit> produits=new ArrayList<Produit>();
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public Categorie() {
		super();
	}
	public Categorie(String nomCat) {
		super();
		this.nomCat = nomCat;
	}
	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + nomCat + "]";
	}
}
