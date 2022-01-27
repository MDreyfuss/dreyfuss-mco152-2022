public class Projectile
{

    private double angleInDegrees;
    private double velocity;

    public Projectile(double angleInDegrees, double velocity)
    {
        this.angleInDegrees = angleInDegrees;
        this.velocity = velocity;
    }

    public double getAngleInDegrees() {
        return angleInDegrees;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getY(double time) {
        return (Math.sin(Math.toRadians(this.getAngleInDegrees())) * this.getVelocity() * time) - .5 * (9.8 * time * time);
    }

    public double getX(double time) {
        return Math.cos(Math.toRadians(this.getAngleInDegrees())) * this.getVelocity() * time;
    }
}
