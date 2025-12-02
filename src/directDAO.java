import java.util.List;

public interface directDAO {

    void enviarMensagem(direct direct);
    List<direct> listarMensagens(int usuario1Id, int usuario2Id);
}
