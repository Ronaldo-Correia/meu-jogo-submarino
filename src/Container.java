import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.sound.sampled.*;
public class Container extends Canvas implements Runnable {
	Jframe janela;
	private boolean emExecucao=false;
	private SubmarioPlayer submarino;
	private ArrayList<Missil> missil;
	private ArrayList<Enemy> inimigos;
	private Randon randon=new Random();
	private Image imagemFundo;
	private int contador=0;
	private SoundPlayer soundPlayer;
	private boolean gameOverSom=false;
	private Configuracoes config;
	
	public Container(SoundPlayer soundPlayer, Configuracoes config) {
		super();
		this.soundPlayer = soundPlayer;
		this.config = config;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
