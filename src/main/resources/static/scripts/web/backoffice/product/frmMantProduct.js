$(document).on("click", "#btnagregar", function(){
    $("#txtnomproducto").val("");
    $("#txtpreciounit").val("");
    $("#hddcodprod").val("0");
    $("#cbocategoria").empty();
    $("#cboproveedor").empty();
    $("#switchproducto").hide();
    $("#chkdescontinuado").prop("checked", false);
    listarCategoriasProveedores(0, 0);
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomproducto").val($(this).attr("data-prodname"));
    $("#txtpreciounit").val($(this).attr("data-produnit"));
    $("#hddcodprod").val($(this).attr("data-prodcod"));
    $("#cbocategoria").empty();
    $("#cboproveedor").empty();
    listarCategoriasProveedores($(this).attr("data-prodcateg"), $(this).attr("data-prodprov"));
    $("#switchproducto").show();
    if($(this).attr("data-descontinuado") === "true")
        $("#chkdescontinuado").prop("checked", true);
    else
        $("#chkdescontinuado").prop("checked", false);
    $("#modalNuevo").modal("show");
});

function listarCategoriasProveedores(idcate, idprov){
    $.ajax({
        type: "GET",
        url: "/backoffice/category/listar",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbocategoria").append(
                `<option value="${value.categoryid}">${value.categoryname}</option>`
                )
            })
            if(idcate > 0) {
                $("#cbocategoria").val(idcate);
            }
            $.ajax({
                    type: "GET",
                    url: "/backoffice/supplier/listar",
                    dataType: "json",
                    success: function(resultado){
                        $.each(resultado, function(index, value){
                            $("#cboproveedor").append(
                            `<option value="${value.supplierid}">${value.companyname}</option>`
                            )
                        })
                        if(idprov > 0) {
                            $("#cboproveedor").val(idprov);
                        }
                    }
                })
        }
    })
}