package komarovs.models;

/**
 * This class models Employee object.
 *
 * @author Svetlana Komarova
 *
 */
public class Employee {

    private String name;
    private double hourlyRate;
    private double hours;

    public Employee(String name, double hourlyRate, double hours) throws Exception {
        this.name = name;
        this.setHourlyRate(hourlyRate);
        this.setHours(hours);
    }

    /**
     * Get the value of hours
     *
     * @return the value of hours
     */
    public double getHours() {
        return hours;
    }

    /**
     * Set the value of hours
     *
     * @param hours new value of hours
     */
    public void setHours(double hours) throws Exception {
        
        //make sure the number of hours not exceed more than 40 hours
        //must be positive number only
        if (hours <= 40) {
            this.hours = hours;
        } else {
            throw new Exception("The number of hours is exceeded the weekly maximum.");
        }
    }

    /**
     * Get the value of hourlyRate
     *
     * @return the value of hourlyRate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Set the value of hourlyRate
     *
     * @param hourlyRate new value of hourlyRate
     */
    public void setHourlyRate(double hourlyRate) throws Exception {
        
        //make sure the hourly wage within the allowed range - over $13.15 and less than $50.00
        if (hourlyRate >= 14.00 && hourlyRate <= 50.0) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new Exception("The hourly rate of $" + hourlyRate + " is out of range.");
        }
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) { 
        
            this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", hourlyRate=" + hourlyRate + ", hours=" + hours + '}';
    }

}
