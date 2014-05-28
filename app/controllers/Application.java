package controllers;

import models.SolveSQ;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	static Form solve = Form.form(SolveSQ.class);
	
    static Double s=9.0;
    public static Result index() {
  	  return ok(index.render("BleachGod is here",s));
  	  
  }

    public static Result add() {
    	DynamicForm form =Form.form().bindFromRequest();
    	
    	String petResponse =form.data().get("petResponse");
    	
    	s=Double.parseDouble(petResponse);
        return redirect(routes.Application.index());  
    }
    

    
}
