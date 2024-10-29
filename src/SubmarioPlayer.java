import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SubmarioPlayer {
private int x,y;
private int vida;
private int largura ,altura;
private Image imageSubmarino;
public SubmarioPlayer(int x, int y) {
	super();
	this.x = x;
	this.y = y;
	this.largura = 100;
    this.altura = 50;
    this.vida=3;
    imageSubmarino = new ImageIcon(getClass().getResource("/Resources/navepng.png")).getImage();
    imageSubmarino = imageSubmarino.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
}
}








}
