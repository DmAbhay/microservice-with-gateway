package org.scheduler;

import dataman.dmbase.utils.DmUtil;

import java.sql.Date;

public class Test {

    public static void main(String[] args) {


//        System.out.println(DmUtil.dNull(java.sql.Date.valueOf("23-07-2025")));
//        System.out.println();

        System.out.println(DmUtil.normalizeToDdMmmYyyy("12-Apr-2024"));
        System.out.println(DmUtil.normalizeToDdMmmYyyy("23-Jul-2025"));  // 23-Jul-2025
        System.out.println(DmUtil.normalizeToDdMmmYyyy("2025-Jul-23"));  // 23-Jul-2025
        System.out.println(DmUtil.normalizeToDdMmmYyyy("")); // null
        System.out.println(DmUtil.normalizeToDdMmmYyyy("23-23-2025"));   // 23-Jul-2025

    }



}
