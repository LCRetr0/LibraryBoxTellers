package LibraryBoxTellers.LCRetr0.Model;

public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    FANTASIA("Fantasy", "Fantasia"),
    FICCAO_CIENTIFICA("Science Fiction", "Ficção Científica"),
    TERROR("Horror", "Terror"),
    SUSPENSE("Thriller", "Suspense"),
    MISTERIO("Mystery", "Mistério"),
    AVENTURA("Adventure", "Aventura"),
    BIOGRAFIA("Biography", "Biografia"),
    AUTOBIOGRAFIA("Autobiography", "Autobiografia"),
    HISTORICO("Historical", "Histórico"),
    POESIA("Poetry", "Poesia"),
    INFANTIL("Children", "Infantil"),
    JUVENIL("Young Adult", "Juvenil"),
    DISTOPIA("Dystopian", "Distopia"),
    UTOPIA("Utopian", "Utopia"),
    LITERATURA_CLASSICA("Classic Literature", "Literatura Clássica"),
    HQ("Comics", "Histórias em Quadrinhos"),
    MANGA("Manga", "Mangá"),
    AUTOAJUDA("Self-Help", "Autoajuda"),
    DESENVOLVIMENTO_PESSOAL("Personal Development", "Desenvolvimento Pessoal"),
    NEGOCIOS("Business", "Negócios"),
    ECONOMIA("Economics", "Economia"),
    FILOSOFIA("Philosophy", "Filosofia"),
    RELIGIAO("Religion", "Religião"),
    CIENCIA("Science", "Ciência"),
    TECNOLOGIA("Technology", "Tecnologia"),
    EDUCACAO("Education", "Educação"),
    SAUDE("Health", "Saúde"),
    CULINARIA("Cooking", "Culinária"),
    VIAGEM("Travel", "Viagem"),
    ESPORTE("Sports", "Esporte");

    private String categoriaOmdb;
    private String categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }


    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}