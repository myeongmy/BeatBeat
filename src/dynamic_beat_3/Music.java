package dynamic_beat_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player;   // jlayer 라이브러리 다운
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop){
		try{
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../Music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	


	// 게임 실행 중 현재 음악이 어디까지 재생되었는지 나타내주는 메소드
	public int getTime(){
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	// 음악 종료시키는 메소드
	public void close(){
		isLoop = false;
		player.close();
		this.interrupt();    //해당 thread를 중지
	}
	
	@Override
	public void run(){
		try{
			do{
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
