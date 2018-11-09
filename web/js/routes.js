$(document).ready(function () {
   
    loadContent();
    btnLinkRoutes();
    
});

function loadContent () {

    $(".loadNavbar").load("../view/components/navbar.html");
    
    $(".loadContenMain").load("./view/components/mainContent.html");
    
    $(".loadFooter").load("./view/components/footer.html");

}

function btnLinkRoutes () {
    
    $("#btnAccess").click(function() {
         alert("Presionando el botón");
    });

} 

