import java.util.Arrays;

public class ProjectileMotion {
    public static void main(String [] args)
    {
        Projectile p = new Projectile(52, 43);

        //not done
        double x = p.getX( 7);
        System.out.println("x = "+ x);
        double y = p.getY(7);
        System.out.println("y = "+ y);

        QuadraticEquation qe = new QuadraticEquation(4,7,3);
        System.out.println(Arrays.toString(qe.getX()));

    }


}
