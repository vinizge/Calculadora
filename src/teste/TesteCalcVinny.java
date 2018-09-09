package teste;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import visao.PainelCalc;

public class TesteCalcVinny {
	
	
	public static void main(String[] args) {
		TesteCalcVinny bala= new TesteCalcVinny();
	}
	
	public TesteCalcVinny() {
		JFrame novo = new JFrame();
		novo.setLayout(new BorderLayout());
		novo.setTitle("Calculadora");
		PainelCalc nova = new PainelCalc();
		novo.setSize(400, 260);
		//novo.add(nova);
		novo.add(BorderLayout.CENTER,nova);
		novo.setLocationRelativeTo(null);
		novo.setVisible(true);
	}

}
