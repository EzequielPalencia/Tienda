package com.market.tienda.service;

import com.market.tienda.model.Producto;
import com.market.tienda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoService producto = new ProductoService();
    private final ProductRepository productRepository;

    @Autowired
    public ProductoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Producto crearProducto(Producto producto) {
        //insert into productos *****
        return this.productRepository.save(producto);
    }

    public Producto obtenerPorId(Long id) {
        //select * from productos where id= id;
        return this.productRepository.findById(id).orElse(null);
    }

    public List<Producto> obtenerTodosLosProductos(int page, int size){
        //select * from productos;
        PageRequest pageRequest = PageRequest.of(page,size);
        return this.productRepository.findAll(pageRequest).getContent();
    }

    public void eliminarProductoById(Long id){
        //delete * from productos where id = id;
        this.productRepository.deleteById(id);
    }

}
