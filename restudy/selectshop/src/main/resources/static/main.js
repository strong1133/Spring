$(document).ready(function () {
    $('#save').on('click', function () {
        $('.popup-container').addClass('active')
    })

    $('#close').on('click', function () {
        $('.popup-container').removeClass('active')
    })

    $('#query').on('keypress', function (e) {
        if (e.key == 'Enter') {
            execSearch();
        }
    });

    $('.card-container').empty();
    $('#search-result-box').empty();
    getProduct();
})

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

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

function getProduct(){
    $.ajax({
        type:'GET',
        url:'/api/products',
        success: function (response){
            for (let i=0; i<response.length; i++){
                let product = response[i];
                let tempHtml = addProductItem(product)
                $('.card-container').append(tempHtml);
                $('#search-result-box').empty();
            }
        }
    })
}
function addProductItem(product){
    return `<div class="card" onclick="window.location.href='${product.link}'">
                <img class="product-img"
                     src="${product.image}" alt="">
                <div class="card-body">
                    <div class="product-title">${product.title}</div>
                    <div class="product-price"><span>${numberWithCommas(product.lprice)}</span>원</div>
                    <div class="is-good ${product.lprice > product.myprice ? 'none' : ''}" >최저가</div>
                </div>
            </div>`;
}

function execSearch() {
    let query = $('#query').val();
    if (query == '') {
        alert('검색어를 입력하세요!');
        return;
    }
    $.ajax({
        type: 'GET',
        url: `api/search?query=${query}`,
        success: function (response) {
            $('#search-result-box').empty();
            for (let i = 0; i < response.length; i++) {
                let itemDto = response[i];
                let tempHtml = addHtml(itemDto)
                $('#search-result-box').append(tempHtml);
            }
        }
    });
}

function addHtml(itemDto) {
    return `<div class="search-itemDto">
                <div class="search-itemDto-left">
                    <img src="${itemDto.image}" alt="">
                </div>
                <div class="search-itemDto-center">
                    <div>
                        ${itemDto.title}
                    </div>
                    <div class="product-price"><span>${numberWithCommas(itemDto.lprice)}</span>원</div>
                </div>
                <div class="search-itemDto-right">
                    <img src="images/icon-save.png" id="save" onclick='addProduct(${JSON.stringify(itemDto)})' />
                </div>
            </div>`;
}

function addProduct(itemDto){
    $.ajax({
        type:'POST',
        url:'/api/products',
        contentType: 'application/json',
        data: JSON.stringify(itemDto),
        success: function (response){
            $('.popup-container').addClass('active');
            targetId = response.id;
        }
    })
}

function setMyprice(){
    let myprice = $('#myprice').val();
    if (myprice==''){
        alert('옳바른 값을 입력하세요.')
        return;
    }
    $.ajax({
        type:'PUT',
        url:`/api/products/${targetId}`,
        contentType: 'application/json',
        data: JSON.stringify({myprice:myprice}),
        success: function (response){
            $('.popup-container').removeClass('active')
            alert('값이 설정 되었습니다.')
            window.location.reload();
        }
    })
}