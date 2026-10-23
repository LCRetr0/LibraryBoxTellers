package LibraryBoxTellers.LCRetr0.Client;

import LibraryBoxTellers.LCRetr0.repository.LivroRepository;
//Instanciada pra trabalhar com a api externa que trará os dados dos livros
// https://github.com/ailsonguedes/API-Catalogo-de-Livros
public class ChamadaDeApi {
    private LivroRepository repositorio;
    public ChamadaDeApi(LivroRepository repositorio) {
        this.repositorio = repositorio;
    }
}
