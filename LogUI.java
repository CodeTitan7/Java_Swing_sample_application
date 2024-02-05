import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ResizeHandler implements ComponentListener {
    private JFrame frame;
    private JLabel instruct;
	private JLabel username;
	private JLabel password;
    private JTextField uname;
    private JTextField pass;
    private JButton btn;
	
    ResizeHandler(JFrame frame, JLabel instruct, JTextField uname, JTextField pass, JButton btn, JLabel username, JLabel password) {
        this.frame = frame;
        this.instruct = instruct;
        this.uname = uname;
        this.pass = pass;
        this.btn = btn;
		this.username=username;
		this.password=password;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        instruct.setBounds((frame.getWidth() - 250) / 2,((frame.getHeight() - 250) / 2), 300, 20);
		username.setBounds((frame.getWidth() - 400) / 2,((frame.getHeight() - 250) / 2)+30,100,20);
		password.setBounds((frame.getWidth() - 400) / 2,((frame.getHeight() - 250) / 2)+60,100,20);
        uname.setBounds((frame.getWidth() - 250) / 2, ((frame.getHeight() - 250) / 2)+30, 200, 20);
        pass.setBounds((frame.getWidth() - 250) / 2, ((frame.getHeight() - 250) / 2)+60, 200, 20);
        btn.setBounds((frame.getWidth() - 250+90) / 2, ((frame.getHeight() - 250) / 2)+90, 100, 30);
	}

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
}

class Login extends JFrame implements ActionListener {
    JFrame frame;
    JLabel instruct;
	JLabel username;
	JLabel password;
    JButton btn;
    JTextField uname;
    JTextField pass;

    Login() {
        frame = new JFrame("Login Page");
        frame.setLayout(null);
		username = new JLabel("Username:");
		password = new JLabel("Password:");
        instruct = new JLabel("Login Using Username and password");
        uname = new JTextField();
        pass = new JTextField();
        btn = new JButton("Login");

        ResizeHandler resizeHandler = new ResizeHandler(frame, instruct, uname, pass, btn,username,password);

        frame.addComponentListener(resizeHandler);
        btn.addActionListener(this);

        frame.add(instruct);
		frame.add(username);
		frame.add(password);
        frame.add(uname);
        frame.add(pass);
        frame.add(btn);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usern = uname.getText();
        String passn = pass.getText();
        if (usern.equals("Devanarayan") && (passn.equals("devanarayan007"))) {
            instruct.setText("Logged in Successfully");
        } else if (usern.equals("") || (passn.equals(""))) {
            instruct.setText("Incomplete Credential");
            uname.setText("");
            pass.setText("");
        } else {
            instruct.setText("Incorrect Credential");
            uname.setText("");
            pass.setText("");
        }
    }
}

public class LogUI {
    public static void main(String[] args) {
        new Login();
    }
}
