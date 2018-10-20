package fczachor.cipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cView extends JFrame{
	private cModel m1;
	private cController c1;
	private cPanel p1;
	private JButton en, de;
	private JRadioButton sh, su, ke;
	private JTextField text, sAlpha, value, keyword;
	private JPanel pa1, pa2, pa3;
	private JLabel te, sA, va, key;
	private Container co1, co2, co3, co4;
	private ButtonGroup rgb;
	
	public cView(cController c, cModel m) {
		this.m1 = m;
		this.c1 = c;
		this.p1 = new cPanel(this.m1);
		
		this.setSize(500, 500);
		
		this.en = new JButton("encrypt");
		this.de = new JButton("decrypt");
		
		this.sh = new JRadioButton("Shift-Cipher");
		this.su = new JRadioButton("Substitution-Cipher", true);
		this.ke = new JRadioButton("Keyword-Cipher");
		
		this.text = new JTextField();
		this.sAlpha = new JTextField();
		this.value = new JTextField();
		this.keyword= new JTextField();
		
		this.pa1 = new JPanel();
		this.pa2 = new JPanel();
		this.pa3 = new JPanel();
		
		this.te = new JLabel("Text: ");
		this.sA = new JLabel("Secret Alphabet: ");
		this.va = new JLabel("Shift-value: ");
		this.key = new JLabel("Keyword: ");
		
		this.co1 = new Container();
		this.co2 = new Container();
		this.co3 = new Container();
		this.co4 = new Container();
		
		this.rgb = new ButtonGroup();
		
		this.rgb.add(this.su);
		this.rgb.add(this.sh);
		this.rgb.add(this.ke);
		
		this.en.addActionListener(this.c1);
		this.de.addActionListener(this.c1);
		this.su.addActionListener(this.c1);
		this.sh.addActionListener(this.c1);
		
		this.setLayout(new BorderLayout());
		this.pa1.setLayout(new GridLayout(3, 1));
		this.pa2.setLayout(new BorderLayout());
		this.pa3.setLayout(new GridLayout());
		this.co1.setLayout(new GridLayout());
		this.co2.setLayout(new GridLayout());
		this.co3.setLayout(new GridLayout());
		this.co4.setLayout(new GridLayout());
		
		this.co1.add(this.te);
		this.co1.add(this.text);
		this.co2.add(this.va);
		this.co2.add(this.value);
		this.co3.add(this.sA);
		this.co3.add(this.sAlpha);
		this.co4.add(this.key);
		this.co4.add(this.keyword);
		
		this.pa3.add(this.sh);
		this.pa3.add(this.su);
		this.pa3.add(this.ke);
		
		
		this.pa2.add(this.pa3, BorderLayout.NORTH);
		this.pa2.add(this.co1, BorderLayout.SOUTH);
		
		this.pa1.add(this.co3);
		this.pa1.add(this.co2);
		this.pa1.add(this.co4);
		
		this.add(this.p1);
		this.add(this.pa2, BorderLayout.NORTH);
		this.add(this.pa1, BorderLayout.SOUTH);
		this.add(this.en, BorderLayout.WEST);
		this.add(this.de, BorderLayout.EAST);
		
		this.setVisible(true);
	}
	public void refresh() {
		this.p1.repaint();
	}
	public boolean isEnPressed(ActionEvent e) {
		if(e.getSource()==this.en) return true;
		return false;
	}
	public boolean isDePressed(ActionEvent e) {
		if(e.getSource()==this.de) return true;
		return false;
	}
	public boolean isShChecked() {
		if(this.sh.isSelected()) return true;
		return false;
	}
	public boolean isSuChecked() {
		if(this.su.isSelected()) return true;
		return false;
	}
	public boolean isKeyChecked() {
		if(this.ke.isSelected()) return true;
		return false;
	}
	public String getKey() {
		return this.keyword.getText();
	}
	public String getValue() {
		return this.value.getText();
	}
	public String getSAlpha() {
		return this.sAlpha.getText();
	}
	public String getText() {
		return this.text.getText();
	}
}