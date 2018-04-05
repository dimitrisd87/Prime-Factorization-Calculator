import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class PrimeFactor {
    public static void main (String args[]){

        UIManager.put("OptionPane.minimumSize",new Dimension(500,250));

        ImageIcon icon_input = new ImageIcon("src/primefactorization.jpg");
        ImageIcon icon_output = new ImageIcon("src/maths.jpg");

        String insert_number_string;
        long insert_number;
        List<Integer> factors = new ArrayList<>();
        List<String> expotential_form = new ArrayList<String>();

        while(true){
            try{
                while(true){
                    insert_number_string = String.valueOf(JOptionPane.showInputDialog(null,"Insert a number","Prime Factorization Calculator", JOptionPane.INFORMATION_MESSAGE, icon_input, null,null));
                    insert_number = Long.parseLong(insert_number_string);
                    if(insert_number >= 2){
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Please insert a number between 2 and 999995999","Error",JOptionPane.ERROR_MESSAGE,null);
                    }
                }

                for (int prime_number = 2; prime_number <= insert_number; prime_number++) {
                    int count = 0;

                    while (insert_number % prime_number == 0) {
                        insert_number /= prime_number; //given_number = given_number / prime_number;
                        count++;
                    }
                    if (count == 0) {
                        continue;
                    }
                    factors.add(prime_number);
                    expotential_form.add(prime_number + "^" + count);
                }

                if (factors.size() == 1) {
                    String output = "Factor of " + insert_number_string + " is: " + factors;
                    JOptionPane.showMessageDialog(null,output,"Prime Factors",JOptionPane.INFORMATION_MESSAGE,icon_output);
                    System.exit(0);
                } else {
                    String output = "Factors of " + insert_number_string + " are: " + factors + "\n" + "In Exponential Form: " + expotential_form;
                    //JOptionPane.showMessageDialog( null, output);
                    JOptionPane.showMessageDialog(null,output,"Prime Factors",JOptionPane.INFORMATION_MESSAGE,icon_output);
                    System.exit(0);
                }

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Please insert a number","Error",JOptionPane.ERROR_MESSAGE,null);
            }
        }
    }
}
