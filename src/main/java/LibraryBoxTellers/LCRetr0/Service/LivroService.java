package LibraryBoxTellers.LCRetr0.Service;

import LibraryBoxTellers.LCRetr0.DTO.LivroDTO;

import java.util.List;

public class LivroService {

    public List<LivroDTO> obterTodasAsSeries(){
        return convertedados(repositorio.findAll());
    }
}
