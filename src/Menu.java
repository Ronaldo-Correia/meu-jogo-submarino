import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private SoundPlayer soundPlayer;
    private JFrame frame;
    private Configuracoes config;  // Instância de Configurações

    public Menu(SoundPlayer soundPlayer, Configuracoes config) {
    	  this.soundPlayer = soundPlayer;
          this.config = config;
        frame = new JFrame("Aventura Submarina");
        frame.setSize(960, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

   
       // Configuração da imagem de fundo
        JLabel fundo = new JLabel();
        fundo.setIcon(new ImageIcon(getClass().getResource("/Resources/IMGinicio.png")));
        fundo.setBounds(0, 0, 960, 600); // Configura o tamanho da imagem para preencher a janela

        // Criação e configuração dos botões
        JButton btnIniciarJogo = new JButton("Iniciar Jogo");
        JButton btnConfiguracoes = new JButton("Configurações");
        JButton btnFechar = new JButton("Fechar Jogo");

     // Configura o fundo transparente para os botões
        btnIniciarJogo.setOpaque(false);
        btnIniciarJogo.setContentAreaFilled(false);

        btnConfiguracoes.setOpaque(false);
        btnConfiguracoes.setContentAreaFilled(false);

        btnFechar.setOpaque(false);
        btnFechar.setContentAreaFilled(false);
        
     // Define a fonte em negrito para os botões
        Font boldFont = new Font("Arial", Font.BOLD, 16);  // Tamanho 16, pode ser ajustado
        btnIniciarJogo.setFont(boldFont);
        btnConfiguracoes.setFont(boldFont);
        btnFechar.setFont(boldFont);

        // Redimensiona e posiciona os botões
        btnIniciarJogo.setBounds(380, 200, 200, 50);  // x = 380, y = 200
        btnConfiguracoes.setBounds(380, 270, 200, 50); // x = 380, y = 270
        btnFechar.setBounds(380, 340, 200, 50);  
        // Adiciona ações aos botões
        btnIniciarJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });

        btnConfiguracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirConfiguracoes();
            }
        });

        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJogo();
            }
        });

        // Adiciona os botões e a imagem de fundo à janela
        frame.add(btnIniciarJogo);
        frame.add(btnConfiguracoes);
        frame.add(btnFechar);
        frame.add(fundo); // A imagem de fundo deve ser adicionada por último para ficar atrás dos botões

        frame.setVisible(true);
    }

    private void iniciarJogo() {
        JOptionPane.showMessageDialog(frame, "Iniciando o Jogo...");
        // Adicione aqui a lógica para iniciar o jogo
    }

    private void abrirConfiguracoes() {
        String novaResolucao = JOptionPane.showInputDialog(frame, "Insira a nova resolução (ex: 1280x720):",soundPlayer);
        if (novaResolucao != null) {
            config.setResolucao(novaResolucao);
        }
        JOptionPane.showMessageDialog(frame, "Configurações salvas! Resolução: " + config.getResolucao() + ", Volume: " + config.getVolume());
    }

    private void fecharJogo() {
        ConfiguracoesMenu configMenu = new ConfiguracoesMenu(soundPlayer, config); // Passa o container corretamente
        configMenu.setVisible(true);  // Abre o menu de configurações

    }

    }


