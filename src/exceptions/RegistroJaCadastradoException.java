package exceptions;

public class RegistroJaCadastradoException extends Exception{
	
	@Override 
	public String toString(){
		return "Esse Produto já foi Cadastrado";
	}

}
