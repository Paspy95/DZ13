package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void addAllProduct() {

        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Арахис", 30);
        Product product2 = new Product(2, "Фисташки", 30);
        Product product3 = new Product(3, "Фундук", 30);
        Product product4 = new Product(4, "Грецкий Орех", 30);
        Product product5 = new Product(5, "Мускатный Орех", 30);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneProduct() {

        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Арахис", 30);
        Product product2 = new Product(2, "Фисташки", 30);
        Product product3 = new Product(3, "Фундук", 30);
        Product product4 = new Product(4, "Грецкий Орех", 30);
        Product product5 = new Product(5, "Мускатный Орех", 30);

        repository.add(product1);


        Product[] expected = {product1};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addNullProduct() {

        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Арахис", 30);
        Product product2 = new Product(2, "Фисташки", 30);
        Product product3 = new Product(3, "Фундук", 30);
        Product product4 = new Product(4, "Грецкий Орех", 30);
        Product product5 = new Product(5, "Мускатный Орех", 30);


        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOneProduct() {

        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Арахис", 30);
        Product product2 = new Product(2, "Фисташки", 30);
        Product product3 = new Product(3, "Фундук", 30);
        Product product4 = new Product(4, "Грецкий Орех", 30);
        Product product5 = new Product(5, "Мускатный Орех", 30);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        repository.removeById(4);

        Product[] expected = {product1, product2, product3, product5};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAllProduct() {

        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Арахис", 30);
        Product product2 = new Product(2, "Фисташки", 30);
        Product product3 = new Product(3, "Фундук", 30);
        Product product4 = new Product(4, "Грецкий Орех", 30);
        Product product5 = new Product(5, "Мускатный Орех", 30);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotExistProduct() {

        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Арахис", 30);
        Product product2 = new Product(2, "Фисташки", 30);
        Product product3 = new Product(3, "Фундук", 30);
        Product product4 = new Product(4, "Грецкий Орех", 30);
        Product product5 = new Product(5, "Мускатный Орех", 30);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(-100);
        });
    }
}

