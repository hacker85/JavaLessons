package solid;

public class LiskovPrincipleLesson {
    private static Rect getNewRectangle()
    {
        //some factory mehtod
        return new Square();
    }

    public static void main (String args[])
    {
        Rect r = LiskovPrincipleLesson.getNewRectangle();

        r.setWidth(5);
        r.setHeight(10);

        System.out.println(r.getArea());
    }
}

//Liskov substitution principle
//if S is a subtype of T, then objects of type T may be replaced with objects of type S without altering any of the desirable properties of T
class Rect
{
    protected int width;
    protected int height;

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }


    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getArea(){
        return width * height;
    }
}

class Square extends Rect
{
    public void setWidth(int width){
        this.width = width;
        height = width;
    }

    public void setHeight(int height){
        width = height;
        this.height = height;
    }

}