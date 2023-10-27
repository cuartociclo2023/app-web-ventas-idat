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

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/backoffice/product/guardar",
        contentType: "application/json",
        data: JSON.stringify({
            productid: $("#hddcodprod").val(),
            productname: $("#txtnomproducto").val(),
            unitprice: $("#txtpreciounit").val(),
            categoryid: $("#cbocategoria").val(),
            supplierid: $("#cboproveedor").val(),
            discontinued: $("#chkdescontinuado").prop("checked")
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarProductos()
            }
            alert(resultado.mensaje);
            $("#modalNuevo").modal("hide");
        }
    })
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

function listarProductos(){
    $.ajax({
        type: "GET",
        url: "/backoffice/product/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append("<tr>"+
                    "<td>"+value.productid+"</td>"+
                    "<td>"+value.productname+"</td>"+
                    "<td>"+value.unitprice+"</td>"+
                    "<td>"+value.category.categoryname+"</td>"+
                    "<td>"+value.supplier.companyname+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'" +
                            " data-prodcod='"+value.productid+"'"+
                            " data-prodname='"+value.productname+"'"+
                            " data-produnit='"+value.unitprice+"'"+
                            " data-prodcateg='"+value.category.categoryid+"'"+
                            " data-prodprov='"+value.supplier.supplierid+"'"+
                            "><i class='fas fa-edit'></i></button></td></tr>"
                );
            })
        }
    })
}