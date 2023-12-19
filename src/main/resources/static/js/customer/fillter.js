const fillter = new Isotope('.store-list', {
    //배치할 요소를 감싸고 있는 부모 요소명
    itemSelector: '.listing-item', //배치할 요소명
    columnWidth: '.list-class', //넓이값을 구할 요소명
    transitionDuration: '0.5s', //화면 재배치시 요소가 움직이는 속도
});
$('#button-all').click(function () {
    fillter.arrange({
        filter: '*',
    });
});
$('#button-1').click(function () {
    fillter.arrange({
        filter: '.category-1',
    });
});
$('#button-2').click(function () {
    fillter.arrange({
        filter: '.category-2',
    });
});
$('#button-3').click(function () {
    fillter.arrange({
        filter: '.category-3',
    });
});