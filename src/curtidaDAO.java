public interface curtidaDAO {

    void curtir(int usuarioId, int postagemId);
    void descurtir(int usuarioId, int postagemId);
    boolean verificarSeJaCurtiu(int usuarioId, int postagemId);
    int contarCurtidas(int postagemId);
}
