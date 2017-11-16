$(document).ready(function(){

/*Código Menu*/
    $("#bt_menu").click(function(){
        $("#bth").hide();
        $('.menu').show();
    });
    $("#v").click(function(){
        $(".menu").show();
        $(".menu").hide();
    });

    /*Máscaras*/
    $("#nascMotorista, #dataEntManutencao, #dataSaidManutencao").mask("99/99/9999");
    $("#cpfMotorista").mask("999.999.999-99");
    $("#valorManutencao").maskMoney({
         decimal: ".",
         thousands: "."
     });

    $("#frotaEquip").mask("9999-99");


});


	 
