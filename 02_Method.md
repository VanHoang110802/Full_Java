Trong **Java**, **Method** (phương thức) là **một khối lệnh dùng để thực hiện một chức năng cụ thể**. Bạn có thể gọi method nhiều lần thay vì viết lại cùng một đoạn code. Điều này giúp chương trình **gọn gàng, dễ đọc và dễ bảo trì hơn**. 💻

---

## 1. Method là gì?

**Method = một hàm trong Java** dùng để thực hiện một nhiệm vụ.

Ví dụ đơn giản:

```java
public class Main {
    static void sayHello() {
        System.out.println("Hello Java!");
    }

    public static void main(String[] args) {
        sayHello(); // gọi method
    }
}
```

**Kết quả khi chạy:**

```
Hello Java!
```

👉 Ở đây:

* `sayHello()` là **method**
* `main()` cũng là **method đặc biệt** – nơi chương trình bắt đầu chạy.

---

## 2. Cấu trúc của Method

Cấu trúc chung:

```java
returnType methodName(parameters) {
    // code thực hiện
}
```

Ví dụ:

```java
static void sayHello() {
    System.out.println("Hello!");
}
```

Giải thích:

| Thành phần | Ý nghĩa              |
| ---------- | -------------------- |
| `static`   | method thuộc class   |
| `void`     | không trả về giá trị |
| `sayHello` | tên method           |
| `()`       | tham số              |
| `{}`       | thân method          |

---

## 3. Method có tham số (Parameters)

Bạn có thể truyền dữ liệu vào method.

Ví dụ:

```java
public class Main {
    static void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
        sayHello("An");
        sayHello("Nam");
    }
}
```

Kết quả:

```
Hello An
Hello Nam
```

👉 `name` là **parameter** (tham số).

---

## 4. Method trả về giá trị (return)

Method có thể **trả lại kết quả**.

Ví dụ:

```java
public class Main {
    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = sum(5, 3);
        System.out.println(result);
    }
}
```

Kết quả:

```
8
```

👉 `return` dùng để trả kết quả về.

---

## 5. Các loại Method thường gặp

1️⃣ **Method không có tham số**

```java
static void hello()
```

2️⃣ **Method có tham số**

```java
static void hello(String name)
```

3️⃣ **Method có return**

```java
static int sum(int a, int b)
```

4️⃣ **Method không return**

```java
static void print()
```

---

## 6. Vì sao Method quan trọng?

Method giúp:

* 🔹 **Tái sử dụng code**
* 🔹 **Chia nhỏ chương trình**
* 🔹 **Dễ đọc và dễ sửa**
* 🔹 **Giảm lỗi**

---

✅ **Ví dụ thực tế (chương trình có nhiều method)**

```java
public class Main {

    static void hello() {
        System.out.println("Hello!");
    }

    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        hello();
        System.out.println(sum(4, 6));
    }
}
```

---

💡 Nếu mới học **Java**, nên học Method theo thứ tự:

1. Method cơ bản
2. Method có tham số
3. Method có return
4. Method Overloading
5. Static vs Non-static Method

---

**“method” và “hàm (function)” rất giống nhau**, nhưng **không hoàn toàn giống**.

---

## 1. Hàm (Function) là gì?

**Function (hàm)** là một **khối code thực hiện một nhiệm vụ và có thể trả về giá trị**.

Ví dụ trong nhiều ngôn ngữ:

```python
def sum(a, b):
    return a + b
```

Ở đây:

* `sum` là **function**
* nhận `a`, `b`
* trả về `a + b`

👉 Function **có thể tồn tại độc lập**.

---

## 2. Method là gì?

**Method** cũng là một **function**, nhưng **nó thuộc về một class hoặc object**.

Ví dụ trong **Java**:

```java
class Calculator {

    int sum(int a, int b) {
        return a + b;
    }

}
```

Ở đây:

* `sum()` là **method**
* vì nó **nằm trong class `Calculator`**

---

## 3. So sánh nhanh

