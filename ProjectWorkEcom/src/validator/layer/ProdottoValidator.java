package validator.layer;


import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import data.layer.Prodotto;
@Service
public class ProdottoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

    /*@Override
    public boolean supports(Class<?> klass) {
        return Prodotto.class.isAssignableFrom(klass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Prodotto prodotto = (Prodotto) target;

        if (prodotto.getCodice().startsWith("p") && prodotto.getPrezzo() > 100) {
        	errors.rejectValue("prezzo","productname.productprice");
        }

    }*/
}