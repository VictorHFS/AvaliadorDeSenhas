avaliador
.controller('avaliadorController', ['$scope', 'avaliadorService', function($scope, avaliadorService){
    $scope.senha = {
        senha: '',
        nota: 0,
        complexidade:''
    }
    $scope.avaliar = function(senha){
        $scope.senha = avaliadorService.avaliar(senha)
    }
}])
