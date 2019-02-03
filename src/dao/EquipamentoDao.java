package dao;

import java.util.ArrayList;
import java.util.List;

import entidade.EquipamentoEsportivo;
import exceptions.RegistroJaCadastradoException;
import exceptions.RegistroNaoCadastradoException;

public class EquipamentoDao implements DaoGenerics<EquipamentoEsportivo>{
	
	private List<EquipamentoEsportivo> equip ;
	
	public EquipamentoDao(){
		this.equip = new ArrayList<EquipamentoEsportivo>();
	}

	
	public void inserir(EquipamentoEsportivo t) throws RegistroJaCadastradoException{
		for(EquipamentoEsportivo equip : this.equip){
			if(equip.getIdProduto() == t.getIdProduto()){
				throw new RegistroJaCadastradoException();
			}
		}
		
		
		this.equip .add(t);
	}
	

	public void alterar(EquipamentoEsportivo t) throws RegistroNaoCadastradoException{
	
		for(EquipamentoEsportivo e : this.equip){
			if(e.getIdProduto() == t.getIdProduto()){
				e .setIdProduto(t.getIdProduto());
				e.setEsporteRelacionado(t.getEsporteRelacionado());
				e.setNome(t.getNome());
				e.setMarca(t.getMarca());
				e.setModelo(t.getModelo());
				e.setPreco(t.getPreco());
				e.setQuantidade(t.getQuantidade());
				System.out.println("Seu produto foi alterado com sucesso!!");
			}
		}
		throw new RegistroNaoCadastradoException();
}
	
	public EquipamentoEsportivo ler(int idProduto) throws RegistroNaoCadastradoException{
		for(EquipamentoEsportivo e : this.equip){
			if(e.getIdProduto() == idProduto){
				return e;
			}
		}
		throw new RegistroNaoCadastradoException();
	}
	
	
	
	public void deletar(EquipamentoEsportivo t){
		this.equip.remove(t);
	}
	
	
	
	
	
	
	
	
	
	
	
}
