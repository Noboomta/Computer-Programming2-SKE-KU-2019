package converter;

public class UnitFactory {
    private Temperature[] values;

    public String[] getUnitTypes() {
        UnitType[] unitType = UnitType.values();
        String[] types = new String[5];
        for (int i = 0; i < unitType.length; i++) {
            types[i] = unitType[i].toString();
        }
        return types;
    }

    public static Unit[] getUnits(String unitName) {
        switch (unitName) {
            case "Length":
                return Length.values();
            case "Volume":
                return Volume.values();
            case "Temperature":
                return Temperature.values();
            case "Weight":
                return Weight.values();
            case "Time":
                return Time.values();
            default:
                return new Unit[0];
        }
    }
}
