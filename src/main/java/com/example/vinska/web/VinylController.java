package com.example.vinska.web;

import com.example.vinska.domain.GenreRepository;
import com.example.vinska.domain.Vinyl;
import com.example.vinska.domain.VinylRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
public class VinylController {
    private List<Vinyl> vinylArrayList = new ArrayList<>();

    @Autowired
    private VinylRepository vrepository;
    @Autowired
    private GenreRepository grepository;

    @RequestMapping("/login")
    public String login() {

        return "login";

    }


    //Shows all vinyls in vrepository
    @RequestMapping(value ="/vinyllist")
    public String vinylList(Model model) {
        model.addAttribute("vinyls", vrepository.findAll());
        model.addAttribute("totalVinylAmount", vrepository.getTotalAmount());
        model.addAttribute("totalSpent", vrepository.getTotalSpent());
        model.addAttribute("totalValue",vrepository.getTotalValue());
        return "vinyllist";
    }

    // RESTful service to get all all vinyls in JSON
    @RequestMapping(value = "/vinyls")
    public @ResponseBody
    List<Vinyl> vinylListRest() {
        return (List<Vinyl>) vrepository.findAll();
    }

    //RESTful service to get vinyls by id in JSON
    @RequestMapping(value = "/vinyl/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Vinyl> findBookRest(@PathVariable("id") Long vinylId) {
        return vrepository.findById(vinylId);
    }


    //Delete vinyl allowed by ADMIN only
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteVinyl(@PathVariable("id") Long vinylId, Model model) {
        vrepository.deleteById(vinylId);
        return "redirect:../vinyllist";
    }

    //Add new vinyl to your repository
    @RequestMapping(value = "/addvinyl")
    public String addVinyl(Model model) {
        model.addAttribute("vinyl", new Vinyl());
        model.addAttribute("genres", grepository.findAll());
        return "addvinyl";
    }

    // Edit existing vinyl
    @RequestMapping(value = "/edit/{id}")
    public String editVinyl(@PathVariable("id") Long vinylId, Model model) {
        model.addAttribute("vinyl", vrepository.findById(vinylId));
        model.addAttribute("genres", grepository.findAll());
        return "edit";

    }

    //Save vinyl
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Vinyl vinyl) {
        vrepository.save(vinyl);
        return "redirect:vinyllist";
    }

    // index-
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
