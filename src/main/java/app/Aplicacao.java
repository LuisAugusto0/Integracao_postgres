package app;

import java.util.List;
import java.util.Scanner;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
      
        int resposta = 0;   
        
        while(resposta != -1) {
            System.out.println(" Menu: ");
            System.out.println("[1] - Inserir usuário");
            System.out.println("[2] - Listar usuários");
            System.out.println("[3] - Excluir usuário");
            System.out.println("[4] - Atualizar usuário");
            System.out.println("Escolha o que deseja acessar: ");
            resposta = scanner.nextInt();
            
            switch(resposta) {
                case 1:
                    System.out.println("Codigo: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Login: ");
                    String login = scanner.nextLine();
                    
                    System.out.println("Senha: ");
                    String senha = scanner.nextLine();
                    
                    System.out.println("Sexo (M/F): ");
                    char sexo = scanner.nextLine().charAt(0);
                    
                    Usuario usuario = new Usuario(codigo, login, senha, sexo);
                    
                    usuarioDAO.insert(usuario);
                    break;
                
                case 2:
                    List<Usuario> usuarios = usuarioDAO.get();
                    System.out.println("Usuários registrados: ");
                    System.out.println(usuarios);
                    break;
                
                case 3:
                    System.out.println("Digite o código do usuário que deseja excluir: ");
                    int codigoAExcluir = scanner.nextInt();
                    usuarioDAO.delete(codigoAExcluir);
                    break;
                
                case 4:
                    System.out.println("Digite o código do usuário que deseja atualizar informações: ");
                    int codigoAtt = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Novo login: ");
                    String novoLogin = scanner.nextLine();
                    
                    System.out.println("Nova senha: ");
                    String novaSenha = scanner.nextLine();
                    
                    System.out.println("Novo sexo (M/F): ");
                    char novoSexo = scanner.nextLine().charAt(0);
                    
                    Usuario usuarioAntigo = usuarioDAO.get(codigoAtt);
                    Usuario usuarioAtualizado = new Usuario(codigoAtt, novoLogin, novaSenha, novoSexo);
                    usuarioDAO.update(usuarioAtualizado);
                    
                    break;
                
                default:
                    System.out.println("Digite um número que está no menu.");
                    break;
            }
        }
        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
