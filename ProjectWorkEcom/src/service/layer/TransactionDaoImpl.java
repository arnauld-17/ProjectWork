package service.layer;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import data.layer.*;

@Service
public class TransactionDaoImpl implements TransactionDao{

    private Connection con;
    private static final Log logger = LogFactory.getLog(TransactionDaoImpl.class);
    public TransactionDaoImpl()  throws SQLException, NamingException  {
    	logger.info("connection");
        establishConnection();
        logger.info("connection: "+con);
    }

    private void establishConnection() throws SQLException, NamingException{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/db");
		con = ds.getConnection();
    }
    
    
    
    
    public List<Prodotto> retrieveProdottoList() throws SQLException{
        List<Prodotto> prodList = new ArrayList<>();
        	
       	String sql = "SELECT * FROM prodotto";
        PreparedStatement pStmt = con.prepareStatement(sql);

        ResultSet rs = pStmt.executeQuery();

        while (rs.next()) {

        	Prodotto prodBean = new Prodotto();
        	 prodBean.setCodice(rs.getString("codice"));
            prodBean.setDescrizione(rs.getString("descrizione"));
            prodBean.setPrezzo(rs.getFloat("prezzo"));
            prodBean.setIva(rs.getInt("iva"));
            prodBean.setSpeseTrasporto(rs.getInt("speseTrasporto"));
        

            prodList.add(prodBean);
        }

        return prodList;
    }
   

    public void addProdotto(Prodotto prodotto) throws SQLException {
    	String sql = " INSERT INTO prodotto VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pStmt = con.prepareStatement(sql);

		String codice = prodotto.getCodice();
		String descrizione = prodotto.getDescrizione();
		double prezzo = prodotto.getPrezzo();
		int iva        = prodotto.getIva();
		int speseTrasporto=prodotto.getSpeseTrasporto();
	

		pStmt.setString(1, codice);
		pStmt.setString(2, descrizione);
		pStmt.setDouble(3, prezzo);
		pStmt.setInt(4, iva);
        pStmt.setInt(5, speseTrasporto);
		pStmt.executeUpdate();
    }
    
    /*public void deleteProdotto(Prodotto prodotto) throws SQLException{
    	String sql = "DELETE FROM prodotto WHERE codice = ?";
    	PreparedStatement pStmt = con.prepareStatement(sql);
    	
    	String codice = prodotto.getCodice();
    	pStmt.setString(1, codice);
    	pStmt.executeUpdate();
    }*/
    
    public void updateProdotto(Prodotto prodotto) throws SQLException {
    	String sql = "UPDATE prodotto SET  descrizione = ?, prezzo = ?, iva = ?, spesetrasporto = ? where codice = ?";
		PreparedStatement pStmt = con.prepareStatement(sql);

		String codice = prodotto.getCodice();
		String descrizione = prodotto.getDescrizione();
		double prezzo = prodotto.getPrezzo();
		int iva        = prodotto.getIva();
		int speseTrasporto=prodotto.getSpeseTrasporto();


		pStmt.setString(5, codice);
		pStmt.setString(1, descrizione);
		pStmt.setDouble(2, prezzo);
		pStmt.setInt(3, iva);
        pStmt.setInt(4, speseTrasporto);
		
		pStmt.executeUpdate();
    }
    
    public Prodotto getProdotto(String prodottoCodice) throws SQLException {
    	
    	String sql = "SELECT * FROM prodotto WHERE codice = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.setString(1, prodottoCodice);

        ResultSet rs = pStmt.executeQuery();

        Prodotto prod = null;

        while (rs.next()) {
            prod = new Prodotto();
            
            prod.setCodice(rs.getString("codice"));
            prod.setDescrizione(rs.getString("descrizione"));
            prod.setPrezzo(rs.getFloat("prezzo"));
            prod.setIva(rs.getInt("iva"));
            prod.setSpeseTrasporto(rs.getInt("speseTrasporto"));
    
        }

        return prod;
    }

	@Override
	public boolean getLogin(String username, String password) throws SQLException {
		
		/*System.out.println(username+"   "+password);*/
		
		String sql= "select * from users where username='"+username+"' and password='"+password+"'";
		PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        if(rs.next())
        	return true;
		
        return false;
	}

	@Override
	public boolean getAdministrator(String username, String password) throws SQLException {
		if(getLogin( username, password)) {
			String sql= "select * from users where username='"+username+"' and password='"+password+"'";
			PreparedStatement pStmt = con.prepareStatement(sql);
	        
	        ResultSet rs = pStmt.executeQuery();
	        while(rs.next()) {
	        	return rs.getBoolean("administrator");
	        }
	        
		}
		return false;
	}

	@Override
	public void  addCarrello(Carrello carrello) throws SQLException {
		
		
	    String sql = " INSERT INTO carrello VALUES (?, ?, ?)";
		PreparedStatement pStmt = con.prepareStatement(sql);
         /*Carrello car = new Carrello();*/
		String codice = carrello.getCodice();
		String descrizione = carrello.getDescrizione();
		
		

		pStmt.setString(1, codice);
		pStmt.setString(2, descrizione);
		pStmt.setInt(3, 1);

    
		
	}
	

    
	
	
}

