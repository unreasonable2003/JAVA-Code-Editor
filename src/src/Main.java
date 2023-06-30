package src;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.datatransfer.*;



class frame extends JFrame implements ActionListener
{

    JTextArea ta1,ta2;
    JCheckBoxMenuItem m61,m62;
    JTextField t3;
    Toolkit tk;
    JDialog d1;
    String cs, sf;
    Choice c;
    int sso = 0;

    frame(){
        super("Visual JAVA Editor - Untitled");
        setSize(1920,1080);
        setLayout(null);
        setBackground(Color.BLACK);
        getMaximumSize();
        getMinimumSize();
        ctrlsetup();
        menusetup();
        setVisible(true);
    }

    void ctrlsetup() {
        {
            tk = Toolkit.getDefaultToolkit();
            Font font1 = new Font("Sherif",Font.BOLD,16);
            Font font2 = new Font("Sherif",Font.BOLD,14);
            ta1= new JTextArea(10,10);
            ta1.setBackground(Color.BLUE);
            ta1.setForeground(Color.white);
            ta1.setFont(font1);
            ta2= new JTextArea(10,10);
            ta2.setBackground(Color.BLACK);
            ta2.setForeground(Color.green);
            ta2.setFont(font2);
            ta1.setBounds(0,0,920,1080);
            ta2.setBounds(925,0,1005,1080);
            ta2.setEditable(false);
            add(ta1);
            add(ta2);
        };
    }

    void menusetup() {
        try {

            JMenu m1,m2,m3,m4,m5;
            JMenuItem m11,m12,m13,m14,m15,m16;
            JMenuItem m21,m22,m23,m24,m25,m26;
            JMenuItem m31,m32;
            JMenuItem m41,m42;
            JMenuItem m51;

            JMenuBar mb = new JMenuBar();
            mb.setForeground(Color.WHITE);
            mb.setBackground(Color.darkGray);
            mb.setOpaque(true);

            m1 = new JMenu("File",true);
            m1.setForeground(Color.WHITE);
            m2 = new JMenu("Edit");
            m2.setForeground(Color.WHITE);
            m3 = new JMenu("Search");
            m3.setForeground(Color.WHITE);
            m4 = new JMenu("Run");
            m4.setForeground(Color.WHITE);
            m5 = new JMenu("Help");
            m5.setForeground(Color.WHITE);

            m11 = new JMenuItem("New");
            m12 = new JMenuItem("Open");
            m13 = new JMenuItem("Save");
            m14 = new JMenuItem("Save As");
            m15 = new JMenuItem("Close");
            m16 = new JMenuItem("Quit");

            m21= new JMenuItem("Undo");
            m22= new JMenuItem("Cut");
            m23= new JMenuItem("Copy");
            m24= new JMenuItem("Paste");
            m25= new JMenuItem("Clear");
            m26= new JMenuItem("Select All");

            m31 = new JMenuItem("Find");
            m32 = new JMenuItem("Find Next");

            m41 = new JMenuItem("Terminal");
            m42 = new JMenuItem("Compile");

            m51 = new JMenuItem("About Visual JAVA Editor");


            m1.add(m11);
            m1.add(m12);
            m1.add(m13);
            m1.add(m14);
            m1.add(m15);
            m1.addSeparator();
            m1.add(m16);

            m2.add(m21);
            m2.addSeparator();
            m2.add(m22);
            m2.add(m23);
            m2.add(m24);
            m2.add(m25);
            m2.addSeparator();
            m2.add(m26);

            m3.add(m31);
            m3.add(m32);

            m4.add(m41);
            m4.addSeparator();
            m4.add(m42);

            m5.add(m51);

            mb.add(m1);
            mb.add(m2);
            mb.add(m3);
            mb.add(m4);
            mb.add(m5);
            setJMenuBar(mb);

            m1.addActionListener(this);
            m2.addActionListener(this);
            m3.addActionListener(this);
            m4.addActionListener(this);
            m5.addActionListener(this);

            m11.addActionListener(this);
            m12.addActionListener(this);
            m13.addActionListener(this);
            m14.addActionListener(this);
            m15.addActionListener(this);
            m16.addActionListener(this);

            m21.addActionListener(this);
            m22.addActionListener(this);
            m23.addActionListener(this);
            m24.addActionListener(this);
            m25.addActionListener(this);
            m26.addActionListener(this);

            m31.addActionListener(this);
            m32.addActionListener(this);

            m41.addActionListener(this);
            m42.addActionListener(this);

            m51.addActionListener(this);

        }
        catch(Exception e){}
    }


