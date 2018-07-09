avaliador
.factory("avaliadorService", function($http, $q){
    var url = "http://localhost:8080/"

    var _avaliar = function(senha){
        cors = createCORSRequest('POST', url+"avaliar")
        if (!cors) {
            alert('CORS not supported')
            return;
          }
        cors.onload = function() {
            var text = cors.responseText;
            var title = text
            alert('Response from CORS request to ' + url + ': ' + title);
          };
        cors.onerror = function() {
        alert('Woops, there was an error making the request.');
        };
        console.log(senha)
        cors.send(senha)
    }
    var _testeHttp = function(){
        $http.get(url+"/")
        .then(function(data){
            console.log("Funcionou corretamente.")
            console.log(data)
        },
    function(erro){
        console.log("Ocorreu um erro.")
        console.log(erro)

    })
    }

    function createCORSRequest(method, url) {
        var xhr = new XMLHttpRequest();
        if ("withCredentials" in xhr) {
          // XHR for Chrome/Firefox/Opera/Safari.
          xhr.open(method, url, true);
        } else if (typeof XDomainRequest != "undefined") {
          // XDomainRequest for IE.
          xhr = new XDomainRequest();
          xhr.open(method, url);
        } else {
          // CORS not supported.
          xhr = null;
        }
        return xhr;
      }

    return{
        avaliar: _avaliar,
        teste: _testeHttp
    }
})