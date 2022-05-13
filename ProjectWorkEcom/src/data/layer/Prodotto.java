package data.layer;
import java.io.Serializable;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Prodotto implements Serializable {
    private static final long serialVersionUID = 748392348L;
    
    private String codice;

   	private String descrizione;

   	private double prezzo;

   	private int iva;
   	
   	private int speseTrasporto;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getSpeseTrasporto() {
		return speseTrasporto;
	}

	public void setSpeseTrasporto(int speseTrasporto) {
		this.speseTrasporto = speseTrasporto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
    
}