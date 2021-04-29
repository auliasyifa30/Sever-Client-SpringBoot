package mii.co.id.clientappmcc.controllers;

import java.util.List;
import mii.co.id.clientappmcc.models.Province;
import mii.co.id.clientappmcc.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    //READ
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("provinces", provinceService.getAll());
        return "province/province";
    }

    @GetMapping("/get-all")
    public @ResponseBody
    List<Province> getAllProcess() {
       return provinceService.getAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Province getById(@PathVariable("id") Integer id) {
        return provinceService.getById(id);
    }

    @PostMapping
    public @ResponseBody String create(@RequestBody Province province) {
        return provinceService.create(province);
    }

    //UPDATE
    @PutMapping("/{id}")
    public @ResponseBody String update(@PathVariable("id") Integer id, @RequestBody Province province) {
        return provinceService.update(id, province);

    }

    @DeleteMapping("/{id}")
    public @ResponseBody String delete(@PathVariable("id") Integer id) {
        return provinceService.delete(id);
    }
}
