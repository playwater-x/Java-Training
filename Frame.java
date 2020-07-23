package pingtu;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Frame extends JFrame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -5857706768468980164L;
	PTpanel pp1=new PTpanel();
    //һЩȫ�ֱ���
    int kaishi=0;
    int x=0;//�����Ӧ����
    int y=0;
    
   public Frame() {
	   //setLayout(new BorderLayout());
	  
	   pp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1) );
	   add(pp1);
	   
	   
	   //���¼�����
	   
   }
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
             Frame frame=new Frame();
             frame.setSize(1000,1000);
             frame.setTitle("����A��ƴͼ");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);
             
	}
	
	
public class PTpanel extends JPanel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7611497405896383717L;
	int[] im=new int[10];//��ʼ����Ƭ����
	int[] answer=new int[10];
	int pwidth=600;//������С
	int pheight=780;
	int w=200;//��Ƭ��С
	int h=260;
	String tupian="images";
	int steps=0;
	JPanel ctPanel=new JPanel();
	JPanel xuanzePanel=new JPanel();
	JButton jbtks=new JButton("��ʼ");
    JButton jbttc=new JButton("�˳�");
    JButton jbtzb=new JButton("���ʹ��ħ��");
	Icon icon1=new ImageIcon(this.getClass().getResource("images/��ϲ.jpg"));
	private JRadioButton jrbt1=new JRadioButton("ͼ1");
	private JRadioButton jrbt2=new JRadioButton("ͼ2");
	private JRadioButton jrbt3=new JRadioButton("ͼ3");	
	AudioClip audio1=Applet.newAudioClip(this.getClass().getResource("������.wav"));//������
	AudioClip audio2=Applet.newAudioClip(this.getClass().getResource("bgm.wav"));//������
	AudioClip audio3=Applet.newAudioClip(this.getClass().getResource("ħ��.wav"));//������
public PTpanel() {
	audio2.play();
	setLayout(new BorderLayout(760,0));
	ctPanel.setLayout(new GridLayout(1,3,150,0));
	   ctPanel.add(jbtks);
	   ctPanel.add(jbttc);
	   ctPanel.add(jbtzb);
	   add(ctPanel,BorderLayout.NORTH);
	   xuanzePanel.setLayout(new GridLayout(1,3,150,0));
	   xuanzePanel.add(jrbt1);
	   xuanzePanel.add(jrbt2);
	   xuanzePanel.add(jrbt3);
	   ButtonGroup bgr=new ButtonGroup();
		bgr.add(jrbt1);
		bgr.add(jrbt2);
		bgr.add(jrbt3);
	   add(xuanzePanel,BorderLayout.SOUTH);
	
	for(int i=0;i<10;i++) {//�±��ʼ��
		im[i]=i;
		answer[i]=i;
	}
	jrbt1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(kaishi==0)
			tupian="images";
		}
	});
jrbt2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			if(kaishi==0)
			tupian="images2";
		}
	});
jrbt3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(kaishi==0)
		tupian="images3";
	}
});
	jbtks.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
		kaishi=1;
		steps=0;
			for(int i=1;i<=8;i++) {
				int rd=(int)(Math.random()*8+1);
				int temp=im[i];
				im[i]=im[rd];
				im[rd]=temp;
			}
			repaint();
		}
	});
	jbttc.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			System.exit(EXIT_ON_CLOSE);
		}
	});
	jbtzb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			for(int i=1;i<=8;i++) {
				im[i]=i;
			}
			im[0]=0;
			repaint();
			audio3.play();
		}
	});
	//��������
	this.addMouseListener(new MouseActionListener());
     }
class MouseActionListener extends MouseAdapter{
    public void mousePressed(MouseEvent e){
    x=e.getX();
    y=e.getY();
    int t=0;
    int num=0;
    if(x>=150&&y>=50&&x<=750&&y<=830&&kaishi==1) {
    	//1�ж��ұ�
    if(x<=(750-200)&&im[(((int)((x-150+200)/200)+3*(int)((y-50)/260))+1)%9]==0){
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150+200)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150+200)/200)+3*(int)((y-50)/260))+1)%9]=t;
    	steps++;
    	audio1.play();
    }
    //2�ж����
    if(x>=350&&im[(((int)((x-150-200)/200)+3*(int)((y-50)/260))+1)%9]==0) {
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150-200)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150-200)/200)+3*(int)((y-50)/260))+1)%9]=t;
    	steps++;audio1.play();
    }
    //3�ж��ϱ�
    if(y>310&&im[(((int)((x-150)/200)+3*(int)((y-50-260)/260))+1)%9]==0) {
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150)/200)+3*(int)((y-50-260)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50-260)/260))+1)%9]=t;
    	steps++;audio1.play();
    }
    //4�ж��±�
    if(y<=570&&im[(((int)((x-150)/200)+3*(int)((y-50+260)/260))+1)%9]==0) {
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150)/200)+3*(int)((y-50+260)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50+260)/260))+1)%9]=t;
    	steps++;audio1.play();
    }
    	
    repaint();
    }
    if(kaishi==1) {
    for(int j=1;j<=8;j++) {
    	if(im[j]==answer[j]) num+=1;
    }
    if(num==8) {
    	kaishi=0;
    	repaint();
    	
    	JOptionPane.showMessageDialog(null,"������",null,0,icon1);
    	
    }}
    
    }
}
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawLine(150,49,750,49);
	g.drawLine(149,50,149,830);
	g.drawLine(150,830,750,830);
	g.drawLine(750,830,750,50);
	setFont(new Font("Times New", 11, 28));
	g.drawString("�Ѿ�����"+steps+"����", 300, 880);
	if(kaishi==0) {
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[1]+".jpg")).getImage(),150,50,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[2]+".jpg")).getImage(),150+w,50,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[3]+".jpg")).getImage(),150+2*w,50,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[4]+".jpg")).getImage(),150,50+h,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[5]+".jpg")).getImage(),150+w,50+h,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[6]+".jpg")).getImage(),150+2*w,50+h,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[7]+".jpg")).getImage(),150,50+2*h,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[8]+".jpg")).getImage(),150+w,50+2*h,pp1);
	g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[9]+".jpg")).getImage(),150+2*w,50+2*h,pp1);}
	else{
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[1]+".jpg")).getImage(),150,50,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[2]+".jpg")).getImage(),150+w,50,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[3]+".jpg")).getImage(),150+2*w,50,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[4]+".jpg")).getImage(),150,50+h,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[5]+".jpg")).getImage(),150+w,50+h,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[6]+".jpg")).getImage(),150+2*w,50+h,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[7]+".jpg")).getImage(),150,50+2*h,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[8]+".jpg")).getImage(),150+w,50+2*h,pp1);
		g.drawImage(new ImageIcon(this.getClass().getResource(tupian+"/"+im[0]+".jpg")).getImage(),150+2*w,50+2*h,pp1);
	}
}

  }
	
}
