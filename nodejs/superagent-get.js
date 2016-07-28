var request = require('superagent');
request.get('http://localhost:8080/webproject/webapi/hello/function1')
       .end(function(err, res){
             console.log(res.statusCode);
             console.log(res.text);
          // console.log(res.statusCode);
       });

