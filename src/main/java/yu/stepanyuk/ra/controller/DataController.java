package yu.stepanyuk.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yu.stepanyuk.ra.entity.Data;
import yu.stepanyuk.ra.service.DataService;

import java.util.List;

@RestController
public class DataController {

    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping(value = "/alldata",method = RequestMethod.GET)
    public List<Data> findAllData(){
        return dataService.findAll();
    }

    @RequestMapping(value = "/data/{id}")
    public Data getData(@PathVariable String id){
        return dataService.findById(Long.valueOf(id));
    }

    @RequestMapping(value = "/dataq/{id}")
    public String getDataq(@PathVariable String id, Model model){
        model.addAttribute("data", dataService.findById(Long.valueOf(id))) ;
        return "dataview";
    }

    @RequestMapping(value = "/dataadd",method = RequestMethod.POST)
    public void addData(@RequestBody Data data ){
        dataService.addNewData(data);
    }

    @RequestMapping(value = "/dataupdate/{id}",method = RequestMethod.PUT)
    public void addData(@RequestBody Data data, @PathVariable String id){
        dataService.updateData(data, Long.valueOf(id));
    }

    @RequestMapping(value = "/deletedata/{id}",method = RequestMethod.DELETE)
    public void delData(@PathVariable String id ){
        dataService.deleteData(Long.valueOf(id));
    }

    @RequestMapping(value = "/alldatasum",method = RequestMethod.GET)
    public List<Data> getDataGroupRenderEngene(){
        return dataService.getSummaryData();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getEmpty(){
        return "Your Application is running";
    }

}
