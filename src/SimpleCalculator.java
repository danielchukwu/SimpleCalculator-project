import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {

    // array of numbers to be used as buttons
    String[] numbers = {"7", "8", "9",
                        "4", "5", "6",
                        "1", "2", "3",
                        "+", "0", "-",
                        "="};

    // global variables to hold value1, operator, value2, and then result
    String value1 = "";
    String operator = "";
    String value2 = "";
    int result;



    void display() {
        // create java frame
        JFrame myFrame = new JFrame("Simple Calculator");
        myFrame.setSize(300, 500);
        myFrame.setLayout(new GridLayout(5, 3));

        // loop through numbers array(the array in line 9) and create buttons for each of them
        for (int i = 0; i < numbers.length; i++) {
            String value = numbers[i];
            JButton button = new JButton(value);
            myFrame.add(button);                  // add each button to myFrame(in line 25)

            // add action listener on each button created and added so when clicked we can do stuffs
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // if value clicked on is "+" or "-" and operator hasn't been clicked on set operator=value(either + or -)
                    if ((value == "+" || value == "-") && operator == ""){
                        operator = value;
                        System.out.println(operator);

                    // if operator(e.g + or -) has'nt been clicked on then keep adding values clicked on to value1(in line 16). AND if value clicked on is not "="
                    } else if (operator == "" & value1 != "=") {
                        value1 = value1 + value;
                        System.out.println(value1);

                    // if value clicked on is not equal to "=". Add value clicked on to value2(in line 18)
                    } else if (value != "=") {
                        value2 = value2 + value;
                        System.out.println(value2);
                    }

                    // When user clicks on "=". Solve the maths
                    if (value == "="){
                        float firstNum = Integer.parseInt(value1);     // convert string to integer
                        float secondNum = Integer.parseInt(value2);    // convert string to integer
                        float addedResult = firstNum + secondNum;      // add both firstnumber and lastnumber
                        float subtractedResult = firstNum - secondNum; // subtract both firstnumber and lastnumber

                        // Check what operator was clicked on
                        // if operator is "+". print addedResult(in line 59)
                        if (operator.equals("+")){
                            value1 = "";              // reset back to empty
                            value2 = "";              // reset back to empty
                            operator = "";            // reset back to empty

                            System.out.println("\nRESULT: " + addedResult);

                        // if operator is "-". print subtractedResult(in line 60)
                        } else if (operator.equals("-")){
                            value1 = "";              // reset back to empty
                            value2 = "";              // reset back to empty
                            operator = "";            // reset back to empty

                            System.out.println("\nRESULT: " + subtractedResult);
                        }
                    }
                }
            });
        }

        myFrame.setVisible(true);
    }

}
