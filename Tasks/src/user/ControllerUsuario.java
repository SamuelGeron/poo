package user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerUsuario {
        
    Scanner ler = new Scanner(System.in);

    public void cadastroUsuario(){

        Usuario nu = new Usuario();
        
        //login
        System.out.println("login: ");
        nu.setLogin(ler.nextLine());
        
        //senha
        System.out.println("senha: ");
        nu.setSenha(ler.nextLine());
     
        try {
            FileWriter arquivo = new FileWriter(new File(nu.getLogin() + ".txt"));
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.printf(nu.getSenha());
            arquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(ControllerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Usuario cadastrado com sucesso\n");        
    }

    public void excluirUsuario() throws IOException{
        
        String usuario;
        String senha;
        
        System.out.println("Informe o login do usuario que deseja excluir: ");
        usuario = (ler.nextLine());
        System.out.println("Senha: ");
        senha = (ler.nextLine());
        
        
        try {
            FileReader arq = new FileReader(usuario + ".txt");
            BufferedReader lerArq = new BufferedReader(arq);
            
            File arquivo = new File(usuario+".txt");
            
            if(lerArq.readLine().equals(senha)){
            
                if(arquivo.delete())
                  System.out.println("Usuario excluido com sucesso.");
                else
                  System.out.println("Não foi possivel excluir o usuario");
            }else{
                System.out.println("Senha Incorreta");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Usuário não existe");
        }        
    }

}
