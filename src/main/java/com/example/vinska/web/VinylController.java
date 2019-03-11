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
    private double totalValue = 0.00;
    private int totalAmount = 0;
    private double totalWorth = 0.00;
    @Autowired
    private VinylRepository vrepository;
    @Autowired
    private GenreRepository grepository;

    @RequestMapping("/login")
    public String login() {
        //session.setAttribute("Juan","Value");
        return "login";

    }


    //Shows all books
    @RequestMapping(value ="/vinyllist")
    public String vinylList(Model model) {
        totalValue = 0.00;
        totalAmount = 0;
        totalWorth = 0.00;
        for (int i = 0; i < vinylArrayList.size(); i++){
            totalAmount  += vinylArrayList.get(i).getAmount();
            totalValue += vinylArrayList.get(i).getPrice();
            totalWorth += vinylArrayList.get(i).getLastSoldPrice();
        }
        model.addAttribute("totalamount", totalAmount);
        model.addAttribute("totalvalue", totalValue);
        model.addAttribute("totalworth", totalWorth);
        model.addAttribute("vinyls", vrepository.findAll());
        // String value = (String) session.getAttribute("Juan");
        //System.out.println(value);
        return "vinyllist";
    }

    // RESTful service to get all students
    @RequestMapping(value = "/vinyls")
    public @ResponseBody
    List<Vinyl> vinylListRest() {
        return (List<Vinyl>) vrepository.findAll();
    }

    //RESTful service to get stuent by id
    @RequestMapping(value = "/vinyl/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Vinyl> findBookRest(@PathVariable("id") Long vinylId) {
        return vrepository.findById(vinylId);
    }


    //Delete book
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteVinyl(@PathVariable("id") Long vinylId, Model model) {
        for (int i = 0; i < vinylArrayList.size(); i++){
            if (vinylArrayList.get(i).getId() == vinylId){
                vinylArrayList.remove(i); } }

        totalValue = 0.00;
        totalWorth = 0.00;
        totalAmount = 0;
        for (int i = 0; i < vinylArrayList.size(); i++){
            totalAmount  += vinylArrayList.get(i).getAmount();
            totalValue += vinylArrayList.get(i).getPrice();
            totalWorth += vinylArrayList.get(i).getLastSoldPrice();
        }
        vrepository.deleteById(vinylId);
        return "redirect:../vinyllist";
    }

    //Add new book
    @RequestMapping(value = "/addvinyl")
    public String addVinyl(Model model) {
        model.addAttribute("vinyl", new Vinyl());
        model.addAttribute("genres", grepository.findAll());
        return "addvinyl";
    }

    // Edit existing book
    @RequestMapping(value = "/edit/{id}")
    public String editVinyl(@PathVariable("id") Long vinylId, Model model) {
        for (int i = 0; i < vinylArrayList.size(); i++){
            if (vinylArrayList.get(i).getId() == vinylId){
                vinylArrayList.remove(i); }
        }
        totalValue = 0.00;
        totalWorth = 0.00;
        totalAmount = 0;
        for (int i = 0; i < vinylArrayList.size(); i++){
            totalAmount  += vinylArrayList.get(i).getAmount();
            totalValue += vinylArrayList.get(i).getPrice();
        }

        model.addAttribute("totalamount", totalAmount);
        model.addAttribute("totalvalue", totalValue);
        model.addAttribute("totalworth", totalWorth);

        model.addAttribute("vinyl", vrepository.findById(vinylId));
        model.addAttribute("genres", grepository.findAll());
        return "edit";

    }

    //Save vinyl
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Vinyl vinyl) {
        vinylArrayList.add(vinyl);
        vrepository.save(vinyl);
        return "redirect:vinyllist";
    }

    // index-
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
