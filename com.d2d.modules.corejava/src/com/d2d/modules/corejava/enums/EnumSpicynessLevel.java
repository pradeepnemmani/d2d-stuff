package com.d2d.modules.corejava.enums;

public enum EnumSpicynessLevel
{
    MILD( 1 ), MEDIUM( 2 ), REGULAR( 3 ), HOT( 4 ), EXTRA_HOT( 5 );

    private int numberOfMirchis;

    private EnumSpicynessLevel( int numberOfMirchis )
    {
        this.numberOfMirchis = numberOfMirchis;
    }

}
