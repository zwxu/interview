package com.ustc.zwxu.basic.callback;
/*
 * button好比B
 * lister好比A
 * B通过回调方法，告知A执行情况
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//此时ActionListener 就是CallBackInterface
class MyFrame extends JFrame implements ActionListener {
    private final JLabel label = new JLabel("Event Dispatching Thread Sample");
    private final JButton button = new JButton("countUp");
    public MyFrame() {
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        getContentPane().add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            countUp();
        }
    }
    private void countUp() {
    	 // invokerThread在指定时间内sleep之后，呼叫SwingUtilities.invokeLater
        new Thread("invokerThread") {
        	public void run()
        	{
        		for (int i = 0; i < 10; i++) {
    	            /*System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + i + ")");
    	            label.setText("" + i);*/
    	        	final String str = "" + i;
    	        	System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + str + ")");
		            label.setText(str);
		            //做以下可实现资源共享且线程安全
    	            try {
    	            	/*final Runnable executor = new Runnable(){
    	
    						public void run() {
    				            System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + str + ")");
    				            label.setText(str);
    						}
    	            		
    	            	};
    	            	executor.run();
    	            	// 让Event Dispatching Thread呼叫出executor
    	                SwingUtilities.invokeLater(executor);*/
    	                Thread.sleep(1000);
    	            } catch (InterruptedException e) {
    	            }
    	        }
        		
        	}
   
	        
        }.start();
    }
}

public class ExampleFromSwing {
    public static void main(String s[]) {
    	 System.out.println(Thread.currentThread().getName() + ":BEGIN");
         new MyFrame();
         System.out.println(Thread.currentThread().getName() + ":END");
    }
}