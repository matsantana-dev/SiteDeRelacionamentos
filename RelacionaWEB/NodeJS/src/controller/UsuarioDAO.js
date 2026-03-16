const Banco = require('../model/Banco');
const Usuario = require('../model/Usuario');

module.exports = class UsuarioDAO {
  async listar(cpf) {
    let obj = null;
    try {
      Banco.init();
      // Alterei o comando SQL para puxar também as respostas quando preencher o CPF
      let tabela = await Banco.conexao.query('SELECT u.cpf, u.senha, u.login, u.nome, u.cep, u.rua, u.bairro, u.cidade, u.numero, r.r1, r.r2, r.r3 FROM Usuario u LEFT JOIN Resposta r ON u.cpf = r.cpfuser WHERE u.cpf= $1 ', [cpf]);
      Banco.conexao.end();
      if (tabela.rowCount > 0) {
        obj = new Usuario();
        obj.cpf = tabela.rows[0].cpf;
        obj.senha = tabela.rows[0].senha;
        obj.login = tabela.rows[0].login;
        obj.nome = tabela.rows[0].nome;
        obj.cep = tabela.rows[0].cep;
        obj.rua = tabela.rows[0].rua;
        obj.bairro = tabela.rows[0].bairro;
        obj.cidade = tabela.rows[0].cidade;
        obj.numero = tabela.rows[0].numero;

        obj.r1 = tabela.rows[0].r1;
        obj.r2 = tabela.rows[0].r2;
        obj.r3 = tabela.rows[0].r3;
      }
      return obj
    }
    catch (erro) {
      console.log('');
      console.log('==========================================================');
      console.log('');
      console.log(" >> ❌ Erro no DAO: " + erro + " ❌ << ");
      console.log('');
      console.log('==========================================================');
      console.log('');
    }
  }
}