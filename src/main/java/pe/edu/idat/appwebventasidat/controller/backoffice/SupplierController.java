package pe.edu.idat.appwebventasidat.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.appwebventasidat.model.bd.Supplier;
import pe.edu.idat.appwebventasidat.service.SupplierService;

import java.util.List;
@AllArgsConstructor
@Controller
@RequestMapping("/backoffice/supplier")
public class SupplierController {
    private SupplierService supplierService;
    @GetMapping("/listar")
    @ResponseBody
    public List<Supplier> listarProveedores(){
        return supplierService.listarProveedores();
    }

}
