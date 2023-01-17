package com.eknox.moneytransfer.web;
//DEVELOPPER IMPORT
import com.eknox.moneytransfer.dao.UserRepository;
import com.eknox.moneytransfer.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "8") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<User> pageUsers = userRepository.searchUser("%" + keyword + "%", PageRequest.of(page, size));
        model.addAttribute("listUsers", pageUsers.getContent());
        int[] pages = new int[pageUsers.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "User";
    }



    @GetMapping(value = "/delete")
    public String deleteById(Long idUser, int page, int size, String keyword) {
        userRepository.deleteById(idUser);
        return "redirect:/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }

    @GetMapping(value = "/formUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "formUser";
    }

    @PostMapping(value = "/save")
    public String save(Model model, @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "formUser";
        userRepository.save(user);
        return "saveConfirmation";

    }

    @GetMapping(value = "/editUser")
    public String editUser( Long idUser ,Model model) {
        Optional <User> user = userRepository.findById(idUser);
        model.addAttribute("user", user);
        return "editUser";
    }

    @GetMapping(value="/")
    public String homePage() {
        return "redirect:/index";
    }


}