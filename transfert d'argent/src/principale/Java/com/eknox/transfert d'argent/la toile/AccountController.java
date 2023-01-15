
package com.eknox.moneytransfer.web;

public class AccountController {
    @Autowired
    private AccountReposiotory AccountRepository;
    // LISTING DES COMPTES - SEULEMENT ACCESSIBLE AUX ADMINISTRATEURS/AUDITEURS
    @RequestMapping(value = "/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "8") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Account> pageAccounts = userRepository.searchAccount("%" + keyword + "%", PageRequest.of(page, size));
        model.addAttribute("listAccounts", pageAccounts.getContent());
        int[] pages = new int[pageAccounts.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "Account";
    }



    // CREATE
    @PostMapping(value = "/addAccount")
    public String save(Model model, @Validated Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "formAccount";
        accountRepository.save(account);
        return "saveConfirmation";

    }

    //READ
    @GetMapping(value="/")
    public String homePage() {
        return "redirect:/index";
    }

    //UPDATE
    @GetMapping(value = "/updateAccount")
    public String editUser( Long idAccount ,Model model) {
        Optional <Account> account = accountRepository.findById(idAccount);
        model.addAttribute("account", account);
        return "editAccount";
    }
    // DELETE
    @GetMapping(value = "/delete")
    public String deleteById(Long idAccount, int page, int size, String keyword) {
        accountRepository.deleteById(idAccount);
        return "redirect:/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }
    // CRUD IS DONE
}
