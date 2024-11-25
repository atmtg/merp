package merp.model.primitives;

import java.io.Serializable;
import java.util.Objects;

public class CriticalHit implements Serializable {
    public static final CriticalHit NONE = CriticalHit.of(CriticalHitTable.NONE, CriticalHitSeverity.NONE);

    private CriticalHitTable table;
    private CriticalHitSeverity severity;

    private CriticalHit(CriticalHitTable table, CriticalHitSeverity severity) {
        this.table = table;
        this.severity = severity;
    }

    public static CriticalHit of(CriticalHitTable table, CriticalHitSeverity severity) {
        assert table != null;
        assert severity != null;

        return new CriticalHit(table, severity);
    }

    public CriticalHit limitBy(CriticalHitSeverity severity) {
        return this.severity.compareTo(severity) <= 0 ? this : CriticalHit.of(this.table, severity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CriticalHit that = (CriticalHit) o;
        return table == that.table && severity == that.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, severity);
    }

    @Override
    public String toString() {
        return this.table != CriticalHitTable.NONE && this.severity != CriticalHitSeverity.NONE ? this.table + " (" + this.severity + ", " + severityBonus(severity) + ")" : "-";
    }

    private String severityBonus(CriticalHitSeverity severity) {
        switch (severity) {
            case T : return "-50";
            case A : return "-20";
            case B : return "-10";
            case C : return "±0";
            case D : return "+10";
            case E : return "+20";
            default : return "";
        }
    }
}
