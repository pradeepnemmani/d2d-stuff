package com.d2d.modules.corejava.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Container<T> extends ArrayList<T> implements List<T>, Serializable
{
    private List<String> myList = new ArrayList<>();

    private static void test1( List<String> str )
    {

    }

    private static void test2()
    {
        test1( new ArrayList<String>() );
    }
}
