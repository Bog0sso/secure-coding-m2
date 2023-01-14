package com.eknox.moneytransfer.web;

public class TransactionController {
    //CRUD
    // respecter le standard REST
    /*@Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "8") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Product> pageProducts = productRepository.searchProduct("%" + keyword + "%", PageRequest.of(page, size));
        model.addAttribute("listProducts", pageProducts.getContent());
        int[] pages = new int[pageProducts.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "Product";
    }



    @GetMapping(value = "/delete")
    public String deleteById(Long idProduct, int page, int size, String keyword) {
        productRepository.deleteById(idProduct);
        return "redirect:/index?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }

    @GetMapping(value = "/formProduct")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "formProduct";
    }

    @PostMapping(value = "/save")
    public String save(Model model, @Validated Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "formProduct";
        productRepository.save(product);
        return "saveConfirmation";

    }

    @GetMapping(value = "/editProduct")
    public String editProduct( Long idProduct ,Model model) {
        Optional <Product> product = productRepository.findById(idProduct);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @GetMapping(value="/")
    public String homePage() {
        return "redirect:/index";
    }*/
}
