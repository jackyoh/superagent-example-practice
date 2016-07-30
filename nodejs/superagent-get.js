var request = require('superagent');
request.get('http://localhost:8081/webproject/webapi/hello/list')
       .end(function(err, res){
             console.log(res.statusCode);
             console.log(res.text);
          // console.log(res.statusCode);
       });

