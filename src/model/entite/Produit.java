package model.entite;

public class Produit {
	private int id;
	private String designation;
	private int prix;
	private int quant;
	
	
	
	
	public Produit(String designation, int prix, int quant) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quant = quant;
	}

	public Produit(int id, String designation, int prix, int quant) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quant = quant;
	}
	
	public Produit() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	

}
