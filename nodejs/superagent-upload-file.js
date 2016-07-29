var request = require('superagent');
request.post('http://localhost:8080/webproject/webapi/upload/file')
       .set('Content-Type','multipart/form-data')
       .attach('file','/home/user1/wordcount.txt')
       .end(function(err, res){
             console.log(err);
          //   console.log(res.text);
          // console.log(res.statusCode);
       });
