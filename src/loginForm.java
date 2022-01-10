import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Jan 05 22:50:03 EET 2022
 */



/**
 * @author asdfasdfa
 */
public class loginForm extends JPanel {
    JFrame jframe;
    loginForm currentForm;
    private final MainUI mainUI;
    private final Map<Integer,Reservation> reservations;
    private final Map<Integer,Room> rooms;
    private final Map<String,Authentication> users;
    private final Map<String,Customer> customers;
    private final Map<String,Provider> providers;
    private final Map<String,Admin> admins;
    private final Map<Integer,Message> messages;

    public void setCurrentForm(loginForm currentForm) {
        this.currentForm = currentForm;
    }

    public loginForm(JFrame jframe, Map<Integer,Reservation> reservations, Map<Integer,Room> rooms,
                     Map<String,Authentication> users, Map<String,Customer> customers, Map<String,Provider> providers,
                     Map<String,Admin> admins, Map<Integer,Message> messages, MainUI mainUI) {
        this.jframe = jframe;
        this.reservations = reservations;
        this.rooms = rooms;
        this.users = users;
        this.customers = customers;
        this.providers = providers;
        this.admins = admins;
        this.messages = messages;
        this.mainUI=mainUI;
        initComponents();
        jframe.setPreferredSize(new Dimension(330 , 305));
        jframe.pack();
    }

    private void loginButtonClick(ActionEvent e) {
        int role = 0;
        String username = textField1.getText();
        String password = String.valueOf(passwordField1.getPassword());
        if (this.users.containsKey(username)) {
            Authentication temp = this.users.get(username);
            if (password.equals(temp.getPassword())){
                role = temp.getRole();
            }
            else {
                label4.setText("Wrong password");
                label4.setVisible(true);

            }
        }
        else {
            label4.setText("Login failed");
            label4.setVisible(true);
        }
        switch (role) {
            case 1 -> {
                customerForm customerForm = new customerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.customers.get(username));
                customerForm.setCurrentForm(customerForm);
                this.jframe.add(customerForm);
                this.currentForm.setVisible(false);
            }
            case 2 -> {
                providerForm providerForm = new providerForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.providers.get(username));
                providerForm.setCurrentForm(providerForm);
                this.jframe.add(providerForm);
                this.currentForm.setVisible(false);
            }
            case 3 -> {
                adminForm adminForm = new adminForm(this.jframe, this.reservations, this.rooms, this.users, this.customers,
                        this.providers, this.admins, this.messages, this.mainUI, this.admins.get(username));
                adminForm.setCurrentForm(adminForm);
                this.jframe.add(adminForm);
                this.currentForm.setVisible(false);
            }
        }
    }

    private void registerButtonClick(ActionEvent e) {
        registerForm registerForm = new registerForm(this.jframe, this.reservations, this.rooms, this.users,
                this.customers, this.providers, this.admins, this.messages, this.mainUI);
        registerForm.setCurrentForm(registerForm);
        this.jframe.add(registerForm);
        this.currentForm.setVisible(false);
    }

    private void exitButtonClick(ActionEvent e) {
        this.mainUI.saveAndExit();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - asdfasdfa
        label4 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(423, 278));
        setMaximumSize(new Dimension(423, 278));
        setFont(new Font("Droid Sans", Font.PLAIN, 12));
        setAlignmentY(2.5F);
        setBackground(new Color(51, 102, 255));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //---- label4 ----
        label4.setText("Wrong password, please try again");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setVisible(false);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(new Color(255, 51, 51));
        add(label4);
        label4.setBounds(40, 145, 250, 20);

        //---- label1 ----
        label1.setText("Login");
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1);
        label1.setBounds(130, 20, 70, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Username:");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label2);
        label2.setBounds(30, 75, 95, 25);

        //---- textField1 ----
        textField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField1.setForeground(Color.black);
        textField1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        add(textField1);
        textField1.setBounds(145, 75, 135, 25);

        //---- label3 ----
        label3.setText("Password:");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.white);
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label3);
        label3.setBounds(30, 110, 95, 25);

        //---- passwordField1 ----
        passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        add(passwordField1);
        passwordField1.setBounds(145, 110, 135, 25);

        //---- button1 ----
        button1.setText("Login");
        button1.setFont(new Font("Tahoma", Font.BOLD, 14));
        button1.setForeground(Color.white);
        button1.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button1.addActionListener(e -> loginButtonClick(e));
        add(button1);
        button1.setBounds(175, 175, 120, 35);

        //---- button2 ----
        button2.setText("Register");
        button2.setActionCommand("Register");
        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
        button2.setForeground(Color.white);
        button2.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button2.addActionListener(e -> registerButtonClick(e));
        add(button2);
        button2.setBounds(35, 175, 120, 35);

        //---- button3 ----
        button3.setText("Exit");
        button3.setFont(new Font("Tahoma", Font.BOLD, 14));
        button3.setForeground(Color.white);
        button3.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, Color.white, Color.white, Color.blue, Color.blue));
        button3.addActionListener(e -> exitButtonClick(e));
        add(button3);
        button3.setBounds(120, 225, 90, 35);

        setPreferredSize(new Dimension(330, 280));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - asdfasdfa
    private JLabel label4;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
