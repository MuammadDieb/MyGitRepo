package controllers;


import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
    static String s="";

	private static double a;
	private static double b;
	private static double c;
	private static double d;

	private static String r;
	
    public static Result index() {
  	  return ok(index.render("Solving Second-Order Equation By Mohammed Dieb",s));
  	  
  }

    public static Result SolveByInputs() {
    	DynamicForm form =Form.form().bindFromRequest();
    	
    	 a =Double.parseDouble(form.data().get("a"));
    	 b =Double.parseDouble(form.data().get("b"));
    	 c =Double.parseDouble(form.data().get("c"));
    	
    	
    	s=SolveResult();
        return redirect(routes.Application.index());  
    }
    
    public static Result SolveByURI(Double a1,Double b1,Double c1) {
    	a=a1; b=b1; c=c1;
    	
    	s=SolveResult();
        return redirect(routes.Application.index());  
    }
    

	private static String SolveResult() {
		 d= Math.pow(b,2) - 4*a*c;
		
		 if(d<0){r="Impossible";}
	        else if(d==0){r="Doubeld : "+((-1)*b)/(2*a);}
	        	else{r="Two Solution :x1 = "+((-1*b-Math.sqrt(d))/(2*a))+"   |  x2= "+((-1*b+Math.sqrt(d))/(2*a));}
	        
	        return r;
	}
    

    
}
