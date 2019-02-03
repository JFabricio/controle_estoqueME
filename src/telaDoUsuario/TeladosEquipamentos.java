package telaDoUsuario;


import javax.swing.JOptionPane;
import dao.DaoGenerics;
import dao.EquipamentoDao;
import entidade.EquipamentoEsportivo;
import exceptions.RegistroNaoCadastradoException;
import exceptions.RegistroJaCadastradoException;



public class TeladosEquipamentos {

	public static void main(String[] args) {

		//Dados são apresentados no console 
			
		/* Senha para acesso de sistema opicional
		 * 
		 * String senha =""; 
		 * 
		do{
		senha = JOptionPane.showInputDialog("SENHA:");
		
			if(!senha.equalsIgnoreCase( "ifpe")){
					System.out.println("Dica de senha: \n" + "Instituto Federal de Pernambuco");
			}		
			
		}while(!senha.equalsIgnoreCase("ifpe"));
		
			
		*/	
			
		String opcao = "";
	
		 
		DaoGenerics<EquipamentoEsportivo> daoEquipamento = new EquipamentoDao();
		
		
		
		
			opcao = JOptionPane.showInputDialog(" 1 -  INSERIR um novo equipamento \n"+ 
		" 2 -  ALTERAR os dados dos equipamentos \n"+
		" 3 -  LER os detalhes dos equipamentos \n"+
		" 4 -  DELETAR os dados de um equipamento \n"+
		" 0 -  para SAIR ");
		
		while(!opcao.equals("0")){
			if(opcao.equals("1")){       //Inserir
				
				try{
				EquipamentoEsportivo equip = new EquipamentoEsportivo();
				
				equip.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto:")));
				equip.setNome(JOptionPane.showInputDialog("Digite o nome do produto:"));
				equip.setEsporteRelacionado(JOptionPane.showInputDialog("Digite o nome do esporte relacionado:"));
				equip.setMarca(JOptionPane.showInputDialog("Qual a marca do seu produto:"));
				equip.setModelo(JOptionPane.showInputDialog("Qual modelo do seu produto"));
				equip.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Qual o preco do produto:")));
				equip.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade do Produto")));
				
				
				daoEquipamento.inserir(equip);
				System.out.println("Seu produto foi cadastrado com Sucesso!");
				
				}catch(RegistroJaCadastradoException arg){
					System.out.println(arg);
				}catch(NumberFormatException n ){
					System.out.println("Deve ser digitado apenas numeros nesse campo");
				}
			}
			
			else if(opcao.equals("2")){          //Alterar
				
				try{
				String opcao1 = "";
			
				int idproduto = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do produto á ser ALTERADO"));
				
	
				 EquipamentoEsportivo equipamento = daoEquipamento.ler (idproduto);
				
				 System.out.println("O Produto selecionado para ser ALTERADO  é :  " );
				 System.out.println("###############################");
				 System.out.println("ID: "+ equipamento.getIdProduto());
				 System.out.println("Nome: "+equipamento.getNome());
				 System.out.println("Esporte Relacionado: "+equipamento.getEsporteRelacionado());
				 System.out.println("Marca: "+equipamento.getMarca());
				 System.out.println("Modelo: "+equipamento.getModelo());
				 System.out.println("Preço: "+equipamento.getPreco());
				 System.out.println("Quantidade: "+equipamento.getQuantidade());
				 System.out.println("################################");
				
				 opcao1 = JOptionPane.showInputDialog("Qual elemento do produto  "+equipamento.getNome()+ "  você deseja alterar:" + "\n" 
				 +"1 - ID" + "\n" + "2 - Nome" + "\n" + "3 - Esporte Relacionado" + "\n" + "4 - Marca" + "\n" + "5- Modelo"+"\n"
				 +"6 - Preço" + "\n" + "7 - Quantidade" + "\n"
				+"8 - Todos Elementos"+"\n" + "0 - Para Sair");
				  
				 while(!opcao1.equals("0")){
					 if(opcao1.equals("1")){
						  equipamento.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto ")));
				  }else if(opcao1.equals("2")){
					  equipamento.setNome(JOptionPane.showInputDialog("Digite o Nome do produto")); 
				  }else if(opcao1.equals("3")){
					  equipamento.setEsporteRelacionado(JOptionPane.showInputDialog("Digite o Esporte Relacionado ao Produto"));
				  }else if(opcao1.equals("4")){
					  equipamento.setMarca(JOptionPane.showInputDialog("Digite a Marca do produto"));
				  }else if(opcao1.equals("5")){
					  equipamento.setModelo(JOptionPane.showInputDialog("Digite o Modelo do Produto"));
				  }else if (opcao1.equals("6")){
					  equipamento.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o Preço do Produto ")));
				  }else if(opcao1.equals("7")){
					  equipamento.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade do Produto")));
				  }else if(opcao1.equals("8")){
					  equipamento.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto ")));
					  equipamento.setNome(JOptionPane.showInputDialog("Digite o Nome do produto")); 
					  equipamento.setEsporteRelacionado(JOptionPane.showInputDialog("Digite o Esporte Relacionado ao Produto"));
					  equipamento.setMarca(JOptionPane.showInputDialog("Digite a Marca do produto"));
					  equipamento.setModelo(JOptionPane.showInputDialog("Digite o Modelo do Produto"));
					  equipamento.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o Preço do Produto ")));
					  equipamento.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a Quantidade do Produto")));
				  }
					 opcao1 = JOptionPane.showInputDialog("Qual elemento de  "+equipamento.getNome()+ " você deseja alterar:" + "\n" 
							 +"1 - ID" + "\n" + "2 - Nome" + "\n" + "3  - Esporte Relacionado" + "\n" + "4 - Marca" + "\n" + "5 - Modelo"+"\n"
							 +"6 - Preço" + "\n" + "7 - Quantidade" + "\n"
							+"8 - Todos Elementos"+"\n" + "0 - Para Sair");
				  }
					  
				 daoEquipamento.alterar(equipamento);
			}catch(RegistroNaoCadastradoException arg){
				System.out.println(arg);
			}catch(NumberFormatException n){
				System.out.println("Deve ser digitado apenas numero nesse campo");
			}
			}
			else if(opcao.equals("3")){      //Ler
				
				try{
					
					String opcao2 = "";
					
				 int idproduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o IdProduto"));
				
				EquipamentoEsportivo equipamento = daoEquipamento.ler(idproduto);
				
				if(!equipamento.equals(null)){
					
					opcao2 = JOptionPane.showInputDialog("Detalhes do produto: "+equipamento.getNome()+"\n"+
							"1- Esporte Relacionado \n"+
							"2 - Marca \n"+
							"3 - Modelo \n"+
							"4 - Preço \n"+
							"5 - Quantidade \n"+
							"6 - Todos detalhes \n" +
							"0 - Sair");
					
					while(!opcao2.equals("0")){
						
						if(opcao2.equals("1")){
							System.out.println("Detalhe do produto:");
							System.out.println("**************");
							System.out.println("Esporte Relacionado: "+equipamento.getEsporteRelacionado());
							System.out.println("**************");
						}
						else if(opcao2.equals("2")){
							System.out.println("Detalhe do produto:");
							System.out.println("**************");
							System.out.println("Marca: "+equipamento.getMarca());
							System.out.println("**************");
						}
						else if(opcao2.equals("3")){
							System.out.println("Detalhe do produto:");
							System.out.println("**************");
							System.out.println("Modelo: "+equipamento.getModelo());
							System.out.println("**************");
						}
						else if(opcao2.equals("4")){
							System.out.println("Detalhe do produto:");
							System.out.println("**************");
							System.out.println("Preço: "+equipamento.getPreco());
							System.out.println("**************");
						}
						else if(opcao2.equals("5")){
							System.out.println("Detalhe do produto:");
							System.out.println("**************");
							System.out.println("Quantidade: "+equipamento.getQuantidade());
							System.out.println("**************");
						}
						else if(opcao2.equals("6")){
							System.out.println("Detalhe do produto:");
							System.out.println("*********************");
							System.out.println("ID: "+ equipamento.getIdProduto());
							 System.out.println("Nome: "+equipamento.getNome());
							 System.out.println("Esporte Relacionado: "+equipamento.getEsporteRelacionado());
							 System.out.println("Marca: "+equipamento.getMarca());
							 System.out.println("Modelo: "+equipamento.getModelo());
							 System.out.println("Preço: "+equipamento.getPreco());
							 System.out.println("Quantidade: "+equipamento.getQuantidade());
							System.out.println("*********************");
						}
						
						
						opcao2 = JOptionPane.showInputDialog("Detalhes do produto: "+equipamento.getNome()+"\n"+
								"1- Esporte Relacionado \n"+
								"2 - Marca \n"+
								"3 - Modelo \n"+
								"4 - Preço \n"+
								"5 - Quantidade \n"+
								"6 - Todos detalhes \n" +
								"0 - Sair");
						
					} 
				}
			}catch(RegistroNaoCadastradoException arg){
				System.out.println(arg);
			}catch(NumberFormatException n){
					System.out.println("Deve ser digitado apenas numero nesse campo");
			}
		}		
			else if(opcao.equals("4")){    //Deletar
				
				try{
				int idproduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto a ser DELETADO!"));
			
				String confirmacao = "";
				
				confirmacao = JOptionPane.showInputDialog("Tem certeza que deseja EXCLUIR esse produto? \n"+"1 - Sim \n"+"2 - Não");
		
					if(confirmacao.equals("1")){
						  EquipamentoEsportivo equipamento = daoEquipamento.ler(idproduto);
						
						daoEquipamento.deletar(equipamento);
						System.out.println("O produto foi deletado com sucesso");
					}
			}catch(RegistroNaoCadastradoException arg){
				System.out.println(arg);
			}catch(NumberFormatException n){
				System.out.println("Deve ser digitado apenas numero nesse campo");
			}
				
	}
			
			
			opcao = JOptionPane.showInputDialog(" 1 -  INSERIR um novo equipamento \n"+ 
					" 2 -  ALTERAR os dados dos equipamentos \n"+
					" 3 -  LER os detalhes dos equipamentos \n"+
					" 4 -  DELETAR os dados de um equipamento \n"+
					" 0 -  para SAIR ");
		}
		
		
		
		
		
		
		
			
		

	}
	}
	

