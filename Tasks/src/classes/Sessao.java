
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import task.ControllerTarefa;

public class Sessao {
    
    String usuario;
        
    Scanner ler = new Scanner(System.in);
    
    void logar(String login, String senha) throws IOException{
        
        File arquivo = new File(login+".txt");
        
        if(arquivo.exists()){
            
            FileReader arq = new FileReader(login + ".txt");

            BufferedReader lerArq = new BufferedReader(arq);
            
            String autenticacao = lerArq.readLine();
            
            if(autenticacao.equals(senha)){
                
                System.out.println("Logado com sucesso!!");
                this.usuario = login;
                this.menu();
            }else{
                System.out.println("Senha incorreta!!");
            }
        }else{
            System.out.println("Usuário inexistente!");
        }
    }
    
    public void menu() throws IOException{
        
        Scanner ler = new Scanner(System.in);
        int opt;
        do{
            System.out.println("Digite o número da opção desejada\n1 - Cadastrar tarefa\n2 - Listar tarefas\n"
            + "3 - Excluir tarefas\n4 - Sair\n");
            opt = ler.nextInt();

            switch (opt){

                case 1:
                    ControllerTarefa novaTarefa = new ControllerTarefa();
                    novaTarefa.cadastrarTarefa(this.usuario);

                    break;
                case 2: 
                    ControllerTarefa listar = new ControllerTarefa();
                    listar.listarTarefas(this.usuario);
                    
                    break;
                case 3:
                    ControllerTarefa excluir = new ControllerTarefa();
                    excluir.excluirTarefa(this.usuario);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
            }
        }while(opt != 4);
    }   
    
}
