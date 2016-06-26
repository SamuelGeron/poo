package task;

import java.util.Date;

import classes.Local;

public class Tarefa {
	
	private String descTarefa;
	private Date dataTarefa;
	private Date dataConclusao;
	private String nomeTarefa;
	private Local local;
	
	public String getDescTarefa() {
		return descTarefa;
	}
	public void setDescTarefa(String descTarefa) {
		this.descTarefa = descTarefa;
	}
	public Date getDataTarefa() {
		return dataTarefa;
	}
	public void setDataTarefa(Date dataTarefa) {
		this.dataTarefa = dataTarefa;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
        
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	
}
