package br.com.senai.teste.dto;

public class EmprestimoRequest {
    
    private Integer alunoId;

    private Integer livroId;

    public EmprestimoRequest(){

    }
    public Integer getAluno(){
        return alunoId;
    }
    
    public void setAluno(Integer alunoId){
        this.alunoId = alunoId;
    }
    public Integer getLivro(){
        return livroId;
    }

    public void setLivro(Integer livroId){
        this.livroId = livroId;
    }
}
