const { Client } = require('pg');

class Banco {
  static conexao;
  static init() {
    try {
      this.conexao = new Client({
        host: '127.0.0.1',
        port: 5432,
        database: 'WEBTrab2',
        user: 'postgres',
        password: 'ifsp',
      });
      this.conexao.connect();
    }
    catch (erro) {
      console.log('');
      console.log('==========================================================');
      console.log('');
      console.log(" >> ❌ Erro de conexao: " + erro + " ❌ << ");
      console.log('');
      console.log('==========================================================');
      console.log('');
    }
  }
}
module.exports = Banco;