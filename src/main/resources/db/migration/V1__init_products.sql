-- V1__init_products.sql
CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         image_url VARCHAR(255),
                         price DOUBLE NOT NULL,
                         stock INT NOT NULL
);

INSERT INTO product (name, image_url, price, stock) VALUES
                                                        ('Product 1', 'http://example.com/image1.jpg', 100.0, 10),
                                                        ('Product 2', 'http://example.com/image2.jpg', 150.0, 20),
                                                        ('Product 3', 'http://example.com/image3.jpg', 200.0, 30),
                                                        ('Product 4', 'http://example.com/image4.jpg', 250.0, 40),
                                                        ('Product 5', 'http://example.com/image5.jpg', 300.0, 50),
                                                        ('Product 6', 'http://example.com/image6.jpg', 350.0, 60),
                                                        ('Product 7', 'http://example.com/image7.jpg', 400.0, 70),
                                                        ('Product 8', 'http://example.com/image8.jpg', 450.0, 80),
                                                        ('Product 9', 'http://example.com/image9.jpg', 500.0, 90),
                                                        ('Product 10', 'http://example.com/image10.jpg', 550.0, 100);
