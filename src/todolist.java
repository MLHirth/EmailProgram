import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class todolist {

public static void main(String[] args) {
	
	JFrame frame = new JFrame();
	   JPanel panel = new JPanel(); 
		frame.setSize(1920, 1080);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		JTextArea output1 = new JTextArea();
		frame.add(output1, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setVisible(true);
		JTextField abhi = new JTextField();
	
    int menuItem = -1;

    while(menuItem !=0) {
        menuItem = menu(output1);

        switch(menuItem) {

        case 1: 
            showList(output1);
            break;

        case 2: 
            addItem(output1, abhi);
            break;

        case 3: 
            removeItem(output1, abhi);
            break;

        case 0: 
            break;

        default: 
        	output1.append("Enter a valid option");
        }

    }
}

public static int menu(JTextArea output1) {

int choice; 

Scanner keyboard = new Scanner(System.in);
output1.append("Main Menu \n");
output1.append(null);
output1.append("0. Exit the program \n");
output1.append("1. Display to-do list \n");
output1.append("2. Add item to list \n");
output1.append("3. Remove item from list \n");
output1.append(null);
output1.append("Enter choice: \n ");
choice = keyboard.nextInt();

return choice;
}

public static void showList(JTextArea output1) {

	output1.append("To-Do List");

Scanner input = new Scanner(System.in);
String line;
int number = 1;

while (input.hasNextLine()){
    line = input.nextLine();
    output1.append(number + " ");
    output1.append(line);
    ++number;
}

System.out.println();


}

public static void addItem(JTextArea output1, JTextField abhi) {

	output1.append("Add Item");

//Scanner input = new Scanner(System.in);
	String input = abhi.getText();
output1.append("Enter an item: ");
String item = input.nextLine();
output1.append(item);


}

public static void removeItem(JTextArea output1, JTextField abhi) {

int choice;
showList(output1);

Scanner input = new Scanner(System.in);
output1.append("What do you want to remove?");
choice = input.nextInt();

ArrayList<String> items = new ArrayList<String>();
int number = 1;

//Scanner input2 = new Scanner(System.in);
String item; 

while (input2.hasNextLine()) {
    item = input2.nextLine();

    if (number != choice) 
        items.add(item);

    ++number;   
}

for(int i = 0; i < items.size(); i++)
	output1.append(items.get(i));

    }

public static void TodoList(String[] args) {
	todolist.main(args);
	
}
}