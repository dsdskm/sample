var connect = require('connect');
var http = require('http');
var app = connect();

function doOne(reuqest, response,next){
    console.log("do one");
    next();
}
function doTwo(reuqest, response){
    console.log("do two");
}

app.use(doOne);
app.use(doTwo);
http.createServer(app).listen(8888);
console.log("Server Started");