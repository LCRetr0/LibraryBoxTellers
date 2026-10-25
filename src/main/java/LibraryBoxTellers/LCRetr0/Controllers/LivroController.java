
package LibraryBoxTellers.LCRetr0.Controllers;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;
import LibraryBoxTellers.LCRetr0.Model.Livro;
import LibraryBoxTellers.LCRetr0.Service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livro;

    @GetMapping
    public List<LivroDTO> listarLivros() {
        return livro.obterTodosOsLivros();
    }

}
