conn = Mongo();
db = conn.getDB("financial");


db.getCollection('user').insert({
    'name': 'Thiago Henrique de Godoy',
    'email': 'thiagodoy@hotmail.com',
    'password': '$2a$10$7I0zRe/2sEKSOAjAIvU/UO6shOxrWu9uuuCyOMymlkqPI3UvStuM.'
});
// db.getCollection('dentistas').createIndex({'endereco.cidade.localizacao': '2dsphere'});
// db.getCollection('dentistas').createIndex({'descredenciado': 1, 'especialidades.id': 1, 'clinicaVsDentista': 1});
// db.getCollection('dentistas').createIndex({
//     'descredenciado': 1,
//     'especialidades.descricaoEspecialidade': 1,
//     'clinicaVsDentista': 1
// });
// db.getCollection('dentistas').createIndex({'descredenciado': 1, 'rede': 1});