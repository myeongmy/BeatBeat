package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	//���� ���۸� �̿�
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;

	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ��ǻ�� ȭ�� ���߾ӿ� �ߵ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introBackground = new ImageIcon(Main.class.getResource("../Images/IntroBackground(title).jpg")).getImage();
	}
	public void paint(Graphics g){
		screenImage = createImage(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);  // ���� ȭ�� ũ�⸸ŭ �̹��� ����
		screenGraphic = screenImage.getGraphics();  // ������ �̹����� �׸� �׷���
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
		
	}
	public void screenDraw(Graphics g){
		g.drawImage(introBackground, 0, 0, null);
		this.repaint(); // �ٽ� paint() �Լ� ȣ��

	}

}
