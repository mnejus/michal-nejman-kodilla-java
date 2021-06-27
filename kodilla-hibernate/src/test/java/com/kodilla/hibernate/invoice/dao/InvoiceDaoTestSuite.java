package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("FV01/06/2021");

        Product product = new Product("Product");
        Product product1 = new Product("Product One");
        Product product2 = new Product("Product Two");

        Item item = new Item(product, new BigDecimal(10), 100);
        Item item1 = new Item(product1, new BigDecimal(100), 10);
        Item item2 = new Item(product2, new BigDecimal(1000), 1);

        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        productDao.save(product);
        int productId = product.getId();
        productDao.save(product1);
        int productOneId = product1.getId();
        productDao.save(product2);
        int productTwoId = product2.getId();
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, productId);
        assertNotEquals(0, productOneId);
        assertNotEquals(0, productTwoId);
        assertNotEquals(0, invoiceId);

        //CleanUp
        invoiceDao.deleteById(invoiceId);

    }
}
