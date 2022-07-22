package tn.esprit.spring.controller;

/*import org.springframework.beans.factory.annotation.Autowired; */
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.service.UserService;
/*import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
*/
@RestController
public class CommonController {
	
   
    UserService userService;	

    /*   public Utilisateur getAuthenticatedUser() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        return userService.findByUsername(auth.getName());
        
    } */
	
}
