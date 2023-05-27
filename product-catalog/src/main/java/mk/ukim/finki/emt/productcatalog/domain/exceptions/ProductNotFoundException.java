package mk.ukim.finki.emt.productcatalog.domain.exceptions;

import mk.ukim.finki.emt.productcatalog.domain.models.ProductId;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(ProductId id){
        super(String.format("The product with id %d does not exist!", id.getId()));
    }
}
