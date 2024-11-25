package merp.model.primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCriticalHit {

    @Test
    public void criticalHitTableCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            CriticalHit.of(null, CriticalHitSeverity.C);
        });
    }

    @Test
    public void criticalHitSeverityCannotBeNull() {
        Assertions.assertThrows(AssertionError.class, () -> {
            CriticalHit.of(CriticalHitTable.GR, null);
        });
    }

    @Test
    public void severityCanBeLimited() {
        CriticalHit expected = CriticalHit.of(CriticalHitTable.GR, CriticalHitSeverity.A);
        assertEquals(expected, CriticalHit.of(CriticalHitTable.GR, CriticalHitSeverity.E).limitBy(CriticalHitSeverity.A));
    }

    @Test
    public void severityMustNotBeLimited() {
        CriticalHit expected = CriticalHit.of(CriticalHitTable.GR, CriticalHitSeverity.D);
        assertEquals(expected, CriticalHit.of(CriticalHitTable.GR, CriticalHitSeverity.D).limitBy(CriticalHitSeverity.E));
    }

    @Test
    public void severityIsNotLimitedByNone() {
        CriticalHit expected = CriticalHit.of(CriticalHitTable.GR, CriticalHitSeverity.D);
        assertEquals(expected, CriticalHit.of(CriticalHitTable.GR, CriticalHitSeverity.D).limitBy(CriticalHitSeverity.NONE));
    }

    @Test
    public void criticalHitIsPrintedCorrectly() {
        assertEquals("SL (C, ±0)", CriticalHit.of(CriticalHitTable.SL, CriticalHitSeverity.C).toString());
    }

    @Test
    public void severityNotPrintedIfNoHitTable() {
        assertEquals("-", CriticalHit.of(CriticalHitTable.NONE, CriticalHitSeverity.C).toString());
    }
}
