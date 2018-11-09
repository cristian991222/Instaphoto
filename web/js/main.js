
$(window).scroll(function (e) {
    parallax();
});

$(document).ready(function () {

    loadContent();

});


function parallax() {
    
    var scrolled = $(window).scrollTop();
    // console.log(scrolled);
    $('.bg-row-fixed').css('bottom', -(scrolled * 0.1) + 'px');
    if (scrolled >= 870) {
        $("#changeColor").removeClass("text-white");
        $('#changeColor').addClass('animated slideInDown slower');
        $("#changeColor").css('color', '#ff5722');
    }
    if (scrolled <= 819) {
        $('#changeColor').addClass('animated zoomIn slow');
        $("#changeColor").addClass("text-white");
    }
}


function classActive() {
    
    $("#arrow-down").click(function () {

        // $("#arrow-down").attr("href", "#contentMain");
        $("#contentMain").css("transition", "width 2s, height 4s");

    });

    $("#contentMisionId").click(function () {
        $("#contentMisionId").attr('href', '#contenedorMision');
        $(".nav-item").removeClass('active');
        $(".nav-item")[1].addClass('active');

    });

}
