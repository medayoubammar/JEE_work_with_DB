package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entite.Produit;

public class Produit_implement implements iProduit {
	@Override
	public List<Produit> getAllProductes() {
		
		
  Connection cn = DataBaseConnection.getConnection() ;
  PreparedStatement ps;
	 List<Produit> liste = new ArrayList<>();

  try {
	ps = cn.prepareStatement("SELECT * FROM produit");
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
	 Produit produit = new Produit();
	 produit.setId( rs.getInt("id"));
	 produit.setDesignation( rs.getString("Designation"));
	 produit.setPrix(rs.getInt("prix"));
	 produit.setPrix(rs.getInt("quant"));
     
	 liste.add(produit);
	
	
	}
	
	
	
} catch (SQLException e) {

	e.printStackTrace();
}
  return liste;
	}

	@Override
	public List<Produit> getAllProductesByKey(String key) {
		
		 Connection cn = DataBaseConnection.getConnection() ;
		  PreparedStatement ps;
			 List<Produit> liste = new ArrayList<>();

		  try {
			ps = cn.prepareStatement("SELECT * FROM produit WHERE designation LIKE ?");
			ps.setString(1, "%"+ key +"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			 Produit produit = new Produit();
			 produit.setId( rs.getInt("id"));
			 produit.setDesignation( rs.getString("Designation"));
			 produit.setPrix(rs.getInt("prix"));
			 produit.setPrix(rs.getInt("quant"));
		     
			 liste.add(produit);
			
			
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		  return liste;
	}

	@Override
	public void InsertProduct(Produit p) {
		
		 Connection cn = DataBaseConnection.getConnection() ;
		  PreparedStatement ps;
		  
		  try {
			ps = cn.prepareStatement("INSERT INTO produit (designation,prix,quant) VALUES(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setInt(2, p.getPrix());
			ps.setInt(3, p.getQuant());
			
		ps.executeUpdate();
		
			
		  
		  
		  } catch (SQLException e) {
		
			e.printStackTrace();
		}
		  
		
	}

	@Override
	public void RemoveProduct(int index) {
		 Connection cn = DataBaseConnection.getConnection() ;
		  PreparedStatement ps;
		  try {
			ps = cn.prepareStatement("DELETE FROM produit WHERE id=?");
			 ps.setInt(1,index);
			 ps.executeUpdate();
			 } catch (SQLException e) {
		
			e.printStackTrace();
		}
		 

		
	}

}
