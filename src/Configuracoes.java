public class Configuracoes {
    private int volume;  // Volume de música e sons
    private String resolucao;  // Resolução do jogo

    public Configuracoes(SoundPlayer soundPlayer) {
        this.volume = 50;  // Volume padrão
        this.resolucao = "960x600";  // Resolução padrão

    }

    // Métodos para obter e definir o volume
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    // Métodos para obter e definir a resolução
    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }
}
