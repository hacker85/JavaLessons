package advanced;

/**
 * Created by max on 12/22/16.
 */
public class EqualsLesson {
    public static void main(String[] args) {
        Book book = new ChildBook("title", "bla");
        Book book2 = new Book("title");
        Book book3 = new ChildBook("title", "author");
        //reflexive
        System.out.println("reflexive");
        System.out.println(book.equals(book));
        System.out.println("");
        //symmetric
        System.out.println("symmetric");
        System.out.println(book.equals(book2));
        System.out.println(book2.equals(book));
        System.out.println("");
        //transitive
        System.out.println("transitive");
        System.out.println(book.equals(book2));
        System.out.println(book2.equals(book3));
        System.out.println(book3.equals(book));
        System.out.println("");
        //consistent
        System.out.println("consistent");
        System.out.println(book.equals(book2));
        System.out.println(book.equals(book2));
        System.out.println("");
        //non-null
        System.out.println("non-null");
        System.out.println(book.equals(null));
    }
}
class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    //consistent
//    @Override
//    public boolean equals(Object obj) {
//        return Math.random() < 0.5;
//    }

    //transitive
    @Override
    public boolean equals(Object obj) {
        return obj != null && title.equals(((Book)obj).title);
    }

    //reflexive & symmetric
//    @Override
//    public boolean equals(Object obj) {
//        return title.equals(obj);
//    }

//    @Override
//    public boolean equals(Object obj) {
//        return obj != null && title.equals(((Book)obj).title);
//    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Book book = (Book) o;
//
//        return this.title.equals(book.title);
//    }
}

class ChildBook extends Book {
    String author;

    public ChildBook(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ChildBook) {
            return obj != null && title.equals(((ChildBook) obj).title) && author.equals(((ChildBook) obj).author);
        } else {
            return super.equals(obj);
        }
    }
}