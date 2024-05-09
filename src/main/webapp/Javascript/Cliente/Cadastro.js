document.querySelector('form').addEventListener('submit', function(event) {

  var senha = document.querySelector('input[name="password"]').value;
  var confirmaSenha = document.querySelector('input[name="confirmPassword"]').value;
  var termos = document.querySelector('input[id="cb1"]').checked;
  var outroEndereco = document.querySelector('input[name="radiogroup1"]').checked;

  if(senha === '' || confirmaSenha === '') {
    alert('Preencha todos os campos corretamente!');
    return;
}

if(!termos) {
    alert('Você deve concordar com os termos e condições!');
    return;
}

  if(senha !== confirmaSenha) {
      alert('A senha e a confirmação de senha não são iguais!');
      return;
  }

  if(outroEndereco) {
      var cep2 = document.querySelector('input[name="cep2"]').value;
      var logradouro2 = document.querySelector('input[name="Logradouro2"]').value;
      var numero2 = document.querySelector('input[name="Numero2"]').value;
      var complemento2 = document.querySelector('input[name="Complemento2"]').value;
      var bairro2 = document.querySelector('input[name="Bairro2"]').value;
      var cidade2 = document.querySelector('input[name="Cidade2"]').value;
      var uf2 = document.querySelector('select').value;

      if(cep2 === '' || logradouro2 === '' || numero2 === '' || complemento2 === '' || bairro2 === '' || cidade2 === '' || uf2 === 'Selecione') {
          alert('Preencha todos os campos corretamente!');
          return;
      }
  }



});