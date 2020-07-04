import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Graphics {
    JLabel jLabel11=new JLabel();
    public Graphics(Filereader filereader) {
        JFrame frame = new JFrame("sharif");
        JPanel panel = new JPanel();
            panel.setBounds(50, 50, 400, 400);
            panel.setBackground(Color.lightGray);
            panel.setLayout(null);
        final JTextField textField = new JTextField("");
            textField.setBounds(180, 50, 100, 50);
        final JLabel jLabel1 = new JLabel("USERNAME");
            jLabel1.setBounds(100, 50, 100, 50);
        final JPasswordField passwordField = new JPasswordField("");
            passwordField.setBounds(180, 110, 100, 50);
        final JLabel jLabel2 = new JLabel("PASSWORD");
            jLabel2.setBounds(100, 110, 100, 50);
        final JTextField textField2 = new JTextField("");
            textField2.setBounds(180, 170, 100, 50);
        final JLabel jLabel3 = new JLabel("CODE");
            jLabel3.setBounds(100, 170, 100, 50);
        final JButton button = new JButton("LOGIN");
            button.setFont(new Font("Courier New", Font.ITALIC, 15));
            button.setBounds(170, 300, 120, 40);
            button.setBackground(Color.red);
        final JButton button2 = new JButton("REGENERATE");
            button2.setFont(new Font("Courier New", Font.ITALIC, 12));
            button2.setBounds(200, 250, 120, 30);
            button2.setBackground(Color.yellow);
        JLabel jLabel4 = new JLabel();
            jLabel4.setBounds(150, 250, 100, 30);
            jLabel4.setFont(new Font("Courier New", Font.BOLD, 20));
        Random random = new Random();
        jLabel4.setText(String.valueOf(random.nextInt(1000)));
        JLabel jLabel5=new JLabel();
            jLabel5.setBounds(10,10,250,20);
            jLabel5.setForeground(Color.red);


        panel.add(textField);
        panel.add(textField2);
        panel.add(passwordField);
        panel.add(button);
        panel.add(button2);
        panel.add(jLabel1);
        panel.add(jLabel2);
        panel.add(jLabel3);
        panel.add(jLabel4);
        panel.add(jLabel5);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < filereader.users.size(); i++) {
                    if (filereader.users.get(i).equals(textField.getText()) && filereader.passwords.get(i).equals(String.valueOf(passwordField.getPassword())) && textField2.getText().equals(jLabel4.getText())) {
                        frame.setVisible(false);
                        Pattern pattern=Pattern.compile("(([\\d]+),([\\d]+))");
                        Matcher matcher=pattern.matcher(filereader.activecourses.get(i));
                        while(matcher.find()){
                            filereader.activecourses2.add(matcher.group(2));
                            filereader.activecourses2groups.add(matcher.group(3));
                        }
                        afterlogin(filereader,i);
                        break;
                    } else if (filereader.users.get(i).equals(textField.getText()) && filereader.passwords.get(i).equals(String.valueOf(passwordField.getPassword()))) {
                        jLabel5.setText("SECURITY CODE IS NOT CORRECT !");
                        jLabel4.setText(String.valueOf(random.nextInt(1000)));
                        break;
                    } else if (i==7){
                        jLabel5.setText("WRONG USERNAME OR PASSWORD !");
                        jLabel4.setText(String.valueOf(random.nextInt(1000)));
                        break;
                    }
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jLabel4.setText(String.valueOf(random.nextInt(1000)));
            }
        });

    }


    public void afterlogin(Filereader filereader,int i){

        JFrame frame=new JFrame("sharif");
        JPanel panel=new JPanel();
            panel.setBounds(100,120,1050,450);
            panel.setBackground(Color.lightGray);
            panel.setLayout(null);
        frame.add(panel);

        JMenuBar jmenuBar=new JMenuBar();
        jmenuBar.setBounds(0,0,250,25);
        JMenu jMenu=new JMenu("امور ثبتنام و ترمیم");
        JMenu jMenu2=new JMenu("خدمات آموزشی");
        JMenu jMenu3=new JMenu("امور کارنامه");
        JMenuItem jmenuItem1=new JMenuItem("اطلاعیه و راهنمای ثبتنام و ترمیم");jmenuItem1.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem2=new JMenuItem("لیست دروس ارائه شده دانشکده ها در ترم جاری");jmenuItem2.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem3=new JMenuItem("فرم مشاوره انتخاب واحد");jmenuItem3.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem4=new JMenuItem("پرداخت اینترنتی دانشجویان");jmenuItem4.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem5=new JMenuItem("ثبت اطلاعات بانکی دانشجو");jmenuItem5.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem6=new JMenuItem("تطبیق دروس دانشجو با چارت");jmenuItem6.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem7=new JMenuItem("کارتابل درخواست");jmenuItem7.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem8=new JMenuItem("درخواست احراز کارشناسی");jmenuItem8.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem9=new JMenuItem("درخواست های آموزشی");jmenuItem9.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem10=new JMenuItem("فرم ثبتنام دانشجو");jmenuItem10.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem11=new JMenuItem("لیست امتحانات پایانترم");jmenuItem11.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem12=new JMenuItem("برنامه هفتگی دانشجو");jmenuItem12.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem13=new JMenuItem("وضعیت تحصیلی و ریز نمرات دانشجو");jmenuItem13.addActionListener(this::actionPerformed);
        JMenuItem jmenuItem14=new JMenuItem("لیست نمرات موقت و ثبت اعتراض");jmenuItem14.addActionListener(this::actionPerformed);

        jMenu.add(jmenuItem1);jMenu.add(jmenuItem2);jMenu.add(jmenuItem3);jMenu.add(jmenuItem4);
        jMenu2.add(jmenuItem5);jMenu2.add(jmenuItem6);jMenu2.add(jmenuItem7);jMenu2.add(jmenuItem8);jMenu2.add(jmenuItem9);jMenu2.add(jmenuItem10);jMenu2.add(jmenuItem11);jMenu2.add(jmenuItem12);
        jMenu3.add(jmenuItem13);jMenu3.add(jmenuItem14);
        jmenuBar.add(jMenu);jmenuBar.add(jMenu2);jmenuBar.add(jMenu3);jmenuBar.setBackground(Color.RED);
        frame.add(jmenuBar);

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Mahan\\Desktop\\sharif.png");
        Image image=imageIcon.getImage();
        imageIcon.setImage(image);
        JLabel jLabel=new JLabel(imageIcon);
        jLabel.setBounds(1150-imageIcon.getIconWidth(),5,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        frame.add(jLabel);
        JLabel jLabel1=new JLabel();
            jLabel1.setBounds(550,0,100,25);
            jLabel1.setText("نیمسال دوم 98-99");
        JLabel jLabel2=new JLabel();
            jLabel2.setBounds(780,10,200,50);
            jLabel2.setText("شماره دانشجو:  "+filereader.users.get(i));
        JLabel jLabel3=new JLabel();
            jLabel3.setBounds(550,10,200,50);
            jLabel3.setText("نام و نام خانوادگی:  "+filereader.names.get(i));
        JLabel jLabel4=new JLabel();
            jLabel4.setBounds(320,10,200,50);
            jLabel4.setText("دانشکده:  "+filereader.majors.get(i));
        JLabel jLabel5=new JLabel();
            jLabel5.setBounds(780,35,200,50);
            jLabel5.setText("رشته:  "+filereader.majors.get(i));
        JLabel jLabel6=new JLabel();
            jLabel6.setBounds(550,35,200,50);
            if (filereader.orientations.get(i).equals("nan"))
            jLabel6.setText("گرایش:  "+"-");
            else
            jLabel6.setText("گرایش:  "+filereader.orientations.get(i));
        JLabel jLabel7=new JLabel();
            jLabel7.setBounds(320,35,200,50);
            jLabel7.setText("استاد راهنما:  "+filereader.supervisers.get(i));

        frame.add(jLabel1);frame.add(jLabel2);frame.add(jLabel3);frame.add(jLabel4);frame.add(jLabel5);frame.add(jLabel6);frame.add(jLabel7);

        JLabel jLabel8=new JLabel();
            jLabel8.setBounds(880,75,100,50);
            jLabel8.setText("درس");
        JTextField textField1=new JTextField();
            textField1.setBounds(780,85,100,30);
        JLabel jLabel9=new JLabel();
            jLabel9.setBounds(760,75,100,50);
            jLabel9.setText("گروه");
        JTextField textField2=new JTextField();
            textField2.setBounds(660,85,100,30);
        JLabel jLabel10=new JLabel();
            jLabel10.setBounds(640,75,100,50);
            jLabel10.setText("واحد");

            jLabel11.setBounds(10,10,150,50);
            jLabel11.setText("");
            jLabel11.setForeground(Color.red);
        JTextField textField3=new JTextField();
            textField3.setBounds(540,85,100,30);
        JButton jButton=new JButton("اضافه");
            jButton.setBounds(470,85,60,30);
            jButton.setBackground(Color.green);
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(filereader.coursescodes.contains(textField1.getText())) {
                    if (filereader.coursesvaheds.get(filereader.coursescodes.indexOf(textField1.getText())).equals(textField3.getText()) && Integer.parseInt(filereader.coursesgroups.get(filereader.coursescodes.indexOf(textField1.getText()))) >= Integer.parseInt(textField2.getText()) && filereader.activecourses2.contains(textField1.getText()) == false) {
                        filereader.activecourses2.add(textField1.getText());
                        filereader.activecourses2groups.add(textField2.getText());
                        frame.setVisible(false);
                        afterlogin(filereader, i);
                    }
                    else if (filereader.activecourses2.contains(textField1.getText())==true){
                        for (int k=0;k<filereader.coursescodes.size();k++)
                        if (filereader.coursescodes.get(k).equals(textField1.getText())&&filereader.coursesgroups.get(k).equals(textField2.getText())&&filereader.coursesvaheds.get(k).equals(textField3.getText())) {
                            filereader.activecourses2groups.set(filereader.activecourses2.indexOf(textField1.getText()), textField2.getText());
                            frame.setVisible(false);
                            afterlogin(filereader, i);
                        }
                        jLabel11.setText("چنین درسی موجود نیست!");
                    }
                    else jLabel11.setText("چنین درسی موجود نیست!");
                }
                else jLabel11.setText("چنین درسی موجود نیست!");
            }
        });

        frame.add(jLabel8);frame.add(textField1);frame.add(jLabel9);frame.add(textField2);frame.add(jLabel10);frame.add(textField3);frame.add(jButton);frame.add(jLabel11);
            String[] column = {"شماره", "گروه","واحد" ,"نام درس","شرکتکننده","ظرفیت","استاد","برنامه","امتحان","پیشنیاز","توضیحات"};
            String[][] data = new String[filereader.activecourses2.size()][11];
            ArrayList<JCheckBox> jCheckboxes = new ArrayList<JCheckBox>();
            for (int a = 0; a < filereader.activecourses2.size(); a++) {
                for (int k=0;k<filereader.coursescodes.size();k++){
                    if (filereader.coursescodes.get(k).equals(filereader.activecourses2.get(a))&&filereader.coursesgroups.get(k).equals(filereader.activecourses2groups.get(a))){
                        data[a][0] = filereader.activecourses2.get(a);
                        data[a][1] = filereader.activecourses2groups.get(a);
                        data[a][2] = filereader.coursesvaheds.get(k);
                        data[a][3] = filereader.coursesnames.get(k);
                        data[a][4] = String.valueOf(Integer.parseInt(filereader.coursesoccupance.get(k))+1);
                        data[a][5] = filereader.coursessizes.get(k);
                        data[a][6] = filereader.coursesteachers.get(k);
                        data[a][7] = filereader.coursesschedules.get(k);
                        data[a][8] = filereader.coursesexamtime.get(k);
                        data[a][9] = filereader.coursesreqiurements.get(k).toString();
                        data[a][10] = filereader.coursesextrainformations.get(k);
                        JCheckBox jCheckBox = new JCheckBox();
                        jCheckBox.setBounds(1010, 20 + 15 * a, 15, 17);
                        jCheckboxes.add(jCheckBox);
                        panel.add(jCheckboxes.get(a));
                        break;
                    }
                }
            }
            JTable jTable = new JTable(data, column);
            jTable.setBounds(10, 20, 1000, 400);
            TableColumn column1=null;
            column1=jTable.getColumnModel().getColumn(0);
            column1.setPreferredWidth(40);
            column1=jTable.getColumnModel().getColumn(1);
            column1.setPreferredWidth(5);
            column1=jTable.getColumnModel().getColumn(2);
            column1.setPreferredWidth(5);
            column1=jTable.getColumnModel().getColumn(3);
            column1.setPreferredWidth(150);
            column1=jTable.getColumnModel().getColumn(4);
            column1.setPreferredWidth(20);
            column1=jTable.getColumnModel().getColumn(5);
            column1.setPreferredWidth(20);
            column1=jTable.getColumnModel().getColumn(7);
            column1.setPreferredWidth(150);
            column1=jTable.getColumnModel().getColumn(8);
            column1.setPreferredWidth(60);
            column1=jTable.getColumnModel().getColumn(10);
            column1.setPreferredWidth(200);
            JTableHeader header=jTable.getTableHeader();
            header.setReorderingAllowed((false));
            header.setResizingAllowed(false);
            header.setBounds(10,5,1000,15);
            panel.add(header);
            panel.add(jTable);

            JButton jButton2 = new JButton("حذف");
            jButton2.setBounds(950, 415, 70, 25);
            jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int j = filereader.activecourses2.size();
                    while (j > 0) {
                        if (jCheckboxes.get(j - 1).isSelected()) {
                            filereader.activecourses2.remove(j - 1);
                            filereader.activecourses2groups.remove(j - 1);
                        }
                        j--;
                    }

                    frame.setVisible(false);
                    afterlogin(filereader, i);
                    System.out.println(filereader.activecourses2);
                }
            });
            panel.add(jButton2);
        frame.setSize(1200,700);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        jLabel11.setText("دسترسی به منو وجود ندارد!");
    }
}

