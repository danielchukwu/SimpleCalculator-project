import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {

    String[] numbers = {"7", "8", "9",
                        "4", "5", "6",
                        "1", "2", "3",
                        "+", "0", "-",
                        "="};

    String value1 = "";
    String operator = "";
    String value2 = "";
    int result;



    void display() {
        JFrame myFrame = new JFrame("Simple Calculator");
        myFrame.setSize(300, 500);
        myFrame.setLayout(new GridLayout(5, 3));

        // Create buttons
        for (int i = 0; i < numbers.length; i++) {
            String value = numbers[i];
            JButton button = new JButton(value);
            myFrame.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((value == "+" || value == "-") && operator == ""){
                        operator = operator + value;
                        System.out.println(operator);
                    } else if (operator == "" & value1 != "=") {
                        value1 = value1 + value;
                        System.out.println(value1);
                    } else if (value != "=") {
                        value2 = value2 + value;
                        System.out.println(value2);
                    }

                    // Solve when user clicks on "="
                    if (value == "="){
                        int firstNum = Integer.parseInt(value1);
                        int secondNum = Integer.parseInt(value2);
                        int addedResult = firstNum + secondNum;
                        int subtractedResult = firstNum - secondNum;

                        if (operator.equals("+")){
                            value1 = "";
                            value2 = "";
                            operator = "";

                            System.out.println("\nRESULT: " + addedResult);
                        } else if (operator.equals("-")){
                            value1 = "";
                            value2 = "";
                            operator = "";

                            System.out.println("\nRESULT: " + subtractedResult);
                        }
                    }
                }
            });
        }

        myFrame.setVisible(true);
    }

}
