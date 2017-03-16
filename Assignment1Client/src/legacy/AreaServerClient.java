package legacy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class AreaServerClient extends JFrame {
	
	static JButton b1 = new JButton("Input String");
	static JPanel p = new JPanel();
	static JPanel p1 = new JPanel();
	static JLabel l = new JLabel();
	static JTextField tf = new JTextField(15);	
	static JTextArea ta = new JTextArea(20,30);
	static JScrollPane js = new JScrollPane(ta);
	
	public AreaServerClient()
	{
		this.add(p,BorderLayout.NORTH);
		this.add(p1,BorderLayout.CENTER);
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public String invoke(String radius, String type)
    {
        String result="";
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://127.0.0.1:10080"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        client.setConfig(config);
        try
        {
        	if (type.trim().equals("111")){
        		result = (String) client.execute("documentAnalysis.documentWithoutSymbol", new Object[] { radius });
 
        	}
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Result is:" + result);
        return "Result is:" + result;
    }

   
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        if (args.length < 1)
//        {
//            System.out.println("缺少命令行参数!");
//        }
    	p.add(b1);
		p.add(l);
		p.add(tf);
		ta.setLineWrap(true);
		p1.add(js);
		
        final AreaServerClient myTest = new AreaServerClient();
        
        
        b1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			String radius = tf.getText();
    			 if (!radius.equals("")){
    				 String result = myTest.invoke(radius, "111");
    				 ta.setText(result);
    			 }   			
    		}        	  
        });

         
   }
    	
    
}
