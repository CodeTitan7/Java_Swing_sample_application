import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
 
class UI extends JFrame implements ActionListener {
    JFrame frame;
    JLabel b1, b2, h, info, result;
    JButton IMPORT, CALCULATE;

    UI() {
        frame = new JFrame("File Reading Marks");
        IMPORT = new JButton("IMPORT");
        CALCULATE = new JButton("CALCULATE");
        info = new JLabel("");
        b1 = new JLabel("");
        b2 = new JLabel("");
        h = new JLabel("");
        result = new JLabel();

        b1.setBounds(100, 20, 500, 30);
        h.setBounds(100, 55, 400, 30);
        b2.setBounds(100, 90, 500, 30);
        info.setBounds(100, 125, 400, 30);
        result.setBounds(150, 180, 100, 30);
        IMPORT.setBounds(100, 300, 80, 30);
        CALCULATE.setBounds(200, 300, 150, 30);
        IMPORT.addActionListener(this);
        CALCULATE.addActionListener(this);
        frame.add(info);
		frame.add(h);
		frame.add(b1);
		frame.add(b2);
		frame.add(result);
        frame.add(IMPORT);
        frame.add(CALCULATE);
        frame.setLayout(null); 
        frame.setSize(700,700);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton id = (JButton) e.getSource();
        String txtbtn = id.getText();
        if (txtbtn.equals("IMPORT")) {
            try (FileReader out = new FileReader("Newsample.txt");
                BufferedReader bf = new BufferedReader(out)) {
				b1.setText(bf.readLine());
                h.setText(bf.readLine());
                b2.setText(bf.readLine());
                info.setText(bf.readLine());
            } catch (IOException ex) {
                ex.printStackTrace(); // Print the stack trace for debugging
                JOptionPane.showMessageDialog(null, "Error Occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String ftxt = info.getText();
			int sum = 0;
			String[] tokens = ftxt.split("\\s+");
			for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                sum += number;
            } catch (NumberFormatException exx) {
				//
            }
			result.setText("Total Marks: "+(sum-111));
        }
        }
    }
} 
 
class FileUI {
	public static void main(String[] args) throws IOException{
		String text,name,border,head;
		int mark1,mark2,mark3;
		File f = new File("Newsample.txt");
		f.createNewFile();
		FileWriter in = new FileWriter("Newsample.txt");
		Scanner sc = new Scanner(System.in);
		border = "=============================================================================================================\n";
		head = "Roll.No       Name                 Mark1      Mark2      Mark3\n";
		System.out.println("Enter name:");
		name = sc.nextLine(); 
		System.out.println("Enter marks of 3 subject: ");
		mark1 = sc.nextInt();
		mark2 = sc.nextInt();
		mark3 = sc.nextInt(); 
		text = "111           "+name+"           "+mark1+"          "+mark2+"          "+mark3; 	   	
		in.write(border);
		in.write(head);
		in.write(border);
		in.write(text);
		in.close();
		new UI();
 	}                  				
} 
