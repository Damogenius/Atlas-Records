package Principles.DIP_Violation;

 class Clothes {
    void seeRating() {
        System.out.println("Rating Clothes");
    }
    void viewSample() {
        System.out.println("Viewing Clothes Sample");
    }
}

 class Books {
    void seeRating() {
        System.out.println("Rating Books");
    }
    void readSample() {
        System.out.println("Reading Books Sample");
    }
}

 class Cupboard { // High-level class depending directly on low-level classes
    Clothes cobj;

    void addClothes(Clothes cobj) {
        this.cobj = cobj;
    }

    void CustomizeClothes() {
        cobj.seeRating();
        cobj.viewSample();
    }
}
public class Driverclass {
    public static void main(String[] args) {
        Clothes clothes = new Clothes();
        clothes.seeRating();
        clothes.viewSample();

        Books books = new Books();
        books.seeRating();
        books.readSample();

        Cupboard cupboard = new Cupboard();
        cupboard.addClothes(clothes);
        cupboard.CustomizeClothes();

    }
}
