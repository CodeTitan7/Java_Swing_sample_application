import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


class UI extends JFrame implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton btn;
	UI(){
		frame = new JFrame("File Input");
		btn = new JButton("Read");
		textfield =  new JTextField();
		
		textfield.setBounds(150,130,190,35);
		btn.setBounds(150,170,80,30);
		btn.addActionListener(this);
		
		frame.add(textfield);
		frame.add(btn);
		frame.setLayout(null);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		String text = textfield.getText();
		btn.setEnabled(false);
		try{
			writeToFile(text);
		}catch(Exception ex){
			System.out.println("Error Occurred !");
		}	
	}
	

	public void writeToFile(String txt) throws IOException{
		FileOutputStream f = new FileOutputStream("NewGUI.txt");
		String border,head;
		int i = 111;
		byte[] barr;
		border = "====================================================\n";
		head = "SI.No			Token\n";
		barr=border.getBytes();
		f.write(barr);
		barr=head.getBytes();
		f.write(barr);
		barr=border.getBytes();
		f.write(barr);
		StringTokenizer tk = new StringTokenizer(txt);
		while(tk.hasMoreTokens()){
			String token = i+"			"+tk.nextToken()+"\n";
			i++;
			barr = token.getBytes();
			f.write(barr);
		}
		f.close();
	}
}

public class UIFile{
	public static void main(String[] args) throws IOException{
		new UI();	
				
	}
}


//For testing (viewing the file
/*
public class UIFile{
	public static void main(String[] args) throws IOException{
		FileInputStream f = new FileInputStream("NewGUI.txt");
		int i;
		while((i=f.read())!=-1){
			System.out.print((char)i);
		}
		f.close();
	} 
}
*/
