package visao;

import javax.swing.JPanel;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import modelo.*;
import controle.*;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PainelCalc extends JPanel {
	private OpeList listaOpe;
	private Operacao novaOpe;
	private JTextArea textArea;
	private JScrollPane scroll;
	private String str[];
	/**
	 * Create the panel.
	 */
	public PainelCalc() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		setSize(383, 228);
				
		
		JLabel lblTela = new JLabel("Opera\u00E7\u00E3o :");
		lblTela.setBounds(25, 26, 63, 14);
		add(lblTela);
		
		listaOpe = new OpeList();
		listaOpe.addOperacao(new Soma());
		listaOpe.addOperacao(new OperacaoDoida());
		listaOpe.addOperacao(new RaizQuadrada());
		listaOpe.addOperacao(new Subtracao());
		
		JComboBox comboBox = new JComboBox(listaOpe);
		comboBox.setBounds(92, 26, 164, 22);
		add(comboBox);
		scroll = new JScrollPane();
		scroll.setLocation(266, 20);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setSize(108,187);
		this.add(scroll);
		
		textArea = new JTextArea();
		scroll.setViewportView(textArea);
		textArea.setBackground(new Color(0, 250, 154));
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(25, 59, 113, 23);
		btnCalcular.addActionListener(new CalcBotao());
		add(btnCalcular);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(148, 59, 108, 23);
		btnLimpar.addActionListener(new botLimpar());
		add(btnLimpar);
		
		JButton button = new JButton("1");
		button.setBounds(25, 98, 45, 34);
		button.addActionListener(new bot1());
		add(button);
		
		JButton btnNewButton = new JButton("2");
		btnNewButton.setBounds(74, 98, 45, 34);
		btnNewButton.addActionListener(new bot2());
		add(btnNewButton);
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(123, 98, 45, 34);
		button_1.addActionListener(new bot3());
		add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(25, 138, 45, 34);
		button_2.addActionListener(new bot4());
		add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(75, 138, 45, 34);
		button_3.addActionListener(new bot5());
		add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(123, 138, 45, 34);
		button_4.addActionListener(new bot6());
		add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.setBounds(25, 178, 45, 34);
		button_5.addActionListener(new bot7());		
		add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(75, 178, 45, 34);
		button_6.addActionListener(new bot8());
		add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(123, 178, 45, 34);
		button_7.addActionListener(new bot9());
		add(button_7);
		
		JButton btnNewButton_1 = new JButton(".");
		btnNewButton_1.setBounds(172, 99, 84, 26);
		btnNewButton_1.addActionListener(new botPonto());
		add(btnNewButton_1);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBounds(172, 133, 84, 79);
		btnEnter.addActionListener(new botEnter());
		add(btnEnter);
		scroll.setVisible(true);
		
		
	}
	
	private class CalcBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			novaOpe = listaOpe.getSelectedItem();
			JViewport vp = scroll.getViewport();  
			for(Component comp : vp.getComponents()){  
			    if(comp instanceof JTextArea){  
			        JTextArea jta = (JTextArea) comp;  
			        str =jta.getText().split("\n");
			    } 
			    for(int i = 0; i<novaOpe.getNumeroOperandos();i++) {
			    	novaOpe.addOperando( Double.parseDouble(str[i]));
			    }
			}
			String resposta = "A resposta é: "+Double.toString(novaOpe.calcular());
			System.out.printf(resposta);
			JOptionPane.showMessageDialog(null, resposta);
			textArea.setText("");
		}
	}
	
	private class bot1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("1");
					}
						else {
							jta.setText(jta.getText()+"1");
						}
					}
				}
			}
		}
	
	private class bot2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("2");
					}
						else {
							jta.setText(jta.getText()+"2");
						}
					}
				}
			}
		}
	
	private class bot3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("3");
					}
						else {
							jta.setText(jta.getText()+"3");
						}
					}
				}
			}
		}
	
	private class bot4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("4");
					}
						else {
							jta.setText(jta.getText()+"4");
						}
					}
				}
			}
		}
	
	private class bot5 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("5");
					}
						else {
							jta.setText(jta.getText()+"5");
						}
					}
				}
			}
		}
	
	private class bot6 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("6");
					}
						else {
							jta.setText(jta.getText()+"6");
						}
					}
				}
			}
		}
	
	private class bot7 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("7");
					}
						else {
							jta.setText(jta.getText()+"7");
						}
					}
				}
			}
		}
	
	private class bot8 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("8");
					}
						else {
							jta.setText(jta.getText()+"8");
						}
					}
				}
			}
		}
	
	private class bot9 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("9");
					}
						else {
							jta.setText(jta.getText()+"9");
						}
					}
				}
			}
		}
	
	private class botEnter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText("\n");
					}
						else {
							jta.setText(jta.getText()+"\n");
						}
					}
				}
			}
		}
	
	private class botPonto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					if(jta.getText() == null || jta.getText().isEmpty()) {
						jta.setText(".");
					}
						else {
							jta.setText(jta.getText()+".");
						}
					}
				}
			}
		}
	
	private class botLimpar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JViewport vp = scroll.getViewport();
			for(Component comp : vp.getComponents()) {
				if(comp instanceof JTextArea) {
					JTextArea jta = (JTextArea) comp;
					jta.setText("");
					}
				}
			}
		}
	}

