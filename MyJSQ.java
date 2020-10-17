import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class MyJSQ extends JFrame implements ActionListener
{
	JMenuBar bar;
	JMenu me1,me2;
	JMenuItem it11,it12,it13,it14,it15,it21;
	JTextField tf;
	JPanel pa;
	JButton [] btn;
	String [] str={"0","1","2","3","4","5","6","7","8","9","+","-","*","/","C","="};
	GridLayout grid;
	public MyJSQ(String s)
	{
		initMenu();
		initButton();
		this.validate();
		this.setBounds(550,300,200,280);
		this.setResizable(false);
		this.setTitle(s);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initMenu()
	{
		bar=new JMenuBar();
		me1=new JMenu("�༭");
		me2=new JMenu("����");
		it11=new JMenuItem("����");
		it12=new JMenuItem("ճ��");
		it13=new JMenuItem("�˳�");
		it14=new JMenuItem("������");
		it15=new JMenuItem("ʮ����");
		it21=new JMenuItem("���ڼ�����");
		it11.addActionListener(this);
		it12.addActionListener(this);
		it13.addActionListener(this);
		it14.addActionListener(this);
		it15.addActionListener(this);
		it21.addActionListener(this);
		me1.add(it11);
		me1.add(it12);
		me1.add(it14);
		me1.add(it15);
		me1.addSeparator();
		me1.add(it13);
		me2.add(it21);
		bar.add(me1);
		bar.add(me2);
		this.setJMenuBar(bar);
	}
	public void initButton()
	{
		tf=new JTextField("0");
		//tf.setEditable(false);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setFont(new Font("΢���ź�",Font.PLAIN,20));
		pa=new JPanel();
		btn=new JButton[16];
		for(int i=0;i<btn.length;i++)
		{
			btn[i]=new JButton(str[i]);
			btn[i].addActionListener(this);
		}
		grid=new GridLayout(4,4);
		pa.setLayout(grid);
		pa.add(btn[7]);
		pa.add(btn[8]);
		pa.add(btn[9]);
		pa.add(btn[13]);
		pa.add(btn[4]);
		pa.add(btn[5]);
		pa.add(btn[6]);
		pa.add(btn[12]);
		pa.add(btn[1]);
		pa.add(btn[2]);
		pa.add(btn[3]);
		pa.add(btn[11]);
		pa.add(btn[0]);
		pa.add(btn[15]);
		pa.add(btn[14]);
		pa.add(btn[10]);
		this.add(tf,BorderLayout.NORTH);
		this.add(pa,BorderLayout.CENTER);
	}
	String s="";
	public void actionPerformed(ActionEvent e)
	{
		String temp=e.getActionCommand();
		if(temp.equals("C"))
		{
			s="";
			tf.setText(s);
		}
		else if(temp.equals("0")||temp.equals("1")||temp.equals("2")||
				temp.equals("3")||temp.equals("4")||temp.equals("5")||
				temp.equals("6")||temp.equals("7")||temp.equals("8")||
				temp.equals("9"))
				{
					s+=temp;
					tf.setText(s);
				}
		else if(temp.equals("+")||temp.equals("-")||temp.equals("*")||
				temp.equals("/"))
				{
					int d=s.indexOf(" ");
					if(d>=0 && d+1<s.length()-1)
					{
						double a=Double.parseDouble(s.substring(0,d));
						String op=s.substring(d+1,d+2);
						double b=Double.parseDouble(s.substring(d+2));
						double result=0;
						switch(op)
						{
							case "+":result=a+b;break;
							case "-":result=a-b;break;
							case "*":result=a*b;break;
							case "/":result=a/b;;break;
						}
						s=result+" "+temp;
						tf.setText(s);
					}
					else if(d>=0)
					{
						s=s.substring(0,d)+" "+temp;
						tf.setText(s);
					}
					else
					{
						s=s+" "+temp;
						tf.setText(s);
					}
				}
				else
				{
					 int d=s.indexOf(" ");
					 if(d>=0 && d+1<s.length()-1)
					 {
						 						double a=Double.parseDouble(s.substring(0,d));
						String op=s.substring(d+1,d+2);
						double b=Double.parseDouble(s.substring(d+2));
						double result=0;
						switch(op)
						{
							case "+":result=a+b;break;
							case "-":result=a-b;break;
							case "*":result=a*b;break;
							case "/":result=a/b;;break;
						}
						s=result+"";
						tf.setText(s);
					 }
					 else if(d>=0)
					 {
						 s=s.substring(0,d);
						 tf.setText(s);
					 }
				}
	if(e.getSource()==it13)			//����˳���ť
	{
		this.dispose();
	}
	else if(e.getSource()==it11)	//������ư�ť
	{
		tf.copy();
	}
	else if(e.getSource()==it12)	//���ճ����ť
	{
		tf.setEditable(true);
		tf.paste();
	}
	else if(e.getSource()==it14)	//��������ư�ť
	{
		int d=Integer.parseInt(tf.getText());
		s=Integer.toString(d,2);
		tf.setText(s);
	}
	else if(e.getSource()==it15)	//���ʮ���ư�ť
	{
		int d=Integer.parseInt(s,2);
		s=d+"";
		tf.setText(s);
	}
	else if(e.getSource()==it21)	//���������ť
	{
		JOptionPane.showMessageDialog(this,"made in Mr.li","ע�⣡",JOptionPane.INFORMATION_MESSAGE);
	}
	}
}