import javax.swing.*;
import java.awt.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

public class d {

    private JPanel panel1;
    private JButton button1;
    private JList list1;
    private JFrame bob;

    d() throws SQLException {

    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

    static public void main(String args[]) throws SQLException {
new d();

//        System.out.println(rs.next());
//        textArea1.append(rs.toString());
        JFrame frame = new JFrame("ayush");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JTextArea textArea= new JTextArea("dd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/q4", "ayush", "ayush");
        Statement statement = connection.createStatement();
//        System.out.println(statement);

        String query = "SELECT * FROM part";
        // create the java statement
        Statement st = connection.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] data=new String[10];
        assert rs != null;
        int i=0;

        while (rs.next()) {
            String v= null;
            try {
                v = rs.getString(1)+" "+fixedLengthString(rs.getString(2),15)+" "+fixedLengthString(rs.getString(3),15);
                textArea.append(v+"\n");
                data[i++]=v;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(v);
        }


        JMenuBar mainmenu = new JMenuBar();
        JMenu flight = new JMenu("FLIGHT"), staff = new JMenu("STAFF"), payment = new JMenu("PAYMENT");
        JMenuItem reservation = new JMenuItem("CHECK RESERVATION"), update = new JMenuItem("UPDATE"), pilot = new JMenuItem("PILOT"), crew = new JMenuItem("CREW"), check = new JMenuItem("CHECK");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame2 = new JFrame();
                jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame2.setSize(300, 400);
//                jFrame2.add(textArea);
               jFrame2.add( new JList(data));
                jFrame2.setVisible(true);
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
        frame.setVisible(true);
    }

}
