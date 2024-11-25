package merp.model.primitives.table;

public class AttackTables {
    public static final AttackTable SLASHING = new AttackTableSlashing();
    public static final AttackTable CONCUSSION = new AttackTableConcussion();
    public static final AttackTable TWOHAND = new AttackTable2Hand();
    public static final AttackTable MISSILE = new AttackTableMissile();
    public static final AttackTable BITEANDCLAW_SMALL = new AttackTableSmallTeethAndClaws();
    public static final AttackTable BITEANDCLAW_NORMAL = new AttackTableNormalTeethAndClaws();
    public static final AttackTable BITEANDCLAW_LARGE = new AttackTableLargeTeethAndClaws();
    public static final AttackTable BITEANDCLAW_HUGE = new AttackTableHugeTeethAndClaws();
    public static final AttackTable GRAPPLING_SMALL = new AttackTableSmallGrapplingAndUnbalancing();
    public static final AttackTable GRAPPLING_NORMAL = new AttackTableNormalGrapplingAndUnbalancing();
    public static final AttackTable GRAPPLING_LARGE = new AttackTableLargeGrapplingAndUnbalancing();
    public static final AttackTable GRAPPLING_HUGE = new AttackTableHugeGrapplingAndUnbalancing();
}
