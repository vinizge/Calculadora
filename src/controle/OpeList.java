package controle;

import javax.swing.ComboBoxModel;

import modelo.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

@SuppressWarnings("serial")
public class OpeList extends AbstractListModel<Operacao> implements ComboBoxModel<Operacao>{

	private List<Operacao> listaOpe;
	private Operacao opeSel;
	
	public OpeList () {
		this.listaOpe = new ArrayList<>();
	}
	public Operacao getElementAt(int index) {
		return this.listaOpe.get(index);
	}

	public int getSize() {
		return listaOpe.size();
	}

	@Override
	public Operacao getSelectedItem() {
		return this.opeSel;
	}

	@Override
	public void setSelectedItem(Object element) {
		if(element instanceof Operacao) {
		this.opeSel = (Operacao) element;
		fireContentsChanged(this.listaOpe, 0, this.listaOpe.size());
		}
	}
	
	public void addOperacao(Operacao nova) {
		this.listaOpe.add(nova);
	}
	
	
}
