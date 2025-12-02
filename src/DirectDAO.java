import java.util.List;

public interface DirectDAO {

    void enviarMensagem(Direct direct);
    List<Direct> listarMensagens(int usuario1Id, int usuario2Id);
}
