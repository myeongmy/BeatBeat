package dynamic_beat_5;

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

	// 더블 버퍼링 이용
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../Images/IntroBackground(title).jpg")).getImage();
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../Images/MenuBar.png")));

	private ImageIcon exitbuttonclickedimage = new ImageIcon(
			Main.class.getResource("../Images/ExitButton(clicked).png"));
	private ImageIcon exitbuttonbasicimage = new ImageIcon(Main.class.getResource("../Images/ExitButton.png"));
	private ImageIcon startbuttonbasic = new ImageIcon(Main.class.getResource("../Images/startButtonBasic.png"));
	private ImageIcon startbuttonentered = new ImageIcon(Main.class.getResource("../Images/startButtonEntered.png"));
	private ImageIcon exitbuttonbasic = new ImageIcon(Main.class.getResource("../Images/exitButtonBasic.png"));
	private ImageIcon exitbuttonentered = new ImageIcon(Main.class.getResource("../Images/exitButtonEntered.png"));

	private JButton exitbutton = new JButton(exitbuttonbasicimage);
	private JButton startbutton = new JButton(startbuttonbasic);
	private JButton exitbuttonq = new JButton(exitbuttonbasic);

	// 현재 mouse의 x,y 위치 반환
	private int mouseX, mouseY;

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 컴퓨터 화면 정중앙에 뜨도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitbutton.setBounds(936, 0, 30, 30);
		exitbutton.setBorderPainted(false); // exitbutton 화면 출력되는 모양 바로 잡기
		exitbutton.setContentAreaFilled(false);
		exitbutton.setFocusPainted(false);
		exitbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitbutton.setIcon(exitbuttonclickedimage);
				exitbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitbutton.setIcon(exitbuttonbasicimage);
				exitbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitbutton);

		startbutton.setBounds(40, 200, 321, 107);
		startbutton.setBorderPainted(false); // exitbutton 화면 출력되는 모양 바로 잡기
		startbutton.setContentAreaFilled(false);
		startbutton.setFocusPainted(false);
		startbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startbutton.setIcon(startbuttonentered);
				startbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startbutton.setIcon(startbuttonbasic);
				startbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				startbutton.setVisible(false);
				exitbuttonq.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../Images/mainBackground.png")).getImage();
			}
		});
		add(startbutton);

		exitbuttonq.setBounds(40, 330, 321, 107);
		exitbuttonq.setBorderPainted(false); // exitbutton 화면 출력되는 모양 바로 잡기
		exitbuttonq.setContentAreaFilled(false);
		exitbuttonq.setFocusPainted(false);
		exitbuttonq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitbuttonq.setIcon(exitbuttonentered);
				exitbuttonq.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitbuttonq.setIcon(exitbuttonbasic);
				exitbuttonq.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exitbuttonq);

		menubar.setBounds(0, 0, 971, 30); // (x, y, width, height)
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);

		Music introMusic = new Music("IntroMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT); // 게임
																			// 화면
																			// 크기만큼
																			// 이미지
																			// 생성
		screenGraphic = screenImage.getGraphics(); // 생성한 이미지에 그림 그려줌
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g); // JLabel 등을 나타내기 위함
		this.repaint(); // 다시 paint() 함수 호출

	}

}
