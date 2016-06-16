/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nome;
    
    private String endereco;
    
    private String cidade;
    
    private String estado;
    
    private String cpf;
    
    private String sexo;
    
    private boolean ativo;
    
    
    
}
