// Supondo que você esteja usando jQuery
$(document).ready(function(){
    $('input[type=radio][name=rating]').change(function() {
        // Obtenha o valor da classificação
        var rating = $(this).val();

        // Aqui você pode fazer uma chamada AJAX para salvar a classificação no banco de dados
        $.ajax({
            url: '/save_rating',  // Substitua por sua URL
            type: 'post',
            data: { 'rating': rating },
            success: function(response) {
                console.log(response);
            }
        });
    });
});
