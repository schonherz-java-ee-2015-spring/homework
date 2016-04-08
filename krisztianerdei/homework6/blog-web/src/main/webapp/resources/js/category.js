$(function() {
    var availableTags = [
      "Art",
      "Autos",
      "Books",
      "Finance",
      "Games",
      "Internet",
      "Job",
    ];
    $( "#category" ).autocomplete({
      source: availableTags
    });
  });