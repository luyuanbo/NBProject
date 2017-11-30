package com.lus.suanfademo;

import java.io.File;

/**
 * Created by 卢总 on 2017/11/30.
 */

public class Futils {

    public static void printlev(File dir){
        //获取所有的文件和文件夹
        File[] files = dir.listFiles();
        //遍历数组
        for (File file:files) {
            System.out.println(file);
            //如果是文件夹递归调用
            if (file.isDirectory()){
                printlev(file);
            }
        }
    }

    public static int fibonacci(int n)//兔子算法
    {
        int t1,t2;
        if(n == 1 || n == 2)
        {
            return 1;

        }
        else
        {
            t1 = fibonacci( n- 1);
            t2 = fibonacci(n - 2);
            return t1 + t2;

        }
    }

}
