import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//导入io包
import java.io.*;
public class PicView extends JFrame implements ActionListener
{
	JPanel pa;
	JMenu me;
	JMenuBar bar;
	JButton btn1,btn2,btn3,btn4,btn5,btn6;
	JMenuItem btn11;
	public PicView()
	{
		initGUI();
		this.setVisible(true);
		this.setBounds(800,400,150,280);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initGUI()
	{
		bar=new JMenuBar();
		pa=new JPanel();
		me=new JMenu("菜单");
		btn11=new JMenuItem("退出");
		btn1=new JButton("启动网易云");
		btn2=new JButton("启动WeGame");
		btn3=new JButton("启动DEV-C++");
		btn4=new JButton("启动腾讯QQ");
		btn5=new JButton("启动谷歌");
		btn6=new JButton("启动Steam");	
		//加入监听器
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn11.addActionListener(this);
		me.addSeparator();
		me.add(btn11);
		pa.add(btn1);
		pa.add(btn2);
		pa.add(btn3);
		pa.add(btn4);
		pa.add(btn5);
		pa.add(btn6);
		bar.add(me);
		this.setJMenuBar(bar);
		this.add(pa,BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e)
	{
		Runtime rt=Runtime.getRuntime();
		try
		{
			if(e.getSource()==btn1)
			{
				rt.exec("D:\\CloudMusic\\cloudmusic.exe");
			}
			else if(e.getSource()==btn2)
			{
				rt.exec("F:\\Program Files\\WeGame\\tgp_daemon.exe");
			}
			else if(e.getSource()==btn3)
			{
				rt.exec("D:\\Dev-Cpp\\devcpp.exe");
			}
			else if(e.getSource()==btn4)
			{
				rt.exec("C:\\Program Files (x86)\\QQ\\Bin\\QQScLauncher.exe");
			}
			else if(e.getSource()==btn5)
			{
				rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			}
			else if(e.getSource()==btn6)
			{
				rt.exec("D:\\steam\\Steam.exe");
			}
			else if(e.getSource()==btn11)			//点击退出按钮
			{
				this.dispose();
			}
			}
			catch(IOException ee)
			{
				System.out.println("出现错误！\n");
			}
	}
}