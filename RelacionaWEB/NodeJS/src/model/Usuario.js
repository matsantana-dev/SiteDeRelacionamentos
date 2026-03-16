const { json } = require("express");

module.exports = class Usuario {
  //campos private
  #cpf;
  #senha;
  #login;
  #nome;
  #cep;
  #rua;
  #bairro;
  #cidade;
  #numero;
  #r1;
  #r2;
  #r3;

  constructor() {
    this.#cpf = "";
    this.#senha = "";
    this.#login = "";
    this.#nome = "=";
    this.#cep = "";
    this.#rua = "";
    this.#bairro = "";
    this.#cidade = "";
    this.#numero = "";
    this.#r1 = "";
    this.#r2 = "";
    this.#r3 = "";
  }
  set cpf(cpf) { this.#cpf = cpf; }
  get cpf() { return this.#cpf; }

  set senha(senha) { this.#senha = senha; }
  get senha() { return this.#senha; }

  set login(login) { this.#login = login; }
  get login() { return this.#login; }

  set nome(nome) { this.#nome = nome; }
  get nome() { return this.#nome; }

  set cep(cep) { this.#cep = cep; }
  get cep() { return this.#cep; }

  set rua(rua) { this.#rua = rua; }
  get rua() { return this.#rua; }

  set bairro(bairro) { this.#bairro = bairro; }
  get bairro() { return this.#bairro; }

  set cidade(cidade) { this.#cidade = cidade; }
  get cidade() { return this.#cidade; }

  set numero(numero) { this.#numero = numero; }
  get numero() { return this.#numero; }

  set r1(r1) { this.#r1 = r1; }
  get r1() { return this.#r1; }

  set r2(r2) { this.#r2 = r2; }
  get r2() { return this.#r2; }

  set r3(r3) { this.#r3 = r3; }
  get r3() { return this.#r3; }

  toRecord() {
    let obj = {
      cpf: this.#cpf,
      senha: this.#senha,
      login: this.#login,
      nome: this.#nome,
      cep: this.#cep,
      rua: this.#rua,
      bairro: this.#bairro,
      cidade: this.#cidade,
      numero: this.#numero,
      r1: this.#r1,
      r2: this.#r2,
      r3: this.#r3
    };
    return obj;
  }
}