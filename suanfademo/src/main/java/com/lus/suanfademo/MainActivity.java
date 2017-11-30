package com.lus.suanfademo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.nBtn1)
    Button nBtn1;
    @BindView(R.id.nBtn2)
    Button nBtn2;
    @BindView(R.id.nBtn3)
    Button nBtn3;
    @BindView(R.id.nBtn4)
    Button nBtn4;
    @BindView(R.id.mtext)
    TextView mtext;
    @BindView(R.id.meditText)
    EditText meditText;
    @BindView(R.id.nBtn5)
    Button nBtn5;
    @BindView(R.id.nBtn6)
    Button nBtn6;
    @BindView(R.id.nBtn7)
    Button nBtn7;
    @BindView(R.id.nBtn8)
    Button nBtn8;
    @BindView(R.id.nBtn9)
    Button nBtn9;
    @BindView(R.id.nBtn10)
    Button nBtn10;
    @BindView(R.id.nBtn11)
    Button nBtn11;
    @BindView(R.id.nBtn12)
    Button nBtn12;
    @BindView(R.id.meditText2)
    EditText meditText2;
    //uiHandler在主线程中创建，所以自动绑定主线程
    private Handler uiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    System.out.println("handleMessage thread id " + Thread.currentThread().getId());

                    break;
            }
        }
    };

    private StringBuffer stringBuffer1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        File dir = getDir("D:\\files\\Android\\13a.text", MODE_APPEND);
        Futils.printlev(dir);
    }

    @OnClick({R.id.nBtn1, R.id.nBtn2, R.id.nBtn3, R.id.nBtn4, R.id.nBtn5, R.id.nBtn6, R.id.nBtn7, R.id.nBtn8, R.id.nBtn9, R.id.nBtn10, R.id.nBtn11, R.id.nBtn12})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.nBtn1:
                int[][] iArray = new int[10][];
                StringBuffer stringBuffer = new StringBuffer();

                //保证输出10行
                for (int i = 0; i < 10; i++) {
                    //行是从0开始 列数加1 否则出现空指针异常
                    iArray[i] = new int[i + 1];
                    //从第一行开始 依次给每行加不同的空格
                    for (int k = 9; k > i; k--) {
                        System.out.print("    ");
                        stringBuffer.append("\t\t");
                    }
                    //控制每行输出的元素
                    for (int j = 0; j <= i; j++) {
                        if (j == 0 || j == i) {
                            //两边的值
                            iArray[i][j] = 1;
                            System.out.print(iArray[i][j] + "    ");
                            stringBuffer.append(iArray[i][j] + "\t\t");
                            mtext.setText(stringBuffer);
                        } else {
                            //中间的值
                            iArray[i][j] = iArray[i - 1][j] + iArray[i - 1][j - 1];
                            System.out.print(iArray[i][j] + "     ");
                            stringBuffer.append(iArray[i][j] + "\t\t");
                            mtext.setText(stringBuffer);
                        }

                    }
                    System.out.println();//换行

                    stringBuffer.append("\n");
                    mtext.setText(stringBuffer);
                }
                break;
            case R.id.nBtn2:
                int arr[] = new int[500];
                arr[0] = arr[1] = 1;
                for (int i = 2; i < arr.length; i++) {
                    arr[i] = arr[i - 1] + arr[i - 2];
                }
                System.out.println("斐波那契数列的前20项如下所示：");
                for (int i = 0; i < arr.length; i++) {
                    if (i % 5 == 0)
                        System.out.println();
                    System.out.print(arr[i] + "\t");
                }
                break;
            case R.id.nBtn3:
                MyThread myThread = new MyThread();
                myThread.start();
                mtext.setText(stringBuffer1);
                break;
            case R.id.nBtn4:


                break;
            case R.id.nBtn5://输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
                int digital = 0;
                int character = 0;
                int blank = 0;
                int other = 0;
                char[] ch = null;
                String editstr = meditText.getText().toString();
                ch = editstr.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] >= '0' && ch[i] <= '9') {
                        digital++;
                    } else if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
                        character++;
                    } else if (ch[i] == ' ') {
                        blank++;
                    } else {
                        other++;
                    }
                }
                mtext.setText("数字个数是：" + digital + "英文字母个数是：" + character + "空格个数是：" + blank + "其它字符个数是：" + other);

                break;
            case R.id.nBtn6:
                String nstr = meditText.getText().toString();
                int n = Integer.parseInt(nstr);
                int num = Futils.fibonacci(n);//"递推算法求解兔子产子问题!请输入时间:"
                mtext.setText("经过" + n + "月的时间，功能繁殖成" + num + "对兔子!");
                break;
            case R.id.nBtn7://有1,2,3,4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
                StringBuffer sbf = new StringBuffer();
                int i = 0;
                int j = 0;
                int k = 0;
                int t = 0;
                for (i = 1; i <= 4; i++)
                    for (j = 1; j <= 4; j++)
                        for (k = 1; k <= 4; k++)
                            if (i != j && j != k && i != k) {
                                t += 1;
                                sbf.append(i * 100 + j * 10 + k);
                                sbf.append("       ");
                            }
                mtext.setText(sbf + "一共有" + t);
                break;
            case R.id.nBtn8:
                dSum();//求1+2!+3!+...+20!的和
                break;
            case R.id.nBtn9://回文数
                String string = meditText.getText().toString();
                int number = Integer.parseInt(string);
                HuiWenShu(number);
                break;
            case R.id.nBtn10://计算字符串中子串出现的次数
                String str1 = meditText.getText().toString();
                String str2 = meditText2.getText().toString();
                strCount(str1,str2);
                break;
            case R.id.nBtn11:
                String s = meditText.getText().toString();
                int n1 = Integer.parseInt(s);
                Baoshu(n1);
                break;
            case R.id.nBtn12:
                Sushu();//求100之内的素数 //使用除sqrt(n)的方法求出的素数不包括2和3
                break;
        }


    }

    /*求1+2!+3!+...+20!的和*/
    void dSum() {

        BigDecimal result = new BigDecimal(0);
        BigDecimal decimal = new BigDecimal(1);
        for (int i = 1; i <= 20; i++) {
            decimal = decimal.multiply(new BigDecimal(i));
            result = result.add(decimal);
            //   System.out.println(result);
        }
        mtext.setText("求1+2!+3!+...+20!的和-----" + result);
    }

    /**
     * 5位数中找出所有，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
     *
     * @param number
     */
    void HuiWenShu(int number) {

        if (number < 10000 && number >= 10000) {
            mtext.setText("输入的不是5位整数!");
            return;
        }
        int a = number / 10000;
        int b = number / 1000 % 10;
        int c = number / 100 % 10;
        int d = number / 10 % 10;
        int e = number % 10;
        if (a == e && b == d) {
            mtext.setText(number + "是回文数");
        } else {
            mtext.setText(number + "输入的不是回文数");
        }

    }

    /**
     * 计算字符串中子串出现的次数
     * @param str
     * @param strCon
     */
    void strCount(String str, String strCon) {
        int count = 0;
        int start=0;
        while (str.indexOf(strCon,start)>=0 && start<str.length()) {
            count++;
            start = str.indexOf(strCon, start) + strCon.length();
        }
        mtext.setText(start+"/////////"+strCon+"出现"+str+"的次数为"+count);
    }

    /**
     * Java 写有n个人围成一圈，顺序排号，从第一个人开始报数（从1~3报数），凡报到3的人退出圈子，问最后留下的人原来排在第几号。
     * @param n
     */
    void Baoshu(int n){

        Boolean[] arr = new Boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        } // 数组赋值都是true

        int leftCount = n;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (arr[index] == true) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    arr[index] = false;
                    leftCount--;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == true) {
                mtext.setText("原排在第" + (i + 1) + "位的人留下了。");
            }
        }

    }

    /**
     * 求100之内的素数 //使用除sqrt(n)的方法求出的素数不包括2和3
     */
    void Sushu(){
        int[] a = new int[]{2, 3, 5, 7};
        StringBuffer stringBuffer = new StringBuffer();
        for(int j=0; j<4; j++)
            stringBuffer.append(a[j]+"  ");
        boolean b =false;
        for(int i=11; i<100; i+=2) {
            for(int j=0; j<4; j++) {
                if(i % a[j] == 0) {
                    b = false;
                    break;
                } else{
                    b = true;
                }
            }
            if(b == true) {
                stringBuffer.append(i+"  ");
                mtext.setText(stringBuffer);
            }
        }
    }



    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("DownloadThread id " + Thread.currentThread().getId());
            stringBuffer1 = new StringBuffer();
            stringBuffer1.append(xunHuan(50000));
            Message msg = new Message();
            msg.arg1 = 1;
            uiHandler.sendMessage(msg);

        }

        /**
         * 循环实现求n的阶乘
         *
         * @param n
         * @return
         */
        public BigInteger xunHuan(long n) {

            BigInteger cBigInteger = BigInteger.valueOf(1);
            for (long i = 1; i < n + 1; i++) {
                cBigInteger = cBigInteger.multiply(BigInteger.valueOf(i));
            }
            return cBigInteger;
        }

    }

}




