package model.dao;
import java.util.List;

import model.entite.Produit;

public interface iProduit {
	
	List <Produit> getAllProductes();
	List <Produit> getAllProductesByKey(String key);
	void InsertProduct(Produit p);
	void RemoveProduct(int index);


}
