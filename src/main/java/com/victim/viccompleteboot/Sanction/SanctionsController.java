package com.victim.viccompleteboot.Sanction;

import com.victim.viccompleteboot.models.Sanction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class SanctionsController {

    @Autowired
    private SanctionsService sanctionsService;


    @GetMapping("")
    public String showSanctionsPage(Model model) {
        return listByPage(model,1);
    }

    @GetMapping("{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage){
        Page<Sanction> page = sanctionsService.show(currentPage);

        List<Sanction> sanctionList = page.getContent();
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        model.addAttribute("sanctions", sanctionList);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages",totalPages);
        return "pages/sanctions";
    }

    @GetMapping("/maintain")
    public String newSanctionForm(Model model) {
        Sanction sanction = new Sanction();
        model.addAttribute("sanction", sanction);
        return "pages/maintain";
    }

    @PostMapping("/save")
    public String saveSanction(@ModelAttribute("sanction") Sanction sanction, RedirectAttributes redirectAttributes){

        sanctionsService.save(sanction);
        redirectAttributes.addFlashAttribute("message","Successfully completed");
        return "redirect:/";
    }

    @GetMapping("/help")
    public String help(){
        return "pages/help";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id){

        Optional<Sanction> sanction = sanctionsService.sanction(id);
        ModelAndView mv = new ModelAndView("pages/edit");
        mv.addObject("sanction",sanction);

        return mv;
    }


}
