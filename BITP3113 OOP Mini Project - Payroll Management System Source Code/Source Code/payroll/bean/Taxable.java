package payroll.bean;

/**
 * This interface is used to calculate the tax that a employee need to pay every month
 *
 */
public interface Taxable {
	public double taxRate = 0.06;
	public double calculateTax(Employee employee);
}
