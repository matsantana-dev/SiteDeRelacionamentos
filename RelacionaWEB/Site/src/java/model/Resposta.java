/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * 
 * @author Mathias
 */
public class Resposta {
    private int codigo;
    private String cpfuser;
    private char r1;
    private char r2;
    private char r3;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        this.codigo = codigo;
    }
    
    public void setCodigo(String codigo) throws Exception {
        this.setCodigo(Integer.parseInt(codigo));
    }
    
    public String getCpfuser() {
        return cpfuser;
    }

    public void setCpfuser(String cpfuser) {
        this.cpfuser = cpfuser;
    }

    public char getR1() {
        return r1;
    }

    public void setR1(char r1) {
        this.r1 = r1;
    }

    public char getR2() {
        return r2;
    }

    public void setR2(char r2) {
        this.r2 = r2;
    }

    public char getR3() {
        return r3;
    }

    public void setR3(char r3) {
        this.r3 = r3;
    }
}
