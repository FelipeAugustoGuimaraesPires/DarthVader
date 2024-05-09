const swiper = new Swiper('.swiper.mySwiper', {
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
        });

function incrementar(qnt) {
    const inputQuantidade = document.querySelector('.input-quantidade');
    let quantidade = parseInt(inputQuantidade.value);
    if (quantidade < qnt) {
        quantidade++;
        inputQuantidade.value = quantidade;
    }
}

function decrementar() {
    const inputQuantidade = document.querySelector('.input-quantidade');
    let quantidade = parseInt(inputQuantidade.value);
    if (quantidade > 1) {
        quantidade--;
        inputQuantidade.value = quantidade;
    }
}

