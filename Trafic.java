import java.awt.*;
import java.awt.event.*;


public class Trafic extends Frame implements ActionListener, Runnable{

    int x=10,y=0,z;
    String select = "";
    public Trafic()
    {
        setTitle("Trafic lights");      
        setSize(700,700);   
        setLayout(new FlowLayout());
        setVisible(true);


        MenuBar mb = new MenuBar();
        Menu m = new Menu("select");

        MenuItem m1 = new MenuItem("normal");
        MenuItem m2 = new MenuItem("right");
        MenuItem m3 = new MenuItem("left"); 

        
        m.add(m1);
        m.add(m2);
        m.add(m3);

        mb.add(m);

        setMenuBar(mb);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

        new Thread(this).start();

        
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("normal"))
        {
            x = 10;
            y=0;
        }
        if (cmd.equals("left"))
        {
            x = 25;
            y = 2; 
        }
        if (cmd.equals("right"))
        {
            x = 25;
            y = 1; 
        }
    
    }

    int n = -1;

    public void paint(Graphics g) {
   
    g.setColor(Color.black);
    g.fillRect(200, 100, 120, 300); 


    if (n == 0) g.setColor(Color.RED);
    else g.setColor(Color.GRAY);
    g.fillOval(230, 120, 60, 60);


    if (n == 1 || n== 3) g.setColor(Color.YELLOW);
    else g.setColor(Color.GRAY);
    g.fillOval(230, 200, 60, 60);

    
    if (n == 2) g.setColor(Color.GREEN);
    else g.setColor(Color.GRAY);
    g.fillOval(230, 280, 60, 60);

    g.setColor(Color.black);
    g.fillRect(400, 100, 120, 300);

    if (n == 2) g.setColor(Color.RED);
    else g.setColor(Color.GRAY);
    g.fillOval(430, 120, 60, 60);


    if (n == 1 || n==3) g.setColor(Color.YELLOW);
    else g.setColor(Color.GRAY);
    g.fillOval(430, 200, 60, 60);


    if (n == 0) g.setColor(Color.GREEN);
    else g.setColor(Color.GRAY);
    g.fillOval(430, 280, 60, 60);
}


        public void run()
        {
            try{
                while(true)
                {   
                    n++;
                    if(n==4) n = 0;
                    repaint();

                    if(y==0)
                    {
                        if(n==1||n==3) Thread.sleep(2000);
                        else
                        Thread.sleep(500*x);
                    }
                    if(y==1)
                    {
                        if(n==1||n==3) Thread.sleep(2000);
                        else if(n==0)
                            Thread.sleep(500*25);
                        else
                            Thread.sleep(500*10) ; 
                    }
                    if(y==2)
                    {
                        if(n==1||n==3) Thread.sleep(2000);
                        else if(n==0)
                            Thread.sleep(500*10);
                        else
                            Thread.sleep(500*25) ; 
                    }
                    
                  
                }
            }
            catch(Exception e){}
        }

    public static void main(String[] args) {
        new Trafic();
    }






}
    
