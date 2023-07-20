
$(document).ready(function() {
  $('#searchButton').click(function() {
    var searchValue = $('#searchInput').val().trim().toLowerCase();
    $('.station-card').each(function() {
      var stationName = $(this).find('input[name="stationName"]').val().trim().toLowerCase();
      if (stationName.includes(searchValue)) {
        $(this).show();
      } else {
        $(this).hide();
      }
    });
    $('#stationContainer').hide();
    $('.station-card:visible').first().find('#stationContainer').show();
  });
});

