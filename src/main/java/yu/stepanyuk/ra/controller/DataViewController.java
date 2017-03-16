package yu.stepanyuk.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yu.stepanyuk.ra.service.DataService;

@Controller
@RequestMapping("/view")
public class DataViewController {

    private DataService dataService;

    @Autowired
    public DataViewController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("posts", dataService.findAll());
        return "dataview";
    }
}
