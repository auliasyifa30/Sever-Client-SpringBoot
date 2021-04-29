package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.District;
import mii.co.id.clientappmcc.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("district", districtService.getAll());
        return "district/district";
    }

    @GetMapping("/get-all")
    public @ResponseBody List<District> getAllProcess() {
        return districtService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody District getById(@PathVariable("id") Integer id) {
        return districtService.getById(id);
    }

    @PostMapping
    public @ResponseBody String create(@RequestBody District district) {
        System.out.println(district);
        return districtService.create(district);
    }

    //UPDATE
    @PutMapping("/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id, @RequestBody District district) {
        System.out.println(district);
        return districtService.update(id, district);

    }

    @DeleteMapping("/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        System.out.println("district");
        return districtService.delete(id);
    }

}