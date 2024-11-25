package merp.model.primitives.weapon;

import merp.model.primitives.*;
import merp.model.primitives.table.AttackTables;

public class Weapons {
    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable BROADSWORD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Broadsword"), AttackTables.SLASHING)
            .withFumble(Range.of(1,3)).withPrimaryCriticalHitTable(CriticalHitTable.SL);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable DAGGER =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Dagger"),AttackTables.SLASHING)
            .withFumble(Range.of(1,1)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withPrimaryCriticalHitLimit(CriticalHitSeverity.C)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-15), Modifier.of(-15),
                            Modifier.of(0), Modifier.of(0), Modifier.of(0))).withBaseRange(BaseRange.of(5));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable HAND_AXE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Handaxe"),AttackTables.SLASHING)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(+5), Modifier.of(+5),
                            Modifier.of(0), Modifier.of(0), Modifier.of(0))).withBaseRange(BaseRange.of(5));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable SCIMITAR =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Scimitar"),AttackTables.SLASHING)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-5), Modifier.of(-5),
                            Modifier.of(5), Modifier.of(5), Modifier.of(5)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable SHORT_SWORD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Shortsword"),AttackTables.SLASHING)
                    .withFumble(Range.of(1,2)).withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-10), Modifier.of(-10),
                            Modifier.of(10), Modifier.of(10), Modifier.of(10))).withBaseRange(BaseRange.of(1));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable WHIP =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Whip"),AttackTables.SLASHING)
                    .withFumble(Range.of(1,6)).withPrimaryCriticalHitTable(CriticalHitTable.GR)
                    .withPrimaryCriticalHitLimit(CriticalHitSeverity.C)
                    .withSecondaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.A)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-10), Modifier.of(-10),
                            Modifier.of(-10), Modifier.of(-10), Modifier.of(-10)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable CLUB =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Club"),AttackTables.CONCUSSION)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withPrimaryCriticalHitLimit(CriticalHitSeverity.D)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-10), Modifier.of(-10),
                            Modifier.of(-10), Modifier.of(-10), Modifier.of(-10))).withBaseRange(BaseRange.of(1));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable MAUL =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Maul"),AttackTables.CONCUSSION)
                    .withFumble(Range.of(1,2)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withBaseRange(BaseRange.of(2));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable MORNING_STAR =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Morning Star"),AttackTables.CONCUSSION)
                    .withFumble(Range.of(1,8)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withSecondaryCriticalHitTable(CriticalHitTable.PU)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.A)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(10), Modifier.of(10),
                            Modifier.of(10), Modifier.of(10), Modifier.of(10)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable NET =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Net"),AttackTables.GRAPPLING_NORMAL)
                    .withFumble(Range.of(1,6)).withPrimaryCriticalHitTable(CriticalHitTable.GR)
                    .withBaseRange(BaseRange.of(3));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable WAR_HAMMER =
            new WeaponBuilder().withNameAndAttackTable(Name.of("War Hammer"),AttackTables.CONCUSSION)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(5), Modifier.of(5),
                            Modifier.of(5), Modifier.of(5), Modifier.of(5))).withBaseRange(BaseRange.of(5));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable JAVELIN_SHIELD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Javelin and Shield"),AttackTables.SLASHING)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-10), Modifier.of(-10),
                            Modifier.of(-10), Modifier.of(-10), Modifier.of(-10))).withBaseRange(BaseRange.of(10));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable JAVELIN_NO_SHIELD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Javelin without Shield"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-10), Modifier.of(-10),
                            Modifier.of(-10), Modifier.of(-10), Modifier.of(-10))).withBaseRange(BaseRange.of(10));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable SPEAR_SHIELD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Spear and Shield"),AttackTables.SLASHING)
                    .withFumble(Range.of(1,5)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withSecondaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.A)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-5), Modifier.of(-5),
                            Modifier.of(-5), Modifier.of(-5), Modifier.of(-5))).withBaseRange(BaseRange.of(7));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable SPEAR_NO_SHIELD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Spear without Shield"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,5)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withSecondaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.A)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-5), Modifier.of(-5),
                            Modifier.of(-5), Modifier.of(-5), Modifier.of(-5))).withBaseRange(BaseRange.of(7));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable LANCE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Mounted Lance"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,7)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withSecondaryCriticalHitTable(CriticalHitTable.TH)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(15), Modifier.of(15),
                            Modifier.of(15), Modifier.of(15), Modifier.of(15)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable HALBERD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Halberd"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,7)).withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitTable(CriticalHitTable.PU)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-5), Modifier.of(-5),
                            Modifier.of(-5), Modifier.of(-5), Modifier.of(-5)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable BATTLE_AXE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Battle-Axe"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,5)).withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitTable(CriticalHitTable.CR)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(5), Modifier.of(5),
                            Modifier.of(-5), Modifier.of(-5), Modifier.of(-5)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable MACE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Mace"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,8)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withSecondaryCriticalHitTable(CriticalHitTable.PU)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(10), Modifier.of(10),
                            Modifier.of(10), Modifier.of(10), Modifier.of(10)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable STAFF =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Quarterstaff"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,3)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-10), Modifier.of(-10),
                            Modifier.of(-10), Modifier.of(-10), Modifier.of(-10)));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable TWO_HAND_SWORD =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Two-Handed Sword"),AttackTables.TWOHAND)
                    .withFumble(Range.of(1,5)).withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitTable(CriticalHitTable.CR);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable CROSSBOW =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Crossbow"),AttackTables.MISSILE)
                    .withFumble(Range.of(1,5)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withBaseRange(BaseRange.of(30));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable BOLA =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Bola"),AttackTables.MISSILE)
                    .withFumble(Range.of(1,7)).withPrimaryCriticalHitTable(CriticalHitTable.GR)
                    .withSecondaryCriticalHitTable(CriticalHitTable.CR)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.A)
                    .withArmourModifier(ArmourModifier.of(Modifier.of(-5), Modifier.of(-5),
                            Modifier.of(-5), Modifier.of(-5), Modifier.of(-5)))
                    .withBaseRange(BaseRange.of(13));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable COMPOSITE_BOW =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Composite Bow"),AttackTables.MISSILE)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withBaseRange(BaseRange.of(25));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable LONG_BOW =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Long Bow"),AttackTables.MISSILE)
                    .withFumble(Range.of(1,5)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withBaseRange(BaseRange.of(35));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable SHORT_BOW =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Short Bow"),AttackTables.MISSILE)
                    .withFumble(Range.of(1,4)).withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withBaseRange(BaseRange.of(20));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable SLING =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Sling"),AttackTables.MISSILE)
                    .withFumble(Range.of(1,6)).withPrimaryCriticalHitTable(CriticalHitTable.CR)
                    .withPrimaryCriticalHitLimit(CriticalHitSeverity.D)
                    .withBaseRange(BaseRange.of(17));

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable BITE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Bite (big)"),AttackTables.BITEANDCLAW_LARGE)
                    .withPrimaryCriticalHitTable(CriticalHitTable.PU)
                    .withSecondaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.C);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable BITE_NORMAL =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Bite (normal)"),AttackTables.BITEANDCLAW_NORMAL)
                    .withPrimaryCriticalHitTable(CriticalHitTable.PU);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable CLAW =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Claw"),AttackTables.BITEANDCLAW_LARGE)
                    .withPrimaryCriticalHitTable(CriticalHitTable.SL)
                    .withSecondaryCriticalHitTable(CriticalHitTable.PU)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.B);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable GRAPPLE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Grapple"),AttackTables.GRAPPLING_LARGE)
                    .withPrimaryCriticalHitTable(CriticalHitTable.GR)
                    .withSecondaryCriticalHitTable(CriticalHitTable.TH)
                    .withSecondaryCriticalHitLimit(CriticalHitSeverity.C);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable KICK =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Punch/Kick"),AttackTables.BITEANDCLAW_LARGE)
                    .withPrimaryCriticalHitTable(CriticalHitTable.TH)
                    .withPrimaryCriticalHitLimit(CriticalHitSeverity.A);

    public static final WeaponBuilder.WeaponBuilderWithNameAndAttackTable TACKLE =
            new WeaponBuilder().withNameAndAttackTable(Name.of("Wrestle/Tackle"),AttackTables.GRAPPLING_LARGE)
                    .withPrimaryCriticalHitTable(CriticalHitTable.GR)
                    .withPrimaryCriticalHitLimit(CriticalHitSeverity.A);
}
