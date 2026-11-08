package LibraryBoxTellers.LCRetr0.Controllers;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.Service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/")
    public String paginaInicial(Model model) {
        model.addAttribute("livros", livroService.obterTodosOsLivros());
        return "index";
    }
    @GetMapping("/externo")
    public String listarLivrosExternos(@RequestParam(defaultValue = "java") String termo, Model model) {
        List<LivroDTO> livrosExternos = livroService.obterLivrosDaApiComTermo(termo);
        System.out.println(">>> QUANTIDADE DE LIVROS ENCONTRADOS: " + livrosExternos.size());

        model.addAttribute("livros", livrosExternos);
        return "index";
    }
}
//
//    @GetMapping("/externo")
//    public List<LivroDTO> listarLivrosExternos(@RequestParam(defaultValue = "java") String termo) {
//        return livroService.obterLivrosDaApiComTermo(termo);
//    }


//    @Autowired
//    private LivroService livro;
//
//    @GetMapping
//    public List<LivroDTO> listarLivros() {
//        return livro.obterTodosOsLivros();
//    }
//
//    @GetMapping("/externos")
//    public List<LivroDTO> listarLivrosExternos() {
//
//        return livro.obterLivrosDaApi();
//    }

