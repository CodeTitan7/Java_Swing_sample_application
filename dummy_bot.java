import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class App extends JFrame implements ActionListener {
    JFrame frame;
	JPanel textpanel;
    JPanel mespanel;
    JTextArea textf;
    JLabel message;
    JButton btn;

    App() {
        frame = new JFrame("Message App");
        textpanel = new JPanel();
        mespanel = new JPanel();
        textf = new JTextArea("Type your message here");
        message = new JLabel();
        btn = new JButton("Send");
		
        Font font = new Font("Arial", Font.BOLD, 20);
        frame.setLayout(new GridLayout(2, 1));
        message.setFont(font);
        btn.setBackground(Color.BLUE);
        btn.addActionListener(this);
		textf.setSize(300,400);
		btn.setSize(30,40);
				
        mespanel.add(message);
        textpanel.add(textf);
        textpanel.add(btn);

        frame.add(textpanel);
        frame.add(mespanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textf.getText();
        if (text.equals("")) {
            message.setText("Type Anything");
		}else if (text.equals("Type your message here")){
			message.setText("Type Anything");
        } else {
            String reply = "BOT: " + text;
            message.setText(reply);
        }
    }
}

public class dummy_bot {
    public static void main(String[] args) {
        new App();
    }
}
