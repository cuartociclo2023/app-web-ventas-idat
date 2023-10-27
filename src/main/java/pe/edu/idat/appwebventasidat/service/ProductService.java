package pe.edu.idat.appwebventasidat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebventasidat.model.bd.Category;
import pe.edu.idat.appwebventasidat.model.bd.Product;
import pe.edu.idat.appwebventasidat.model.bd.Supplier;
import pe.edu.idat.appwebventasidat.model.request.ProductRequest;
import pe.edu.idat.appwebventasidat.model.response.ResultadoResponse;
import pe.edu.idat.appwebventasidat.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> listarProductos(){
        return productRepository.findAll();
    }


    public ResultadoResponse guardarProducto(ProductRequest productRequest){
        String mensaje = "Producto registrado correctamente";
        Boolean respuesta = true;
        try{
            Product product = new Product();
            if(productRequest.getProductid() > 0){
                product.setProductid(productRequest.getProductid());
            }
            product.setProductname(productRequest.getProductname());
            product.setUnitprice(productRequest.getUnitprice());
            boolean discontinued = false;
            if(productRequest.getDiscontinued() != null){
                discontinued = true;
            }
            product.setDiscontinued(discontinued);
            Category category = new Category();
            category.setCategoryid(productRequest.getCategoryid());
            Supplier supplier = new Supplier();
            supplier.setSupplierid(productRequest.getSupplierid());
            product.setCategory(category);
            product.setSupplier(supplier);
            productRepository.save(product);
        }catch (Exception ex){
            mensaje = "Producto no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
