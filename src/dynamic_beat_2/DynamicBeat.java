package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	//더블 버퍼링 이용
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;

	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 컴퓨터 화면 정중앙에 뜨도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introBackground = new ImageIcon(Main.class.getResource("../Images/IntroBackground(title).jpg")).getImage();
	}
	public void paint(Graphics g){
		screenImage = createImage(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);  // 게임 화면 크기만큼 이미지 생성
		screenGraphic = screenImage.getGraphics();  // 생성한 이미지에 그림 그려줌
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}
	public void screenDraw(Graphics g){
		g.drawImage(introBackground, 0, 0, null);
		this.repaint(); // 다시 paint() 함수 호출

	}

}
