package dependencies.lib;

public class BigNum {
    int[] arr = new int[1000];
    //store numbers from left to right for convenience example 152 will be stored as 251000...


    BigNum() {

    }

    BigNum(int x) {
        for (int i = 0; x > 0; i++) {
            arr[i] = x % 10;
            x /= 10;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BigNum x = new BigNum(2);
        BigNum y = new BigNum(2);
        for (int i = 0; i < 128; i++) {
            System.out.println("2**" + (i + 1) + " = " + x);
            x.multiply(y);
        }
        x = new BigNum(1);
        y = new BigNum(1);
        int n = 2;
        while (x.getLength() != 1000) {
            BigNum temp = new BigNum();
            temp.setValue(x);
            x.add(y);
            y.setValue(temp);
            n++;
            if (n < 10)
                System.out.println(n + "th fibonnaci number is " + x);
        }
        System.out.println("First fibonacci number with 1000 digits = " + x + "\n at " + n);
        System.out.println(x.getLength());
        System.out.println("Execution time = " + (System.currentTimeMillis() - start) / 1000f + " sec");
    }

    public void setValue(BigNum bigNum) {
        this.arr = bigNum.arr.clone();
    }

    public int getLength() {
        int i = 999;
        for (; i >= 0; i--) {
            if (this.arr[i] != 0) {
                break;
            }
        }
        return i + 1;
    }

    public void add(BigNum bigNum) {
        for (int i = 0; i < 1000; i++) {
            int sum = this.arr[i] + bigNum.arr[i];
            this.arr[i] = sum % 10;
            if (i != 999) {
                this.arr[i + 1] += sum / 10;
            }
        }
    }

    public void multiply(BigNum bigNum) {
//        long begin = System.currentTimeMillis();

        BigNum mul = new BigNum();
        for (int i = 0; i < 1000; i++) {
            int mult = 0;
            for (int j = 0; j <= i; j++) {
                mult += this.arr[j] * bigNum.arr[i - j];
            }
            if (i == 0) {
                mul.arr[i] = mult;
            } else {
                mul.arr[i] = mul.arr[i - 1] / 10 + mult;
                mul.arr[i - 1] = mul.arr[i - 1] % 10;
            }
        }
        mul.arr[999] = mul.arr[999] % 10;
        this.arr = mul.arr;

//        long end = System.currentTimeMillis();
//        System.out.println((end - begin) + " msec");
    }

    @Override
    public String toString() {
        String s = "";
        boolean trimmed = false;
        for (int i = 999; i >= 0; i--) {
            if (trimmed) {
                s += arr[i];
            } else {
                if (arr[i] != 0) {
                    trimmed = true;
                    s += arr[i];
                }
            }
        }
        return s;
    }
}
