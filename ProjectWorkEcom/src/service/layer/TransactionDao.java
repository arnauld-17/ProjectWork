package service.layer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.layer.Carrello;
import data.layer.Prodotti;
import data.layer.Prodotto;

public interface TransactionDao {
	List<Prodotto> retrieveProdottoList() throws SQLException;
	void addProdotto(Prodotto prodotto) throws SQLException;
	void updateProdotto(Prodotto prodotto) throws SQLException;
	/*void deleteProdotto(Prodotto prodotto) throws SQLException;*/
	Prodotto getProdotto(String prodottoCodice) throws SQLException;
	boolean getLogin(String username,String password) throws SQLException;
	boolean getAdministrator(String username,String password) throws SQLException;
	void addCarrello(Carrello carrello) throws SQLException;
	
	
	
   
	
}
