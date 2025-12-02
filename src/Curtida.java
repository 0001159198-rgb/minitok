import java.time.LocalDate;

public class Curtida {

    private int id;
    private int remetenteId;
    private int destinatarioId;
    private LocalDate dataCurtida;

    // Contador estático de curtidas
    private static int totalCurtidas = 0;

    public Curtida(int id, int remetenteId, int destinatarioId) {
        this.id = id;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.dataCurtida = LocalDate.now();
        totalCurtidas++;
    }

    public void curtir(int id, int remetenteId, int destinatarioId) {
        this.id = id;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
        this.dataCurtida = LocalDate.now();
        totalCurtidas++;
    }

    public void descurtir() {
        this.id = 0;
        this.remetenteId = 0;
        this.destinatarioId = 0;
        this.dataCurtida = null;

        if (totalCurtidas > 0) {
            totalCurtidas--;
        }
    }

    public static int contarCurtidas() {
        return totalCurtidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemetenteId() {
        return remetenteId;
    }

    public void setRemetenteId(int remetenteId) {
        this.remetenteId = remetenteId;
    }

    public int getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public LocalDate getDataCurtida() {
        return dataCurtida;
    }

    public void setDataCurtida(LocalDate dataCurtida) {
        this.dataCurtida = dataCurtida;
    }
}
