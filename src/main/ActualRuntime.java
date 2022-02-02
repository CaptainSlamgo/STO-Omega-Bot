package main;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JToggleButton; 

import java.awt.event.ActionEvent;
import java.awt.AWTException;
import java.awt.event.*;  




public final class ActualRuntime extends JFrame implements core.Pixelmove, java.awt.event.ActionListener
{
	public static boolean toggleSw;
	
    public ActualRuntime()
    {
        super();
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocation(300,0);
        JButton b1 = new JButton("Exit");
        JToggleButton t1 = new JToggleButton("Enable");
        add(b1);
        t1.setSize(200,100);
        add(t1);
        
        t1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
        		toggleSw = t1.isSelected();
        		System.out.println(main.ActualRuntime.toggleSw);
            }
        });
        b1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
        		System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        System.exit(0);
    }
    private final void start()
    {
        try
        {
            while(true)
            run();
        }
        catch(AWTException e)
        {
            
        }
    }
    public static void main(String[] args)
    {
    	ActualRuntime a = new ActualRuntime();
    	a.start();
    }
}
