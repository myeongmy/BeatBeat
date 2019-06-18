package dynamic_beat_4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	// ���� ���۸� �̿�
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground = new ImageIcon(Main.class.getResource("../Images/IntroBackground(title).jpg"))
			.getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../Images/MenuBar.png")));
	
	private ImageIcon exitbuttonclickedimage = new ImageIcon(Main.class.getResource("../Images/ExitButton(clicked).png"));
	private ImageIcon exitbuttonbasicimage = new ImageIcon(Main.class.getResource("../Images/ExitButton.png"));
	private JButton exitbutton = new JButton(exitbuttonbasicimage);
	
	//���� mouse�� x,y ��ġ ��ȯ
	private int mouseX, mouseY;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ��ǻ�� ȭ�� ���߾ӿ� �ߵ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		
		exitbutton.setBounds(936, 0, 30 , 30);
		exitbutton.setBorderPainted(false);    //exitbutton ȭ�� ��µǴ� ��� �ٷ� ���
		exitbutton.setContentAreaFilled(false);
		exitbutton.setFocusPainted(false);
		exitbutton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				exitbutton.setIcon(exitbuttonclickedimage);
				exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e){
				exitbutton.setIcon(exitbuttonbasicimage);
				exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});
		add(exitbutton);
		
		menubar.setBounds(0,0,971,30); //(x, y, width, height)
		menubar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menubar);
		
		
		
	    Music introMusic = new Music("IntroMusic.mp3", true);
	    introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT); // ����
																			// ȭ��
																			// ũ�⸸ŭ
																			// �̹���
																			// ����
		screenGraphic = screenImage.getGraphics(); // ������ �̹����� �׸� �׷���
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g); // JLabel ���� ��Ÿ���� ����
		this.repaint(); // �ٽ� paint() �Լ� ȣ��

	}

}
