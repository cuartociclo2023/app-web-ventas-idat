package pe.edu.idat.appwebventasidat.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.idat.appwebventasidat.model.bd.Product;
import pe.edu.idat.appwebventasidat.model.request.ProductRequest;
import pe.edu.idat.appwebventasidat.model.response.ResultadoResponse;
import pe.edu.idat.appwebventasidat.service.ProductService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/product")
public class ProductController {

    private ProductService productService;


    @GetMapping("")
    public String frmMantProducto(Model model){
        model.addAttribute("listaproductos",
                productService.listarProductos());
        return "backoffice/product/frmproduct";
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Product> listarProductos(){
        return productService.listarProductos();
    }

    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarProducto(@RequestBody ProductRequest productRequest){
        return productService.guardarProducto(productRequest);
    }

}
