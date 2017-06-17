package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BooksSellLesson {
    // 5% 10% 15% 20%
    enum Books {ONE, TWO ,THREE, FOUR, FIVE}
    int price = 10;
    public static void main(String[] args) {
        List<Books> books = new ArrayList<>();
        books.add(Books.ONE);
        books.add(Books.TWO);
        books.add(Books.THREE);
        books.add(Books.FOUR);//34
        books.add(Books.ONE);
        books.add(Books.TWO);//19
        System.out.println(getPrice(books));//53
    }
    static int getPrice(List<Books> books) {
        List<Set<Books>> booksList = new ArrayList<>();
        Set<Books> booksSet = new HashSet<>();
        while (books.size() != 0) {
            for (int i = 0; i < books.size(); ) {
                int size = booksSet.size();
                booksSet.add(books.get(i));
                if (booksSet.size() > size) {
                    books.remove(i);
                } else {
                    i++;
                }
            }
            booksList.add(booksSet);
            booksSet = new HashSet<>();
        }
        int price = 0;
        for (Set<Books> set : booksList) {
            switch (set.size()) {
                case 5: price += 40; break;
                case 4: price += 34; break;
                case 3: price += 27; break;
                case 2: price += 19; break;
                case 1: price += 10; break;
            }
        }
        return price;
    }
}
