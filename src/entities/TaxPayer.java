package entities;

public class TaxPayer {

    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;

    public TaxPayer() {
    }

    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public Double salaryTax() {
        double finalTax = 0;
        if (salaryIncome/12.00 > 5000.00) {
            finalTax = salaryIncome * 0.20;
        } else if (salaryIncome/12.00 > 3000.00 || salaryIncome/12.00 < 5000.00) {
            finalTax = salaryIncome * 0.10;
        }
        else {
            finalTax = 0;
        }
        return finalTax;
    }

    public Double servicesTax() {
        double finalTax = 0;
        if (servicesIncome > 0.00) {
            finalTax = servicesIncome * 0.15;
        }
        else {
            finalTax = 0;
        }
        return finalTax;
    }

    public Double capitalTax() {
        double finalTax = 0;
        if (capitalIncome > 0.00) {
            finalTax = capitalIncome * 0.20;
        }
        else {
            finalTax = 0;
        }
        return finalTax;
    }

    public Double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public Double taxRebate() {
        double discountedValue = grossTax() * 0.30;
        double benefits = healthSpending + educationSpending;
        double down = 0;
        if (benefits < discountedValue) {
           down = benefits;
        } else {
            down = discountedValue;
        }
        return down;
    }

    public Double netTax() {
        return grossTax() - taxRebate();
    }
}