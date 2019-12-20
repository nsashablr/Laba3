package Laba3S;
import org.w3c.dom.DOMImplementation;
import javax.swing.table.AbstractTableModel;
public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;
    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients ) { //констр
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }

    @Override
    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        switch (col) {
            case 0: {
                return x;
            }
            case 1: {
                Double result = coefficients[0];
                for (int i = 1; i < coefficients.length; i++)
                {
                    result = result * x + coefficients[i];
                }
                return result;
            }
            case 2: {
                Double result = 0.0;
                for (int i = 0; i < coefficients.length; i++)
                {
                    result += coefficients[i] * Math.pow(x, coefficients.length - i - 1);
                }
                return result;
            }
            default: {
                return Math.abs((Double)(this.getValueAt(row, 1)) - (Double)(this.getValueAt(row, 2)));
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return Double.class;
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0: {
                return "Значение X";
            }
            case 1: {
                return "Значение многочлена";
            }
            case 2: {
                return "Значение через pow";
            }
            default: {
                return "Разница";
            }
        }
    }

}

