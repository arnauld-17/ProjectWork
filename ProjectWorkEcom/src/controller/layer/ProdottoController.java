package controller.layer;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import data.layer.Carrello;
import data.layer.Prodotto;
import data.layer.User;
import service.layer.TransactionDao;
import validator.layer.ProdottoValidator;

@Controller
public class ProdottoController {
	@Autowired 
	private TransactionDao dao;
	@Autowired ProdottoValidator prodottoValidator;
	
    private static final Log logger = LogFactory
            .getLog(ProdottoController.class);
    


    @RequestMapping(value = "/prodotto_input")
    public String inputProdotto(Model model) {
        model.addAttribute("prodotto", new Prodotto());
        logger.info("prodotto_input");
        return "prodottoForm";
    	
    }
    
    @RequestMapping(value = "/prodottoList")
    public String listProdotto(Model model) {
    	
        String jspcodice = null;
        try {
        	List<Prodotto> lista = dao.retrieveProdottoList();
            model.addAttribute("prodotto", lista);
            jspcodice = "prodottoList"; 
              
        } catch (Exception e){

        }
        
    return jspcodice;

    }
    
    @RequestMapping(value = "/prodottiList")
    public String listProdotti(Model model) {
    	
        String jspcodice = null;
        try {
        	List<Prodotto> lista = dao.retrieveProdottoList();
            model.addAttribute("prodotto", lista);
            jspcodice = "prodottiList"; 
              
        } catch (Exception e){

        }
        
    return jspcodice;

    }
    
   @RequestMapping(value= "/user")
   public String login() {
	   return "Login";
   }
   
   @RequestMapping(value= "/user_check")
   public String checkuser( @Valid @ModelAttribute("user") User user,
           BindingResult bindingResult, Model model,HttpSession session) {
       logger.info("user_check");
      
       try {
    	  
    	   boolean b= dao.getLogin(user.getUsername(),user.getPassword());
    	   if (b) { 
    		   session.setAttribute("log","true");
    		   if(dao.getAdministrator(user.getUsername(),user.getPassword()))
    			   return "administratorMenu";
    		   else
    			   return "clientMenu";
    	   }
    	   
                  
       } catch (SQLException e) {
       	/*System.out.println("Eccezione: "+e); // non fatelo!*/
       }
       /*bindingResult.addError(new ObjectError("err","username o password sbagliato"));*/ 
       bindingResult.reject("err","username o password sbagliato");
      /*System.out.println(bindingResult.getAllErrors().get(0));*/
       return "Login";
       
   }
    
    @RequestMapping(value = "/prodottoEdit")
    public String editProdotto(Model model, @RequestParam String codice) {
    	
		/*String jspname=null;*/
		String jspcodice=null;
		Prodotto prod = null;
        try {
        	prod = dao.getProdotto(codice);        
        } catch (SQLException e) {
        	/*System.out.println("Eccezione: "+e); // non fatelo!*/
        }

        model.addAttribute("prodotto", prod);
        return "prodottoEdit";
		
    }

    @RequestMapping(value = "/prodotto_save")
    public String saveProdotto(@Valid @ModelAttribute("prodotto") Prodotto prodotto,
            BindingResult bindingResult, Model model) {
        logger.info("prodotto_save");
        System.out.println("prod save");
        
        if (bindingResult.hasErrors()) {
            return "prodottoForm";
        }
        
        //ProductValidator productValidator = new ProductValidator();
        prodottoValidator.validate(prodotto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "prodottoForm";
        }

        try {
        	dao.addProdotto(prodotto);        
        } catch (SQLException e) {
        	bindingResult.reject("codice",e.getMessage());
        	return "prodottoForm";
        }

        model.addAttribute("prodotto", prodotto);
        return "prodottoDetails";
    }
    
    /*@RequestMapping(value = "/prodotto_delete")
    public String deleteProdotto(Model model, @RequestParam String codice) {
    	
    	String jspcodice=null;
		Prodotto prod = null;
        try {
        	prod = dao.getProdotto(codice);
        	dao.deleteProdotto(prod);        
        } catch (SQLException e) {
        	/*System.out.println("Eccezione: "+e);
        }

        return "prodottoDelete";
    	
    	
    }*/
    
    @RequestMapping(value = "/prodotto_update")
    public String updateProdotto(@Valid @ModelAttribute("prodotto") Prodotto 			prodotto,
            BindingResult bindingResult, Model model) {
        
        if (bindingResult.hasErrors()) {
            return "prodottoForm";
        }
        
        //ProductValidator productValidator = new ProductValidator();
        prodottoValidator.validate(prodotto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "prodottoEdit";
        }

        try {
        	dao.updateProdotto(prodotto);        
        } catch (SQLException e) {
        	bindingResult.reject("codice",e.getMessage());
        	return "prodottoEdit";
        }

        model.addAttribute("prodotto", prodotto);
        return "prodottoDetails";
    }
    
    
    @RequestMapping(value = "/obtainProduct")
    public String getProdotto(Model model, @ModelAttribute("codice") String codice  ) {
    	
    	String jspcodice=null;
		Prodotto prod = null;
        try {
        	
        	 
      	List<Prodotto> lista = dao.retrieveProdottoList();
                 
        	prod = dao.getProdotto(codice); 
        	 model.addAttribute("prodotto", prod);
             jspcodice = "obtainProduct"; 
        	
        } catch (SQLException e) {
        
        }

        return jspcodice;
    	
    	
    }
    
    
    @RequestMapping(value = "/findProduct")
    public String processGetProduct() {
    	
    
            return "findProduct";
    	
    	
    }
    
    
    @RequestMapping(value = "/administratorMenu")
    public String administratorMenu(HttpSession session ) {
        logger.info("administratorMenu");
        String log= (String) session.getAttribute("log");
        System.out.println(log);
        if(log.equals("true"))
        	return "administratorMenu";
        else return "Login";
    }
    
    @RequestMapping(value = "/clientMenu")
    public String clientMenu(HttpSession session ) {
        logger.info("clientMenu");
        String log= (String) session.getAttribute("log");
        System.out.println(log);
        if(log.equals("true"))
        	return "clientMenu";
        else return "Login";
    }
    

  
 
    
    
    @RequestMapping(value = "/carrello")
    public String inputCarrello(Model  model,@RequestParam String codice) {
    	
		
		Prodotto prod = null;
		Carrello car = new Carrello();
		
        try {
        	prod = dao.getProdotto(codice);
        	
        	car.setCodice(prod.getCodice());
        	car.setDescrizione(prod.getDescrizione());
        	car.setId(1);
        	 dao.addCarrello(car);
        } catch (SQLException e) {
        	/*System.out.println("Eccezione: "+e); // non fatelo!*/
        }

        return "carrelloForm";
    
}
    }
