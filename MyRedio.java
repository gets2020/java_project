import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.applet.*;
class MyRedio extends JFrame implements ActionListener
{
	JSplitPane sp;
	JLabel la;
	JScrollPane scro;
	JList lt;
	JPanel pa;			//放置四个按钮
	JButton btn,btn1,btn2,btn3;
	DefaultListModel dlm;
	JFileChooser fc;
	AudioClip ac;
	public MyRedio()
	{
		initGUI();
		fc=new JFileChooser("f:/");
		this.setVisible(true);
		this.setBounds(50,80,600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	public void initGUI()
	{
		la=new JLabel();
		Icon con=new ImageIcon("F:/MyJavaClass/Redio/Pic1.jpg");
		la.setIcon(con);
		lt=new JList();
		dlm=new DefaultListModel();
		lt.setModel(dlm);
		MouseListener mouseListener = new MouseAdapter()	//鼠标
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)		//如果鼠标选中并点击两下
				{
					int index = lt.locationToIndex(e.getPoint());
					String bo=(String)dlm.getElementAt(index);
					try
					{
						URL url=new URL("file:"+bo);
						ac=Applet.newAudioClip(url);
					}
					catch(Exception ee)
					{
						System.out.println("无法播放");
					}
				}
			}
		};
		lt.addMouseListener(mouseListener);
		scro=new JScrollPane(lt);
		sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,la,scro);
		this.add(sp,BorderLayout.CENTER);
		btn=new JButton("选择路径");
		btn1=new JButton("开始");
		btn2=new JButton("暂停");
		btn3=new JButton("循环");
		/*----添加监听器----*/
		btn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		/*------------------*/
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		pa=new JPanel();
		/*----4个按钮加入容器中，并存放在窗体下方----*/
		pa.add(btn);
		pa.add(btn1);
		pa.add(btn2);
		pa.add(btn3);
		this.add(pa,BorderLayout.SOUTH);
		/*-------------------------------------------*/
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==btn)		//点击按钮"打开音频文件"
		{
			fc.setDialogTitle("选择音频文件夹");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fc.showOpenDialog(this);
			File f=fc.getSelectedFile();
			String[] filename=f.list();
			for(String st :filename)
			{
				if(st.endsWith("wav")||st.endsWith("mid"))		//令其只能选择wav和mid文件
					dlm.addElement(f.getAbsolutePath()+"\\"+st);
			}
			if(dlm.size()>0)			//如果列表框中存在文件,则使得下面按钮可以使用
			{
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
			}
		}
		else if(e.getSource()==btn1)	//点击按钮“播放”
		{
			ac.play();
		}
		else if(e.getSource()==btn2)	//点击按钮"停止"
		{
			ac.stop();
		}
		else if(e.getSource()==btn3)	//点击按钮"循环"
		{
			ac.loop();
		}			
	}
}