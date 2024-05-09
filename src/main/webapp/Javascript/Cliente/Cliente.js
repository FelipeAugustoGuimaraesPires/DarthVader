document.querySelectorAll('.product').forEach((product, index) => {
  const estoqueInput = document.getElementById(`Estoque_${index}`);
  const estoqueValor = estoqueInput.value;
  const addToCartButton = product.querySelector('.add-to-cart');
  const quantityControl = product.querySelector('.quantity-control');
  const decrementButton = product.querySelector('.decrement');
  const incrementButton = product.querySelector('.increment');
  const quantitySpan = product.querySelector('.quantity');

  addToCartButton.addEventListener('click', () => {
    addToCartButton.style.display = 'none';
    quantityControl.style.display = 'flex';
  });

  decrementButton.addEventListener('click', () => {
    let quantity = parseInt(quantitySpan.textContent, 10);
    if (quantity > 1) {
      quantitySpan.textContent = quantity - 1;
    } else {
      addToCartButton.style.display = 'block';
      quantityControl.style.display = 'none';
    }
  });

  incrementButton.addEventListener('click', () => {
    let quantity = parseInt(quantitySpan.textContent, 10);
    console.log(estoqueValor);
    console.log(quantity);
    if (quantity < estoqueValor) {
      quantitySpan.textContent = quantity + 1;
    } else {
    }
  });
});