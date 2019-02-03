package exceptions;

public class RegistroNaoCadastradoException extends Exception{
	
	@Override 
	public String toString(){
		return "Esse Produto não está cadastrado";
	}

}
