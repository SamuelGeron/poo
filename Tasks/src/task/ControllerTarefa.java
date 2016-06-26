package task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import classes.Local;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public class ControllerTarefa{

    public void cadastrarTarefa(String usuario) throws IOException{

        Tarefa nt = new Tarefa();

        //nomeTarefa
        System.out.println("Digite o nome da Tarefa: ");
        Scanner ler = new Scanner(System.in);
        nt.setNomeTarefa(ler.nextLine());

        //descricao
        System.out.println("Informe a descricao da tarefa: ");
        nt.setDescTarefa(ler.nextLine());

        // Data
        boolean errData;
        do{
            errData = false;
            try {
                    System.out.println("Digite a data da tarefa no formato dd/MM/yyyy: ");
                    String dataRecebida =  ler.nextLine();
                    System.out.println("Digite a hora da tarefa no formato hh:mm ");
                    dataRecebida +=  " " + ler.nextLine();
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                    nt.setDataTarefa(df.parse(dataRecebida));
            } catch (ParseException e) {
                    errData = true;
                    System.out.println("O formato de data ou hora esta incorreto!");
            }
        }while(errData);

        //local
        System.out.println("Deseja cadastrar um local para esta tarefa? (s/n)");
        String x = ler.nextLine();

        if(x.equals("s")){
            Local novoLocal = new Local();
            System.out.println("Nome: ");
            novoLocal.setNome(ler.nextLine());
            System.out.println("Rua: ");
            novoLocal.setRua(ler.nextLine());
            System.out.println("Numero: ");
            novoLocal.setNumero(ler.nextInt());
            ler.nextLine();// limpar o buffer;
            System.out.println("Bairro: ");
            novoLocal.setBairro(ler.nextLine());
            System.out.println("Telefone: ");
            novoLocal.setTelefone(ler.nextLine());

            nt.setLocal(novoLocal);
        }

        FileWriter arq = new FileWriter(usuario+".txt", true);
        Writer gravar = new BufferedWriter(arq);
        gravar.append("\n"+nt.getNomeTarefa()+";"+nt.getDescTarefa()+";"+nt.getDataTarefa()+";");
        
        if(x.equals("s")){
            
            gravar.append(nt.getLocal().getNome()+";"+nt.getLocal().getRua()+";"
                +nt.getLocal().getNumero()+";"+nt.getLocal().getBairro()+";"
                +nt.getLocal().getTelefone()+";");
        }
        
        gravar.close();
    }
		
    public void listarTarefas(String usuario) throws FileNotFoundException, IOException{
        
        FileReader arq = new FileReader(usuario + ".txt");
        BufferedReader lerArq = new BufferedReader(arq);
        
        int linha = 0;
        String lista = "";
        while(lista != null){
            
            if(linha == 0){
                
                lerArq.readLine();
                linha++;
                continue;
            }
            
            lista = lerArq.readLine();
            
            if(lista == null){
                
               System.out.println("entrei aqui");
               break;
            }
            
            System.out.println(linha+" - "+lista);
            linha++;
        }
    }
    
    public void excluirTarefa(String usuario) throws IOException{
        
        int numtarefa;
        int linha = 1;
        Scanner ler = new Scanner(System.in);
        
        this.listarTarefas(usuario);
        
        FileReader fr = new FileReader(usuario + ".txt");
        BufferedReader bfr = new BufferedReader(fr);
        
        System.out.println("Informe o numero da tarefa que deseja excluir: ");
        numtarefa = ler.nextInt();
        ler.nextLine();
        
        ArrayList<String> novoArquivo = new ArrayList();
        
        linha = 0;
        String listar = "";
        while(listar != null){
            
            if(linha == numtarefa){
                
                bfr.readLine();
                linha++;
                continue;
            }

            listar = bfr.readLine();
            novoArquivo.add(listar);
            linha++;
        }
        
        for (String s:novoArquivo)
            System.out.println(s);
        
        fr.close();
        bfr.close();
        
        FileWriter fw = new FileWriter(usuario+".txt", true);
        fw.close();
        
        FileWriter fw2 = new FileWriter(usuario + ".txt");
        BufferedWriter  bfw = new BufferedWriter(fw2);
        
        for(int i=0; i < novoArquivo.size()-1; i++){
           
            bfw.write(novoArquivo.get(i));
            bfw.newLine();
        }
        
        bfw.close();
        fw.close();
    }
}
