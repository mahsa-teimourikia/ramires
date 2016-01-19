/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimi.thesis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller makes it a controller. i.e. receives requests 
 * direct to the corresponding method identified by the @RequestMapping annotation.
 */
@Controller
public class DefaultController {
    
    /**
     * This method is invoked via the url “/” . It returns a view. I.e. the view “index.jsp” 
     * as per the matched name “index” = “index.jsp”. The configuration in Config.setupViewResolver() 
     * sets prefixes and suffixes around “index” to match it to /WEB-INF/jsp/index.jsp
     * @param map
     * @return 
     */
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(ModelMap map){
        map.put("msg", "Hello Spring 4 Web MVC!");
        return "index";
    }
    
}
