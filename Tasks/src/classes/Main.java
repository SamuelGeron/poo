package classes;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import task.ControllerTarefa;
import task.Tarefa;

import user.ControllerUsuario;
import user.Usuario;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {

	int opcao;
        Scanner ler;
        
        do{
            System.out.println("Bem vindo ao agendador de tarefas!!!\nDigite o número da opção desejada:\n"
                    + "1 - Login\n2 - Cadastro de usuário\n3 - Excluir Usuário\n4 - Sair");

            ler = new Scanner(System.in);

            opcao = ler.nextInt();
            ler.nextLine();

            System.out.println("opcao escolhida = " + opcao);
        
        switch(opcao){
            
            case 1: System.out.println("Login: ");
                    String login = ler.nextLine();
                    System.out.println("senha: ");
                    String senha = ler.nextLine();
                    
                    Sessao sessao = new Sessao();
                    
                    sessao.logar(login, senha);  
                    break;
            
            case 2: ControllerUsuario cadastrar = new ControllerUsuario();
                    cadastrar.cadastroUsuario();
                    break;
                    
            case 3: ControllerUsuario excluir = new ControllerUsuario();
                    excluir.excluirUsuario();
                    break;
            default:
                System.out.println("fechando o programa...");
        }
        
        }while(opcao != 4);
        
    }
    
}
