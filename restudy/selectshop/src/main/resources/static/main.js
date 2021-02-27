$(document).ready(function () {

})

function tab_see() {
    $('.see-area').show();
    $('.search-area').hide();

    $('.nav-see').addClass('active');
    $('.nav-search').removeClass('active');
}


function tab_search() {
    $('.see-area').hide();
    $('.search-area').show();

    $('.nav-see').removeClass('active');
    $('.nav-search').addClass('active')
}