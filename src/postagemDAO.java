import java.util.List;

public interface postagemDAO {

    void salvar(postagem postagem);
    void atualizar(postagem postagem);
    void deletar(int id);
    postagem buscarPorId(int id);
    List<postagem> listarPorUsuario(int usuarioId);
}
