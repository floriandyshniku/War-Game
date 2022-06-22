package projectV2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	public GameFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.add(new GamePanel());
		frame.setTitle("WarGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(618, 638);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
