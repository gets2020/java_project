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
	JPanel pa;			//�����ĸ���ť
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
		MouseListener mouseListener = new MouseAdapter()	//���
		{
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)		//������ѡ�в��������
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
						System.out.println("�޷�����");
					}
				}
			}
		};
		lt.addMouseListener(mouseListener);
		scro=new JScrollPane(lt);
		sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,la,scro);
		this.add(sp,BorderLayout.CENTER);
		btn=new JButton("ѡ��·��");
		btn1=new JButton("��ʼ");
		btn2=new JButton("��ͣ");
		btn3=new JButton("ѭ��");
		/*----��Ӽ�����----*/
		btn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		/*------------------*/
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		pa=new JPanel();
		/*----4����ť���������У�������ڴ����·�----*/
		pa.add(btn);
		pa.add(btn1);
		pa.add(btn2);
		pa.add(btn3);
		this.add(pa,BorderLayout.SOUTH);
		/*-------------------------------------------*/
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==btn)		//�����ť"����Ƶ�ļ�"
		{
			fc.setDialogTitle("ѡ����Ƶ�ļ���");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fc.showOpenDialog(this);
			File f=fc.getSelectedFile();
			String[] filename=f.list();
			for(String st :filename)
			{
				if(st.endsWith("wav")||st.endsWith("mid"))		//����ֻ��ѡ��wav��mid�ļ�
					dlm.addElement(f.getAbsolutePath()+"\\"+st);
			}
			if(dlm.size()>0)			//����б���д����ļ�,��ʹ�����水ť����ʹ��
			{
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
			}
		}
		else if(e.getSource()==btn1)	//�����ť�����š�
		{
			ac.play();
		}
		else if(e.getSource()==btn2)	//�����ť"ֹͣ"
		{
			ac.stop();
		}
		else if(e.getSource()==btn3)	//�����ť"ѭ��"
		{
			ac.loop();
		}			
	}
}