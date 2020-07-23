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
    //一些全局变量
    int kaishi=0;
    int x=0;//鼠标响应变量
    int y=0;
    
   public Frame() {
	   //setLayout(new BorderLayout());
	  
	   pp1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1) );
	   add(pp1);
	   
	   
	   //以下监听器
	   
   }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
             Frame frame=new Frame();
             frame.setSize(1000,1000);
             frame.setTitle("哆啦A梦拼图");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setLocationRelativeTo(null);
             frame.setVisible(true);
             
	}
	
	
public class PTpanel extends JPanel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7611497405896383717L;
	int[] im=new int[10];//初始化碎片数组
	int[] answer=new int[10];
	int pwidth=600;//画布大小
	int pheight=780;
	int w=200;//碎片大小
	int h=260;
	String tupian="images";
	int steps=0;
	JPanel ctPanel=new JPanel();
	JPanel xuanzePanel=new JPanel();
	JButton jbtks=new JButton("开始");
    JButton jbttc=new JButton("退出");
    JButton jbtzb=new JButton("点击使用魔法");
	Icon icon1=new ImageIcon(this.getClass().getResource("images/恭喜.jpg"));
	private JRadioButton jrbt1=new JRadioButton("图1");
	private JRadioButton jrbt2=new JRadioButton("图2");
	private JRadioButton jrbt3=new JRadioButton("图3");	
	AudioClip audio1=Applet.newAudioClip(this.getClass().getResource("落子声.wav"));//落子音
	AudioClip audio2=Applet.newAudioClip(this.getClass().getResource("bgm.wav"));//落子音
	AudioClip audio3=Applet.newAudioClip(this.getClass().getResource("魔法.wav"));//落子音
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
	
	for(int i=0;i<10;i++) {//下标初始化
		im[i]=i;
		answer[i]=i;
	}
	jrbt1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(kaishi==0)
			tupian="images";
		}
	});
jrbt2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(kaishi==0)
			tupian="images2";
		}
	});
jrbt3.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(kaishi==0)
		tupian="images3";
	}
});
	jbtks.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
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
			// TODO 自动生成的方法存根
			System.exit(EXIT_ON_CLOSE);
		}
	});
	jbtzb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			for(int i=1;i<=8;i++) {
				im[i]=i;
			}
			im[0]=0;
			repaint();
			audio3.play();
		}
	});
	//鼠标监听器
	this.addMouseListener(new MouseActionListener());
     }
class MouseActionListener extends MouseAdapter{
    public void mousePressed(MouseEvent e){
    x=e.getX();
    y=e.getY();
    int t=0;
    int num=0;
    if(x>=150&&y>=50&&x<=750&&y<=830&&kaishi==1) {
    	//1判断右边
    if(x<=(750-200)&&im[(((int)((x-150+200)/200)+3*(int)((y-50)/260))+1)%9]==0){
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150+200)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150+200)/200)+3*(int)((y-50)/260))+1)%9]=t;
    	steps++;
    	audio1.play();
    }
    //2判断左边
    if(x>=350&&im[(((int)((x-150-200)/200)+3*(int)((y-50)/260))+1)%9]==0) {
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150-200)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150-200)/200)+3*(int)((y-50)/260))+1)%9]=t;
    	steps++;audio1.play();
    }
    //3判断上边
    if(y>310&&im[(((int)((x-150)/200)+3*(int)((y-50-260)/260))+1)%9]==0) {
    	t=im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50)/260))+1)%9]=im[(((int)((x-150)/200)+3*(int)((y-50-260)/260))+1)%9];
    	im[(((int)((x-150)/200)+3*(int)((y-50-260)/260))+1)%9]=t;
    	steps++;audio1.play();
    }
    //4判断下边
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
    	
    	JOptionPane.showMessageDialog(null,"不错呦",null,0,icon1);
    	
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
	g.drawString("已经走了"+steps+"步了", 300, 880);
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
