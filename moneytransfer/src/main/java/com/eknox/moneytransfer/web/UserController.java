package com.eknox.moneytransfer.web;

public class UserController {
    @Autowired
    private UserReposiotory UserRepository;
    // LISTING DES UTILISATEURS - SEULEMENT ACCESSIBLE AUX ADMINISTRATEURS/AUDITEURS
    @RequestMapping(value = "/")
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



    // CREATE
    @PostMapping(value = "/addUser")
    public String save(Model model, @Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "formUser";
        userRepository.save(user);
        return "saveConfirmation";

    }

    //READ
    @GetMapping(value="/")
    public String homePage() {
        return "redirect:/index";
    }

    //UPDATE
    @GetMapping(value = "/updateUser")
    public String editUser( Long idUser ,Model model) {
        Optional <User> user = userRepository.findById(idUser);
        model.addAttribute("user", user);
        return "editUser";
    }
    // DELETE
    @GetMapping(value = "/delete")
    public String deleteById(Long idUser, int page, int size, String keyword) {
        userRepository.deleteById(idUser);
        return "redirect:/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }
    // CRUD IS DONE
}
