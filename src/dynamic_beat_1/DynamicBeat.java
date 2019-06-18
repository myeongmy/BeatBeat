package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {

	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDE, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // 컴퓨터 화면 정중앙에 뜨도록
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
