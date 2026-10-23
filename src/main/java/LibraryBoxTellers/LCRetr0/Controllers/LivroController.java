
package LibraryBoxTellers.LCRetr0.Controllers;

import LibraryBoxTellers.LCRetr0.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LivroController {

    @Autowired
    private LivroService livro;
}
