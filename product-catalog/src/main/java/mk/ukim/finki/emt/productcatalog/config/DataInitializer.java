package mk.ukim.finki.emt.productcatalog.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Category;
import mk.ukim.finki.emt.productcatalog.domain.models.Product;
import mk.ukim.finki.emt.productcatalog.domain.repository.ProductRepository;
import mk.ukim.finki.emt.productcatalog.xport.rest.ProductResource;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final ProductRepository productRepository;

    @PostConstruct
    public void initData() {
        Product p1 = Product.build("Gigabyte i5 6500, GTX 1060", Money.valueOf(Currency.MKD,60000), 10, Category.Computer);
        Product p2 = Product.build("Asus TUF F15", Money.valueOf(Currency.MKD,50000), 5, Category.Laptop);
        Product p3 = Product.build("Logitech G102", Money.valueOf(Currency.MKD,1200), 5, Category.Peripheral);
        if (productRepository.findAll().isEmpty()) {
            productRepository.saveAll(Arrays.asList(p1,p2,p3));
        }
    }
}
