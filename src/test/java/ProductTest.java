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
    void shouldAdditemAndDelId() {
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
    void shouldAddItems() {
        ProductManager manager = new ProductManager();


        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);

        Product[] actual = manager.findAll();
        Product[] expected = new Product[]{bookFirst, bookSecond, bookThird};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldItem() {
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

}