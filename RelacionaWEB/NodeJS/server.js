// npm i express
const express = require('express');
const app = new express();
const bodyParser = require('body-parser');
// cors -> (Cross-Origin Resource Sharing) -> compartilha requisições de várias origens
// npm i cors
const cors = require('cors');
const fs = require('fs')

const UsuarioDAO = require('./src/controller/UsuarioDAO');
const Usuario = require("./src/model/Usuario");
const date = new Date;

// configurações para dentro do servidor express, adicionando middlewares (body-parser, morgan, cors)
app.use(bodyParser.text({ type: 'text/html' }));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cors());

app.get("/Usuario/:cpf", async function (req, res) {
    const { cpf } = req.params;
    let hoje = new Date();
    let usuario;
    let usuarioDAO;
    let ipCliente = "";
    try {
        ipCliente = req.socket.remoteAddress ||                  // Recupera o endereço através do socket TCP
            (req.headers['x-forwarded-for'] || '').split(',').pop() || // Recupera o IP de origem, caso a fonte esteja utilizando proxy
            req.connection.remoteAddress || // Recupera o endereço remoto da chamada
            req.connection.socket.remoteAddress; // Recupera o endereço através do socket da conexão
    
        usuarioDAO = new UsuarioDAO();
        usuario = await usuarioDAO.listar(cpf);
        if (usuario != null) {
            fs.appendFileSync("logAPI.txt", "\n" + hoje.toLocaleString() + ": IP = " + ipCliente + " -> Encontrou " + JSON.stringify(usuario.toRecord()));
            return res.json({ 'dados': usuario.toRecord() });
        }
        else {
            fs.appendFileSync("logAPI.txt", "\n" + hoje.toLocaleString() + ": IP =" + ipCliente + " -> Não encontrou cpf = " + cpf);
            return res.json({ 'dados': null });
        }
    } catch (erro) {
        console.log(erro);
    }
});

app.listen(3000, function (erro) {
    if (erro) {
        console.log('');
        console.log('==========================================================');
        console.log('');
        console.log(' >> ❌ Erro ao ligar o servidor: ' + erro + ' ❌ << ');
        console.log('');
        console.log('==========================================================');
        console.log('');
     } else {
        console.log('');
        console.log('==========================================================');
        console.log('');
        console.log(' >> ✅ Servidor ligado às ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds() + ' ✅ << ');
        console.log('');
        console.log('==========================================================');
        console.log('');
     }
})