    public void actionPerformed(ActionEvent e){
        String s=e.getActionCommand();

        if (s.equals("New"))
        {
            ta1.setText("");
            d1=new JDialog(this,"New ... ",true);
            d1.setLocation(320,320);
            d1.setSize(250,100);
            d1.setLayout(new FlowLayout());
            d1.add(new Label("Select the File Type"));
            c=new Choice();
            c.add("Application");

            d1.add(c);
            JButton b1=new JButton("Start");
            JButton b2=new JButton("Cancel");
            d1.add(b1);
            d1.add(b2);

            b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent v)
                {
                    String xx= (String) c.getSelectedItem();
                    String title=getTitle().substring(21,getTitle().length()-5);

                    if(xx.equals("Application"))
                    {
                        String s1="import java.lang.*;";
                        FileDialog fd=new FileDialog(new frame(),"Save Application",FileDialog.SAVE);
                        fd.setVisible(true);
                        setTitle("Visual JAVA Editor - " + new File(fd.getFile()) + ".java");
                        title=getTitle().substring(21,getTitle().length()-5);
                        s1+="\nclass " + title;
                        s1+="\n{\n\tpublic static void main(String args[])";
                        s1+="\n\t{\n\n\n\t}\n}";
                        ta1.setText(s1);
                    }

                    ta1.requestFocus();
                    d1.dispose();
                }
            });
            b2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent v)
                {
                    d1.dispose();
                }
            });
            d1.setVisible(true);
        }

        if (s.equals("Open"))
        {
            FileDialog fd=new FileDialog(this,"File Open ...",FileDialog.LOAD);
            fd.setVisible(true);
            setTitle("Visual JAVA Editor - " + new File(fd.getFile()));
            try{
                FileInputStream ds=new FileInputStream(fd.getFile());
                int c;
                ta1.setText("");
                String sx="";
                while((c=ds.read())!=-1)
                    sx=sx+(char)c;
                ta1.setText(sx);
            }catch(Exception se){}
        }
        if (s.equals("Save"))
        {
            String t=getTitle();
            File ff;
            if (t.equals("Visual JAVA Editor - Untitled"))
            {
                FileDialog fd=new FileDialog(this,"File Saving...",FileDialog.SAVE);
                fd.setVisible(true);
                ff=new File(fd.getFile());
            }
            else
            {
                ff=new File(t.substring(21,t.length()));
            }
            try{
                PrintWriter pw = new PrintWriter(new FileOutputStream(ff),true);
                pw.println(ta1.getText());
            }catch(Exception fe){}
            setTitle("Visual JAVA Editor - " + ff);
        }
        if (s.equals("Save As"))
        {
            String t=getTitle();
            File ff;
            FileDialog fd;
            if (t.equals("Visual JAVA Editor - Untitled"))
                fd=new FileDialog(this,"Save...",FileDialog.SAVE);
            else
                fd=new FileDialog(this,"Save As ...",FileDialog.SAVE);
            fd.setVisible(true);
            ff=new File(fd.getFile());
            try{
                PrintWriter pw = new PrintWriter(new FileOutputStream(ff),true);
                pw.println(ta1.getText());
            }catch(Exception fe){};
            setTitle("Visual JAVA Editor - " + ff);
        }
        if(s.equals("Close"))
        {
            setTitle("Visual JAVA Editor - Untitled");
            ta1.setText("");
            ta1.requestFocus();
        }

        if(s.equals("Quit"))
            System.exit(0);

        if (s.equals("Undo"))
        {
            ta1.setText(cs);
        }
        if(s.equals("Cut"))
        {
            String s1=ta1.getSelectedText();
            String b=ta1.getText();
            cs=ta1.getText();
            b=ta1.getText().substring(0,ta1.getCaretPosition());
            b=b+ta1.getText().substring(ta1.getCaretPosition()+ta1.getSelectedText().length(),ta1.getText().length());
            ta1.setText(b);
            StringSelection ss=new StringSelection(s1);
            Clipboard cl=tk.getSystemClipboard();
            cl.setContents(ss,ss);
        }

        if (s.equals("Copy"))
        {
            String s1=ta1.getSelectedText();
            StringSelection ss=new StringSelection(s1);
            Clipboard cl=tk.getSystemClipboard();
            cl.setContents(ss,ss);
        }

        if (s.equals("Paste"))
        {
            String dat="";
            Clipboard cl=tk.getSystemClipboard();
            Transferable con=cl.getContents(this);
            try{
                dat=(String) con.getTransferData(DataFlavor.stringFlavor);
            }
            catch(Exception ex){}
            StringBuffer tt=new StringBuffer(ta1.getText());
            tt.insert(ta1.getCaretPosition(),dat);
            ta1.setText(tt.toString());
        }

        if(s.equals("Clear"))
        {
            String s1=ta1.getSelectedText();
            String b=ta1.getText();
            cs =ta1.getText();
            b=ta1.getText().substring(0,ta1.getCaretPosition());
            b=b+ta1.getText().substring(ta1.getCaretPosition()+ta1.getSelectedText().length(),ta1.getText().length());
            ta1.setText(b);
        }

        if (s.equals("Select All"))
        {
            ta1.select(0,ta1.getText().length());
        }

        if (s.equals("Find"))
        {
            d1=new JDialog(this,"Find ... ",true);
            d1.setLocation(300,300);
            d1.setSize(250,90);
            d1.setLayout(new FlowLayout());
            d1.add(new Label("Enter the Text to Find"));
            t3= new JTextField(10);
            d1.add(t3);
            Button b1=new Button("Find");
            Button b2=new Button("Cancel");
            d1.add(b1);
            d1.add(b2);
            b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent we)
                {
                    sf=t3.getText();
                    String tst=ta1.getText();
                    int az=tst.indexOf(sf,sso);
                    ta1.select(az,az+sf.length());
                    sso=az+sf.length();
                    d1.dispose();
                }
            });
            b2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent we)
                {
                    d1.dispose();
                }
            });

            d1.setVisible(true);
        }

        if (s.equals("Find Next"))
        {
            sf=t3.getText();
            String tst=ta1.getText();
            int len=ta1.getText().length();
            int az=0;
            if(sso<=len)
                az=tst.indexOf(sf,sso);
            else
                sso=0;
            ta1.select(az,az+sf.length());
            sso=az+sf.length();
        }
        if (s.equals("Compile"))
        {
            try{
                String r = getTitle().substring(21,getTitle().length());
                Runtime rt =Runtime.getRuntime();
                Process p =rt.exec("javac  "+r);
                p.waitFor();
                int i =p.exitValue();
                InputStream ip =p.getErrorStream();
                int a =ip.available();
                ta2.setText("");
                ta2.setText("""
                        Compiling ...

                        """);
                if(a==0)
                    ta2.setText(ta2.getText()+"There is no error in your Program\n");
                else
                {
                    int c;
                    StringBuilder ts= new StringBuilder(ta2.getText());
                    while((c =ip.read()) != -1)
                    {
                        ts.append((char) c);
                    }
                    ta2.setText(ts.toString());
                }
            }catch(Exception ex){}
        }

        if(s.equals("Terminal"))
        {
            String r = getTitle().substring(21,getTitle().length()-5);
            try
            {
                Runtime t =Runtime.getRuntime();
                Process p=t.exec("java  "+r);
                p.waitFor();
                int i =p.exitValue();
                InputStream ip =p.getInputStream();
                int a =ip.available();
                ta2.setText("Output of " + r + ".java  : \n\n");
                StringBuilder ts= new StringBuilder(ta2.getText());
                if(a!=0)
                {
                    int c;
                    while((c =ip.read()) != -1)
                    {
                        ts.append((char) c);
                    }
                    ta2.setText(ts.toString());
                }
                else
                    ta2.setText("Program Successfully Executed");
            }catch(Exception eq){}
        }
        if(s.equals("About Visual JAVA Editor"))
        {
            d1=new JDialog(this,"About Visual JAVA Editor",true);
            d1.setLocation(100,100);
            d1.setSize(400,500);
            d1.setLayout(null);
            JLabel l1=new JLabel("JAVA IDE");
            JLabel l2=new JLabel("OOM Project");
            JLabel l3=new JLabel("By IIT2021229, IIT2021502, IIT2021503");
            JLabel l4=new JLabel("");
            JLabel l5=new JLabel("");
            JLabel l6=new JLabel("");
            String st = "OK";
            JButton b1=new JButton(st);
            l1.setBounds(50,50,100,25);
            l2.setBounds(50,75,100,25);
            l3.setBounds(50,150,300,25);
            l4.setBounds(50,190,200,25);
            l5.setBounds(50,220,100,25);
            l6.setBounds(50,260,100,25);

            b1.setBounds(50,300,95,30);
            d1.add(l1);
            d1.add(l2);
            d1.add(l3);
            d1.add(l4);
            d1.add(l5);
            d1.add(l6);
            d1.add(b1);
            b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent we)
                {
                    d1.dispose();
                }
            });
            d1.setVisible(true);

        }
    }

}

public class Main extends frame {
    public static void main(String[] args) {
        frame f = new frame();
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
