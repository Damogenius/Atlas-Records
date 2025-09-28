package Principles.DIP;
import java.util.ArrayList;
import java.util.List;

// Interface abstraction for all products
interface IProduct {
    void SeeReviews();
    void getSample();
}

// Clothes implements IProduct
class Clothes implements IProduct {
    @Override
    public void SeeReviews() {
        System.out.println("Viewing reviews of Clothes");
    }

    @Override
    public void getSample() {
        System.out.println("Getting sample of Clothes");
    }
}

// Books implements IProduct
 class Books implements IProduct {
    @Override
    public void SeeReviews() {
        System.out.println("Viewing reviews of Books");
    }

    @Override
    public void getSample() {
        System.out.println("Getting sample of Books");
    }
}

// Cupboard depends on abstraction IProduct, not concrete classes


 class Cupboard {
    private List<IProduct> products = new ArrayList<>();

    public void addProduct(IProduct product) {
        products.add(product);
    }

    public void customizeProducts() {
        for (IProduct product : products) {
            product.SeeReviews();
            product.getSample();
        }
    }
}

// Driver class to demonstrate DIP in action
public class Driverclass {
    public static void main(String[] args) {
        Cupboard cupboard = new Cupboard();

        Clothes clothes = new Clothes();
        Books books = new Books();

        cupboard.addProduct(clothes);
        cupboard.addProduct(books);

        cupboard.customizeProducts();
    }
}

