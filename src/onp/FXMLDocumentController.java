/*
 * Lingwistyka Matematyczna Zadanie 4 - Odwrotna Notacja Polska.
 * Szymon Zawadzki 221515.
 */

package onp;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Szaman
 */

public class FXMLDocumentController implements Initializable 
{
    @FXML
    private TextField userInputField;
    @FXML
    private Label reversePolishNotationLabel;
    
    private String userInput;
    private int userInputLength;
    
    private String reversePolishNotationString;
    
    ArrayList<Character> alphabetList = new ArrayList<>();
    ArrayList<Character> digitList = new ArrayList<>();
    ArrayList<Character> operatorList = new ArrayList<>();
    
    Stack<Character> stack = new Stack<>();
    
    @FXML
    private void handleONP()
    {
        userInput = userInputField.getText();
        userInputLength = userInput.length();
        
        reversePolishNotationString = "";
        
        System.out.println("User Input: " + userInput);
        System.out.println("User input length: " + userInputLength);
        for(int i = 0; i < userInputLength; i++)
        {
            if(alphabetList.contains(userInput.charAt(i)))
            {
                switch (userInput.charAt(i)) 
                {
                    case '+':
                    {
                        while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) 
                        {
                            reversePolishNotationString = reversePolishNotationString + " ";
                            reversePolishNotationString = reversePolishNotationString + stack.pop(); 
                        }
                        reversePolishNotationString = reversePolishNotationString + " ";
                        stack.push(userInput.charAt(i));
                        break;
                    } 
                    case '-':
                    {
                        while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) 
                        {
                            reversePolishNotationString = reversePolishNotationString + " ";
                            reversePolishNotationString = reversePolishNotationString + stack.pop(); 
                        }
                        reversePolishNotationString = reversePolishNotationString + " ";
                        stack.push(userInput.charAt(i));
                        break;
                    }                        
                    case '*':
                    {
                        reversePolishNotationString = reversePolishNotationString + " ";
                        stack.push(userInput.charAt(i));
                        break;
                    }  
                    case '/':
                    {
                        reversePolishNotationString = reversePolishNotationString + " ";
                        stack.push(userInput.charAt(i));
                        break;
                    }  
                    case '(':
                    {
                        stack.push(userInput.charAt(i));
                        break;
                    }
                    case ')':
                    {
                        while (!stack.empty() && stack.peek() != '(')
                        {
                            reversePolishNotationString = reversePolishNotationString + " ";
                            reversePolishNotationString = reversePolishNotationString + stack.pop(); 
                        }
                        stack.pop();
                        break;
                    }
                    default:
                    {
                        reversePolishNotationString = reversePolishNotationString + "" + userInput.charAt(i);
                        break;
                    }
                }
                
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Błąd!");
                alert.setContentText("Wyrażenie jest błędne!");
                alert.showAndWait();
                System.out.println("Wyrażenie jest błędne");
                
                stack.clear();
                reversePolishNotationLabel.setText("Wyrażenie jest błędne");
                break;
            }
            
        }
        while (!stack.isEmpty())
        {
            reversePolishNotationString = reversePolishNotationString + " " + stack.pop();
        }
        reversePolishNotationLabel.setText("Wynik: " + reversePolishNotationString);
        System.out.println(reversePolishNotationString);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        alphabetList.addAll(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '^', '(', ')'));
        digitList.addAll(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        operatorList.addAll(Arrays.asList('+', '-', '*', '/', '^'));
    }    
    
}
