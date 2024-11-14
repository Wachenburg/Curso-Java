/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_com_arquivo;
import java.io.Serializable;
import java.awt.Component;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author usuário
 */
public class Final_com_arquivo {
private static Component parent;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    JFileChooser escolhe = new JFileChooser();
    escolhe.showOpenDialog(parent);
    File arq = new File (escolhe.getSelectedFile().getAbsolutePath());   
    FileOutputStream arq_w;
    ObjectOutputStream flux_w;
    FileInputStream arq_r;
    ObjectInputStream flux_r;
    Object tempo;
    Livros Templivro = null;    
        ArrayList<Livros> Estoque = new ArrayList<>();
        int op,op2,idsearch,i,idi,check, cont;
        char gen;
        Estoque = Estoque;
            try{
            arq_r = new FileInputStream(arq);
            flux_r = new ObjectInputStream(arq_r);
            tempo = flux_r.readObject();
            Estoque = (ArrayList<Livros>) tempo;
            arq_r.close();
            flux_r.close();
            }
            catch (Exception e){
            e.printStackTrace();
            }
            
        
        
        do{
           check = 0;
           op = Integer.parseInt(JOptionPane.showInputDialog("Biblioteca do Grug. Livros cadastrados: "+Estoque.size()+"\nDigite:\n1-Cadastrar uma obra:\n2-Excluir uma obra:\n3-Editar um registro:\n4-Exibir todas as obras:\n5-Gravar o registro:\n6-Sair"));
           switch(op){
               case 1:{
                   Livros Temp = new Livros();
                   do{
                   idi = (Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da obra: ")));
                   if(Estoque.isEmpty()){
                       check = 1;
                       break;
                   }
                   else{
                       for(i=0;i<Estoque.size();i++){
                           Livros Tempcheck = new Livros();
                           Tempcheck = (Livros)Estoque.get(i);
                           if(Tempcheck.getId()==idi){
                               JOptionPane.showMessageDialog(null, "ID ja registrado, insira outro");
                               check = 0;
                               break;
                           }
                           else{
                               check = 1;
                           }
                       }
                   }
                   }while(check == 0);
                   Temp.setId(idi);
                   Temp.setTitulo(JOptionPane.showInputDialog("Digite o titulo da obra: "));
                   Temp.setAutor(JOptionPane.showInputDialog("Digite o autor da obra: "));
                   do{
                   gen = JOptionPane.showInputDialog("Digite o genero da obra:\n-d para drama\n-f para fantasia\n-a para aventura\n-o para outro").charAt(0);
                   if(gen != 'f' && gen != 'o' && gen!='a' && gen!='d'){
                       JOptionPane.showMessageDialog(null, "Genero para a obra invalido, insira outro.");
                   }
                   }while(gen != 'f' && gen != 'o' && gen!='a' && gen!='d');
                   Temp.setGenero(gen);
                   Temp.setPaginas(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de paginas da obra: ")));
                   Temp.setEditora(JOptionPane.showInputDialog("Digite a editora da obra: "));
                   Temp.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de publicacao da obra: ")));
                   Temp.setEdicao(Integer.parseInt(JOptionPane.showInputDialog("Digite a edicao da obra: ")));
                   Temp.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco da obra: ")));
                   Estoque.add(Temp);
                   
               }break;
               case 2:{
                   Livros Temp = new Livros();
                   idsearch = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da obra: "));
                   for(i=0;i<Estoque.size();i++){
                       Temp = (Livros)Estoque.get(i);
                   if(Temp.getId() == idsearch){
                      Estoque.remove(i);
                   }
                   }    
               }break;
               case 3:{
                   int corrige =0;
                   check = 0;
                   Livros Temp = new Livros();
                   idsearch = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da obra: "));
                   for(i=0;i<Estoque.size();i++){
                       Temp = (Livros)Estoque.get(i);
                   if(Temp.getId() == idsearch){
                      op2 = Integer.parseInt(JOptionPane.showInputDialog("1-alterar ID\n2-alterar titulo\n3-alterar o autor\n4-alterar o genero\n5-alterar o numero de paginas\n6-alterar a editora\n7-alterar o ano de publicacao\n8-alterar a edicao da obra\n9-alterar o preco da obra"));
                      switch(op2){
                          case 1:{
                                do{
                                idi = (Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da obra: ")));
                                if(Estoque.isEmpty()){
                                    check = 1;
                                    break;
                                }
                                else{
                                     for(i=0;i<Estoque.size();i++){
                                        Livros Tempcheck = new Livros();
                                           Tempcheck = (Livros)Estoque.get(i);
                                           if(Tempcheck.getId()==idi){
                                              JOptionPane.showMessageDialog(null, "ID ja registrado, insira outro");
                                              check = 0;
                                              break;
                                          }
                                           else{
                                               check = 1;
                                          }
                                    }
                                }
                                }while(check == 0);
                                Temp.setId(idi);
                                corrige =1;
                          }break;
                          case 2:{
                              Temp.setTitulo(JOptionPane.showInputDialog("Digite o titulo da obra: "));
                              corrige =1;
                          }break;
                          case 3:{
                              Temp.setAutor(JOptionPane.showInputDialog("Digite o autor da obra: "));
                              corrige =1;
                          }break;
                          case 4:{
                              do{
                              gen = JOptionPane.showInputDialog("Digite o genero da obra:\n-d para drama\n-f para fantasia\n-a para aventura\n-o para outro").charAt(0);
                              if(gen != 'f' && gen != 'o' && gen!='a' && gen!='d'){
                                    JOptionPane.showMessageDialog(null, "Genero para a obra invalido, insira outro.");
                                }
                              }while(gen != 'f' && gen != 'a' && gen !='o');
                              Temp.setGenero(gen);
                              corrige =1;
                          }break;
                          case 5:{   
                              Temp.setPaginas(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de paginas da obra: ")));
                              corrige =1;
                          }break;
                          case 6:{
                              Temp.setEditora(JOptionPane.showInputDialog("Digite a editora da obra: "));
                              corrige =1;
                          }break;
                          case 7:{
                              Temp.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de publicacao da obra: ")));
                              corrige =1;
                          }break;
                          case 8:{
                              Temp.setEdicao(Integer.parseInt(JOptionPane.showInputDialog("Digite a edicao da obra: ")));
                              corrige =1;
                          }break;
                          case 9:{
                              Temp.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco da obra: ")));
                              corrige =1;
                          }break;
                          default:{
                              JOptionPane.showMessageDialog(null, "Opcao invalida");
                              corrige =1;
                          }break;
                      }
                   }
                   }
                   if(corrige == 0){
                      JOptionPane.showMessageDialog(null, "ID incorreto ou nao encontrado.");
                   }
               }break;
               case 4:{  
                  for(i=0;i<Estoque.size();i++){
                      Livros Temp = new Livros();
                      Temp = (Livros)Estoque.get(i);
                      if(Temp.getGenero() == 'f'){
                            JOptionPane.showMessageDialog(null, "Mostrando obra cadastrada "+(i+1)+" de "+(Estoque.size())+"\nID: "+Temp.getId()+"\nTitulo: "+Temp.getTitulo()+"\nAutor: "+Temp.getAutor()+"\nGenero: Fantasia\nPaginas: "+Temp.getPaginas()+"\nEditora: "+Temp.getEditora()+"\nAno: "+Temp.getAno()+"\nEdicao: "+Temp.getEdicao()+"\nPreco: "+Temp.getPreco());
                      }
                      if(Temp.getGenero() == 'd'){
                          JOptionPane.showMessageDialog(null, "Mostrando obra cadastrada "+(i+1)+" de "+(Estoque.size())+"\nID: "+Temp.getId()+"\nTitulo: "+Temp.getTitulo()+"\nAutor: "+Temp.getAutor()+"\nGenero: Drama\nPaginas: "+Temp.getPaginas()+"\nEditora: "+Temp.getEditora()+"\nAno: "+Temp.getAno()+"\nEdicao: "+Temp.getEdicao()+"\nPreco: "+Temp.getPreco());
                      }
                      if(Temp.getGenero() == 'a'){
                          JOptionPane.showMessageDialog(null, "Mostrando obra cadastrada "+(i+1)+" de "+(Estoque.size())+"\nID: "+Temp.getId()+"\nTitulo: "+Temp.getTitulo()+"\nAutor: "+Temp.getAutor()+"\nGenero: Aventura\nPaginas: "+Temp.getPaginas()+"\nEditora: "+Temp.getEditora()+"\nAno: "+Temp.getAno()+"\nEdicao: "+Temp.getEdicao()+"\nPreco: "+Temp.getPreco());
                      }
                      if(Temp.getGenero() == 'o'){
                          JOptionPane.showMessageDialog(null, "Mostrando obra cadastrada "+(i+1)+" de "+(Estoque.size())+"\nID: "+Temp.getId()+"\nTitulo: "+Temp.getTitulo()+"\nAutor: "+Temp.getAutor()+"\nGenero: Outro\nPaginas: "+Temp.getPaginas()+"\nEditora: "+Temp.getEditora()+"\nAno: "+Temp.getAno()+"\nEdicao: "+Temp.getEdicao()+"\nPreco: "+Temp.getPreco());
                      }
                  } 
               }break;
               case 5:{
                   try {
                        arq_w = new FileOutputStream(arq);
                        flux_w = new ObjectOutputStream(arq_w);
                        flux_w.writeObject(Estoque);
                        flux_w.close();   
                        arq_w.close();   
                        JOptionPane.showMessageDialog(null,"Dados gravados com sucesso no arquivo.");
                        }
                        catch (Exception e){
                        e.printStackTrace();
                        }
                   
               }break;
               case 6:{
                   JOptionPane.showMessageDialog(null, "Saindo");
               }break;
               default:{
                   JOptionPane.showMessageDialog(null, "Opcao invalida");
               }break;
           }
        }while(op != 6);
    }
    
}
