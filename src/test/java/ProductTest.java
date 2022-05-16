import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    int idDel = 1;
    int idDelTwo = 99;


    Book bookFirst = new Book(1, "Первая книга", "Тарковский");
    Book bookSecond = new Book(2, "вторая книга", "Тарковский");
    Book bookThird = new Book(3, "третья книга", "Тарковский");
    Smartphone smartphoneFirst = new Smartphone(4, "iPhone", "Apple");
    Smartphone SmartphoneSecond = new Smartphone(5, "Android", "Samsung");

    @Test
    void shouldAddItemAndDelId() {
        ProductManager manager = new ProductManager();


        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(SmartphoneSecond);

        manager.delId(idDel);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{bookSecond, bookThird, smartphoneFirst, SmartphoneSecond};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddBooksAndSmartphone() {
        ProductManager manager = new ProductManager();


        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{bookFirst, bookSecond, bookThird, smartphoneFirst};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchItem() {
        ProductManager manager = new ProductManager();

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(SmartphoneSecond);

        manager.searchBy("Первая книга");


        Product[] actual = manager.searchBy("Первая книга");
        Product[] expected = new Product[]{bookFirst};

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldNoItem() {
        ProductManager manager = new ProductManager();

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(SmartphoneSecond);

        manager.searchBy("Десятая книга");

        Product[] actual = manager.searchBy("Десятая книга");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneItemAndDelOneItem() {
        ProductManager manager = new ProductManager();


        manager.add(bookFirst);


        manager.delId(idDel);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void DelNonexistent() {
        ProductManager manager = new ProductManager();


        manager.add(bookFirst);


        //    manager.delId(idDelTwo);

        // Product[] actual = manager.findAll();
        //Product[] expected = new Product[]{};

        assertThrows(NotFoundException.class, () -> {
            manager.delId(idDelTwo);
        });
    }


    @Test
    void ShouldEmptySearch() {
        ProductManager manager = new ProductManager();

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartphoneFirst);
        manager.add(SmartphoneSecond);

        manager.searchBy("2342432432423432");

        Product[] actual = manager.searchBy("345345");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTwoItems() {
        ProductManager manager = new ProductManager();


        manager.add(bookSecond);
        manager.add(bookFirst);
        manager.add(smartphoneFirst);

        manager.searchBy("книга");


        Product[] actual = manager.searchBy("книга");
        Product[] expected = new Product[]{bookSecond, bookFirst};

        assertArrayEquals(expected, actual);

    }


}
