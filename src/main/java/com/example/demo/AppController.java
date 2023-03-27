package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // связь зависимотей
import org.springframework.data.repository.query.Param; // привязываем параметры
import org.springframework.stereotype.Controller; // класс управляющий
import org.springframework.ui.Model; // взаимодействия view controller
import org.springframework.web.bind.annotation.ModelAttribute; // связывание параметра и метода , который выводится в веб интейфейс
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; // название html страниц которые подвязываются к контролеру

@Controller
public class AppController {

    @Autowired
    private LoadService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Load> listLoad = service.listAll(keyword);
        model.addAttribute("listLoad", listLoad);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewSessionForm(Model model){
        Load load = new Load();
        model.addAttribute("Load", load);
        return "new_load";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("Session") Load load){
        service.save(load);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditSessionFrom(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_load");
        Load load = service.get(id);
        mav.addObject("Load", load );
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteSession(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";

    }


}