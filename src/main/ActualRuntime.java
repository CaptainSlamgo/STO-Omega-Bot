package main;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.AWTException;

public final class ActualRuntime extends JFrame implements core.Pixelmove, java.awt.event.ActionListener
{
    public ActualRuntime()
    {
        super();
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        JButton b1 = new JButton("Exit");
        add(b1);
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
}