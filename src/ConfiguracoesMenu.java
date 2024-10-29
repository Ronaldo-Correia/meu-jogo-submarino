import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfiguracoesMenu extends JFrame {
    private SoundPlayer soundPlayer;
    private Configuracoes configuracoes;
    private Container container; // Referência à instância do Container

    public ConfiguracoesMenu(SoundPlayer soundPlayer, Configuracoes configuracoes, Container container) {
        this.soundPlayer = soundPlayer;
        this.configuracoes = configuracoes;
        this.container = container; // Inicializa a referência ao Container

        // Configurações da janela
        setTitle("Menu de Configurações");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Criação dos componentes do menu
        JLabel volumeLabel = new JLabel("Volume:");
        volumeLabel.setBounds(30, 30, 100, 30);
        add(volumeLabel);

        // Criação do JSlider para o volume
        JSlider volumeSlider = new JSlider(0, 100, configuracoes.getVolume());
        volumeSlider.setBounds(30, 60, 300, 50);
        
        // Adiciona o ChangeListener para o volumeSlider
        volumeSlider.addChangeListener(e -> {
            int novoVolume = volumeSlider.getValue();
            configuracoes.setVolume(novoVolume);  // Atualiza as configurações
            soundPlayer.setVolume(novoVolume);     // Aplica o novo volume ao SoundPlayer
        });

        add(volumeSlider);

        JLabel resolucaoLabel = new JLabel("Resolução:");
        resolucaoLabel.setBounds(30, 130, 100, 30);
        add(resolucaoLabel);

        String[] resolucoes = {"800x600", "1024x768", "1280x720", "1920x1080"};
        JComboBox<String> resolucaoComboBox = new JComboBox<>(resolucoes);
        resolucaoComboBox.setSelectedItem(configuracoes.getResolucao());
        resolucaoComboBox.setBounds(30, 160, 200, 30);
        
        // Adiciona o ActionListener para o JComboBox
        resolucaoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaResolucao = (String) resolucaoComboBox.getSelectedItem();
                configuracoes.setResolucao(novaResolucao); // Atualiza as configurações

                // Divide a string da resolução para obter largura e altura
                String[] partes = novaResolucao.split("x");
                int largura = Integer.parseInt(partes[0]);
                int altura = Integer.parseInt(partes[1]);

                // Ajusta a janela do jogo para a nova resolução
                container.ajustarResolucao(largura, altura); // Chama o método do Container
            }
        });
        add(resolucaoComboBox);

        setVisible(true); // Torna a janela visível
    }
}

