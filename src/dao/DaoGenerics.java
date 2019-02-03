package dao;


import exceptions.RegistroJaCadastradoException;
import exceptions.RegistroNaoCadastradoException;

public interface DaoGenerics <T>{
	
	public void inserir(T t) throws RegistroJaCadastradoException;
	public void alterar(T t) throws RegistroNaoCadastradoException;
	public T  ler(int idProduto)throws RegistroNaoCadastradoException;
	public void deletar(T t) ;

}
