package eu.chowaniok;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by marek on 11/11/14.
 */
@Controller
public class PingViewController {

    @RequestMapping("/")
    public ModelAndView getPingsView() {
        ModelMap model = new ModelMap();
//                model.addAttribute("pings", pingRepository.getPings());
        model.addAttribute("pings2", new String("2222"));
        return new ModelAndView("overview", model);
    }
}
