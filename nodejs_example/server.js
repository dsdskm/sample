var connect = require('connect');
var http = require('http');

var app = connect();
http.createServer(app).listen(8888);
console.log("서버가 작동중");

function about(request, response) {
    console.log("about");
}


function email(request, response) {
    console.log("email");
}
app.use('/about', about);
app.use('/email', email);