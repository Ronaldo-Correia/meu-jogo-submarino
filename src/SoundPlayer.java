import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    private Clip backgroundMusicClip;
    private FloatControl musicVolumeControl;
    private FloatControl soundEffectVolumeControl;

    public void playSound(String filePath) {
        try {
            // Tenta obter o recurso do arquivo de som
            URL soundURL = getClass().getResource("/resources/sounds/" + filePath);
            if (soundURL == null) {
                System.err.println("Arquivo de som não encontrado: " + filePath);
                return;
            }

            // Converte o URL em um stream de áudio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();  // Toca o som

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playBackgroundMusic(String filePath) {
        try {
            // Tenta obter o recurso do arquivo de som
            URL soundURL = getClass().getResource("/resources/sounds/" + filePath);
            if (soundURL == null) {
                System.err.println("Arquivo de som não encontrado: " + filePath);
                return;
            }

            // Converte o URL em um stream de áudio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(audioStream);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);  // Reproduz a música em loop
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void GameOver(String filePath) {
        try {
            // Tenta obter o recurso do arquivo de som
            URL soundURL = getClass().getResource("/resources/sounds/" + filePath);
            if (soundURL == null) {
                System.err.println("Arquivo de som não encontrado: " + filePath);
                return;
            }

            // Converte o URL em um stream de áudio
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();  // Toca o som

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void setVolumeMusica(int volume) {
        if (musicVolumeControl != null) {
            // Volume varia de -80.0 (mudo) até 6.0 (máximo)
            float range = musicVolumeControl.getMaximum() - musicVolumeControl.getMinimum();
            float gain = (range * volume / 100f) + musicVolumeControl.getMinimum(); 
            musicVolumeControl.setValue(gain);
        }
    }

    // Método para ajustar o volume dos efeitos sonoros
    public void setVolume(int volume) {
        if (backgroundMusicClip != null && backgroundMusicClip.isOpen()) {
            FloatControl volumeControl = (FloatControl) backgroundMusicClip.getControl(FloatControl.Type.MASTER_GAIN);
            float ganhoMin = volumeControl.getMinimum();
            float ganhoMax = volumeControl.getMaximum();
            float ganho = ganhoMin + (ganhoMax - ganhoMin) * (volume / 100.0f);
            volumeControl.setValue(ganho);
        } else {
            System.out.println("Erro: Clip de música de fundo não inicializado.");
        }
    }
    public void tocarMusica() {
        if (backgroundMusicClip != null) {
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

}

