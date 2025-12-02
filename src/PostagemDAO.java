import java.util.List;

public interface PostagemDAO {

    void salvar(Postagem postagem);
    void atualizar(Postagem postagem);
    void deletar(int id);
    Postagem buscarPorId(int id);
    List<Postagem> listarPorUsuario(int usuarioId);
}
