import java.util.List;

public interface UsuarioDAO {

    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(int id);
    Usuario buscarPorId(int id);
    List<Usuario> listarTodos();
}
