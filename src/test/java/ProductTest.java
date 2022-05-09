import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    int idDel = 1;


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



        Product[] actual = manager.searchBy ("Первая книга");
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

}