/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_com_arquivo;

import java.io.Serializable;

/**
 *
 * @author usuário
 */
public class Livros implements Serializable {
    int id;
    String titulo;
    String autor;
    char genero;
    int paginas;
    String editora;
    int ano;
    int edicao;
    float preco;
    
    public Livros(){
        
    }
    public int setId(int id){
        this.id=id;
        return this.id;
    }
    public String setTitulo(String titulo){
        this.titulo=titulo;
        return this.titulo;
    }
    public String setAutor(String autor){
        this.autor=autor;
        return this.autor;
    }
    public char setGenero(char genero){
        this.genero=genero;
        return this.genero;
    }
    public int setPaginas(int paginas){
        this.paginas=paginas;
        return this.paginas;
    }
    public String setEditora(String editora){
        this.editora=editora;
        return this.editora;
    }
    public int setAno(int ano){
        this.ano=ano;
        return this.ano;
    }
    public int setEdicao(int edicao){
        this.edicao=edicao;
        return this.edicao;
    }
    public float setPreco(float preco){
        this.preco=preco;
        return this.preco;
    }
    public int getId(){
        return this.id;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public char getGenero(){
        return this.genero;
    }
    public int getPaginas(){
        return this.paginas;
    }
    public String getEditora(){
        return this.editora;
    }
    public int getAno(){
        return this.ano;
    }
    public int getEdicao(){
        return this.edicao;
    }
    public float getPreco(){
        return this.preco;
    }
}
