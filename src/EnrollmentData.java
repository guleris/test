package csv;

/**
 * Creates table of enrollment data for various countries over a specific range of years using 1D and 2D arrays.
 */
public class EnrollmentData {
    private String[] countryNames;
    private int[] yearLabels;
    private double[][] table;
    private int numCount = 0;    //points to the row of data do be entered

    /**
     * Constructs a new EnrollmentData object.
     * @param maxRows       Max number of countries in the table.
     * @param numYears      # of years per country
     * @param startingYear  first year to start data
     */
    public EnrollmentData(int maxRows, int numYears, int startingYear) {
        this.countryNames = new String[maxRows];
        this.yearLabels = new int[numYears];
        this.table = new double[maxRows][numYears];

        for (int i = 0; i < numYears; i++) {
            yearLabels[i] = startingYear + i;
        }
    }

    /**
     * Adds the data for a country to the enrollment data table.
     * @param countryName       The name of the country to add.
     * @param enrollmentData    1D array of doubles showing enrollment per year for a country
     */
    public void addCountry(String countryName, double[] enrollmentData){
        countryNames[numCount] = countryName;
        table[numCount] = enrollmentData;
        numCount++;
    }

    /**
     * Returns a string representation of the data formatted as a table.
     * @return  Formatted string
     */
    public String toString(){
        StringBuilder representation = new StringBuilder();
        representation.append(String.format("%15s", "Country Name"));
        for (int i = 0; i < yearLabels.length; i++){
            representation.append(String.format("%8d", yearLabels[i]));
        }
        representation.append("\n");

        for (int i = 0; i < numCount; i++){
            representation.append(String.format("%15s", countryNames[i]));
            for (int j = 0; j < table[i].length; j++){
                double data = table[i][j];
                if (data < 0){
                    representation.append(String.format("%8s", " "));
                } else {
                    representation.append(String.format("%8.2f", data));
                }
            }
            representation.append("\n");
        }
        return representation.toString();
    }
}
