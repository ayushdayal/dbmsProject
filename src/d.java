import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class d {

    private JPanel panel1;
    private JFrame bob;

    d() {
    }

    static public void main(String args[]) {
     JFrame frame= new JFrame("ayush");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(300,400);
     frame.setVisible(true);
     JMenuBar mainmenu= new JMenuBar();
     JMenu flight=new JMenu("FLIGHT"),staff=new JMenu("STAFF"),payment=new JMenu("PAYMENT");
     JMenuItem reservation=new JMenuItem("CHECK RESERVATION"),update=new JMenuItem("UPDATE"),pilot=new JMenuItem("PILOT"),crew=new JMenuItem("CREW"),check =new JMenuItem("CHECK");
/*
     reservation.addMenuKeyListener(new MenuKeyListener() {
            @Override
            public void menuKeyTyped(MenuKeyEvent e) {
                JFrame jFrame2=new JFrame();
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame2.setSize(300,400);
                jFrame2.setVisible(true);
                System.out.print("fhgf");
            }

            @Override
            public void menuKeyPressed(MenuKeyEvent e) {
                JFrame jFrame2=new JFrame();
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame2.setSize(300,400);
                jFrame2.setVisible(true);
                System.out.print("fhgf");
            }

            @Override
            public void menuKeyReleased(MenuKeyEvent e) {

                JFrame jFrame2=new JFrame();
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame2.setSize(300,400);
                jFrame2.setVisible(true);
                System.out.print("fhgf");
            }
        });
*/
     ActionListener actionListener =new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             JFrame jFrame2=new JFrame();
             jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             jFrame2.setSize(300,400);
             jFrame2.setVisible(true);
             System.out.print("fhgf");
         }
     };

     reservation.addActionListener(actionListener);
     flight.add(reservation);
     flight.add(update);
     staff.add(pilot);
     staff.add(crew);
     payment.add(check);
     mainmenu.add(flight);
     mainmenu.add(staff);
     mainmenu.add(payment);

     frame.add(mainmenu);
     frame.setJMenuBar(mainmenu);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
