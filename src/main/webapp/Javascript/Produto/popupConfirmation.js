function showConfirmationPopup() {
  var confirmation = confirm("Tem certeza de que deseja Inativar/Reativar o produto?");

  if (confirmation) {
    document.getElementById("formularioStatus").submit();
  }
}