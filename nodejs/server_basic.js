var http = require('http');
var fs = require('fs');

function sendResponse(response){
    response.writeHead(404,{"Content-Type":"text/plain"});
    response.write("Error Message");
    response.end();
}

function onRequest(request,response){
   if(request.method == "GET" && request.url =="/"){
       response.writeHead(200,{"Content-Type":"text/html"});
       fs.createReadStream("./index.html").pipe(response);
   } else {
       sendResponse(response);
   }

}

http.createServer(onRequest).listen(8888);
console.log("Server Started");

