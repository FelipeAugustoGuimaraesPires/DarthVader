// Seleciona todas as células que têm a classe "prodPreco"
const precoCells = document.querySelectorAll('.prodPreco');

// Inicializa a variável para armazenar o total
let total = 0;

// Itera sobre todas as células de preço
precoCells.forEach(cell => {
    // Obtém o valor do texto da célula e converte para número
    const preco = parseFloat(cell.textContent);

    // Verifica se o valor é um número válido
    if (!isNaN(preco)) {
        // Adiciona o preço ao total
        total += preco;
    }
});

// Exibe o total
console.log('Total: ', total);