| Function (Hàm)                 | Method                     |
| ------------------------------ | -------------------------- |
| Có thể tồn tại độc lập         | Thuộc về class hoặc object |
| Có trong C, Python, JavaScript | Phổ biến trong OOP         |
| Không cần class                | Phải nằm trong class       |

---

## 4. Trong Java thì sao?

Trong **Java**, **tất cả các hàm đều là method**.

Ví dụ:

```java
public class Main {

    static void hello() {
        System.out.println("Hello");
    }

}
```

`hello()` được gọi là **method**, không gọi là function.

---

✅ **Kết luận dễ nhớ:**

* **Function = khái niệm chung**
* **Method = function nằm trong class**

📌 Công thức nhớ nhanh:

```
Method = Function + Class
```

---

Mình sẽ giải thích **cách Method hoạt động bên trong Java** theo kiểu **dễ hình dung cho người mới học**. Khi hiểu phần này bạn sẽ nắm được cách Java chạy chương trình. 🚀

---

# 1. Chương trình Java bắt đầu từ đâu?

Mọi chương trình Java **luôn bắt đầu từ method `main()`**.

```java
public class Main {
    public static void main(String[] args) {
        sayHello();
    }

    static void sayHello() {
        System.out.println("Hello");
    }
}
```

**Quy trình chạy:**

1️⃣ JVM chạy `main()` \
2️⃣ `main()` gọi `sayHello()` \
3️⃣ `sayHello()` chạy code bên trong \
4️⃣ chạy xong → quay lại `main()` 

---

# 2. Cách Method được gọi (Method Call)

Khi một method gọi method khác, Java sẽ **tạo một vùng nhớ tạm để chạy method đó**.

Ví dụ:

```java
public class Main {

    static void methodA() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        methodA();
        System.out.println("Done");
    }
}
```

Thứ tự chạy:

```
main()
  ↓
methodA()
  ↓
in ra "A"
  ↓
quay lại main()
  ↓
in ra "Done"
```

Kết quả:

```
A
Done
```

---

# 3. Call Stack (Stack gọi Method)

Java dùng một cấu trúc gọi là **Call Stack** để quản lý method.

Ví dụ:

```java
public class Main {

    static void A() {
        B();
    }

    static void B() {
        C();
    }

    static void C() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        A();
    }
}
```

**Quá trình trong stack:**

```
main()
   ↓
A()
   ↓
B()
   ↓
C()
```

Sau khi `C()` chạy xong:

```
C() kết thúc
↑
B() kết thúc
↑
A() kết thúc
↑
main() tiếp tục
```

👉 Method **chạy xong sẽ bị pop khỏi stack**.

---

# 4. Truyền tham số vào Method

Khi gọi method, Java **copy giá trị vào parameter**.

```java
public class Main {

    static void printNumber(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        int a = 5;
        printNumber(a);
    }
}
```

Bên trong:

```
a = 5
↓
copy vào x
↓
x = 5
```

👉 Java **truyền tham trị (pass by value)**.

---

# 5. Method trả kết quả

Sau khi chạy xong, method có thể **trả kết quả về nơi gọi nó**.

```java
public class Main {

    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = sum(3,4);
        System.out.println(result);
    }
}
```

Luồng chạy:

```
main()
   ↓
sum(3,4)
   ↓
return 7
   ↓
result = 7
```

---

# 6. Hình dung đơn giản nhất

Hãy tưởng tượng **method giống như một công nhân trong nhà máy** 🏭

```
main() = quản lý

main() gọi → methodA()
methodA() làm việc
methodA() xong → báo lại main()
```

Luồng hoạt động:

```
Main → gọi Method → Method làm việc → trả kết quả → Main tiếp tục
```

---

✅ **Tóm tắt cực ngắn:**

Method trong Java hoạt động theo 4 bước:

1️⃣ JVM chạy `main()` \
2️⃣ Method được **gọi (call)** \
3️⃣ Method chạy trong **Call Stack** \
4️⃣ Method **return** rồi quay lại method gọi nó

---
