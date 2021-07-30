package com.codegym.controller;

import com.codegym.model.Phone;
import com.codegym.service.Category.ICategoryService;
import com.codegym.service.Phone.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/phone")
public class PhoneController {

        @Autowired
        private IPhoneService phoneService;
        @Autowired
        private ICategoryService categoryService;

        @GetMapping("/create")
        public ModelAndView showFormCreat(){
            ModelAndView modelAndView = new ModelAndView("/phone/create");
            modelAndView.addObject("phone", new Phone());
            modelAndView.addObject("categories", categoryService.findAll());
            return modelAndView;
        }

        @PostMapping("/create")
        public ModelAndView saveProduct(@ModelAttribute("phone")Phone phone) {
            phoneService.save(phone);
            ModelAndView modelAndView = new ModelAndView("/phone/create");
            modelAndView.addObject("phone", phone);
            return modelAndView;
        }

        @GetMapping("")
        public ModelAndView findAll() {
            ModelAndView modelAndView = new ModelAndView("/phone/list");
            modelAndView.addObject("phone", phoneService.findAll());
            return modelAndView;
        }

        @GetMapping("{id}/delete")
        public ModelAndView delete(@PathVariable Long id){
            Optional<Phone> phone= phoneService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/phone/delete");
            modelAndView.addObject("phone", phone.get());
            return modelAndView;
        }
        @PostMapping("/delete")
        public String delete(@ModelAttribute Phone phone){
            phoneService.remove(phone.getId());
            return "redirect:/phone";
        }
        @GetMapping("{id}/edit")
        public ModelAndView edit(@PathVariable Long id){
            Optional<Phone> phone = phoneService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/phone/edit");
            modelAndView.addObject("phone",phone.get());
            modelAndView.addObject("categories", categoryService.findAll());
            return modelAndView;
        }

        @PostMapping("/edit")
        public ModelAndView update(Phone phone){
            phoneService.save(phone);
            ModelAndView modelAndView = new ModelAndView("/phone/list");
            modelAndView.addObject("message","Updated");
            modelAndView.addObject("phone", phoneService.findAll());
            return modelAndView;
        }

    }
