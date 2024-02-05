import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Signindetails{
	String Name,Username,Password,Mailid,Phno;
	Signindetails(String Name,String Username,String Password,String Mailid,String Phno){
		this.Name = Name;
		this.Username = Username;
		this.Password = Password;
		this.Mailid = Mailid;
		this.Phno = Phno;
	}
}

class ResizeHandlersignin implements ComponentListener {
    private JFrame frame;
    private JLabel instruct;
	private JLabel name;
	private JLabel username;
	private JLabel password;
	private JLabel mailid;
	private JLabel phno;
    private JButton btn;
	private JTextField nname;
    private JTextField uname;
    private JTextField pass;
	private JTextField mname;
	private JTextField phn;
	
    ResizeHandlersignin(JFrame frame,JLabel instruct,JTextField nname,JTextField uname,JTextField pass,JTextField mname,JTextField phn,JButton btn,
	JLabel name,JLabel username,JLabel password,JLabel mailid,JLabel phno){
        this.frame = frame;
        this.instruct = instruct;
		this.nname = nname;
		this.mailid = mailid;
		this.phno = phno;
		this.uname = uname;
        this.pass = pass;
        this.btn = btn;
		this.username=username;
		this.password=password;
		this.name = name;
		this.mname = mname;
		this.phn = phn;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        instruct.setBounds((frame.getWidth() - 165) / 2,((frame.getHeight() - 250) / 2), 300, 20);
		
		name.setBounds((frame.getWidth() - 392) / 2,((frame.getHeight() - 250) / 2)+30,100,20);
		username.setBounds((frame.getWidth() - 400) / 2,((frame.getHeight() - 250) / 2)+60,100,20);
		password.setBounds((frame.getWidth() - 400) / 2,((frame.getHeight() - 250) / 2)+90,100,20);
        mailid.setBounds((frame.getWidth() - 360) / 2,((frame.getHeight() - 250) / 2)+120,100,20);
		phno.setBounds((frame.getWidth() - 450) / 2,((frame.getHeight() - 250) / 2)+150,100,20);
		
		nname.setBounds((frame.getWidth() - 250) / 2,((frame.getHeight() - 250) / 2)+30,200,20);
	    uname.setBounds((frame.getWidth() - 250) / 2, ((frame.getHeight() - 250) / 2)+60, 200, 20);
        pass.setBounds((frame.getWidth() - 250) / 2, ((frame.getHeight() - 250) / 2)+90, 200, 20);
		mname.setBounds((frame.getWidth() - 250) / 2, ((frame.getHeight() - 250) / 2)+120, 200, 20);
		phn.setBounds((frame.getWidth() - 250) / 2, ((frame.getHeight() - 250) / 2)+150, 200, 20);
		
        btn.setBounds((frame.getWidth() - 250+90) / 2, ((frame.getHeight() - 250) / 2)+180, 100, 30);
	}

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
}

class Signin extends JFrame implements ActionListener {
    JFrame frame;
    JLabel instruct;
	JLabel name;
	JLabel username;
	JLabel password;
	JLabel mailid;
	JLabel phno;
    JButton btn;
	JTextField nname;
    JTextField uname;
    JTextField pass;
	JTextField mname;
	JTextField phn;

    Signin() {
        frame = new JFrame("SignIn Page");
        frame.setLayout(null);
		name = new JLabel("Full Name:");
		username = new JLabel("Username:");
		password = new JLabel("Password:");
		mailid = new JLabel("Mail ID:");
		phno = new JLabel("Phone Number:");
        instruct = new JLabel("Fill the details below");
		nname = new JTextField();
        uname = new JTextField();
        pass = new JTextField();
		mname = new JTextField();
		phn = new JTextField();
        btn = new JButton("Signin");

        ResizeHandlersignin resizeHandler = new ResizeHandlersignin(frame, instruct,nname,uname, pass,mname,phn, btn,name,username,password,mailid,phno);

        frame.addComponentListener(resizeHandler);
        btn.addActionListener(this);

        frame.add(instruct);
		frame.add(name);
		frame.add(username);
		frame.add(password);
		frame.add(mailid);
		frame.add(phno);
		frame.add(nname);
        frame.add(uname);
        frame.add(pass);
		frame.add(mname);
		frame.add(phn);
        frame.add(btn);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		String Name = nname.getText();
        String Username = uname.getText();
        String Password = pass.getText();
		String Mailid = mname.getText();
		String Phno = phn.getText();
		
        if (Name.equals("")||Username.equals("")||Password.equals("")||Mailid.equals("")||Phno.equals("")){
			instruct.setText("Fill all the details !");
		}else{
			Signindetails det = new Signindetails(Name,Username,Password,Mailid,Phno);
			instruct.setText("Signed In Successfully");
			btn.setEnabled(false);
		}
    }
}

public class signup {
    public static void main(String[] args) {
        new Signin();
    }
}
