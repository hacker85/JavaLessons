package solid;

public class SolidOpenCloseLesson {
    public static void main(String[] args) {

    }
}
//open close
//software entities … should be open for extension, but closed for modification
class Rectangle
{
    double width;
    double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class AreaCalculator
{
    public double Area(Rectangle[] shapes)
    {
        double area = 0;
        for (Rectangle shape : shapes)
        {
            area += shape.getWidth() * shape.getHeight();
        }

        return area;
    }

    double Area(Object[] shapes)
    {
        double area = 0;
        for (Object shape : shapes) {
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                area += rectangle.getWidth() * rectangle.getHeight();
            } else {
                Circle circle = (Circle)shape;
                area += circle.getRadius() * circle.getRadius() * Math.PI;
            }
        }

        return area;
    }

    public double Area(Shape[] shapes)
    {
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.Area();
        }
        return area;
    }
}

class Circle implements Shape {
    double radius;
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return radius * radius * Math.PI;
    }
}

interface Shape
{
    double Area();
}

class Rectangle2 implements Shape {
    double width;
    double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double Area()
    {
        return width * height;
    }
}



//---------------------
//class LoanApprovalHandler
//{
//    public void approveLoan(PersonalValidator validator)
//    {
//        if ( validator.isValid())
//        {
//            //Process the loan.
//        }
//    }
//}
//public class PersonalLoanValidator
//{
//    public boolean isValid()
//    {
//        //Validation logic
//    }
//}
//
//public class LoanApprovalHandler
//{
//    public void approvePersonalLoan (PersonalLoanValidator validator)
//    {
//        if ( validator.isValid())
//        {
//            //Process the loan.
//        }
//    }
//    public void approveVehicleLoan (VehicleLoanValidator validator )
//    {
//        if ( validator.isValid())
//        {
//            //Process the loan.
//        }
//    }
//    // Method for approving other loans.
//}
//class PersonalLoanValidator
//{
//    public boolean isValid()
//    {
//        //Validation logic
//    }
//}
//public class VehicleLoanValidator
//{
//    public boolean isValid()
//    {
//        //Validation logic
//    }
//}
//
//public abstract class Validator
//{
//    public boolean isValid();
//}
//class PersonalLoanValidator
//        extends Validator
//{
//    public boolean isValid()
//    {
//        //Validation logic.
//    }
//}
//class LoanApprovalHandler
//{
//    public void approveLoan(Validator validator)
//    {
//        if ( validator.isValid())
//        {
//            //Process the loan.
//        }
//    }
//}