package Laba3S;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class GornerTableCellRenderer implements TableCellRenderer {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
    private Boolean search = false;
    private String[] searchArgs;
    private int argsSize;

    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        panel.add(label);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        if ((col == 1 || col == 2) && needle != null && needle.equals(formattedDouble)) {
            panel.setBackground(Color.YELLOW);
        } else {
            panel.setBackground(Color.WHITE);
        }
        if (this.search) {
            for (int i = 0; i < this.argsSize; i++) {
                if ((col == 1 || col == 2) && this.searchArgs[i].equals(formattedDouble)) {
                    panel.setBackground(Color.YELLOW);
                }
            }
        }
        if ((col == 1 || col == 2) && Double.parseDouble(formattedDouble) != 0) {
            if (Double.parseDouble(formattedDouble) > 0) {
                panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            }
            if (Double.parseDouble(formattedDouble) < 0) {
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            }
        } else {
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        }
        return panel;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    public void searhPrime(String[] args, int argsSize) {
        this.search = true;
        this.searchArgs = args;
        this.argsSize = argsSize;
    }

    public void searchPrimeSetEnabled(Boolean enable) {
        this.search = enable;
    }
}
