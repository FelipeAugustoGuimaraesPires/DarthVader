const avaliacaoElement = document.getElementById('avaliacao');

function exibirAvaliacao() {
    avaliacaoElement.innerHTML = '';
    const numeroAvaliacao = Number(avaliacaoValue); // Converte o valor da avaliação para um número

    for (let i = 1; i <= 5; i++) {
        const estrela = document.createElement('span');
        estrela.classList.add('estrela');

        if (i <= numeroAvaliacao) {
            estrela.classList.add('preenchida');
        }

        avaliacaoElement.appendChild(estrela);
    }
}

exibirAvaliacao();